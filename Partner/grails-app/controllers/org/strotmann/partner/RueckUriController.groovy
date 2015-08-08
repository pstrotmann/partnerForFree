package org.strotmann.partner



import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional

@Transactional(readOnly = true)
class RueckUriController {

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond RueckUri.list(params), model:[rueckUriInstanceCount: RueckUri.count()]
    }

    def show(RueckUri rueckUriInstance) {
        respond rueckUriInstance
    }

    def create() {
        respond new RueckUri(params)
    }

    @Transactional
    def save(RueckUri rueckUriInstance) {
        if (rueckUriInstance == null) {
            notFound()
            return
        }

        if (rueckUriInstance.hasErrors()) {
            respond rueckUriInstance.errors, view:'create'
            return
        }

        rueckUriInstance.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'rueckUri.label', default: 'RueckUri'), rueckUriInstance.id])
                redirect rueckUriInstance
            }
            '*' { respond rueckUriInstance, [status: CREATED] }
        }
    }

    def edit(RueckUri rueckUriInstance) {
        respond rueckUriInstance
    }

    @Transactional
    def update(RueckUri rueckUriInstance) {
        if (rueckUriInstance == null) {
            notFound()
            return
        }

        if (rueckUriInstance.hasErrors()) {
            respond rueckUriInstance.errors, view:'edit'
            return
        }

        rueckUriInstance.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'RueckUri.label', default: 'RueckUri'), rueckUriInstance.id])
                redirect rueckUriInstance
            }
            '*'{ respond rueckUriInstance, [status: OK] }
        }
    }

    @Transactional
    def delete(RueckUri rueckUriInstance) {

        if (rueckUriInstance == null) {
            notFound()
            return
        }

        rueckUriInstance.delete flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'RueckUri.label', default: 'RueckUri'), rueckUriInstance.id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'rueckUri.label', default: 'RueckUri'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
