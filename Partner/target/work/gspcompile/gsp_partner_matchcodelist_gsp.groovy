import org.strotmann.partner.Matchcode
import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_partner_matchcodelist_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/matchcode/list.gsp" }
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
invokeTag('set','g',7,['var':("entityName"),'value':(message(code: 'matchcode.label', default: 'Matchcode'))],-1)
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
invokeTag('message','g',15,['code':("default.matchcode.label"),'args':([entityName])],-1)
})
invokeTag('link','g',15,['class':("create"),'action':("create")],2)
printHtmlPart(8)
invokeTag('message','g',19,['code':("default.list.label"),'args':([entityName])],-1)
printHtmlPart(9)
if(true && (flash.message)) {
printHtmlPart(10)
expressionOut.print(flash.message)
printHtmlPart(11)
}
printHtmlPart(12)
invokeTag('sortableColumn','g',26,['property':("name"),'title':(message(code: 'matchcode.name.label', default: 'Name'))],-1)
printHtmlPart(13)
invokeTag('sortableColumn','g',28,['property':("vorname"),'title':(message(code: 'matchcode.vorname.label', default: ' '))],-1)
printHtmlPart(14)
invokeTag('sortableColumn','g',30,['property':("strasse"),'title':(message(code: 'matchcode.strasse.label', default: 'Strasse'))],-1)
printHtmlPart(14)
invokeTag('sortableColumn','g',32,['property':("postleitzahl"),'title':(message(code: 'matchcode.postleitzahl.label', default: 'Plz'))],-1)
printHtmlPart(14)
invokeTag('sortableColumn','g',34,['property':("ort"),'title':(message(code: 'matchcode.ort.label', default: 'Ort'))],-1)
printHtmlPart(15)
loop:{
int i = 0
for( matchcodeInstance in (matchcodeInstanceList) ) {
printHtmlPart(16)
expressionOut.print((i % 2) == 0 ? 'even' : 'odd')
printHtmlPart(17)
if(true && (matchcodeInstance.partnerart == 'p')) {
printHtmlPart(18)
createTagBody(4, {->
expressionOut.print(fieldValue(bean: matchcodeInstance, field: "name"))
})
invokeTag('link','g',44,['controller':("person"),'action':("show"),'id':(matchcodeInstance.id)],4)
printHtmlPart(18)
}
printHtmlPart(18)
if(true && (matchcodeInstance.partnerart == 'o')) {
printHtmlPart(18)
createTagBody(4, {->
expressionOut.print(fieldValue(bean: matchcodeInstance, field: "name"))
})
invokeTag('link','g',47,['controller':("organisation"),'action':("show"),'id':(matchcodeInstance.id)],4)
printHtmlPart(18)
}
printHtmlPart(19)
expressionOut.print(fieldValue(bean: matchcodeInstance, field: "vorname"))
printHtmlPart(20)
expressionOut.print(fieldValue(bean: matchcodeInstance, field: "strasse"))
printHtmlPart(21)
if(true && (matchcodeInstance.postleitzahl == 0)) {
printHtmlPart(22)
}
else {
printHtmlPart(23)
expressionOut.print(fieldValue(bean: matchcodeInstance, field: "postleitzahl"))
printHtmlPart(24)
}
printHtmlPart(25)
expressionOut.print(fieldValue(bean: matchcodeInstance, field: "ort"))
printHtmlPart(26)
i++
}
}
printHtmlPart(27)
invokeTag('paginate','g',69,['total':(matchcodeInstanceTotal)],-1)
printHtmlPart(28)
})
invokeTag('captureBody','sitemesh',72,[:],1)
printHtmlPart(29)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1424177791000L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
