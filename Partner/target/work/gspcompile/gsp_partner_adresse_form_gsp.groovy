import org.strotmann.partner.Adresse
import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_partner_adresse_form_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/adresse/_form.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
expressionOut.print(hasErrors(bean: adresseInstance, field: 'ort', 'error'))
printHtmlPart(1)
invokeTag('message','g',7,['code':("adresse.ort.label"),'default':("Ort")],-1)
printHtmlPart(2)
invokeTag('textField','g',10,['name':("ort"),'value':(adresseInstance?.ort)],-1)
printHtmlPart(3)
expressionOut.print(hasErrors(bean: adresseInstance, field: 'postleitzahl', 'error'))
printHtmlPart(4)
invokeTag('message','g',15,['code':("adresse.postleitzahl.label"),'default':("Postleitzahl")],-1)
printHtmlPart(5)
invokeTag('field','g',18,['name':("postleitzahl"),'type':("number"),'value':(adresseInstance.postleitzahl),'required':("")],-1)
printHtmlPart(6)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1419783077000L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
