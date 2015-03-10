import org.strotmann.partner.Historie
import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_partner_historiedomList_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/historie/domList.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
createTagBody(1, {->
printHtmlPart(1)
invokeTag('captureMeta','sitemesh',5,['gsp_sm_xmlClosingForEmptyTag':(""),'name':("layout"),'content':("main")],-1)
printHtmlPart(1)
invokeTag('set','g',6,['var':("entityName"),'value':(message(code: 'historie.label', default: 'Historie'))],-1)
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
if(true && (flash.dom)) {
printHtmlPart(7)
createTagBody(3, {->
invokeTag('message','g',15,['code':("default.akt.label"),'args':([flash.domName])],-1)
})
invokeTag('link','g',15,['controller':(flash.domName),'action':("show"),'id':(flash.domId)],3)
printHtmlPart(8)
}
else {
printHtmlPart(7)
createTagBody(3, {->
invokeTag('message','g',18,['code':("default.loe.label"),'args':([flash.domName])],-1)
})
invokeTag('link','g',18,['class':("create"),'controller':("historie"),'action':("loeList"),'params':([domName:flash.domName])],3)
printHtmlPart(8)
}
printHtmlPart(9)
invokeTag('message','g',23,['code':("default.histo.label"),'args':([flash.domName])],-1)
printHtmlPart(10)
if(true && (flash.message)) {
printHtmlPart(11)
expressionOut.print(flash.message)
printHtmlPart(12)
}
printHtmlPart(13)
loop:{
int i = 0
for( historieInstance in (historieInstanceList) ) {
printHtmlPart(14)
expressionOut.print((i % 2) == 0 ? 'even' : 'odd')
printHtmlPart(15)
createTagBody(3, {->
expressionOut.print(fieldValue(bean: historieInstance, field: "userName"))
})
invokeTag('link','g',47,['action':("show"),'id':(historieInstance.id)],3)
printHtmlPart(16)
invokeTag('formatDate','g',49,['date':(historieInstance.gueAb)],-1)
printHtmlPart(17)
invokeTag('formatDate','g',51,['date':(historieInstance.gueBis)],-1)
printHtmlPart(18)
expressionOut.print(fieldValue(bean: historieInstance, field: "feldName"))
printHtmlPart(16)
expressionOut.print(fieldValue(bean: historieInstance, field: "feldinhalt"))
printHtmlPart(19)
i++
}
}
printHtmlPart(20)
invokeTag('paginate','g',62,['total':(historieInstanceCount ?: 0)],-1)
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
public static final long LAST_MODIFIED = 1424177791000L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
