import org.strotmann.mail.Email
import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_partner_email_form2_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/email/_form2.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
expressionOut.print(hasErrors(bean: emailInstance, field: 'sender', 'error'))
printHtmlPart(1)
invokeTag('message','g',5,['code':("email.sender.label"),'default':("Von")],-1)
printHtmlPart(2)
invokeTag('field','g',8,['type':("email"),'name':("sender"),'required':(""),'value':(flash.mailFrom)],-1)
printHtmlPart(3)
expressionOut.print(hasErrors(bean: emailInstance, field: 'emailBetreff', 'error'))
printHtmlPart(4)
invokeTag('message','g',14,['code':("email.emailBetreff.label"),'default':("Betreff")],-1)
printHtmlPart(5)
invokeTag('textField','g',17,['name':("emailBetreff"),'required':(""),'value':(emailInstance?.emailBetreff)],-1)
printHtmlPart(3)
expressionOut.print(hasErrors(bean: emailInstance, field: 'emailText', 'error'))
printHtmlPart(6)
invokeTag('message','g',23,['code':("email.emailText.label"),'default':("Text")],-1)
printHtmlPart(5)
invokeTag('textArea','g',26,['name':("emailText"),'required':(""),'value':(emailInstance?.emailText),'rows':("2"),'cols':("80")],-1)
printHtmlPart(3)
expressionOut.print(hasErrors(bean: emailInstance, field: 'gesendet', 'error'))
printHtmlPart(7)
invokeTag('message','g',32,['code':("email.send.label"),'default':("Senden")],-1)
printHtmlPart(5)
invokeTag('checkBox','g',35,['name':("gesendet"),'value':(false)],-1)
printHtmlPart(8)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1426168541000L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
