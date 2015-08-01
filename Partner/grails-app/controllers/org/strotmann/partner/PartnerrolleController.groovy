package org.strotmann.partner



import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional

@Transactional(readOnly = true)
class PartnerrolleController {

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond Partnerrolle.list(params), model:[partnerrolleInstanceCount: Partnerrolle.count()]
    }

    def show(Partnerrolle partnerrolleInstance) {
        respond partnerrolleInstance
    }

    def create() {
		respond new Partnerrolle(params)
    }

    @Transactional
    def save(Partnerrolle partnerrolleInstance) {
		String s = partnerrolleInstance.objektname.toLowerCase() + '.id'
		partnerrolleInstance.objektId = new Long(params[s])
        if (partnerrolleInstance == null) {
            notFound()
            return
        }

        if (partnerrolleInstance.hasErrors()) {
            respond partnerrolleInstance.errors, view:'create'
            return
        }

        //partnerrolleInstance.save flush:true
		
		if(!partnerrolleInstance.save(flush: true)) {
			partnerrolleInstance.errors.each {
				
				if(it.toString().contains('unique.error')) {
					partnerrolleInstance = Partnerrolle.getPartnerrolle(partnerrolleInstance)
				}
			}
		}
		
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'partnerrolle.label', default: 'Partnerrolle'), partnerrolleInstance.id])
                redirect partnerrolleInstance
			}
            '*' { respond partnerrolleInstance, [status: CREATED] }
        }
    }

    def edit(Partnerrolle partnerrolleInstance) {
        respond partnerrolleInstance
    }

    @Transactional
    def update(Partnerrolle partnerrolleInstance) {
        if (partnerrolleInstance == null) {
            notFound()
            return
        }

        if (partnerrolleInstance.hasErrors()) {
            respond partnerrolleInstance.errors, view:'edit'
            return
        }

        partnerrolleInstance.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'Partnerrolle.label', default: 'Partnerrolle'), partnerrolleInstance.id])
                redirect partnerrolleInstance
            }
            '*'{ respond partnerrolleInstance, [status: OK] }
        }
    }

    @Transactional
    def delete(Partnerrolle partnerrolleInstance) {

        if (partnerrolleInstance == null) {
            notFound()
            return
        }

        partnerrolleInstance.delete flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'Partnerrolle.label', default: 'Partnerrolle'), partnerrolleInstance.id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'partnerrolle.label', default: 'Partnerrolle'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
