import org.strotmann.partner.Organisation
import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_partner_organisationjoin_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/organisation/join.gsp" }
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
invokeTag('message','g',7,['code':("default.show.label"),'args':([entityName])],-1)
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
invokeTag('message','g',17,['code':("default.pMerge.label")],-1)
printHtmlPart(7)
if(true && (flash.message)) {
printHtmlPart(8)
expressionOut.print(flash.message)
printHtmlPart(9)
}
printHtmlPart(10)
createTagBody(2, {->
printHtmlPart(11)
invokeTag('fieldValue','g',35,['bean':(organisationInstance1),'field':("name")],-1)
printHtmlPart(12)
invokeTag('checkBox','g',36,['name':("organisationInstance1.name")],-1)
printHtmlPart(12)
invokeTag('fieldValue','g',37,['bean':(organisationInstance2),'field':("name")],-1)
printHtmlPart(12)
invokeTag('checkBox','g',38,['name':("organisationInstance2.name")],-1)
printHtmlPart(13)
invokeTag('fieldValue','g',42,['bean':(organisationInstance1),'field':("nameZusatz")],-1)
printHtmlPart(12)
invokeTag('checkBox','g',43,['name':("organisationInstance1.nameZusatz")],-1)
printHtmlPart(12)
invokeTag('fieldValue','g',44,['bean':(organisationInstance2),'field':("nameZusatz")],-1)
printHtmlPart(12)
invokeTag('checkBox','g',45,['name':("organisationInstance2.nameZusatz")],-1)
printHtmlPart(14)
invokeTag('fieldValue','g',49,['bean':(organisationInstance1),'field':("rechtsform")],-1)
printHtmlPart(12)
invokeTag('checkBox','g',50,['name':("organisationInstance1.rechtsform")],-1)
printHtmlPart(12)
invokeTag('fieldValue','g',51,['bean':(organisationInstance2),'field':("rechtsform")],-1)
printHtmlPart(12)
invokeTag('checkBox','g',52,['name':("organisationInstance2.rechtsform")],-1)
printHtmlPart(15)
createTagBody(3, {->
expressionOut.print(organisationInstance1?.hausadresse?.encodeAsHTML())
})
invokeTag('link','g',56,['controller':("hausadresse"),'action':("show"),'id':(organisationInstance1?.hausadresse?.id)],3)
printHtmlPart(12)
invokeTag('checkBox','g',57,['name':("organisationInstance1.hausadresse")],-1)
printHtmlPart(12)
createTagBody(3, {->
expressionOut.print(organisationInstance2?.hausadresse?.encodeAsHTML())
})
invokeTag('link','g',58,['controller':("hausadresse"),'action':("show"),'id':(organisationInstance2?.hausadresse?.id)],3)
printHtmlPart(12)
invokeTag('checkBox','g',59,['name':("organisationInstance2.hausadresse")],-1)
printHtmlPart(16)
invokeTag('actionSubmit','g',65,['class':("save"),'action':("joinZwei"),'value':(message(code: 'default.button.merge.label', default: 'Join'))],-1)
printHtmlPart(17)
})
invokeTag('form','g',67,['method':("put"),'action':("joinZwei")],2)
printHtmlPart(18)
})
invokeTag('captureBody','sitemesh',69,[:],1)
printHtmlPart(19)
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
