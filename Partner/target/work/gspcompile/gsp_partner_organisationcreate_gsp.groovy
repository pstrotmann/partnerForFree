import org.strotmann.partner.Organisation
import org.strotmann.partner.Hausadresse
import org.strotmann.partner.Lieferadresse
import org.strotmann.partner.Postfachadresse
import org.strotmann.partner.Bankverbindung
import org.strotmann.partner.Kommunikation
import org.strotmann.notiz.Notiz
import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_partner_organisationcreate_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/organisation/create.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
printHtmlPart(0)
printHtmlPart(0)
printHtmlPart(0)
printHtmlPart(0)
printHtmlPart(0)
printHtmlPart(1)
createTagBody(1, {->
printHtmlPart(2)
invokeTag('captureMeta','sitemesh',11,['gsp_sm_xmlClosingForEmptyTag':(""),'name':("layout"),'content':("main")],-1)
printHtmlPart(2)
invokeTag('set','g',12,['var':("entityName"),'value':(message(code: 'organisation.label', default: 'Organisation'))],-1)
printHtmlPart(2)
createTagBody(2, {->
createTagBody(3, {->
invokeTag('message','g',13,['code':("default.create.label"),'args':([entityName])],-1)
})
invokeTag('captureTitle','sitemesh',13,[:],3)
})
invokeTag('wrapTitleTag','sitemesh',13,[:],2)
printHtmlPart(3)
})
invokeTag('captureHead','sitemesh',14,[:],1)
printHtmlPart(3)
createTagBody(1, {->
printHtmlPart(4)
invokeTag('message','g',16,['code':("default.link.skip.label"),'default':("Skip to content&hellip;")],-1)
printHtmlPart(5)
expressionOut.print(createLink(uri: "/menu", params: [lang: session.user.sprache]))
printHtmlPart(6)
invokeTag('message','g',19,['code':("default.home.label")],-1)
printHtmlPart(7)
createTagBody(2, {->
invokeTag('message','g',20,['code':("default.list.label"),'args':([entityName])],-1)
})
invokeTag('link','g',20,['class':("list"),'action':("list")],2)
printHtmlPart(8)
invokeTag('message','g',24,['code':("default.create.label"),'args':([entityName])],-1)
printHtmlPart(9)
if(true && (flash.message)) {
printHtmlPart(10)
expressionOut.print(flash.message)
printHtmlPart(11)
}
printHtmlPart(12)
createTagBody(2, {->
printHtmlPart(13)
createTagBody(3, {->
printHtmlPart(14)
if(true && (error in org.springframework.validation.FieldError)) {
printHtmlPart(15)
expressionOut.print(error.field)
printHtmlPart(16)
}
printHtmlPart(17)
invokeTag('message','g',31,['error':(error)],-1)
printHtmlPart(18)
})
invokeTag('eachError','g',32,['bean':(organisationInstance),'var':("error")],3)
printHtmlPart(19)
})
invokeTag('hasErrors','g',34,['bean':(organisationInstance)],2)
printHtmlPart(12)
createTagBody(2, {->
printHtmlPart(20)
invokeTag('render','g',37,['template':("form2")],-1)
printHtmlPart(21)
invokeTag('render','g',38,['template':("/hausadresse/form2"),'model':(['hausadresseInstance':new Hausadresse()])],-1)
printHtmlPart(21)
invokeTag('render','g',39,['template':("/postfachadresse/form2"),'model':(['postfachadresseInstance':new Postfachadresse()])],-1)
printHtmlPart(21)
invokeTag('render','g',40,['template':("/lieferadresse/form2"),'model':(['lieferadresseInstance':new Lieferadresse()])],-1)
printHtmlPart(21)
invokeTag('render','g',41,['template':("/bankverbindung/form2"),'model':(['bankverbindungInstance':new Bankverbindung()])],-1)
printHtmlPart(21)
invokeTag('render','g',42,['template':("/kommunikation/form2"),'model':(['kommunikationInstance':new Kommunikation()])],-1)
printHtmlPart(21)
invokeTag('render','g',43,['template':("/notiz/form2"),'model':(['notizInstance':new Notiz()])],-1)
printHtmlPart(22)
invokeTag('submitButton','g',46,['name':("create"),'class':("save"),'value':(message(code: 'default.button.create.label', default: 'Create'))],-1)
printHtmlPart(21)
invokeTag('actionSubmit','g',47,['class':("list"),'action':("plz"),'value':(message(code: 'default.button.plz.label', default: 'plz bestimmen'))],-1)
printHtmlPart(23)
})
invokeTag('form','g',49,['action':("save")],2)
printHtmlPart(24)
})
invokeTag('captureBody','sitemesh',51,[:],1)
printHtmlPart(25)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1424680767000L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
