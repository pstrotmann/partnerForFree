package org.strotmann.partner

import grails.transaction.Transactional;

import org.springframework.dao.DataIntegrityViolationException
import org.strotmann.partner.Kommunikation;
import org.strotmann.partner.Partner;
import org.apache.commons.mail.*


class KommunikationController {

    def scaffold = true
	
	def show(Long id) {
		def kommunikationInstance = Kommunikation.get(id)
		flash.person = kommunikationInstance.getPerson()
		flash.partner = kommunikationInstance.partner
		if (!kommunikationInstance) {
			flash.message = message(code: 'default.not.found.message', args: [message(code: 'kommunikation.label', default: 'Kommunikation'), id])
			redirect(action: "list")
			return
		}
		[kommunikationInstance: kommunikationInstance]
	}
	
	def create() {
		if (params.organisation || params.person)
			flash.partner = Partner.get(params.organisation?params.organisation.id:params.person.id)
		[kommunikationInstance: new Kommunikation(params)]
	}
	
	def edit(Kommunikation kommunikationInstance) {
		flash.partner = kommunikationInstance.partner
		[kommunikationInstance: kommunikationInstance]
	}
		 
}
