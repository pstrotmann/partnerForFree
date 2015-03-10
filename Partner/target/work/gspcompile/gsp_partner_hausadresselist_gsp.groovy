import org.strotmann.partner.Hausadresse
import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_partner_hausadresselist_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/hausadresse/list.gsp" }
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
invokeTag('set','g',7,['var':("entityName"),'value':(message(code: 'hausadresse.label', default: 'Hausadresse'))],-1)
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
invokeTag('message','g',19,['code':("default.list.label"),'args':([entityName])],-1)
printHtmlPart(9)
if(true && (flash.message)) {
printHtmlPart(10)
expressionOut.print(flash.message)
printHtmlPart(11)
}
printHtmlPart(12)
invokeTag('sortableColumn','g',27,['property':("strasse"),'title':(message(code: 'hausadresse.strasse.label', default: 'Strasse'))],-1)
printHtmlPart(13)
invokeTag('sortableColumn','g',29,['property':("hausnummer"),'title':(message(code: 'hausadresse.hausnummer.label', default: 'Hausnummer'))],-1)
printHtmlPart(13)
invokeTag('sortableColumn','g',31,['property':("zusatz"),'title':(message(code: 'hausadresse.zusatz.label', default: 'Zusatz'))],-1)
printHtmlPart(13)
invokeTag('sortableColumn','g',33,['property':("postleitzahl"),'title':(message(code: 'hausadresse.postleitzahl.label', default: 'Postleitzahl'))],-1)
printHtmlPart(13)
invokeTag('sortableColumn','g',35,['property':("ort"),'title':(message(code: 'hausadresse.ort.label', default: 'Ort'))],-1)
printHtmlPart(13)
invokeTag('sortableColumn','g',37,['property':("phStrasse"),'title':(message(code: 'hausadresse.phStrasse.label', default: 'Ph Strasse'))],-1)
printHtmlPart(14)
invokeTag('sortableColumn','g',39,['property':("phOrt"),'title':(message(code: 'hausadresse.phStrasse.label', default: 'Ph Ort'))],-1)
printHtmlPart(15)
loop:{
int i = 0
for( hausadresseInstance in (hausadresseInstanceList) ) {
printHtmlPart(16)
expressionOut.print((i % 2) == 0 ? 'even' : 'odd')
printHtmlPart(17)
createTagBody(3, {->
expressionOut.print(fieldValue(bean: hausadresseInstance, field: "strasse"))
})
invokeTag('link','g',47,['action':("show"),'id':(hausadresseInstance.id)],3)
printHtmlPart(18)
expressionOut.print(fieldValue(bean: hausadresseInstance, field: "hausnummer"))
printHtmlPart(18)
expressionOut.print(fieldValue(bean: hausadresseInstance, field: "zusatz"))
printHtmlPart(18)
expressionOut.print(fieldValue(bean: hausadresseInstance, field: "postleitzahl"))
printHtmlPart(18)
expressionOut.print(fieldValue(bean: hausadresseInstance, field: "ort"))
printHtmlPart(18)
expressionOut.print(fieldValue(bean: hausadresseInstance, field: "phStrasse"))
printHtmlPart(19)
expressionOut.print(fieldValue(bean: hausadresseInstance, field: "phOrt"))
printHtmlPart(20)
i++
}
}
printHtmlPart(21)
invokeTag('paginate','g',66,['total':(hausadresseInstanceCount ?: 0)],-1)
printHtmlPart(22)
})
invokeTag('captureBody','sitemesh',69,[:],1)
printHtmlPart(23)
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
