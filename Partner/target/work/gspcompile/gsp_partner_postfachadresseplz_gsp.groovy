import org.strotmann.partner.Postfachadresse
import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_partner_postfachadresseplz_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/postfachadresse/plz.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
createTagBody(1, {->
printHtmlPart(1)
invokeTag('captureMeta','sitemesh',5,['gsp_sm_xmlClosingForEmptyTag':(""),'name':("layout"),'content':("main")],-1)
printHtmlPart(1)
invokeTag('set','g',6,['var':("entityName"),'value':(message(code: 'postfachadresse.label', default: 'Postfachadresse'))],-1)
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
invokeTag('sortableColumn','g',26,['property':("postfach"),'title':(message(code: 'postfachadresse.postfach.label', default: 'Postfach'))],-1)
printHtmlPart(12)
invokeTag('sortableColumn','g',28,['property':("postleitzahl"),'title':(message(code: 'postfachadresse.postleitzahl.label', default: 'Postleitzahl'))],-1)
printHtmlPart(12)
invokeTag('sortableColumn','g',30,['property':("ort"),'title':(message(code: 'postfachadresse.ort.label', default: 'Ort'))],-1)
printHtmlPart(13)
invokeTag('message','g',32,['code':("postfachadresse.organisation.label"),'default':("Organisation")],-1)
printHtmlPart(14)
loop:{
int i = 0
for( postfachadresseInstance in (postfachadresseInstanceList) ) {
printHtmlPart(15)
expressionOut.print((i % 2) == 0 ? 'even' : 'odd')
printHtmlPart(16)
createTagBody(3, {->
expressionOut.print(fieldValue(bean: postfachadresseInstance, field: "postfach"))
})
invokeTag('link','g',40,['action':("show"),'id':(postfachadresseInstance.id)],3)
printHtmlPart(17)
expressionOut.print(fieldValue(bean: postfachadresseInstance, field: "postleitzahl"))
printHtmlPart(17)
expressionOut.print(fieldValue(bean: postfachadresseInstance, field: "ort"))
printHtmlPart(17)
expressionOut.print(fieldValue(bean: postfachadresseInstance, field: "organisation"))
printHtmlPart(18)
i++
}
}
printHtmlPart(19)
invokeTag('paginate','g',53,['total':(postfachadresseInstanceTotal)],-1)
printHtmlPart(20)
})
invokeTag('captureBody','sitemesh',56,[:],1)
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
