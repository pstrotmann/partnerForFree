package org.strotmann.partner

import java.util.Map;

import grails.transaction.Transactional;

import org.springframework.dao.DataIntegrityViolationException
import org.strotmann.notiz.Notiz;
import org.strotmann.partner.Bankverbindung;
import org.strotmann.partner.Hausadresse;
import org.strotmann.partner.Kommunikation;
import org.strotmann.partner.Matchcode;
import org.strotmann.partner.Partnerrolle;
import org.strotmann.partner.Person;

class PersonController {
	
	def scaffold = true
		
	def list(Integer max) {
		params.max = Math.min(max ?: 10, 100)
		[personInstanceList: Person.getPersonList (), personInstanceTotal: Person.getPersonList().count({})]
	}
	
	def show(Person personInstance) {
		respond personInstance
	}
	
	def createLong() {
		respond new Person(params)
	}
	
	def phList(Integer max) {
		params.max = Math.min(max ?: 10, 100)
		session.personInstanceList = Person.getPhPersonList()
		[personInstanceList: session.personInstanceList,personInstanceTotal: Person.getPhPersonList().count({})]
	}
	
	def join(Integer max) {
		def i = 0
		def anz = 0
		def personInstance1
		def personInstance2
		session.personInstanceList.each {item ->
			if (params["personInstanceList[${i}].checked"]) {
				anz++
				if (anz == 1) session.personInstance1 = item
				if (anz == 2) session.personInstance2 = item
			}
			i++
		}
		if (anz != 2) {
			flash.message = message(code: 'default.notTwo.message',args: [])
			redirect(action: "phList")
			return
		}
		[personInstance1: session.personInstance1, personInstance2: session.personInstance2]
	}
	
	@Transactional
	def joinZwei () {
		def List <Historie> h
		h = Historie.zweiNachEinsHistorie (session.user.name, session.personInstance1, session.personInstance2, params.personInstance2)
		h.each {Historie item ->
			item.save flush:true
		}
		session.personInstance1 =
		Person.zweiNachEins(session.personInstance1,session.personInstance2,params.personInstance2)
		session.personInstance1.merge().save flush:true
		
		session.personInstance2.merge().delete flush:true
		h = Historie.updateHistorie (session.user.name, session.personInstance2, null)
		h.each {Historie item ->
			item.save flush:true
		}
		
		def long p1Id = session.personInstance1.id
		session.personInstance1 = null
		session.personInstance2 = null
		
		flash.message = message(code: 'default.joined.message', args: [message(code: 'person.label', default: 'Person')])
		redirect(action: "show", id: p1Id)
	}
	
