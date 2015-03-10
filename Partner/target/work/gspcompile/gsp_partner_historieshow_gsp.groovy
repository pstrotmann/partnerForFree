import org.strotmann.partner.Historie
import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_partner_historieshow_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/historie/show.gsp" }
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
invokeTag('message','g',8,['code':("default.show.label"),'args':([entityName])],-1)
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
invokeTag('message','g',15,['code':("default.list.label"),'args':([entityName])],-1)
})
invokeTag('link','g',15,['class':("list"),'action':("index")],2)
printHtmlPart(8)
createTagBody(2, {->
invokeTag('message','g',16,['code':("default.new.label"),'args':([entityName])],-1)
})
invokeTag('link','g',16,['class':("create"),'action':("create")],2)
printHtmlPart(9)
invokeTag('message','g',20,['code':("default.show.label"),'args':([entityName])],-1)
printHtmlPart(10)
if(true && (flash.message)) {
printHtmlPart(11)
expressionOut.print(flash.message)
printHtmlPart(12)
}
printHtmlPart(13)
if(true && (historieInstance?.userName)) {
printHtmlPart(14)
invokeTag('message','g',28,['code':("historie.userName.label"),'default':("User Name")],-1)
printHtmlPart(15)
invokeTag('fieldValue','g',30,['bean':(historieInstance),'field':("userName")],-1)
printHtmlPart(16)
}
printHtmlPart(17)
if(true && (historieInstance?.gueAb)) {
printHtmlPart(18)
invokeTag('message','g',37,['code':("historie.gueAb.label"),'default':("Gue Ab")],-1)
printHtmlPart(19)
invokeTag('formatDate','g',39,['date':(historieInstance?.gueAb)],-1)
printHtmlPart(16)
}
printHtmlPart(17)
if(true && (historieInstance?.domainName)) {
printHtmlPart(20)
invokeTag('message','g',46,['code':("historie.domainName.label"),'default':("Domain Name")],-1)
printHtmlPart(21)
invokeTag('fieldValue','g',48,['bean':(historieInstance),'field':("domainName")],-1)
printHtmlPart(16)
}
printHtmlPart(17)
if(true && (historieInstance?.domainId)) {
printHtmlPart(22)
invokeTag('message','g',55,['code':("historie.domainId.label"),'default':("Domain Id")],-1)
printHtmlPart(23)
invokeTag('fieldValue','g',57,['bean':(historieInstance),'field':("domainId")],-1)
printHtmlPart(16)
}
printHtmlPart(17)
if(true && (historieInstance?.feldName)) {
printHtmlPart(24)
invokeTag('message','g',64,['code':("historie.feldName.label"),'default':("Feld Name")],-1)
printHtmlPart(25)
invokeTag('fieldValue','g',66,['bean':(historieInstance),'field':("feldName")],-1)
printHtmlPart(16)
}
printHtmlPart(17)
if(true && (historieInstance?.stringInhalt)) {
printHtmlPart(26)
invokeTag('message','g',73,['code':("historie.stringInhalt.label"),'default':("String Inhalt")],-1)
printHtmlPart(27)
invokeTag('fieldValue','g',75,['bean':(historieInstance),'field':("stringInhalt")],-1)
printHtmlPart(16)
}
printHtmlPart(17)
if(true && (historieInstance?.charInhalt)) {
printHtmlPart(28)
invokeTag('message','g',82,['code':("historie.charInhalt.label"),'default':("Char Inhalt")],-1)
printHtmlPart(29)
invokeTag('fieldValue','g',84,['bean':(historieInstance),'field':("charInhalt")],-1)
printHtmlPart(16)
}
printHtmlPart(17)
if(true && (historieInstance?.intInhalt)) {
printHtmlPart(30)
invokeTag('message','g',91,['code':("historie.intInhalt.label"),'default':("Int Inhalt")],-1)
printHtmlPart(31)
invokeTag('fieldValue','g',93,['bean':(historieInstance),'field':("intInhalt")],-1)
printHtmlPart(16)
}
printHtmlPart(17)
if(true && (historieInstance?.longInhalt)) {
printHtmlPart(32)
invokeTag('message','g',100,['code':("historie.longInhalt.label"),'default':("Long Inhalt")],-1)
printHtmlPart(33)
invokeTag('fieldValue','g',102,['bean':(historieInstance),'field':("longInhalt")],-1)
printHtmlPart(16)
}
printHtmlPart(17)
if(true && (historieInstance?.dateInhalt)) {
printHtmlPart(34)
invokeTag('message','g',109,['code':("historie.dateInhalt.label"),'default':("Date Inhalt")],-1)
printHtmlPart(35)
invokeTag('formatDate','g',111,['date':(historieInstance?.dateInhalt)],-1)
printHtmlPart(16)
}
printHtmlPart(17)
if(true && (historieInstance?.booleanInhalt)) {
printHtmlPart(36)
invokeTag('message','g',118,['code':("historie.booleanInhalt.label"),'default':("Boolean Inhalt")],-1)
printHtmlPart(37)
invokeTag('formatBoolean','g',120,['boolean':(historieInstance?.booleanInhalt)],-1)
printHtmlPart(16)
}
printHtmlPart(38)
createTagBody(2, {->
printHtmlPart(39)
createTagBody(3, {->
invokeTag('message','g',128,['code':("default.button.edit.label"),'default':("Edit")],-1)
})
invokeTag('link','g',128,['class':("edit"),'action':("edit"),'resource':(historieInstance)],3)
printHtmlPart(40)
invokeTag('actionSubmit','g',129,['class':("delete"),'action':("delete"),'value':(message(code: 'default.button.delete.label', default: 'Delete')),'onclick':("return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');")],-1)
printHtmlPart(41)
})
invokeTag('form','g',131,['url':([resource:historieInstance, action:'delete']),'method':("DELETE")],2)
printHtmlPart(42)
})
invokeTag('captureBody','sitemesh',133,[:],1)
printHtmlPart(43)
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
