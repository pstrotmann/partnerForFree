import org.strotmann.partner.Hausadresse
import org.strotmann.partner.Land
import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_partner_hausadresse_form_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/hausadresse/_form.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
printHtmlPart(1)
expressionOut.print(hasErrors(bean: hausadresseInstance, field: 'strasse', 'error'))
printHtmlPart(2)
invokeTag('message','g',5,['code':("hausadresse.strasse.label")],-1)
printHtmlPart(3)
invokeTag('textField','g',8,['name':("strasse"),'maxlength':("50"),'pattern':(hausadresseInstance.constraints.strasse.matches),'required':(""),'value':(hausadresseInstance?.strasse)],-1)
printHtmlPart(4)
expressionOut.print(hasErrors(bean: hausadresseInstance, field: 'hausnummer', 'error'))
printHtmlPart(5)
invokeTag('message','g',13,['code':("hausadresse.hausnummer.label")],-1)
printHtmlPart(3)
invokeTag('field','g',16,['name':("hausnummer"),'type':("number"),'min':("1"),'max':("1000"),'value':(hausadresseInstance.hausnummer),'required':("")],-1)
printHtmlPart(4)
expressionOut.print(hasErrors(bean: hausadresseInstance, field: 'zusatz', 'error'))
printHtmlPart(6)
invokeTag('message','g',21,['code':("hausadresse.zusatz.label")],-1)
printHtmlPart(7)
invokeTag('textField','g',24,['name':("zusatz"),'maxlength':("10"),'value':(hausadresseInstance?.zusatz)],-1)
printHtmlPart(4)
expressionOut.print(hasErrors(bean: hausadresseInstance, field: 'postleitzahl', 'error'))
printHtmlPart(8)
invokeTag('message','g',29,['code':("hausadresse.postleitzahl.label")],-1)
printHtmlPart(3)
invokeTag('field','g',32,['name':("postleitzahl"),'type':("number"),'max':("99999"),'value':(hausadresseInstance.postleitzahl)],-1)
printHtmlPart(4)
expressionOut.print(hasErrors(bean: hausadresseInstance, field: 'ort', 'error'))
printHtmlPart(9)
invokeTag('message','g',37,['code':("hausadresse.ort.label")],-1)
printHtmlPart(3)
invokeTag('textField','g',40,['name':("ort"),'maxlength':("50"),'pattern':(hausadresseInstance.constraints.ort.matches),'required':(""),'value':(hausadresseInstance?.ort)],-1)
printHtmlPart(4)
expressionOut.print(hasErrors(bean: hausadresseInstance, field: 'land', 'error'))
printHtmlPart(10)
invokeTag('message','g',45,['code':("hausadresse.land.label")],-1)
printHtmlPart(7)
invokeTag('select','g',48,['id':("land"),'name':("land.id"),'from':(org.strotmann.partner.Land.list()),'optionKey':("id"),'value':(hausadresseInstance?.land?.id),'class':("many-to-one"),'noSelection':(['null': ''])],-1)
printHtmlPart(4)
expressionOut.print(hasErrors(bean: hausadresseInstance, field: 'partner', 'error'))
printHtmlPart(11)
invokeTag('message','g',53,['code':("hausadresse.partner.label"),'default':("Partner")],-1)
printHtmlPart(3)
if(true && (flash.partner)) {
printHtmlPart(12)
invokeTag('select','g',57,['id':("partner"),'name':("partner.id"),'from':(flash.partner),'optionKey':("id"),'required':(""),'class':("many-to-one")],-1)
printHtmlPart(13)
}
else {
printHtmlPart(12)
invokeTag('select','g',60,['id':("partner"),'name':("partner.id"),'from':(org.strotmann.partner.Partner.list()),'optionKey':("id"),'required':(""),'class':("many-to-one"),'noSelection':(['null': ''])],-1)
printHtmlPart(13)
}
printHtmlPart(14)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1424199406000L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
