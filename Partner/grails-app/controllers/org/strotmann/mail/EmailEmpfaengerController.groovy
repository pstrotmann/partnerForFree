package org.strotmann.mail



import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional

@Transactional(readOnly = true)
class EmailEmpfaengerController {

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond EmailEmpfaenger.list(params), model:[emailEmpfaengerInstanceCount: EmailEmpfaenger.count()]
    }

    def show(EmailEmpfaenger emailEmpfaengerInstance) {
        respond emailEmpfaengerInstance
    }

    def create() {
		if (params.email.id) {
			def emailInstance = Email.get(params.email.id)
			flash.email = emailInstance
		}
		respond new EmailEmpfaenger(params)
    }

    @Transactional
    def save(EmailEmpfaenger emailEmpfaengerInstance) {
        if (emailEmpfaengerInstance == null) {
            notFound()
            return
        }

        if (emailEmpfaengerInstance.hasErrors()) {
            respond emailEmpfaengerInstance.errors, view:'create'
            return
        }

        emailEmpfaengerInstance.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'emailEmpfaenger.label', default: 'EmailEmpfaenger'), emailEmpfaengerInstance.id])
                redirect emailEmpfaengerInstance
            }
            '*' { respond emailEmpfaengerInstance, [status: CREATED] }
        }
    }

    def edit(EmailEmpfaenger emailEmpfaengerInstance) {
        respond emailEmpfaengerInstance
    }

    @Transactional
    def update(EmailEmpfaenger emailEmpfaengerInstance) {
        if (emailEmpfaengerInstance == null) {
            notFound()
            return
        }

        if (emailEmpfaengerInstance.hasErrors()) {
            respond emailEmpfaengerInstance.errors, view:'edit'
            return
        }

        emailEmpfaengerInstance.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'EmailEmpfaenger.label', default: 'EmailEmpfaenger'), emailEmpfaengerInstance.id])
                redirect emailEmpfaengerInstance
            }
            '*'{ respond emailEmpfaengerInstance, [status: OK] }
        }
    }

    @Transactional
    def delete(EmailEmpfaenger emailEmpfaengerInstance) {

        if (emailEmpfaengerInstance == null) {
            notFound()
            return
        }

        emailEmpfaengerInstance.delete flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'EmailEmpfaenger.label', default: 'EmailEmpfaenger'), emailEmpfaengerInstance.id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'emailEmpfaenger.label', default: 'EmailEmpfaenger'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
