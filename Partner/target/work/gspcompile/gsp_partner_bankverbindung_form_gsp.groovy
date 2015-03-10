import org.strotmann.partner.Bankverbindung
import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_partner_bankverbindung_form_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/bankverbindung/_form.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
expressionOut.print(hasErrors(bean: bankverbindungInstance, field: 'iban', 'error'))
printHtmlPart(1)
invokeTag('message','g',5,['code':("bankverbindung.iban.label"),'default':("Iban")],-1)
printHtmlPart(2)
invokeTag('textField','g',8,['name':("iban"),'value':(bankverbindungInstance?.iban)],-1)
printHtmlPart(3)
expressionOut.print(hasErrors(bean: bankverbindungInstance, field: 'bic', 'error'))
printHtmlPart(4)
invokeTag('message','g',13,['code':("bankverbindung.bic.label"),'default':("BIC")],-1)
printHtmlPart(2)
invokeTag('textField','g',16,['name':("bic"),'value':(bankverbindungInstance?.bic)],-1)
printHtmlPart(3)
expressionOut.print(hasErrors(bean: bankverbindungInstance, field: 'partner', 'error'))
printHtmlPart(5)
invokeTag('message','g',21,['code':("bankverbindung.partner.label"),'default':("Partner")],-1)
printHtmlPart(6)
if(true && (flash.partner)) {
printHtmlPart(7)
invokeTag('select','g',25,['id':("partner"),'name':("partner.id"),'from':(flash.partner),'optionKey':("id"),'required':(""),'value':(bankverbindungInstance?.partner?.id),'class':("many-to-one")],-1)
printHtmlPart(8)
}
else {
printHtmlPart(7)
invokeTag('select','g',28,['id':("partner"),'name':("partner.id"),'from':(org.strotmann.partner.Partner.list()),'optionKey':("id"),'required':(""),'value':(bankverbindungInstance?.partner?.id),'class':("many-to-one")],-1)
printHtmlPart(8)
}
printHtmlPart(9)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1423559812000L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
