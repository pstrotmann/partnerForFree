import org.strotmann.partner.Partnerrolle
import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_partner_partnerrolleshow_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/partnerrolle/show.gsp" }
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
invokeTag('set','g',7,['var':("entityName"),'value':(message(code: 'partnerrolle.label', default: 'Partnerrolle'))],-1)
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
expressionOut.print(createLink(uri: "/menu", params: [lang: session.user.sprache]))
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
if(true && (partnerrolleInstance?.partner.instanceOf(org.strotmann.partner.Person))) {
printHtmlPart(14)
invokeTag('message','g',28,['code':("partnerrolle.person.label"),'default':("Person")],-1)
printHtmlPart(15)
createTagBody(3, {->
expressionOut.print(partnerrolleInstance?.partner?.encodeAsHTML())
})
invokeTag('link','g',29,['controller':("person"),'action':("show"),'id':(partnerrolleInstance?.partner?.id)],3)
printHtmlPart(16)
}
printHtmlPart(17)
if(true && (partnerrolleInstance?.partner.instanceOf(org.strotmann.partner.Organisation))) {
printHtmlPart(14)
invokeTag('message','g',34,['code':("partnerrolle.person.label"),'default':("Organisation")],-1)
printHtmlPart(18)
createTagBody(3, {->
expressionOut.print(partnerrolleInstance?.partner?.encodeAsHTML())
})
invokeTag('link','g',35,['controller':("organisation"),'action':("show"),'id':(partnerrolleInstance?.partner?.id)],3)
printHtmlPart(16)
}
printHtmlPart(19)
if(true && (partnerrolleInstance?.rolle)) {
printHtmlPart(20)
invokeTag('message','g',41,['code':("partnerrolle.rolle.label"),'default':("Rolle")],-1)
printHtmlPart(21)
invokeTag('fieldValue','g',43,['bean':(partnerrolleInstance),'field':("rolle")],-1)
printHtmlPart(22)
}
printHtmlPart(19)
if(true && (partnerrolleInstance?.objektname)) {
printHtmlPart(23)
invokeTag('message','g',50,['code':("partnerrolle.objektname.label"),'default':(" ")],-1)
printHtmlPart(24)
invokeTag('fieldValue','g',52,['bean':(partnerrolleInstance),'field':("objektname")],-1)
printHtmlPart(22)
}
printHtmlPart(19)
if(true && (partnerrolleInstance?.objektId)) {
printHtmlPart(25)
invokeTag('message','g',59,['code':("partnerrolle.objektId.label"),'default':(" ")],-1)
printHtmlPart(26)
createTagBody(3, {->
expressionOut.print(partnerrolleInstance?.objekt)
})
invokeTag('link','g',61,['controller':(partnerrolleInstance?.objektname),'action':("show"),'id':(partnerrolleInstance?.objektId)],3)
printHtmlPart(22)
}
printHtmlPart(27)
createTagBody(2, {->
printHtmlPart(28)
createTagBody(3, {->
invokeTag('message','g',69,['code':("default.button.edit.label"),'default':("Edit")],-1)
})
invokeTag('link','g',69,['class':("edit"),'action':("edit"),'resource':(partnerrolleInstance)],3)
printHtmlPart(29)
invokeTag('actionSubmit','g',70,['class':("delete"),'action':("delete"),'value':(message(code: 'default.button.delete.label', default: 'Delete')),'onclick':("return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');")],-1)
printHtmlPart(30)
})
invokeTag('form','g',72,['url':([resource:partnerrolleInstance, action:'delete']),'method':("DELETE")],2)
printHtmlPart(31)
})
invokeTag('captureBody','sitemesh',74,[:],1)
printHtmlPart(32)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1424177792000L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
