package org.strotmann.partner



import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional

@Transactional(readOnly = true)
class BrancheController {

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
		//ladeBranchen ()
		params.max = Math.min(max ?: 10, 100)
        respond Branche.list(params), model:[brancheInstanceCount: Branche.count()]
    }

    def show(Branche brancheInstance) {
        respond brancheInstance
    }

    def create() {
        respond new Branche(params)
    }

    @Transactional
    def save(Branche brancheInstance) {
        if (brancheInstance == null) {
            notFound()
            return
        }

        if (brancheInstance.hasErrors()) {
            respond brancheInstance.errors, view:'create'
            return
        }

        brancheInstance.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'branche.label', default: 'Branche'), brancheInstance.id])
                redirect brancheInstance
            }
            '*' { respond brancheInstance, [status: CREATED] }
        }
    }

    def edit(Branche brancheInstance) {
        respond brancheInstance
    }

    @Transactional
    def update(Branche brancheInstance) {
        if (brancheInstance == null) {
            notFound()
            return
        }

        if (brancheInstance.hasErrors()) {
            respond brancheInstance.errors, view:'edit'
            return
        }

        brancheInstance.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'Branche.label', default: 'Branche'), brancheInstance.id])
                redirect brancheInstance
            }
            '*'{ respond brancheInstance, [status: OK] }
        }
    }

    @Transactional
    def delete(Branche brancheInstance) {

        if (brancheInstance == null) {
            notFound()
            return
        }

        brancheInstance.delete flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'Branche.label', default: 'Branche'), brancheInstance.id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'branche.label', default: 'Branche'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
	
	void ladeBranchen () {
		FileInputStream brancheStream = new FileInputStream ("/vol/branche");
		InputStreamReader brancheReader = new InputStreamReader(brancheStream, "UTF-8")
		BufferedReader branche = new BufferedReader (brancheReader)
		branche.eachLine {String it ->
			Branche b = new Branche()
			b.kode = it.split()[0]
			if (b.kode.length() == 2) {
				b.bezeichnung = it.substring(2)
				b.save()
			}
		}
	}
}
