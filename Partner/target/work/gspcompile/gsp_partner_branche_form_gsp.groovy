import org.strotmann.partner.Branche
import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_partner_branche_form_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/branche/_form.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
expressionOut.print(hasErrors(bean: brancheInstance, field: 'kode', 'error'))
printHtmlPart(1)
invokeTag('message','g',7,['code':("branche.kode.label"),'default':("Kode")],-1)
printHtmlPart(2)
invokeTag('textField','g',10,['name':("kode"),'required':(""),'value':(brancheInstance?.kode)],-1)
printHtmlPart(3)
expressionOut.print(hasErrors(bean: brancheInstance, field: 'bezeichnung', 'error'))
printHtmlPart(4)
invokeTag('message','g',16,['code':("branche.bezeichnung.label"),'default':("Bezeichnung")],-1)
printHtmlPart(2)
invokeTag('textField','g',19,['name':("bezeichnung"),'required':(""),'value':(brancheInstance?.bezeichnung)],-1)
printHtmlPart(5)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1422730790000L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
