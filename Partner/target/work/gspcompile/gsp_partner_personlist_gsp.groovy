import org.strotmann.partner.Person
import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_partner_personlist_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/person/list.gsp" }
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
invokeTag('set','g',7,['var':("entityName"),'value':(message(code: 'person.label', default: 'Person'))],-1)
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
invokeTag('message','g',16,['code':("default.pMerge.label")],-1)
})
invokeTag('link','g',16,['class':("list"),'action':("phList")],2)
printHtmlPart(8)
createTagBody(2, {->
invokeTag('message','g',17,['code':("default.loe.label"),'args':([entityName])],-1)
})
invokeTag('link','g',17,['class':("list"),'controller':("historie"),'action':("loeList"),'params':([domName:entityName])],2)
printHtmlPart(9)
invokeTag('message','g',21,['code':("default.list.label"),'args':([entityName])],-1)
printHtmlPart(10)
if(true && (flash.message)) {
printHtmlPart(11)
expressionOut.print(flash.message)
printHtmlPart(12)
}
printHtmlPart(13)
invokeTag('sortableColumn','g',29,['property':("name"),'title':(message(code: 'person.name.label'))],-1)
printHtmlPart(14)
invokeTag('sortableColumn','g',31,['property':("vorname"),'title':(message(code: 'person.vorname.label'))],-1)
printHtmlPart(14)
invokeTag('sortableColumn','g',33,['property':("geschlecht"),'title':(message(code: 'person.geschlecht.label'))],-1)
printHtmlPart(14)
invokeTag('sortableColumn','g',35,['property':("geburtsdatum"),'title':(message(code: 'person.geburtsdatum.label'))],-1)
printHtmlPart(15)
invokeTag('sortableColumn','g',37,['property':("hausadresse"),'title':(message(code: 'person.hausadresse.label'))],-1)
printHtmlPart(16)
loop:{
int i = 0
for( personInstance in (personInstanceList) ) {
printHtmlPart(17)
expressionOut.print((i % 2) == 0 ? 'even' : 'odd')
printHtmlPart(18)
createTagBody(3, {->
expressionOut.print(fieldValue(bean: personInstance, field: "name"))
})
invokeTag('link','g',46,['action':("show"),'id':(personInstance.id)],3)
printHtmlPart(19)
expressionOut.print(fieldValue(bean: personInstance, field: "vorname"))
printHtmlPart(19)
expressionOut.print(fieldValue(bean: personInstance, field: "geschlecht"))
printHtmlPart(19)
invokeTag('formatDate','g',52,['date':(personInstance.geburtsdatum),'format':("dd.MM.yyyy")],-1)
printHtmlPart(20)
expressionOut.print(fieldValue(bean: personInstance, field: "hausadresse"))
printHtmlPart(21)
i++
}
}
printHtmlPart(22)
})
invokeTag('captureBody','sitemesh',62,[:],1)
printHtmlPart(23)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1424183045000L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
