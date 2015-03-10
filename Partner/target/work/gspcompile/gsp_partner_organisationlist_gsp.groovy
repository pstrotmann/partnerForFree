import org.strotmann.partner.Organisation
import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_partner_organisationlist_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/organisation/list.gsp" }
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
invokeTag('set','g',7,['var':("entityName"),'value':(message(code: 'organisation.label', default: 'Organisation'))],-1)
printHtmlPart(2)
createTagBody(2, {->
createTagBody(3, {->
invokeTag('message','g',8,['code':("default.list.label"),'args':([entityName])],-1)
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
invokeTag('message','g',15,['code':("default.new.label"),'args':([entityName])],-1)
})
invokeTag('link','g',15,['class':("create"),'action':("create")],2)
printHtmlPart(8)
createTagBody(2, {->
invokeTag('message','g',16,['code':("default.oMerge.label")],-1)
})
invokeTag('link','g',16,['class':("create"),'action':("phList")],2)
printHtmlPart(8)
createTagBody(2, {->
invokeTag('message','g',17,['code':("default.loe.label"),'args':([entityName])],-1)
})
invokeTag('link','g',17,['class':("create"),'controller':("historie"),'action':("loeList"),'params':([domName:entityName])],2)
printHtmlPart(9)
invokeTag('message','g',21,['code':("default.list.label"),'args':([entityName])],-1)
printHtmlPart(10)
if(true && (flash.message)) {
printHtmlPart(11)
expressionOut.print(flash.message)
printHtmlPart(12)
}
printHtmlPart(13)
invokeTag('sortableColumn','g',28,['property':("name"),'title':(message(code: 'organisation.name.label', default: 'Name'))],-1)
printHtmlPart(14)
invokeTag('sortableColumn','g',30,['property':("nameZusatz"),'title':(message(code: 'organisation.nameZusatz.label', default: 'Name Zusatz'))],-1)
printHtmlPart(14)
invokeTag('sortableColumn','g',32,['property':("rechtsform"),'title':(message(code: 'organisation.rechtsform.label', default: 'Rechtsform'))],-1)
printHtmlPart(15)
invokeTag('message','g',34,['code':("organisation.hausadresse.label"),'default':("Hausadresse")],-1)
printHtmlPart(16)
loop:{
int i = 0
for( organisationInstance in (organisationInstanceList) ) {
printHtmlPart(17)
expressionOut.print((i % 2) == 0 ? 'even' : 'odd')
printHtmlPart(18)
createTagBody(3, {->
expressionOut.print(fieldValue(bean: organisationInstance, field: "name"))
})
invokeTag('link','g',42,['action':("show"),'id':(organisationInstance.id)],3)
printHtmlPart(19)
expressionOut.print(fieldValue(bean: organisationInstance, field: "nameZusatz"))
printHtmlPart(19)
expressionOut.print(fieldValue(bean: organisationInstance, field: "rechtsform"))
printHtmlPart(20)
expressionOut.print(fieldValue(bean: organisationInstance, field: "hausadresse"))
printHtmlPart(21)
i++
}
}
printHtmlPart(22)
invokeTag('paginate','g',56,['total':(organisationInstanceTotal)],-1)
printHtmlPart(23)
})
invokeTag('captureBody','sitemesh',59,[:],1)
printHtmlPart(24)
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
