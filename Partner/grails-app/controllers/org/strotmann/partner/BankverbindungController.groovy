package org.strotmann.partner

import org.springframework.dao.DataIntegrityViolationException
import org.strotmann.partner.Bankverbindung;
import org.strotmann.partner.Partner;

class BankverbindungController {
	
	def scaffold = true
	
	def show(Long id) {
		def bankverbindungInstance = Bankverbindung.get(id)
		flash.person = bankverbindungInstance.getPerson()
		flash.partner = bankverbindungInstance.partner
		if (!bankverbindungInstance) {
			flash.message = message(code: 'default.not.found.message', args: [message(code: 'bankverbindung.label', default: 'Bankverbindung'), id])
			redirect(action: "list")
			return
		}

		[bankverbindungInstance: bankverbindungInstance]
	}
	
	def create() {
		if (params.organisation || params.person)
			flash.partner = Partner.get(params.organisation?params.organisation.id:params.person.id)
        [bankverbindungInstance: new Bankverbindung(params)]
    }
	
	def edit(Long id) {
		def bankverbindungInstance = Bankverbindung.get(id)
		flash.person = bankverbindungInstance.getPerson()
		flash.partner = bankverbindungInstance.partner
		flash.bankverbindung = bankverbindungInstance
		if (!bankverbindungInstance) {
			flash.message = message(code: 'default.not.found.message', args: [message(code: 'bankverbindung.label', default: 'Bankverbindung'), id])
			redirect(action: "list")
			return
		}
		[bankverbindungInstance: bankverbindungInstance]
	}
}
