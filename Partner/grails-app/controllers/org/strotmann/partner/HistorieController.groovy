package org.strotmann.partner



import static org.springframework.http.HttpStatus.*

import org.strotmann.partner.Historie;

import grails.transaction.Transactional

@Transactional(readOnly = true)
class HistorieController {

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond Historie.list(params), model:[historieInstanceCount: Historie.count()]
    }
	
	def domList(Integer max) {
		flash.dom = params.dom
		flash.domId = params.domId
		flash.domName = params.domName
		respond Historie.domList(params.domName,params.domId)
	}
	
	def loeList(Integer max) {
		flash.domName = params.domName
		respond Historie.loeList(params.domName)
	}

    def show(Historie historieInstance) {
        respond historieInstance
    }

    def create() {
        respond new Historie(params)
    }

    @Transactional
    def save(Historie historieInstance) {
        if (historieInstance == null) {
            notFound()
            return
        }

        if (historieInstance.hasErrors()) {
            respond historieInstance.errors, view:'create'
            return
        }

        historieInstance.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'historie.label', default: 'Historie'), historieInstance.id])
                redirect historieInstance
            }
            '*' { respond historieInstance, [status: CREATED] }
        }
    }

    def edit(Historie historieInstance) {
        respond historieInstance
    }

    @Transactional
    def update(Historie historieInstance) {
        if (historieInstance == null) {
            notFound()
            return
        }

        if (historieInstance.hasErrors()) {
            respond historieInstance.errors, view:'edit'
            return
        }

        historieInstance.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'Historie.label', default: 'Historie'), historieInstance.id])
                redirect historieInstance
            }
            '*'{ respond historieInstance, [status: OK] }
        }
    }

    @Transactional
    def delete(Historie historieInstance) {

        if (historieInstance == null) {
            notFound()
            return
        }

        historieInstance.delete flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'Historie.label', default: 'Historie'), historieInstance.id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'historie.label', default: 'Historie'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
