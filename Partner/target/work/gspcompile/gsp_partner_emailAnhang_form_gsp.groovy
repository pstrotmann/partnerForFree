import org.strotmann.mail.EmailAnhang
import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_partner_emailAnhang_form_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/emailAnhang/_form.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
expressionOut.print(hasErrors(bean: emailAnhangInstance, field: 'dateiname', 'error'))
printHtmlPart(1)
createClosureForHtmlPart(2, 1)
invokeTag('uploadForm','g',10,['action':("upload"),'id':("flash.email.id")],1)
printHtmlPart(3)
expressionOut.print(hasErrors(bean: emailAnhangInstance, field: 'eMail', 'error'))
printHtmlPart(4)
if(true && (session.email)) {
printHtmlPart(5)
invokeTag('select','g',16,['id':("eMail"),'name':("eMail.id"),'from':(session.email),'optionKey':("id"),'required':(""),'value':(emailAnhangInstance?.eMail?.id),'class':("many-to-one")],-1)
printHtmlPart(6)
}
else {
printHtmlPart(5)
invokeTag('select','g',19,['id':("eMail"),'name':("eMail.id"),'from':(org.strotmann.mail.Email.list()),'optionKey':("id"),'required':(""),'value':(emailAnhangInstance?.eMail?.id),'class':("many-to-one")],-1)
printHtmlPart(6)
}
printHtmlPart(7)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1426276193000L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
