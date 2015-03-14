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
if(true && (!emailInstance.gesendet)) {
printHtmlPart(10)
createTagBody(3, {->
invokeTag('message','g',18,['code':("default.send.label"),'args':(['eMail'])],-1)
})
invokeTag('link','g',18,['class':("create"),'action':("send"),'id':(emailInstance.id)],3)
printHtmlPart(9)
}
printHtmlPart(11)
invokeTag('message','g',23,['code':("default.show.label"),'args':([entityName])],-1)
printHtmlPart(12)
if(true && (flash.message)) {
printHtmlPart(13)
expressionOut.print(flash.message)
printHtmlPart(14)
}
printHtmlPart(15)
if(true && (emailInstance?.sendedatum)) {
printHtmlPart(16)
invokeTag('message','g',31,['code':("eMail.sendedatum.label"),'default':("Sendedatum")],-1)
printHtmlPart(17)
invokeTag('formatDate','g',33,['date':(emailInstance?.sendedatum)],-1)
printHtmlPart(18)
}
printHtmlPart(19)
if(true && (emailInstance?.sender)) {
printHtmlPart(20)
invokeTag('message','g',40,['code':("email.sender.label"),'default':("Sender")],-1)
printHtmlPart(21)
invokeTag('fieldValue','g',42,['bean':(emailInstance),'field':("sender")],-1)
printHtmlPart(18)
}
printHtmlPart(22)
if(true && (emailInstance?.emailBetreff)) {
printHtmlPart(23)
invokeTag('message','g',49,['code':("email.emailBetreff.label"),'default':("Email Betreff")],-1)
printHtmlPart(24)
invokeTag('fieldValue','g',51,['bean':(emailInstance),'field':("emailBetreff")],-1)
printHtmlPart(18)
}
printHtmlPart(22)
if(true && (emailInstance?.emailText)) {
printHtmlPart(25)
invokeTag('message','g',58,['code':("email.emailText.label"),'default':("Email Text")],-1)
printHtmlPart(26)
invokeTag('fieldValue','g',60,['bean':(emailInstance),'field':("emailText")],-1)
printHtmlPart(18)
}
printHtmlPart(22)
if(true && (emailInstance?.anhaenge)) {
printHtmlPart(27)
invokeTag('message','g',67,['code':("email.anhaenge.label"),'default':("Anhaenge")],-1)
printHtmlPart(28)
for( a in (emailInstance.anhaenge) ) {
printHtmlPart(29)
createTagBody(4, {->
expressionOut.print(a?.encodeAsHTML())
})
invokeTag('link','g',70,['controller':("emailAnhang"),'action':("show"),'id':(a.id)],4)
printHtmlPart(30)
}
printHtmlPart(31)
}
printHtmlPart(22)
if(true && (emailInstance?.emailEmpfaengers)) {
printHtmlPart(32)
invokeTag('message','g',78,['code':("email.emailEmpfaengers.label"),'default':("Empfänger")],-1)
printHtmlPart(28)
for( e in (emailInstance.emailEmpfaengers) ) {
printHtmlPart(33)
createTagBody(4, {->
expressionOut.print(e?.encodeAsHTML())
})
invokeTag('link','g',81,['controller':("emailEmpfaenger"),'action':("show"),'id':(e.id)],4)
printHtmlPart(30)
}
printHtmlPart(31)
}
printHtmlPart(34)
invokeTag('message','g',88,['code':("email.emailGesendet.label"),'default':("Gesendet")],-1)
printHtmlPart(35)
invokeTag('formatBoolean','g',90,['boolean':(emailInstance.gesendet),'true':("Ja"),'false':("Nein")],-1)
printHtmlPart(36)
createTagBody(2, {->
printHtmlPart(37)
if(true && (!emailInstance.gesendet)) {
printHtmlPart(38)
createTagBody(4, {->
invokeTag('message','g',99,['code':("default.button.edit.label"),'default':("Edit")],-1)
})
invokeTag('link','g',99,['class':("edit"),'action':("edit"),'resource':(emailInstance)],4)
printHtmlPart(39)
}
printHtmlPart(39)
invokeTag('actionSubmit','g',101,['class':("delete"),'action':("delete"),'value':(message(code: 'default.button.delete.label', default: 'Delete')),'onclick':("return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');")],-1)
printHtmlPart(40)
})
invokeTag('form','g',103,['url':([resource:emailInstance, action:'delete']),'method':("DELETE")],2)
printHtmlPart(41)
})
invokeTag('captureBody','sitemesh',105,[:],1)
printHtmlPart(42)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1426173423000L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
