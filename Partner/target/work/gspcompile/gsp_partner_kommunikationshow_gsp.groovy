import org.strotmann.partner.Kommunikation
import org.strotmann.mail.Email
import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_partner_kommunikationshow_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/kommunikation/show.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
printHtmlPart(0)
printHtmlPart(1)
createTagBody(1, {->
printHtmlPart(2)
invokeTag('captureMeta','sitemesh',7,['gsp_sm_xmlClosingForEmptyTag':(""),'name':("layout"),'content':("main")],-1)
printHtmlPart(2)
invokeTag('set','g',8,['var':("entityName"),'value':(message(code: 'kommunikation.label', default: 'Kommunikation'))],-1)
printHtmlPart(2)
createTagBody(2, {->
createTagBody(3, {->
invokeTag('message','g',9,['code':("default.show.label"),'args':([entityName])],-1)
})
invokeTag('captureTitle','sitemesh',9,[:],3)
})
invokeTag('wrapTitleTag','sitemesh',9,[:],2)
printHtmlPart(3)
})
invokeTag('captureHead','sitemesh',10,[:],1)
printHtmlPart(3)
createTagBody(1, {->
printHtmlPart(4)
invokeTag('message','g',12,['code':("default.link.skip.label"),'default':("Skip to content&hellip;")],-1)
printHtmlPart(5)
expressionOut.print(createLink(uri: "/menu", params: [lang: session.user.sprache]))
printHtmlPart(6)
invokeTag('message','g',15,['code':("default.home.label")],-1)
printHtmlPart(7)
createTagBody(2, {->
invokeTag('message','g',16,['code':("default.list.label"),'args':([entityName])],-1)
})
invokeTag('link','g',16,['class':("list")],2)
printHtmlPart(8)
createTagBody(2, {->
invokeTag('message','g',17,['code':("default.new.label"),'args':([entityName])],-1)
})
invokeTag('link','g',17,['class':("create"),'action':("create")],2)
printHtmlPart(9)
if(true && (kommunikationInstance.art == 'eMail')) {
printHtmlPart(10)
createTagBody(3, {->
invokeTag('message','g',19,['code':("default.send.label"),'args':(['eMail'])],-1)
})
invokeTag('link','g',19,['class':("create"),'controller':("email"),'action':("create"),'params':([kommId:kommunikationInstance.id])],3)
printHtmlPart(9)
}
printHtmlPart(11)
if(true && (kommunikationInstance.art == 'Handy')) {
printHtmlPart(10)
createTagBody(3, {->
invokeTag('message','g',22,['code':("default.send.label"),'args':(['Sms'])],-1)
})
invokeTag('link','g',22,['class':("create"),'controller':("sms"),'action':("create"),'params':([kommId:kommunikationInstance.id])],3)
printHtmlPart(9)
}
printHtmlPart(12)
invokeTag('message','g',27,['code':("default.show.label"),'args':([entityName])],-1)
printHtmlPart(13)
if(true && (flash.message)) {
printHtmlPart(14)
expressionOut.print(flash.message)
printHtmlPart(15)
}
printHtmlPart(16)
if(true && (kommunikationInstance?.art)) {
printHtmlPart(17)
invokeTag('message','g',35,['code':("kommunikation.art.label"),'default':("Art")],-1)
printHtmlPart(18)
invokeTag('fieldValue','g',37,['bean':(kommunikationInstance),'field':("art")],-1)
printHtmlPart(19)
}
printHtmlPart(20)
if(true && (kommunikationInstance?.anwahl)) {
printHtmlPart(21)
invokeTag('message','g',44,['code':("kommunikation.anwahl.label"),'default':("Anwahl")],-1)
printHtmlPart(22)
invokeTag('fieldValue','g',46,['bean':(kommunikationInstance),'field':("anwahl")],-1)
printHtmlPart(19)
}
printHtmlPart(23)
if(true && (kommunikationInstance?.zusatz)) {
printHtmlPart(24)
invokeTag('message','g',53,['code':("kommunikation.zusatz.label"),'default':("Zusatz")],-1)
printHtmlPart(25)
invokeTag('fieldValue','g',55,['bean':(kommunikationInstance),'field':("zusatz")],-1)
printHtmlPart(19)
}
printHtmlPart(20)
if(true && (kommunikationInstance?.partner)) {
printHtmlPart(26)
invokeTag('message','g',62,['code':("kommunikation.partner.label"),'default':("Partner")],-1)
printHtmlPart(27)
if(true && (flash.person)) {
printHtmlPart(28)
createTagBody(4, {->
expressionOut.print(kommunikationInstance?.partner?.encodeAsHTML())
})
invokeTag('link','g',65,['controller':("person"),'action':("show"),'id':(kommunikationInstance?.partner?.id)],4)
printHtmlPart(29)
}
printHtmlPart(29)
if(true && (!flash.person)) {
printHtmlPart(28)
createTagBody(4, {->
expressionOut.print(kommunikationInstance?.partner?.encodeAsHTML())
})
invokeTag('link','g',68,['controller':("organisation"),'action':("show"),'id':(kommunikationInstance?.partner?.id)],4)
printHtmlPart(29)
}
printHtmlPart(30)
}
printHtmlPart(31)
createTagBody(2, {->
printHtmlPart(32)
invokeTag('hiddenField','g',77,['name':("id"),'value':(kommunikationInstance?.id)],-1)
printHtmlPart(33)
createTagBody(3, {->
invokeTag('message','g',78,['code':("default.button.edit.label"),'default':("Edit")],-1)
})
invokeTag('link','g',78,['class':("edit"),'action':("edit"),'id':(kommunikationInstance?.id)],3)
printHtmlPart(33)
invokeTag('actionSubmit','g',79,['class':("delete"),'action':("delete"),'value':(message(code: 'default.button.delete.label', default: 'Delete')),'onclick':("return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');")],-1)
printHtmlPart(34)
})
invokeTag('form','g',81,['url':([resource:kommunikationInstance, action:'delete']),'method':("DELETE")],2)
printHtmlPart(35)
})
invokeTag('captureBody','sitemesh',83,[:],1)
printHtmlPart(36)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1425991929000L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
