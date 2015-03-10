import org.strotmann.partner.Person
import org.strotmann.partner.Hausadresse
import org.strotmann.partner.Bankverbindung
import org.strotmann.partner.Kommunikation
import org.strotmann.notiz.Notiz
import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_partner_personcreate_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/person/create.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
printHtmlPart(0)
printHtmlPart(0)
printHtmlPart(0)
printHtmlPart(1)
createTagBody(1, {->
printHtmlPart(2)
invokeTag('captureMeta','sitemesh',9,['gsp_sm_xmlClosingForEmptyTag':(""),'name':("layout"),'content':("main")],-1)
printHtmlPart(2)
invokeTag('set','g',10,['var':("entityName"),'value':(message(code: 'person.label', default: 'Person'))],-1)
printHtmlPart(2)
createTagBody(2, {->
createTagBody(3, {->
invokeTag('message','g',11,['code':("default.create.label"),'args':([entityName])],-1)
})
invokeTag('captureTitle','sitemesh',11,[:],3)
})
invokeTag('wrapTitleTag','sitemesh',11,[:],2)
printHtmlPart(3)
})
invokeTag('captureHead','sitemesh',12,[:],1)
printHtmlPart(3)
createTagBody(1, {->
printHtmlPart(4)
invokeTag('message','g',14,['code':("default.link.skip.label"),'default':("Skip to content&hellip;")],-1)
printHtmlPart(5)
expressionOut.print(createLink(uri: "/menu", params: [lang: session.user.sprache]))
printHtmlPart(6)
invokeTag('message','g',17,['code':("default.home.label")],-1)
printHtmlPart(7)
createTagBody(2, {->
invokeTag('message','g',18,['code':("default.list.label"),'args':([entityName])],-1)
})
invokeTag('link','g',18,['class':("list"),'action':("list")],2)
printHtmlPart(8)
invokeTag('message','g',22,['code':("default.create.label"),'args':([entityName])],-1)
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
invokeTag('message','g',29,['error':(error)],-1)
printHtmlPart(18)
})
invokeTag('eachError','g',30,['bean':(personInstance),'var':("error")],3)
printHtmlPart(19)
})
invokeTag('hasErrors','g',32,['bean':(personInstance)],2)
printHtmlPart(12)
createTagBody(2, {->
printHtmlPart(20)
invokeTag('render','g',35,['template':("form2")],-1)
printHtmlPart(21)
invokeTag('render','g',36,['template':("/hausadresse/form2"),'model':(['hausadresseInstance':new Hausadresse()])],-1)
printHtmlPart(21)
invokeTag('render','g',37,['template':("/bankverbindung/form2"),'model':(['bankverbindungInstance':new Bankverbindung()])],-1)
printHtmlPart(21)
invokeTag('render','g',38,['template':("/kommunikation/form2"),'model':(['kommunikationInstance':new Kommunikation()])],-1)
printHtmlPart(21)
invokeTag('render','g',39,['template':("/notiz/form2"),'model':(['notizInstance':new Notiz()])],-1)
printHtmlPart(22)
invokeTag('submitButton','g',42,['name':("create"),'class':("save"),'value':(message(code: 'default.button.create.label'))],-1)
printHtmlPart(21)
invokeTag('actionSubmit','g',43,['class':("list"),'action':("plz"),'value':(message(code: 'default.button.plz.label'))],-1)
printHtmlPart(23)
})
invokeTag('form','g',45,['action':("save")],2)
printHtmlPart(24)
})
invokeTag('captureBody','sitemesh',47,[:],1)
printHtmlPart(25)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1424805787000L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
