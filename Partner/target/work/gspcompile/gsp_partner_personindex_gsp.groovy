import org.strotmann.partner.Person
import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_partner_personindex_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/person/index.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
createTagBody(1, {->
printHtmlPart(1)
invokeTag('captureMeta','sitemesh',5,['gsp_sm_xmlClosingForEmptyTag':(""),'name':("layout"),'content':("main")],-1)
printHtmlPart(1)
invokeTag('set','g',6,['var':("entityName"),'value':(message(code: 'person.label', default: 'Person'))],-1)
printHtmlPart(1)
createTagBody(2, {->
createTagBody(3, {->
invokeTag('message','g',7,['code':("default.list.label"),'args':([entityName])],-1)
})
invokeTag('captureTitle','sitemesh',7,[:],3)
})
invokeTag('wrapTitleTag','sitemesh',7,[:],2)
printHtmlPart(2)
})
invokeTag('captureHead','sitemesh',8,[:],1)
printHtmlPart(2)
createTagBody(1, {->
printHtmlPart(3)
invokeTag('message','g',10,['code':("default.link.skip.label"),'default':("Skip to content&hellip;")],-1)
printHtmlPart(4)
expressionOut.print(createLink(uri: "/menu", params: [lang: session.user.sprache]))
printHtmlPart(5)
invokeTag('message','g',13,['code':("default.home.label")],-1)
printHtmlPart(6)
createTagBody(2, {->
invokeTag('message','g',14,['code':("default.new.label"),'args':([entityName])],-1)
})
invokeTag('link','g',14,['class':("create"),'action':("create")],2)
printHtmlPart(7)
invokeTag('message','g',18,['code':("default.list.label"),'args':([entityName])],-1)
printHtmlPart(8)
if(true && (flash.message)) {
printHtmlPart(9)
expressionOut.print(flash.message)
printHtmlPart(10)
}
printHtmlPart(11)
invokeTag('sortableColumn','g',26,['property':("name"),'title':(message(code: 'person.name.label', default: 'Name'))],-1)
printHtmlPart(12)
invokeTag('sortableColumn','g',28,['property':("vorname"),'title':(message(code: 'person.vorname.label', default: 'Vorname'))],-1)
printHtmlPart(12)
invokeTag('sortableColumn','g',30,['property':("geschlecht"),'title':(message(code: 'person.geschlecht.label', default: 'Geschlecht'))],-1)
printHtmlPart(12)
invokeTag('sortableColumn','g',32,['property':("geburtsdatum"),'title':(message(code: 'person.geburtsdatum.label', default: 'Geburtsdatum'))],-1)
printHtmlPart(13)
invokeTag('sortableColumn','g',34,['property':("hausadresse"),'title':(message(code: 'person.hausadresse.label', default: 'Hausadresse'))],-1)
printHtmlPart(14)
loop:{
int i = 0
for( personInstance in (personInstanceList) ) {
printHtmlPart(15)
expressionOut.print((i % 2) == 0 ? 'even' : 'odd')
printHtmlPart(16)
createTagBody(3, {->
expressionOut.print(fieldValue(bean: personInstance, field: "name"))
})
invokeTag('link','g',43,['action':("show"),'id':(personInstance.id)],3)
printHtmlPart(17)
expressionOut.print(fieldValue(bean: personInstance, field: "vorname"))
printHtmlPart(17)
expressionOut.print(fieldValue(bean: personInstance, field: "geschlecht"))
printHtmlPart(17)
invokeTag('formatDate','g',49,['date':(personInstance.geburtsdatum),'format':("dd.MM.yyyy")],-1)
printHtmlPart(18)
expressionOut.print(fieldValue(bean: personInstance, field: "hausadresse"))
printHtmlPart(19)
i++
}
}
printHtmlPart(20)
})
invokeTag('captureBody','sitemesh',59,[:],1)
printHtmlPart(21)
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
