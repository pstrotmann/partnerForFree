import org.strotmann.partner.Bankverbindung
import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_partner_bankverbindung_form2_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/bankverbindung/_form2.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
invokeTag('message','g',4,['code':("person.bankverbindung.label")],-1)
printHtmlPart(1)
invokeTag('message','g',6,['code':("bankverbindung.iban.label")],-1)
printHtmlPart(2)
invokeTag('message','g',7,['code':("bankverbindung.bic.label")],-1)
printHtmlPart(3)
expressionOut.print(hasErrors(bean: bankverbindungInstance, field: 'iban', 'error'))
printHtmlPart(4)
invokeTag('textField','g',11,['name':("iban"),'value':(bankverbindungInstance?.iban)],-1)
printHtmlPart(5)
expressionOut.print(hasErrors(bean: bankverbindungInstance, field: 'BIC', 'error'))
printHtmlPart(4)
invokeTag('textField','g',14,['name':("bic"),'value':(bankverbindungInstance?.bic)],-1)
printHtmlPart(6)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1424783738000L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
