import org.strotmann.partner.Historie
import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_partner_historie_form_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/historie/_form.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
expressionOut.print(hasErrors(bean: historieInstance, field: 'userName', 'error'))
printHtmlPart(1)
invokeTag('message','g',7,['code':("historie.userName.label"),'default':("User Name")],-1)
printHtmlPart(2)
invokeTag('textField','g',10,['name':("userName"),'required':(""),'value':(historieInstance?.userName)],-1)
printHtmlPart(3)
expressionOut.print(hasErrors(bean: historieInstance, field: 'gueAb', 'error'))
printHtmlPart(4)
invokeTag('message','g',16,['code':("historie.gueAb.label"),'default':("Gue Ab")],-1)
printHtmlPart(2)
invokeTag('datePicker','g',19,['name':("gueAb"),'precision':("day"),'value':(historieInstance?.gueAb)],-1)
printHtmlPart(3)
expressionOut.print(hasErrors(bean: historieInstance, field: 'domainName', 'error'))
printHtmlPart(5)
invokeTag('message','g',25,['code':("historie.domainName.label"),'default':("Domain Name")],-1)
printHtmlPart(2)
invokeTag('textField','g',28,['name':("domainName"),'required':(""),'value':(historieInstance?.domainName)],-1)
printHtmlPart(3)
expressionOut.print(hasErrors(bean: historieInstance, field: 'domainId', 'error'))
printHtmlPart(6)
invokeTag('message','g',34,['code':("historie.domainId.label"),'default':("Domain Id")],-1)
printHtmlPart(2)
invokeTag('field','g',37,['name':("domainId"),'type':("number"),'value':(historieInstance.domainId),'required':("")],-1)
printHtmlPart(3)
expressionOut.print(hasErrors(bean: historieInstance, field: 'feldName', 'error'))
printHtmlPart(7)
invokeTag('message','g',43,['code':("historie.feldName.label"),'default':("Feld Name")],-1)
printHtmlPart(8)
invokeTag('textField','g',46,['name':("feldName"),'value':(historieInstance?.feldName)],-1)
printHtmlPart(3)
expressionOut.print(hasErrors(bean: historieInstance, field: 'stringInhalt', 'error'))
printHtmlPart(9)
invokeTag('message','g',52,['code':("historie.stringInhalt.label"),'default':("String Inhalt")],-1)
printHtmlPart(8)
invokeTag('textField','g',55,['name':("stringInhalt"),'value':(historieInstance?.stringInhalt)],-1)
printHtmlPart(3)
expressionOut.print(hasErrors(bean: historieInstance, field: 'charInhalt', 'error'))
printHtmlPart(10)
invokeTag('message','g',61,['code':("historie.charInhalt.label"),'default':("Char Inhalt")],-1)
printHtmlPart(8)
invokeTag('field','g',64,['name':("charInhalt"),'type':("number"),'value':(historieInstance.charInhalt)],-1)
printHtmlPart(3)
expressionOut.print(hasErrors(bean: historieInstance, field: 'intInhalt', 'error'))
printHtmlPart(11)
invokeTag('message','g',70,['code':("historie.intInhalt.label"),'default':("Int Inhalt")],-1)
printHtmlPart(8)
invokeTag('field','g',73,['name':("intInhalt"),'type':("number"),'value':(historieInstance.intInhalt)],-1)
printHtmlPart(3)
expressionOut.print(hasErrors(bean: historieInstance, field: 'longInhalt', 'error'))
printHtmlPart(12)
invokeTag('message','g',79,['code':("historie.longInhalt.label"),'default':("Long Inhalt")],-1)
printHtmlPart(8)
invokeTag('field','g',82,['name':("longInhalt"),'type':("number"),'value':(historieInstance.longInhalt)],-1)
printHtmlPart(3)
expressionOut.print(hasErrors(bean: historieInstance, field: 'dateInhalt', 'error'))
printHtmlPart(13)
invokeTag('message','g',88,['code':("historie.dateInhalt.label"),'default':("Date Inhalt")],-1)
printHtmlPart(8)
invokeTag('datePicker','g',91,['name':("dateInhalt"),'precision':("day"),'value':(historieInstance?.dateInhalt),'default':("none"),'noSelection':(['': ''])],-1)
printHtmlPart(3)
expressionOut.print(hasErrors(bean: historieInstance, field: 'booleanInhalt', 'error'))
printHtmlPart(14)
invokeTag('message','g',97,['code':("historie.booleanInhalt.label"),'default':("Boolean Inhalt")],-1)
printHtmlPart(8)
invokeTag('checkBox','g',100,['name':("booleanInhalt"),'value':(historieInstance?.booleanInhalt)],-1)
printHtmlPart(15)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1419783078000L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
