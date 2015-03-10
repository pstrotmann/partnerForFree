import org.strotmann.partner.Organisation
import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_partner_organisationphList_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/organisation/phList.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
createTagBody(1, {->
printHtmlPart(1)
invokeTag('captureMeta','sitemesh',5,['gsp_sm_xmlClosingForEmptyTag':(""),'name':("layout"),'content':("main")],-1)
printHtmlPart(1)
invokeTag('set','g',6,['var':("entityName"),'value':(message(code: 'organisation.label', default: 'Organisation'))],-1)
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
invokeTag('message','g',17,['code':("default.list.label"),'args':([entityName])],-1)
printHtmlPart(7)
if(true && (flash.message)) {
printHtmlPart(8)
expressionOut.print(flash.message)
printHtmlPart(9)
}
printHtmlPart(10)
createTagBody(2, {->
printHtmlPart(11)
invokeTag('sortableColumn','g',26,['property':("name"),'title':(message(code: 'organisation.name.label', default: 'Name'))],-1)
printHtmlPart(12)
invokeTag('sortableColumn','g',28,['property':("nameZusatz"),'title':(message(code: 'organisation.nameZusatz.label', default: 'Name Zusatz'))],-1)
printHtmlPart(12)
invokeTag('sortableColumn','g',30,['property':("rechtsform"),'title':(message(code: 'organisation.rechtsform.label', default: 'Rechtsform'))],-1)
printHtmlPart(12)
invokeTag('sortableColumn','g',32,['property':("hausadresse"),'title':(message(code: 'organisation.hausadresse.label', default: 'Hausadresse'))],-1)
printHtmlPart(13)
loop:{
int i = 0
for( organisationInstance in (organisationInstanceList) ) {
printHtmlPart(14)
expressionOut.print((i % 2) == 0 ? 'even' : 'odd')
printHtmlPart(15)
createTagBody(4, {->
expressionOut.print(fieldValue(bean: organisationInstance, field: "name"))
})
invokeTag('link','g',40,['action':("show"),'id':(organisationInstance.id)],4)
printHtmlPart(16)
expressionOut.print(fieldValue(bean: organisationInstance, field: "nameZusatz"))
printHtmlPart(16)
expressionOut.print(fieldValue(bean: organisationInstance, field: "rechtsform"))
printHtmlPart(17)
invokeTag('checkBox','g',46,['name':("organisationInstanceList[${i}].checked")],-1)
printHtmlPart(18)
i++
}
}
printHtmlPart(19)
invokeTag('actionSubmit','g',56,['class':("save"),'action':("join"),'value':(message(code: 'default.button.merge.label', default: 'Join'))],-1)
printHtmlPart(20)
})
invokeTag('form','g',59,['method':("put"),'action':("join")],2)
printHtmlPart(21)
})
invokeTag('captureBody','sitemesh',61,[:],1)
printHtmlPart(22)
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
