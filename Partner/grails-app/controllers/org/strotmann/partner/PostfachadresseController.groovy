package org.strotmann.partner

import grails.transaction.Transactional;

import org.springframework.dao.DataIntegrityViolationException
import org.strotmann.partner.Matchcode;
import org.strotmann.partner.Partner;
import org.strotmann.partner.Postfachadresse;

class PostfachadresseController {

    def scaffold = true
	
	def create() {
		if (params.organisation || params.person)
			flash.partner = Partner.get(params.organisation?params.organisation.id:params.person.id)
		[postfachadresseInstance: new Postfachadresse(params)]
	}
	
	@Transactional
	def save(Postfachadresse postfachadresseInstance) {
		if (postfachadresseInstance == null) {
			notFound()
			return
		}

		postfachadresseInstance.phOrt = Matchcode.koePhone(postfachadresseInstance.ort)
		if (postfachadresseInstance.hasErrors()) {
			respond postfachadresseInstance.errors, view:'create'
			return
		}

		postfachadresseInstance.save flush:true

		request.withFormat {
			form multipartForm {
				flash.message = message(code: 'default.created.message', args: [message(code: 'bank.label', default: 'Postfach'), postfachadresseInstance.id])
				redirect postfachadresseInstance
			}
			'*' { respond postfachadresseInstance, [status: CREATED] }
		}
	}
	
	def edit(Postfachadresse postfachadresseInstance) {
		flash.partner = postfachadresseInstance.partner
		[postfachadresseInstance: postfachadresseInstance]
	}
	
	@Transactional
	def update(Postfachadresse postfachadresseInstance) {
		if (postfachadresseInstance == null) {
			notFound()
			return
		}

		if (postfachadresseInstance.hasErrors()) {
			respond postfachadresseInstance.errors, view:'edit'
			return
		}
		postfachadresseInstance.phOrt = Matchcode.koePhone(postfachadresseInstance.ort)
		postfachadresseInstance.save flush:true

		request.withFormat {
			form multipartForm {
				flash.message = message(code: 'default.updated.message', args: [message(code: 'Postfachadresse.label', default: 'Postfachadresse'), postfachadresseInstance.id])
				redirect postfachadresseInstance
			}
			'*'{ respond postfachadresseInstance, [status: OK] }
		}
	}
	
	@Transactional
	def delete(Postfachadresse postfachadresseInstance) {

		if (postfachadresseInstance == null) {
			notFound()
			return
		}
		try {
			postfachadresseInstance.delete flush:true
		}
		catch (Exception e) {
			flash.messageNo = "postfachadresse ${postfachadresseInstance} kann nicht gelöscht werden."
		}
		request.withFormat {
			form multipartForm {
				if (flash.messageNo)
					flash.message = flash.messageNo
				else
					flash.message = message(code: 'default.deleted.message', args: [message(code: 'Postfachadresse.label', default: 'Postfachadresse'), postfachadresseInstance])
				redirect action:"index", method:"GET"
			}
			'*'{ render status: NO_CONTENT }
		}
	}
	
	def plz() {
		redirect(uri: "http://www.deutschepost.de/plzsuche/PlzSearchServlet?finda=plugin&search={${''},${Postfachadresse.ort(params.ort)}}")
	}
	
}
