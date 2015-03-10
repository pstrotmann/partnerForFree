package org.strotmann.partner



import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional

@Transactional(readOnly = true)
class LandController {

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
		//ladeLaender()
		params.max = Math.min(max ?: 10, 100)
		respond Land.list(params), model:[landInstanceCount: Land.count()]
    }

    def show(Land landInstance) {
		respond landInstance
    }

    def create() {
        respond new Land(params)
    }

    @Transactional
    def save(Land landInstance) {
        if (landInstance == null) {
            notFound()
            return
        }

        if (landInstance.hasErrors()) {
            respond landInstance.errors, view:'create'
            return
        }

        landInstance.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'land.label', default: 'Land'), landInstance.id])
                redirect landInstance
            }
            '*' { respond landInstance, [status: CREATED] }
        }
    }

    def edit(Land landInstance) {
        respond landInstance
    }

    @Transactional
    def update(Land landInstance) {
        if (landInstance == null) {
            notFound()
            return
        }

        if (landInstance.hasErrors()) {
            respond landInstance.errors, view:'edit'
            return
        }

        landInstance.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'Land.label', default: 'Land'), landInstance.id])
                redirect landInstance
            }
            '*'{ respond landInstance, [status: OK] }
        }
    }

    @Transactional
    def delete(Land landInstance) {

        if (landInstance == null) {
            notFound()
            return
        }

        landInstance.delete flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'Land.label', default: 'Land'), landInstance.id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'land.label', default: 'Land'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
	
	void ladeLaender () {
		FileInputStream landStream = new FileInputStream ("/vol/land");
		InputStreamReader landReader = new InputStreamReader(landStream, "UTF-8")
		BufferedReader land = new BufferedReader (landReader)
		land.eachLine {String it ->
			String kfzKz = it.split()[0]
			String landName = ''
			it.split().each {String item ->
				if (item != kfzKz)
				landName += item+' '
			}
			Land l = new Land()
			l.kfzKz = kfzKz
			l.name = landName
			l.save()
		}
	}
}
