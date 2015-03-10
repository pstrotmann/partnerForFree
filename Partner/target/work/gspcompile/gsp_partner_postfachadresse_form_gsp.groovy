import org.strotmann.partner.Postfachadresse
import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_partner_postfachadresse_form_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/postfachadresse/_form.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
expressionOut.print(hasErrors(bean: postfachadresseInstance, field: 'postfach', 'error'))
printHtmlPart(1)
invokeTag('message','g',7,['code':("postfachadresse.postfach.label"),'default':("Postfach")],-1)
printHtmlPart(2)
invokeTag('field','g',10,['name':("postfach"),'type':("number"),'value':(postfachadresseInstance.postfach),'required':("")],-1)
printHtmlPart(3)
expressionOut.print(hasErrors(bean: postfachadresseInstance, field: 'postleitzahl', 'error'))
printHtmlPart(4)
invokeTag('message','g',15,['code':("postfachadresse.postleitzahl.label"),'default':("Postleitzahl")],-1)
printHtmlPart(2)
invokeTag('field','g',18,['name':("postleitzahl"),'type':("number"),'min':("1000"),'max':("99999"),'value':(postfachadresseInstance.postleitzahl),'required':("")],-1)
printHtmlPart(3)
expressionOut.print(hasErrors(bean: postfachadresseInstance, field: 'ort', 'error'))
printHtmlPart(5)
invokeTag('message','g',23,['code':("postfachadresse.ort.label"),'default':("Ort")],-1)
printHtmlPart(2)
invokeTag('textField','g',26,['name':("ort"),'required':(""),'value':(postfachadresseInstance?.ort)],-1)
printHtmlPart(3)
expressionOut.print(hasErrors(bean: postfachadresseInstance, field: 'partner', 'error'))
printHtmlPart(6)
invokeTag('message','g',31,['code':("postfachadresse.partner.label"),'default':("Partner")],-1)
printHtmlPart(2)
if(true && (flash.partner)) {
printHtmlPart(7)
invokeTag('select','g',35,['id':("partner"),'name':("partner.id"),'from':(flash.partner),'optionKey':("id"),'required':(""),'value':(postfachadresseInstance?.partner?.id),'class':("many-to-one")],-1)
printHtmlPart(8)
}
else {
printHtmlPart(7)
invokeTag('select','g',38,['id':("partner"),'name':("partner.id"),'from':(org.strotmann.partner.Partner.list()),'optionKey':("id"),'required':(""),'value':(postfachadresseInstance?.partner?.id),'class':("many-to-one")],-1)
printHtmlPart(8)
}
printHtmlPart(9)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1423905806000L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
