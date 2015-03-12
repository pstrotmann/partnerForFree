package org.strotmann.mail



import static org.springframework.http.HttpStatus.*

import java.util.Map;

import grails.transaction.Transactional
import grails.util.Holders

import org.strotmann.partner.Bankverbindung
import org.strotmann.partner.Kommunikation
import org.strotmann.partner.Partner

@Transactional(readOnly = true)
class EmailController {

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond Email.list(params), model:[emailInstanceCount: Email.count()]
    }

    def show(Email emailInstance) {
        respond emailInstance
    }

    def create() {
		if (params.kommId) {
			def kommunikationInstance = Kommunikation.get(params.kommId)
			flash.partner = kommunikationInstance.partner 
			flash.mailTo = kommunikationInstance.anwahl
		}
		flash.mailFrom = Holders.config.mailFrom
        respond new Email(params)
    }

    @Transactional
    def save(Email emailInstance) {
		def EmailEmpfaenger empf = emailEmpfaenger (params)
		if (empf) {
			emailInstance.emailEmpfaengers = []
			emailInstance.emailEmpfaengers << empf
			empf.eMail = emailInstance
		}
		
        if (emailInstance == null) {
            notFound()
            return
        }
		
		if (emailInstance.hasErrors()) {
            respond emailInstance.errors, view:'create'
            return
        }

		
		if (params.gesendet == 'on') {
			if (emailInstance.sendMail() == 0) {
				emailInstance.sendedatum = new Date() 
				emailInstance.gesendet = true
				flash.message = message(code: 'default.send.good.label', args:['eMail'])
			}
			else
				flash.message = message(code: 'default.send.bad.label', args:['eMail'])
		}
		emailInstance.save flush:true

        request.withFormat {
            form multipartForm {
				if (params.gesendet != 'on')
                flash.message = message(code: 'default.created.message', args: [message(code: 'email.label', default: 'Email'), emailInstance.id])
                redirect emailInstance
            }
            '*' { respond emailInstance, [status: CREATED] }
        }
    }

    def edit(Email emailInstance) {
        respond emailInstance
    }

    @Transactional
    def update(Email emailInstance) {
        if (emailInstance == null) {
            notFound()
            return
        }

        if (emailInstance.hasErrors()) {
            respond emailInstance.errors, view:'edit'
            return
        }

        emailInstance.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'Email.label', default: 'Email'), emailInstance.id])
                redirect emailInstance
            }
            '*'{ respond emailInstance, [status: OK] }
        }
    }

    @Transactional
    def delete(Email emailInstance) {

        if (emailInstance == null) {
            notFound()
            return
        }

        emailInstance.delete flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'Email.label', default: 'Email'), emailInstance.id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }
	
	def send(Email emailInstance) {
		if (emailInstance.sendMail() == 0) {
			emailInstance.sendedatum = new Date()
			emailInstance.gesendet = true
			flash.message = message(code: 'default.send.good.label', args:['eMail'])
			emailInstance.save flush:true
		}
		else
			flash.message = message(code: 'default.send.bad.label', args:['eMail'])
			
		redirect(action: "show", id:emailInstance.id)
	}

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'email.label', default: 'Email'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
	
	static EmailEmpfaenger emailEmpfaenger (Map m) {
		EmailEmpfaenger empf = null
		if (m.emailAdresse && m.partner) {
			empf = new EmailEmpfaenger()
			empf.emailAdresse = m.emailAdresse
			empf.partner = Partner.get(m.partner.id)
			empf.save()
		}
		empf
	}
}
