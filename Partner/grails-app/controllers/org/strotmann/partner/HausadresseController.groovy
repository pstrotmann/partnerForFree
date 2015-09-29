package org.strotmann.partner

import grails.transaction.Transactional;

import org.springframework.dao.DataIntegrityViolationException
import org.strotmann.partner.Hausadresse;
import org.strotmann.partner.Matchcode;

class HausadresseController {

    def scaffold = true
	
	def index(Integer max) {
		params.max = Math.min(max ?: 100, 1000)
		[hausadresseInstanceList: Hausadresse.getMiniList(), hausadresseInstanceTotal: Hausadresse.getMiniList().count({})]
	}
	
	def create() {
		if (params.partner) flash.partner = Partner.get(params.partner.id)
		respond new Hausadresse(params)
	}
	
	@Transactional
	def update(Hausadresse hausadresseInstance) {
		
		if (hausadresseInstance == null) {
			notFound()
			return
		}
		
		if (hausadresseInstance.hasErrors()) {
			respond hausadresseInstance.errors, view:'edit'
			return
		}
		hausadresseInstance.phOrt = Matchcode.koePhone(hausadresseInstance.ort)
		hausadresseInstance.phStrasse = Matchcode.koePhone(hausadresseInstance.strasse)
		
		if (!hausadresseInstance.save()) {
			render(view: "edit", model: [hausadresseInstance: hausadresseInstance])
			return
		}

		request.withFormat {
			form multipartForm {
				flash.message = message(code: 'default.updated.message', args: [message(code: 'Hausadresse.label', default: 'Hausadresse'), hausadresseInstance.id])
				redirect hausadresseInstance
			}
			'*'{ respond hausadresseInstance, [status: OK] }
		}
	}
	
	def save() {
		def hausadresseInstance = new Hausadresse(params)
		def Partner partnerInstance
		
		if (params.partner) {
			partnerInstance = Partner.get(params.partner.id)
			partnerInstance.hausadresse = hausadresseInstance
		}
		
		hausadresseInstance.phOrt = Matchcode.koePhone(hausadresseInstance.ort)
		hausadresseInstance.phStrasse = Matchcode.koePhone(hausadresseInstance.strasse)
		if (!hausadresseInstance.save(flush: true)) {
			render(view: "create", model: [hausadresseInstance: hausadresseInstance])
			return
		}
		
		if (partnerInstance) 
			partnerInstance.save(flush: true)
		
		flash.message = message(code: 'default.created.message', args: [message(code: 'hausadresse.label', default: 'Hausadresse'), hausadresseInstance.id])
		redirect(action: "show", id: hausadresseInstance.id)
	}
	
	@Transactional
	def delete(Hausadresse hausadresseInstance) {

		if (hausadresseInstance == null) {
			notFound()
			return
		}
		try {
			hausadresseInstance.delete flush:true
		}
		catch (Exception e) {
			flash.messageNo = "hausadresse ${hausadresseInstance} kann nicht gelöscht werden."
		}
		request.withFormat {
			form multipartForm {
				if (flash.messageNo)
					flash.message = flash.messageNo
				else 
					flash.message = message(code: 'default.deleted.message', args: [message(code: 'Hausadresse.label', default: 'Hausadresse'), hausadresseInstance])
				redirect action:"index", method:"GET"
			}
			'*'{ render status: NO_CONTENT }
		}
	}
	
	def plz() {
		redirect(uri: "http://www.postdirekt.de/plzserver/PlzSearchServlet?finda=plugin&search={${Hausadresse.strHnr(params.strasse, params.hausnummer)},${Hausadresse.ort(params.ort)}}")
	}
	
}
