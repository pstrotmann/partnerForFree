package org.strotmann.partner

import java.util.Map;

import grails.transaction.Transactional;

import org.springframework.dao.DataIntegrityViolationException
import org.strotmann.notiz.Notiz;
import org.strotmann.partner.Bankverbindung;
import org.strotmann.partner.Hausadresse;
import org.strotmann.partner.Lieferadresse;
import org.strotmann.partner.Kommunikation;
import org.strotmann.partner.Matchcode;
import org.strotmann.partner.Organisation;
import org.strotmann.partner.Partnerrolle;
import org.strotmann.partner.Postfachadresse;

class OrganisationController {
	
	def scaffold = true

    def list(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        [organisationInstanceList: Organisation.getMiniList(), organisationInstanceTotal: Organisation.getMiniList().count({})]
    }
	
	def phList(Integer max) {
		params.max = Math.min(max ?: 10, 100)
		session.organisationInstanceList = Organisation.getPhOrganisationList()
		[organisationInstanceList: session.organisationInstanceList,organisationInstanceTotal: Organisation.getPhOrganisationList().count({})]
	}

	def join(Integer max) {
		def i = 0
		def anz = 0
		def organisationInstance1
		def organisationInstance2
		session.organisationInstanceList.each {item ->
			if (params["organisationInstanceList[${i}].checked"]) {
				anz++
				if (anz == 1) session.organisationInstance1 = item
				if (anz == 2) session.organisationInstance2 = item
			}
			i++
		}
		if (anz != 2) {
			flash.message = message(code: 'default.notTwo.message',args: [])
			redirect(action: "phList")
			return
		}
		[organisationInstance1: session.organisationInstance1, organisationInstance2: session.organisationInstance2]
	}
	
	@Transactional
	def joinZwei () {
		def List <Historie> h
		h = Historie.zweiNachEinsHistorie (session.user.name, session.organisationInstance1, session.organisationInstance2, params.organisationInstance2)
		h.each {Historie item ->
			item.save flush:true
		}
		session.organisationInstance1 =
		Organisation.zweiNachEins(session.organisationInstance1,session.organisationInstance2,params.organisationInstance2)
		session.organisationInstance1.merge().save flush:true
		
		session.organisationInstance2.merge().delete flush:true
		h = Historie.updateHistorie (session.user.name, session.organisationInstance2, null)
		h.each {Historie item ->
			item.save flush:true
		}
		
		def long p1Id = session.organisationInstance1.id
		session.organisationInstance1 = null
		session.organisationInstance2 = null
		
		flash.message = message(code: 'default.joined.message', args: [message(code: 'organisation.label', default: 'Organisation')])
		redirect(action: "show", id: p1Id)
	}
	
