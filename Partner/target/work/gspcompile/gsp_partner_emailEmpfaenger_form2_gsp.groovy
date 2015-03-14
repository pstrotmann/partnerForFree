import org.strotmann.mail.EmailEmpfaenger
import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_partner_emailEmpfaenger_form2_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/emailEmpfaenger/_form2.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
expressionOut.print(hasErrors(bean: emailEmpfaengerInstance, field: 'emailAdresse', 'error'))
printHtmlPart(1)
invokeTag('message','g',5,['code':("emailEmpfaenger.emailAdresse.label"),'default':("An")],-1)
printHtmlPart(2)
if(true && (flash.mailTo)) {
printHtmlPart(3)
invokeTag('field','g',9,['type':("email"),'name':("emailAdresse"),'required':(""),'value':(flash.mailTo)],-1)
printHtmlPart(4)
}
else {
printHtmlPart(3)
invokeTag('field','g',12,['type':("email"),'name':("emailAdresse"),'required':(""),'value':(emailEmpfaengerInstance?.emailAdresse)],-1)
printHtmlPart(4)
}
printHtmlPart(5)
if(true && (flash.partner)) {
printHtmlPart(3)
invokeTag('select','g',16,['id':("partner"),'name':("partner.id"),'from':(flash.partner),'optionKey':("id"),'required':(""),'value':(emailEmpfaengerInstance?.partner?.id),'class':("many-to-one")],-1)
printHtmlPart(4)
}
else {
printHtmlPart(3)
invokeTag('select','g',19,['id':("partner"),'name':("partner.id"),'from':(org.strotmann.partner.Partner.list()),'optionKey':("id"),'required':(""),'value':(emailEmpfaengerInstance?.partner?.id),'class':("many-to-one")],-1)
printHtmlPart(4)
}
printHtmlPart(6)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1425913053000L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
