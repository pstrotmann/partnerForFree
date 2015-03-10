import org.strotmann.mail.Email
import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_partner_email_form_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/email/_form.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
expressionOut.print(hasErrors(bean: emailInstance, field: 'sender', 'error'))
printHtmlPart(1)
invokeTag('message','g',7,['code':("email.sender.label"),'default':("Sender")],-1)
printHtmlPart(2)
invokeTag('field','g',10,['type':("email"),'name':("sender"),'required':(""),'value':(emailInstance?.sender)],-1)
printHtmlPart(3)
expressionOut.print(hasErrors(bean: emailInstance, field: 'emailBetreff', 'error'))
printHtmlPart(4)
invokeTag('message','g',16,['code':("email.emailBetreff.label"),'default':("Email Betreff")],-1)
printHtmlPart(2)
invokeTag('textField','g',19,['name':("emailBetreff"),'required':(""),'value':(emailInstance?.emailBetreff)],-1)
printHtmlPart(3)
expressionOut.print(hasErrors(bean: emailInstance, field: 'emailText', 'error'))
printHtmlPart(5)
invokeTag('message','g',25,['code':("email.emailText.label"),'default':("Email Text")],-1)
printHtmlPart(2)
invokeTag('textField','g',28,['name':("emailText"),'required':(""),'value':(emailInstance?.emailText)],-1)
printHtmlPart(3)
expressionOut.print(hasErrors(bean: emailInstance, field: 'anhaenge', 'error'))
printHtmlPart(6)
invokeTag('message','g',34,['code':("email.anhaenge.label"),'default':("Anhaenge")],-1)
printHtmlPart(7)
for( a in (emailInstance?.anhaenge) ) {
printHtmlPart(8)
createTagBody(2, {->
expressionOut.print(a?.encodeAsHTML())
})
invokeTag('link','g',40,['controller':("emailAnhang"),'action':("show"),'id':(a.id)],2)
printHtmlPart(9)
}
printHtmlPart(10)
createTagBody(1, {->
expressionOut.print(message(code: 'default.add.label', args: [message(code: 'emailAnhang.label', default: 'EmailAnhang')]))
})
invokeTag('link','g',43,['controller':("emailAnhang"),'action':("create"),'params':(['email.id': emailInstance?.id])],1)
printHtmlPart(11)
expressionOut.print(hasErrors(bean: emailInstance, field: 'emailEmpfaengers', 'error'))
printHtmlPart(12)
invokeTag('message','g',52,['code':("email.emailEmpfaengers.label"),'default':("Email Empfaengers")],-1)
printHtmlPart(7)
for( e in (emailInstance?.emailEmpfaengers) ) {
printHtmlPart(8)
createTagBody(2, {->
expressionOut.print(e?.encodeAsHTML())
})
invokeTag('link','g',58,['controller':("emailEmpfaenger"),'action':("show"),'id':(e.id)],2)
printHtmlPart(9)
}
printHtmlPart(10)
createTagBody(1, {->
expressionOut.print(message(code: 'default.add.label', args: [message(code: 'emailEmpfaenger.label', default: 'EmailEmpfaenger')]))
})
invokeTag('link','g',61,['controller':("emailEmpfaenger"),'action':("create"),'params':(['email.id': emailInstance?.id])],1)
printHtmlPart(13)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1424965232000L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
