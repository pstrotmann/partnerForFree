package org.strotmann.mail



import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional

@Transactional(readOnly = true)
class EmailAnhangController {

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
		params.max = Math.min(max ?: 10, 100)
        respond EmailAnhang.list(params), model:[emailAnhangInstanceCount: EmailAnhang.count()]
    }

    def show(EmailAnhang emailAnhangInstance) {
        respond emailAnhangInstance
    }

    def create() {
		if (params.email.id) {
			def emailInstance = Email.get(params.email.id)
			session.email = emailInstance
		}
		session.emailAnhang = new EmailAnhang(params)
		respond session.emailAnhang
    }
	
	def upload() {
		def org.springframework.web.multipart.commons.CommonsMultipartFile f = request.getFile('file')
		String fName = f.getOriginalFilename()
		String v1Name = "/vol/partnerEmails"
		File verzPartnerEmails = new File(v1Name)
		if (!verzPartnerEmails.exists())
			verzPartnerEmails.mkdir()
		String v2Name = v1Name+"/anhaengeEmail_"+session.email.id.toString()
		File verzPartnerEmail = new File(v2Name)
		if (!verzPartnerEmail.exists())
			verzPartnerEmail.mkdir()
		String anhangName = v2Name+'/'+fName
		f.transferTo(new File(anhangName))
		def EmailAnhang emailAnhangInstance = session.emailAnhang
		emailAnhangInstance.dateiname = anhangName 
		emailAnhangInstance.eMail = session.email
		emailAnhangInstance.save flush:true
		redirect(controller: "email", action: "show", id:session.email.id)
	}

    @Transactional
    def save(EmailAnhang emailAnhangInstance) {
		println 'save'
		println params
		def org.springframework.web.multipart.commons.CommonsMultipartFile f = request.getFile('file')
		String fName = f.getOriginalFilename()
		println fName
		if (emailAnhangInstance == null) {
            notFound()
            return
        }

        if (emailAnhangInstance.hasErrors()) {
            respond emailAnhangInstance.errors, view:'create'
            return
        }

        emailAnhangInstance.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'emailAnhang.label', default: 'EmailAnhang'), emailAnhangInstance.id])
                redirect emailAnhangInstance
            }
            '*' { respond emailAnhangInstance, [status: CREATED] }
        }
    }

    def edit(EmailAnhang emailAnhangInstance) {
        respond emailAnhangInstance
    }

    @Transactional
    def update(EmailAnhang emailAnhangInstance) {
		
        if (emailAnhangInstance == null) {
            notFound()
            return
        }

        if (emailAnhangInstance.hasErrors()) {
            respond emailAnhangInstance.errors, view:'edit'
            return
        }

        emailAnhangInstance.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'EmailAnhang.label', default: 'EmailAnhang'), emailAnhangInstance.id])
                redirect emailAnhangInstance
            }
            '*'{ respond emailAnhangInstance, [status: OK] }
        }
    }

    @Transactional
    def delete(EmailAnhang emailAnhangInstance) {

        if (emailAnhangInstance == null) {
            notFound()
            return
        }

        emailAnhangInstance.delete flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'EmailAnhang.label', default: 'EmailAnhang'), emailAnhangInstance.id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'emailAnhang.label', default: 'EmailAnhang'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
