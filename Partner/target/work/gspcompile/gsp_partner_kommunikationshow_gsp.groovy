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
invokeTag('message','g',19,['code':("default.mail.label")],-1)
})
invokeTag('link','g',19,['class':("create"),'controller':("email"),'action':("create"),'params':([kommId:kommunikationInstance.id])],3)
printHtmlPart(9)
}
printHtmlPart(11)
invokeTag('message','g',24,['code':("default.show.label"),'args':([entityName])],-1)
printHtmlPart(12)
if(true && (flash.message)) {
printHtmlPart(13)
expressionOut.print(flash.message)
printHtmlPart(14)
}
printHtmlPart(15)
if(true && (kommunikationInstance?.art)) {
printHtmlPart(16)
invokeTag('message','g',32,['code':("kommunikation.art.label"),'default':("Art")],-1)
printHtmlPart(17)
invokeTag('fieldValue','g',34,['bean':(kommunikationInstance),'field':("art")],-1)
printHtmlPart(18)
}
printHtmlPart(19)
if(true && (kommunikationInstance?.anwahl)) {
printHtmlPart(20)
invokeTag('message','g',41,['code':("kommunikation.anwahl.label"),'default':("Anwahl")],-1)
printHtmlPart(21)
invokeTag('fieldValue','g',43,['bean':(kommunikationInstance),'field':("anwahl")],-1)
printHtmlPart(18)
}
printHtmlPart(22)
if(true && (kommunikationInstance?.zusatz)) {
printHtmlPart(23)
invokeTag('message','g',50,['code':("kommunikation.zusatz.label"),'default':("Zusatz")],-1)
printHtmlPart(24)
invokeTag('fieldValue','g',52,['bean':(kommunikationInstance),'field':("zusatz")],-1)
printHtmlPart(18)
}
printHtmlPart(19)
if(true && (kommunikationInstance?.partner)) {
printHtmlPart(25)
invokeTag('message','g',59,['code':("kommunikation.partner.label"),'default':("Partner")],-1)
printHtmlPart(26)
if(true && (flash.person)) {
printHtmlPart(27)
createTagBody(4, {->
expressionOut.print(kommunikationInstance?.partner?.encodeAsHTML())
})
invokeTag('link','g',62,['controller':("person"),'action':("show"),'id':(kommunikationInstance?.partner?.id)],4)
printHtmlPart(28)
}
printHtmlPart(28)
if(true && (!flash.person)) {
printHtmlPart(27)
createTagBody(4, {->
expressionOut.print(kommunikationInstance?.partner?.encodeAsHTML())
})
invokeTag('link','g',65,['controller':("organisation"),'action':("show"),'id':(kommunikationInstance?.partner?.id)],4)
printHtmlPart(28)
}
printHtmlPart(29)
}
printHtmlPart(30)
createTagBody(2, {->
printHtmlPart(31)
invokeTag('hiddenField','g',74,['name':("id"),'value':(kommunikationInstance?.id)],-1)
printHtmlPart(32)
createTagBody(3, {->
invokeTag('message','g',75,['code':("default.button.edit.label"),'default':("Edit")],-1)
})
invokeTag('link','g',75,['class':("edit"),'action':("edit"),'id':(kommunikationInstance?.id)],3)
printHtmlPart(32)
invokeTag('actionSubmit','g',76,['class':("delete"),'action':("delete"),'value':(message(code: 'default.button.delete.label', default: 'Delete')),'onclick':("return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');")],-1)
printHtmlPart(33)
})
invokeTag('form','g',78,['url':([resource:kommunikationInstance, action:'delete']),'method':("DELETE")],2)
printHtmlPart(34)
})
invokeTag('captureBody','sitemesh',80,[:],1)
printHtmlPart(35)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1424981887000L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