    def edit(Long id) {
        def organisationInstance = Organisation.get(id)
		flash.partner = organisationInstance
		session.organisation = organisationInstance
		flash.rollenZuObjektnameListe = Partnerrolle.rollenZuObjektname('o')
		if (!organisationInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'organisation.label', default: 'Organisation'), id])
            redirect(action: "list")
            return
        }

        [organisationInstance: organisationInstance]
    }
	
	@Transactional
	def save(Organisation organisationInstance) {
		if (organisationInstance.hausadresse == null) {
			Hausadresse hAdr = hausadresse (params)
			if (hAdr) {
				Hausadresse hAdrBestand = Hausadresse.findByPostleitzahlAndStrasseAndHausnummerAndZusatz(hAdr.postleitzahl,hAdr.strasse,hAdr.hausnummer,hAdr.zusatz)
				if (hAdrBestand)
					organisationInstance.hausadresse = hAdrBestand
				else {
					hAdr.save()
					organisationInstance.hausadresse = hAdrBestand
				}
			}
		}
				
		def Postfachadresse pofa = postfachadresse (params)
		if (pofa) {
			organisationInstance.postfachadressen = []
			organisationInstance.postfachadressen << pofa
			pofa.partner = organisationInstance
		}
		
		def Lieferadresse lief = lieferadresse (params)
		if (lief) {
			organisationInstance.lieferadressen = []
			organisationInstance.lieferadressen << lief
			lief.partner = organisationInstance
		}
		
		def Kommunikation komm = kommunikation (params)
		if (komm) {
			organisationInstance.kommunikationen = []
			organisationInstance.kommunikationen << komm
			komm.partner = organisationInstance
		}
		def Bankverbindung bVerb = bankverbindung (params)
		if (bVerb) {
			organisationInstance.bankverbindungen = []
			organisationInstance.bankverbindungen << bVerb
			bVerb.partner = organisationInstance
		}			
		
		if (organisationInstance == null) {
			notFound()
			return
		}

		if (organisationInstance.hasErrors()) {
			respond organisationInstance.errors, view:'create'
			return
		}
		
		organisationInstance.phName = Matchcode.koePhone(organisationInstance.name)
		
		if (!organisationInstance.save()) {
			render(view: "create", model: [organisationInstance: organisationInstance])
			return
		}
		
		def Historie h = Historie.createHistorie (session.user.name, organisationInstance)
		session.organisation = null
		h.save() 
		
		def Notiz n = notiz (params, organisationInstance)
		if (n)
			n.save()
		
		request.withFormat {
			form multipartForm {
				flash.message = message(code: 'default.created.message', args: [message(code: 'organisation.label', default: 'Organisation'), organisationInstance.id])
				redirect organisationInstance
			}
			'*' { respond organisationInstance, [status: CREATED] }
		}
	}
	
	@Transactional
	def update(Organisation organisationInstance) {
		if (organisationInstance == null) {
			notFound()
			return
		}
		
		if (organisationInstance.hasErrors()) {
			respond organisationInstance.errors, view:'edit'
			return
		}

		organisationInstance.phName = Matchcode.koePhone(organisationInstance.name)
		if (!organisationInstance.save()) {
			render(view: "edit", model: [organisationInstance: organisationInstance])
			return
		}
		
		def List <Historie> h = Historie.updateHistorie (session.user.name, session.organisation, organisationInstance)
		session.organisation = null
		h.each {Historie item ->
			item.save flush:true
		}
        
		request.withFormat {
			form multipartForm {
				flash.message = message(code: 'default.updated.message', args: [message(code: 'Organisation.label', default: 'Organisation'), organisationInstance.id])
				redirect organisationInstance
			}
			'*'{ respond organisationInstance, [status: OK] }
		}
	}
	
	@Transactional
	def delete(Organisation organisationInstance) {

		if (organisationInstance == null) {
			notFound()
			return
		}

		organisationInstance.delete flush:true
		def List <Historie> h = Historie.updateHistorie (session.user.name, organisationInstance, null)
		h.each {Historie item ->
			item.save flush:true
		}

		request.withFormat {
			form multipartForm {
				flash.message = message(code: 'default.deleted.message', args: [message(code: 'Organisation.label', default: 'Organisation'), organisationInstance.id])
				redirect action:"index", method:"GET"
			}
			'*'{ render status: NO_CONTENT }
		}
	}
	
	def toRolle(Long id) {
		def partnerrolleInstance = params.partnerrolleInstance
		flash.rolle = params.partnerrolleInstance.rolle.split(' zu ')[0]
		flash.objektname = params.partnerrolleInstance.rolle.split(' zu ')[1]
		flash.partner = Organisation.get(id)
		redirect(controller: "partnerrolle", action: "create",params:[rolle: flash.rolle, objektname: flash.objektname])
	}
	
	def plz() {
		redirect(uri: "http://www.deutschepost.de/plzsuche/PlzSearchServlet?finda=plugin&search={${Hausadresse.strHnr(params.strasse[0], params.hausnummer[0])},${Hausadresse.ort(params.ort[0])}}")
	}
	
	static Hausadresse hausadresse (Map m) {
		Hausadresse hAdr = null
		if (m.strasse[0] && m.hausnummer[0] && new Integer(m.postleitzahl[0]) > 0 && m.ort[0]) {
			hAdr = new Hausadresse()
			hAdr.strasse = m.strasse[0]
			hAdr.phStrasse = Matchcode.koePhone(m.strasse[0])
			hAdr.hausnummer = new Integer(m.hausnummer[0])
			hAdr.zusatz = m.zusatz[0]
			hAdr.postleitzahl = new Integer(m.postleitzahl[0])
			hAdr.ort = m.ort[0]
			hAdr.phOrt = Matchcode.koePhone(m.ort[0])
			hAdr.save()
		}
		hAdr
	}
	
	static Postfachadresse postfachadresse (Map m) {
		Postfachadresse pofa = null
		if (new Integer(m.postfach) > 0 && new Integer(m.postleitzahl[1]) > 0 && m.ort[1]) {
			pofa = new Postfachadresse()
			pofa.postfach = new Integer(m.postfach)
			pofa.postleitzahl = new Integer(m.postleitzahl[1])
			pofa.ort = m.ort[1]
			pofa.phOrt = Matchcode.koePhone(m.ort[1])
			pofa.save()
		}
		pofa
	}
	
	static Lieferadresse lieferadresse (Map m) {
		Lieferadresse lAdr = null
		if (new Integer(m.postleitzahl[2]) > 0 && m.ort[2]) {
			lAdr = new Lieferadresse()
			lAdr.strasse = m.strasse[1]
			lAdr.hausnummer = m.hausnummer[1]?new Integer(m.hausnummer[1]):null
			lAdr.zusatz = m.zusatz[1]
			lAdr.postleitzahl = new Integer(m.postleitzahl[2])
			lAdr.ort = m.ort[2]
			lAdr.phOrt = Matchcode.koePhone(m.ort[2])
			lAdr.anfahrt = m.anfahrt
			lAdr.save()
		}
		lAdr
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
	
	static Notiz notiz (Map m, Organisation o) {
		Notiz n = null
		if (m.notiztext) {
			n = new Notiz()
			n.anlagetermin = new Date()
			n.wiedervorlagetermin = n.anlagetermin
			n.notiztext = m.notiztext
			n.referenz = 'Organisation.id:'+o.id+' '+o
		}
		n
	}
}
