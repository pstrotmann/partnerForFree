import org.strotmann.partner.Historie
import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_partner_historieindex_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/historie/index.gsp" }
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
invokeTag('set','g',7,['var':("entityName"),'value':(message(code: 'historie.label', default: 'Historie'))],-1)
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
invokeTag('sortableColumn','g',27,['property':("userName"),'title':(message(code: 'historie.userName.label', default: 'User Name'))],-1)
printHtmlPart(13)
invokeTag('sortableColumn','g',29,['property':("gueAb"),'title':(message(code: 'historie.gueAb.label', default: 'Gue Ab'))],-1)
printHtmlPart(13)
invokeTag('sortableColumn','g',31,['property':("domainName"),'title':(message(code: 'historie.domainName.label', default: 'Domain Name'))],-1)
printHtmlPart(13)
invokeTag('sortableColumn','g',33,['property':("domainId"),'title':(message(code: 'historie.domainId.label', default: 'Domain Id'))],-1)
printHtmlPart(13)
invokeTag('sortableColumn','g',35,['property':("feldName"),'title':(message(code: 'historie.feldName.label', default: 'Feld Name'))],-1)
printHtmlPart(13)
invokeTag('sortableColumn','g',37,['property':("stringInhalt"),'title':(message(code: 'historie.stringInhalt.label', default: 'String Inhalt'))],-1)
printHtmlPart(14)
loop:{
int i = 0
for( historieInstance in (historieInstanceList) ) {
printHtmlPart(15)
expressionOut.print((i % 2) == 0 ? 'even' : 'odd')
printHtmlPart(16)
createTagBody(3, {->
expressionOut.print(fieldValue(bean: historieInstance, field: "userName"))
})
invokeTag('link','g',45,['action':("show"),'id':(historieInstance.id)],3)
printHtmlPart(17)
invokeTag('formatDate','g',47,['date':(historieInstance.gueAb)],-1)
printHtmlPart(17)
expressionOut.print(fieldValue(bean: historieInstance, field: "domainName"))
printHtmlPart(17)
expressionOut.print(fieldValue(bean: historieInstance, field: "domainId"))
printHtmlPart(17)
expressionOut.print(fieldValue(bean: historieInstance, field: "feldName"))
printHtmlPart(17)
expressionOut.print(fieldValue(bean: historieInstance, field: "stringInhalt"))
printHtmlPart(18)
i++
}
}
printHtmlPart(19)
invokeTag('paginate','g',62,['total':(historieInstanceCount ?: 0)],-1)
printHtmlPart(20)
})
invokeTag('captureBody','sitemesh',65,[:],1)
printHtmlPart(21)
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
