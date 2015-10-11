package org.strotmann.partner



import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional

@Transactional(readOnly = true)
class LastschriftmandatController {

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond Lastschriftmandat.list(params), model:[lastschriftmandatInstanceCount: Lastschriftmandat.count()]
    }

    def show(Lastschriftmandat lastschriftmandatInstance) {
        respond lastschriftmandatInstance
    }

    def create() {
        respond new Lastschriftmandat(params)
    }

    @Transactional
    def save(Lastschriftmandat lastschriftmandatInstance) {
        if (lastschriftmandatInstance == null) {
            notFound()
            return
        }

        if (lastschriftmandatInstance.hasErrors()) {
            respond lastschriftmandatInstance.errors, view:'create'
            return
        }

        lastschriftmandatInstance.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'lastschriftmandat.label', default: 'Lastschriftmandat'), lastschriftmandatInstance.id])
                redirect lastschriftmandatInstance
            }
            '*' { respond lastschriftmandatInstance, [status: CREATED] }
        }
    }

    def edit(Lastschriftmandat lastschriftmandatInstance) {
        respond lastschriftmandatInstance
    }

    @Transactional
    def update(Lastschriftmandat lastschriftmandatInstance) {
        if (lastschriftmandatInstance == null) {
            notFound()
            return
        }

        if (lastschriftmandatInstance.hasErrors()) {
            respond lastschriftmandatInstance.errors, view:'edit'
            return
        }

        lastschriftmandatInstance.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'Lastschriftmandat.label', default: 'Lastschriftmandat'), lastschriftmandatInstance.id])
                redirect lastschriftmandatInstance
            }
            '*'{ respond lastschriftmandatInstance, [status: OK] }
        }
    }

    @Transactional
    def delete(Lastschriftmandat lastschriftmandatInstance) {

        if (lastschriftmandatInstance == null) {
            notFound()
            return
        }

        lastschriftmandatInstance.delete flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'Lastschriftmandat.label', default: 'Lastschriftmandat'), lastschriftmandatInstance.id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'lastschriftmandat.label', default: 'Lastschriftmandat'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
