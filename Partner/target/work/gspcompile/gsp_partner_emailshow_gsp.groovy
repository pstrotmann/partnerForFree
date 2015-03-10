import org.strotmann.mail.Email
import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_partner_emailshow_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/email/show.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
printHtmlPart(1)
createTagBody(1, {->
printHtmlPart(2)
invokeTag('captureMeta','sitemesh',6,['gsp_sm_xmlClosingForEmptyTag':(""),'name':("layout"),'content':("main")],-1)
printHtmlPart(2)
invokeTag('set','g',7,['var':("entityName"),'value':(message(code: 'email.label', default: 'Email'))],-1)
printHtmlPart(2)
createTagBody(2, {->
createTagBody(3, {->
invokeTag('message','g',8,['code':("default.show.label"),'args':([entityName])],-1)
})
invokeTag('captureTitle','sitemesh',8,[:],3)
})
invokeTag('wrapTitleTag','sitemesh',8,[:],2)
printHtmlPart(3)
})
invokeTag('captureHead','sitemesh',9,[:],1)
printHtmlPart(3)
createTagBody(1, {->
printHtmlPart(4)
invokeTag('message','g',11,['code':("default.link.skip.label"),'default':("Skip to content&hellip;")],-1)
printHtmlPart(5)
expressionOut.print(createLink(uri: '/'))
printHtmlPart(6)
invokeTag('message','g',14,['code':("default.home.label")],-1)
printHtmlPart(7)
createTagBody(2, {->
invokeTag('message','g',15,['code':("default.list.label"),'args':([entityName])],-1)
})
invokeTag('link','g',15,['class':("list"),'action':("index")],2)
printHtmlPart(8)
createTagBody(2, {->
invokeTag('message','g',16,['code':("default.new.label"),'args':([entityName])],-1)
})
invokeTag('link','g',16,['class':("create"),'action':("create")],2)
printHtmlPart(9)
invokeTag('message','g',20,['code':("default.show.label"),'args':([entityName])],-1)
printHtmlPart(10)
if(true && (flash.message)) {
printHtmlPart(11)
expressionOut.print(flash.message)
printHtmlPart(12)
}
printHtmlPart(13)
if(true && (emailInstance?.sender)) {
printHtmlPart(14)
invokeTag('message','g',28,['code':("email.sender.label"),'default':("Sender")],-1)
printHtmlPart(15)
invokeTag('fieldValue','g',30,['bean':(emailInstance),'field':("sender")],-1)
printHtmlPart(16)
}
printHtmlPart(17)
if(true && (emailInstance?.emailBetreff)) {
printHtmlPart(18)
invokeTag('message','g',37,['code':("email.emailBetreff.label"),'default':("Email Betreff")],-1)
printHtmlPart(19)
invokeTag('fieldValue','g',39,['bean':(emailInstance),'field':("emailBetreff")],-1)
printHtmlPart(16)
}
printHtmlPart(17)
if(true && (emailInstance?.emailText)) {
printHtmlPart(20)
invokeTag('message','g',46,['code':("email.emailText.label"),'default':("Email Text")],-1)
printHtmlPart(21)
invokeTag('fieldValue','g',48,['bean':(emailInstance),'field':("emailText")],-1)
printHtmlPart(16)
}
printHtmlPart(17)
if(true && (emailInstance?.anhaenge)) {
printHtmlPart(22)
invokeTag('message','g',55,['code':("email.anhaenge.label"),'default':("Anhaenge")],-1)
printHtmlPart(23)
for( a in (emailInstance.anhaenge) ) {
printHtmlPart(24)
createTagBody(4, {->
expressionOut.print(a?.encodeAsHTML())
})
invokeTag('link','g',58,['controller':("emailAnhang"),'action':("show"),'id':(a.id)],4)
printHtmlPart(25)
}
printHtmlPart(26)
}
printHtmlPart(17)
if(true && (emailInstance?.emailEmpfaengers)) {
printHtmlPart(27)
invokeTag('message','g',66,['code':("email.emailEmpfaengers.label"),'default':("Email Empfaengers")],-1)
printHtmlPart(23)
for( e in (emailInstance.emailEmpfaengers) ) {
printHtmlPart(28)
createTagBody(4, {->
expressionOut.print(e?.encodeAsHTML())
})
invokeTag('link','g',69,['controller':("emailEmpfaenger"),'action':("show"),'id':(e.id)],4)
printHtmlPart(25)
}
printHtmlPart(26)
}
printHtmlPart(29)
invokeTag('message','g',76,['code':("email.emailGesendet.label"),'default':("Gesendet")],-1)
printHtmlPart(30)
invokeTag('formatBoolean','g',78,['boolean':(emailInstance.gesendet),'true':("Ja"),'false':("Nein")],-1)
printHtmlPart(31)
createTagBody(2, {->
printHtmlPart(32)
createTagBody(3, {->
invokeTag('message','g',86,['code':("default.button.edit.label"),'default':("Edit")],-1)
})
invokeTag('link','g',86,['class':("edit"),'action':("edit"),'resource':(emailInstance)],3)
printHtmlPart(33)
invokeTag('actionSubmit','g',87,['class':("delete"),'action':("delete"),'value':(message(code: 'default.button.delete.label', default: 'Delete')),'onclick':("return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');")],-1)
printHtmlPart(34)
})
invokeTag('form','g',89,['url':([resource:emailInstance, action:'delete']),'method':("DELETE")],2)
printHtmlPart(35)
})
invokeTag('captureBody','sitemesh',91,[:],1)
printHtmlPart(36)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1425054488000L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
