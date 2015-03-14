import org.strotmann.mail.EmailEmpfaenger
import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_partner_emailEmpfaenger_form_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/emailEmpfaenger/_form.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
expressionOut.print(hasErrors(bean: emailEmpfaengerInstance, field: 'emailAdresse', 'error'))
printHtmlPart(1)
invokeTag('message','g',7,['code':("emailEmpfaenger.emailAdresse.label"),'default':("Email Adresse")],-1)
printHtmlPart(2)
invokeTag('field','g',10,['type':("email"),'name':("emailAdresse"),'required':(""),'value':(emailEmpfaengerInstance?.emailAdresse)],-1)
printHtmlPart(3)
expressionOut.print(hasErrors(bean: emailEmpfaengerInstance, field: 'eMail', 'error'))
printHtmlPart(4)
invokeTag('message','g',16,['code':("emailEmpfaenger.eMail.label"),'default':("E Mail")],-1)
printHtmlPart(2)
if(true && (flash.email)) {
printHtmlPart(5)
invokeTag('select','g',20,['id':("eMail"),'name':("eMail.id"),'from':(flash.email),'optionKey':("id"),'required':(""),'value':(emailEmpfaengerInstance?.eMail?.id),'class':("many-to-one")],-1)
printHtmlPart(6)
}
else {
printHtmlPart(5)
invokeTag('select','g',23,['id':("eMail"),'name':("eMail.id"),'from':(org.strotmann.mail.Email.list()),'optionKey':("id"),'required':(""),'value':(emailEmpfaengerInstance?.eMail?.id),'class':("many-to-one")],-1)
printHtmlPart(6)
}
printHtmlPart(7)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1426102422000L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