    def edit(Long id) {
		def personInstance = Person.get(id)
		flash.partner = personInstance
		session.person = personInstance
		flash.rollenZuObjektnameListe = Partnerrolle.rollenZuObjektname('p')
        if (!personInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'person.label', default: 'Person'), id])
            redirect(action: "list")
            return
        }
		[personInstance: personInstance]
    }
	
	@Transactional
	def save(Person personInstance) {
		if (personInstance.hausadresse == null) {
			Hausadresse hAdr = hausadresse (params)
			if (hAdr) {
				Hausadresse hAdrBestand = Hausadresse.findByPostleitzahlAndStrasseAndHausnummerAndZusatz(hAdr.postleitzahl,hAdr.strasse,hAdr.hausnummer,hAdr.zusatz)
				if (hAdrBestand)
					personInstance.hausadresse = hAdrBestand
				else {
					hAdr.save()
					personInstance.hausadresse = hAdrBestand
				}
			}
		}
		
		def Kommunikation komm = kommunikation (params)
		if (komm) {
			personInstance.kommunikationen = []
			personInstance.kommunikationen << komm
			komm.partner = personInstance
		}
		
		def Bankverbindung bVerb = bankverbindung (params)
		if (bVerb) {
			personInstance.bankverbindungen = []
			personInstance.bankverbindungen << bVerb
			bVerb.partner = personInstance
		}
		
		if (personInstance == null) {
			notFound()
			return
		}

		if (personInstance.hasErrors()) {
			respond personInstance.errors, view:'create'
			return
		}
		
		personInstance.phName = Matchcode.koePhone(personInstance.name)
		personInstance.phVorname = Matchcode.koePhone(personInstance.vorname)
		
		if (!personInstance.save()) {
			render(view: "create", model: [personInstance: personInstance])
			return
		}
		 
		def Historie h = Historie.createHistorie (session.user.name, personInstance)
		session.person = null
		h.save()
		def Notiz n = notiz (params, personInstance)
		if (n)
			n.save()
		 
		request.withFormat {
			form multipartForm {
				flash.message = message(code: 'default.created.message', args: [message(code: 'person.label', default: 'Person'), personInstance.id])
				redirect personInstance
			}
			'*' { respond personInstance, [status: CREATED] }
		}
	}
	
	@Transactional
	def update(Person personInstance) {
		if (personInstance == null) {
			notFound()
			return
		}

		if (personInstance.hasErrors()) {
			respond personInstance.errors, view:'edit'
			return
		}
		
		personInstance.phName = Matchcode.koePhone(personInstance.name)
		personInstance.phVorname = Matchcode.koePhone(personInstance.vorname)
		personInstance.save flush:true
		def List <Historie> h = Historie.updateHistorie (session.user.name, session.person, personInstance)
		session.person = null
		h.each {Historie item ->
			item.save flush:true
		}

		request.withFormat {
			form multipartForm {
				flash.message = message(code: 'default.updated.message', args: [message(code: 'Person.label', default: 'Person'), personInstance.id])
				redirect personInstance
			}
			'*'{ respond personInstance, [status: OK] }
		}
	}
	
	@Transactional
	def delete(Person personInstance) {

		if (personInstance == null) {
			notFound()
			return
		}

		personInstance.delete flush:true
		def List <Historie> h = Historie.updateHistorie (session.user.name, personInstance, null)
		h.each {Historie item ->
			item.save flush:true
		}

		request.withFormat {
			form multipartForm {
				flash.message = message(code: 'default.deleted.message', args: [message(code: 'Person.label', default: 'Person'), personInstance.id])
				redirect action:"index", method:"GET"
			}
			'*'{ render status: NO_CONTENT }
		}
	}
	
	def toRolle(Long id) {
		def partnerrolleInstance = params.partnerrolleInstance
		flash.rolle = params.partnerrolleInstance.rolle.split(' zu ')[0]
		flash.objektname = params.partnerrolleInstance.rolle.split(' zu ')[1]
		flash.partner = Person.get(id)
		redirect(controller: "partnerrolle", action: "create",params:[rolle: flash.rolle, objektname: flash.objektname])
	}
	
	def plz() {
		redirect(uri: "http://www.deutschepost.de/plzsuche/PlzSearchServlet?finda=plugin&search={${Hausadresse.strHnr(params.strasse, params.hausnummer)},${Hausadresse.ort(params.ort)}}")
	}	
	
	static Hausadresse hausadresse (Map m) {
		Hausadresse hAdr = null
		if (m.strasse && m.hausnummer && new Integer(m.postleitzahl) > 0 && m.ort) {
			hAdr = new Hausadresse()
			hAdr.strasse = m.strasse
			hAdr.phStrasse = Matchcode.koePhone(m.strasse)
			hAdr.hausnummer = new Integer(m.hausnummer)
			hAdr.zusatz = m.zusatz[0]
			hAdr.postleitzahl = new Integer(m.postleitzahl)
			hAdr.ort = m.ort
			hAdr.phOrt = Matchcode.koePhone(m.ort)
			hAdr.save()
		}
		hAdr
	}
	
	static Bankverbindung bankverbindung (Map m) {
		Bankverbindung bVerb = null
		if (m.iban) {
			bVerb = new Bankverbindung()
			bVerb.iban = m.iban
			bVerb.save()
		}
		bVerb
	}
	
	static Kommunikation kommunikation (Map m) {
		Kommunikation komm = null
		if (m.art && m.anwahl) {
			komm = new Kommunikation()
			komm.art = m.art
			komm.anwahl = m.anwahl
			komm.zusatz = m.zusatz[1]
			komm.save()
		}
		komm
	}
	
	static Notiz notiz (Map m, Person p) {
		Notiz n = null
		if (m.notiztext) {
			n = new Notiz()
			n.anlagetermin = new Date()
			n.wiedervorlagetermin = n.anlagetermin
			n.notiztext = m.notiztext
			n.referenz = 'Person.id:'+p.id+' '+p
		}
		n
	}
}
