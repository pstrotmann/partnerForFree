package org.strotmann.partner



import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional

@Transactional(readOnly = true)
class LieferadresseController {

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond Lieferadresse.list(params), model:[lieferadresseInstanceCount: Lieferadresse.count()]
    }

    def show(Lieferadresse lieferadresseInstance) {
        respond lieferadresseInstance
    }

    def create() {
		if (params.organisation || params.person)
			flash.partner = Partner.get(params.organisation?params.organisation.id:params.person.id)
		respond new Lieferadresse(params)
    }

    @Transactional
    def save(Lieferadresse lieferadresseInstance) {
        if (lieferadresseInstance == null) {
            notFound()
            return
        }

		lieferadresseInstance.phOrt = Matchcode.koePhone(lieferadresseInstance.ort)
		if (lieferadresseInstance.hasErrors()) {
            respond lieferadresseInstance.errors, view:'create'
            return
        }

        lieferadresseInstance.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'lieferadresse.label', default: 'Lieferadresse'), lieferadresseInstance.id])
                redirect lieferadresseInstance
            }
            '*' { respond lieferadresseInstance, [status: CREATED] }
        }
    }

    def edit(Lieferadresse lieferadresseInstance) {
		flash.partner = lieferadresseInstance.partner
        respond lieferadresseInstance
    }

    @Transactional
    def update(Lieferadresse lieferadresseInstance) {
        if (lieferadresseInstance == null) {
            notFound()
            return
        }

        if (lieferadresseInstance.hasErrors()) {
            respond lieferadresseInstance.errors, view:'edit'
            return
        }

		lieferadresseInstance.phOrt = Matchcode.koePhone(lieferadresseInstance.ort)
		lieferadresseInstance.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'Lieferadresse.label', default: 'Lieferadresse'), lieferadresseInstance.id])
                redirect lieferadresseInstance
            }
            '*'{ respond lieferadresseInstance, [status: OK] }
        }
    }

    @Transactional
    def delete(Lieferadresse lieferadresseInstance) {

        if (lieferadresseInstance == null) {
            notFound()
            return
        }

        lieferadresseInstance.delete flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'Lieferadresse.label', default: 'Lieferadresse'), lieferadresseInstance.id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'lieferadresse.label', default: 'Lieferadresse'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
