import org.strotmann.partner.Person
import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_partner_personjoin_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/person/join.gsp" }
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
invokeTag('fieldValue','g',35,['bean':(personInstance1),'field':("name")],-1)
printHtmlPart(12)
invokeTag('checkBox','g',36,['name':("personInstance1.name")],-1)
printHtmlPart(12)
invokeTag('fieldValue','g',37,['bean':(personInstance2),'field':("name")],-1)
printHtmlPart(12)
invokeTag('checkBox','g',38,['name':("personInstance2.name")],-1)
printHtmlPart(13)
invokeTag('fieldValue','g',42,['bean':(personInstance1),'field':("titel")],-1)
printHtmlPart(12)
invokeTag('checkBox','g',43,['name':("personInstance1.titel")],-1)
printHtmlPart(12)
invokeTag('fieldValue','g',44,['bean':(personInstance2),'field':("titel")],-1)
printHtmlPart(12)
invokeTag('checkBox','g',45,['name':("personInstance2.titel")],-1)
printHtmlPart(14)
invokeTag('fieldValue','g',49,['bean':(personInstance1),'field':("vorname")],-1)
printHtmlPart(12)
invokeTag('checkBox','g',50,['name':("personInstance1.vorname")],-1)
printHtmlPart(12)
invokeTag('fieldValue','g',51,['bean':(personInstance2),'field':("vorname")],-1)
printHtmlPart(12)
invokeTag('checkBox','g',52,['name':("personInstance2.vorname")],-1)
printHtmlPart(15)
invokeTag('fieldValue','g',56,['bean':(personInstance1),'field':("geschlecht")],-1)
printHtmlPart(12)
invokeTag('checkBox','g',57,['name':("personInstance1.geschlecht")],-1)
printHtmlPart(12)
invokeTag('fieldValue','g',58,['bean':(personInstance2),'field':("geschlecht")],-1)
printHtmlPart(12)
invokeTag('checkBox','g',59,['name':("personInstance2.geschlecht")],-1)
printHtmlPart(16)
invokeTag('formatBoolean','g',63,['boolean':(personInstance1?.persoenlicheAnrede),'true':("persönlich"),'false':("formal")],-1)
printHtmlPart(12)
invokeTag('checkBox','g',64,['name':("personInstance1.anrede")],-1)
printHtmlPart(12)
invokeTag('formatBoolean','g',65,['boolean':(personInstance2?.persoenlicheAnrede),'true':("persönlich"),'false':("formal")],-1)
printHtmlPart(12)
invokeTag('checkBox','g',66,['name':("personInstance2.anrede")],-1)
printHtmlPart(17)
invokeTag('formatDate','g',70,['date':(personInstance1?.geburtsdatum),'format':("dd.MM.yyyy")],-1)
printHtmlPart(12)
invokeTag('checkBox','g',71,['name':("personInstance1.geburtsdatum")],-1)
printHtmlPart(12)
invokeTag('formatDate','g',72,['date':(personInstance2?.geburtsdatum),'format':("dd.MM.yyyy")],-1)
printHtmlPart(12)
invokeTag('checkBox','g',73,['name':("personInstance2.geburtsdatum")],-1)
printHtmlPart(18)
createTagBody(3, {->
expressionOut.print(personInstance1?.hausadresse?.encodeAsHTML())
})
invokeTag('link','g',77,['controller':("hausadresse"),'action':("show"),'id':(personInstance1?.hausadresse?.id)],3)
printHtmlPart(12)
invokeTag('checkBox','g',78,['name':("personInstance1.hausadresse")],-1)
printHtmlPart(12)
createTagBody(3, {->
expressionOut.print(personInstance2?.hausadresse?.encodeAsHTML())
})
invokeTag('link','g',79,['controller':("hausadresse"),'action':("show"),'id':(personInstance2?.hausadresse?.id)],3)
printHtmlPart(12)
invokeTag('checkBox','g',80,['name':("personInstance2.hausadresse")],-1)
printHtmlPart(19)
invokeTag('actionSubmit','g',85,['class':("save"),'action':("joinZwei"),'value':(message(code: 'default.button.merge.label', default: 'Join'))],-1)
printHtmlPart(20)
})
invokeTag('form','g',87,['method':("put"),'action':("joinZwei")],2)
printHtmlPart(21)
})
invokeTag('captureBody','sitemesh',89,[:],1)
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
