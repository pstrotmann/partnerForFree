package org.strotmann.mail



import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional

import org.strotmann.partner.Kommunikation

@Transactional(readOnly = true)
class SmsController {

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond Sms.list(params), model:[smsInstanceCount: Sms.count()]
    }

    def show(Sms smsInstance) {
        respond smsInstance
    }

    def create() {
		if (params.kommId) {
			def kommunikationInstance = Kommunikation.get(params.kommId)
			flash.partner = kommunikationInstance.partner
			flash.mailTo = kommunikationInstance.handyNum
		}
        respond new Sms(params)
    }

    @Transactional
    def save(Sms smsInstance) {
        if (smsInstance == null) {
            notFound()
            return
        }

        if (smsInstance.hasErrors()) {
            respond smsInstance.errors, view:'create'
            return
        }
		
		if (smsInstance.sendSms() == 0) {
			flash.message = message(code: 'default.send.good.label', args:['sms'])
			smsInstance.save flush:true
			}
		else {
			flash.message = message(code: 'default.send.bad.label', args:['sms'])
			respond smsInstance.errors, view:'create'
			return
		}
        request.withFormat {
            form multipartForm {
				redirect smsInstance
            }
            '*' { respond smsInstance, [status: CREATED] }
        }
    }

    def edit(Sms smsInstance) {
        respond smsInstance
    }

    @Transactional
    def update(Sms smsInstance) {
        if (smsInstance == null) {
            notFound()
            return
        }

        if (smsInstance.hasErrors()) {
            respond smsInstance.errors, view:'edit'
            return
        }

        smsInstance.save flush:true

        request.withFormat {
            form multipartForm {
				flash.message = message(code: 'default.updated.message', args: [message(code: 'sms.label', default: 'Sms'), smsInstance.id])
                redirect smsInstance
            }
            '*'{ respond smsInstance, [status: OK] }
        }
    }

    @Transactional
    def delete(Sms smsInstance) {

        if (smsInstance == null) {
            notFound()
            return
        }

        smsInstance.delete flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'Sms.label', default: 'Sms'), smsInstance.id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'sms.label', default: 'Sms'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
