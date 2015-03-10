import org.strotmann.partner.Lieferadresse
import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_partner_lieferadresseindex_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/lieferadresse/index.gsp" }
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
invokeTag('set','g',7,['var':("entityName"),'value':(message(code: 'lieferadresse.label', default: 'Lieferadresse'))],-1)
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
expressionOut.print(createLink(uri: '/'))
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
invokeTag('sortableColumn','g',27,['property':("strasse"),'title':(message(code: 'lieferadresse.strasse.label', default: 'Strasse'))],-1)
printHtmlPart(13)
invokeTag('sortableColumn','g',29,['property':("hausnummer"),'title':(message(code: 'lieferadresse.hausnummer.label', default: 'Hausnummer'))],-1)
printHtmlPart(13)
invokeTag('sortableColumn','g',31,['property':("zusatz"),'title':(message(code: 'lieferadresse.zusatz.label', default: 'Zusatz'))],-1)
printHtmlPart(13)
invokeTag('sortableColumn','g',33,['property':("postleitzahl"),'title':(message(code: 'lieferadresse.postleitzahl.label', default: 'Postleitzahl'))],-1)
printHtmlPart(13)
invokeTag('sortableColumn','g',35,['property':("ort"),'title':(message(code: 'lieferadresse.ort.label', default: 'Ort'))],-1)
printHtmlPart(14)
invokeTag('message','g',37,['code':("lieferadresse.land.label"),'default':("Land")],-1)
printHtmlPart(15)
loop:{
int i = 0
for( lieferadresseInstance in (lieferadresseInstanceList) ) {
printHtmlPart(16)
expressionOut.print((i % 2) == 0 ? 'even' : 'odd')
printHtmlPart(17)
createTagBody(3, {->
expressionOut.print(fieldValue(bean: lieferadresseInstance, field: "strasse"))
})
invokeTag('link','g',45,['action':("show"),'id':(lieferadresseInstance.id)],3)
printHtmlPart(18)
expressionOut.print(fieldValue(bean: lieferadresseInstance, field: "hausnummer"))
printHtmlPart(18)
expressionOut.print(fieldValue(bean: lieferadresseInstance, field: "zusatz"))
printHtmlPart(18)
expressionOut.print(fieldValue(bean: lieferadresseInstance, field: "postleitzahl"))
printHtmlPart(18)
expressionOut.print(fieldValue(bean: lieferadresseInstance, field: "ort"))
printHtmlPart(18)
expressionOut.print(fieldValue(bean: lieferadresseInstance, field: "land"))
printHtmlPart(19)
i++
}
}
printHtmlPart(20)
invokeTag('paginate','g',62,['total':(lieferadresseInstanceCount ?: 0)],-1)
printHtmlPart(21)
})
invokeTag('captureBody','sitemesh',65,[:],1)
printHtmlPart(22)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1424599570000L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
