import org.strotmann.benutzer.Benutzer
import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_partner_benutzer_form_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/benutzer/_form.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
expressionOut.print(hasErrors(bean: benutzerInstance, field: 'name', 'error'))
printHtmlPart(1)
invokeTag('message','g',7,['code':("benutzer.name.label"),'default':("Name")],-1)
printHtmlPart(2)
invokeTag('textField','g',10,['name':("name"),'required':(""),'value':(benutzerInstance?.name)],-1)
printHtmlPart(3)
expressionOut.print(hasErrors(bean: benutzerInstance, field: 'passwort', 'error'))
printHtmlPart(4)
invokeTag('message','g',16,['code':("benutzer.passwort.label"),'default':("Passwort")],-1)
printHtmlPart(2)
invokeTag('textField','g',19,['name':("passwort"),'required':(""),'value':(benutzerInstance?.passwort)],-1)
printHtmlPart(3)
expressionOut.print(hasErrors(bean: benutzerInstance, field: 'sprache', 'error'))
printHtmlPart(5)
invokeTag('message','g',25,['code':("benutzer.sprache.label"),'default':("Sprache")],-1)
printHtmlPart(2)
invokeTag('select','g',28,['name':("sprache"),'from':(benutzerInstance.constraints.sprache.inList),'value':(benutzerInstance?.sprache),'valueMessagePrefix':("benutzer.sprache"),'noSelection':(['': ''])],-1)
printHtmlPart(6)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1423998486000L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
