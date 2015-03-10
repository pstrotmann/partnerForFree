import org.strotmann.partner.Postfachadresse
import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_partner_postfachadresse_form2_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/postfachadresse/_form2.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
invokeTag('message','g',7,['code':("postfachadresse.postfach.label"),'default':("Postfach")],-1)
printHtmlPart(1)
invokeTag('message','g',8,['code':("postfachadresse.postleitzahl.label"),'default':("Postleitzahl")],-1)
printHtmlPart(1)
invokeTag('message','g',9,['code':("postfachadresse.ort.label"),'default':("Ort")],-1)
printHtmlPart(2)
expressionOut.print(hasErrors(bean: postfachadresseInstance, field: 'postfach', 'error'))
printHtmlPart(3)
invokeTag('field','g',13,['name':("postfach"),'type':("number"),'value':(postfachadresseInstance.postfach)],-1)
printHtmlPart(4)
expressionOut.print(hasErrors(bean: postfachadresseInstance, field: 'postleitzahl', 'error'))
printHtmlPart(3)
invokeTag('field','g',16,['name':("postleitzahl"),'type':("number"),'min':("0"),'max':("99999"),'value':(postfachadresseInstance.postleitzahl)],-1)
printHtmlPart(5)
expressionOut.print(hasErrors(bean: postfachadresseInstance, field: 'ort', 'error'))
printHtmlPart(3)
invokeTag('textField','g',19,['name':("ort"),'maxlength':("50"),'pattern':(postfachadresseInstance.constraints.ort.matches),'value':(postfachadresseInstance?.ort)],-1)
printHtmlPart(6)
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
