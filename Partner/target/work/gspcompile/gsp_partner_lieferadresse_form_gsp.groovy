import org.strotmann.partner.Lieferadresse
import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_partner_lieferadresse_form_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/lieferadresse/_form.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
expressionOut.print(hasErrors(bean: lieferadresseInstance, field: 'strasse', 'error'))
printHtmlPart(1)
invokeTag('message','g',7,['code':("lieferadresse.strasse.label"),'default':("Strasse")],-1)
printHtmlPart(2)
invokeTag('textField','g',10,['name':("strasse"),'value':(lieferadresseInstance?.strasse)],-1)
printHtmlPart(3)
expressionOut.print(hasErrors(bean: lieferadresseInstance, field: 'hausnummer', 'error'))
printHtmlPart(4)
invokeTag('message','g',16,['code':("lieferadresse.hausnummer.label"),'default':("Hausnummer")],-1)
printHtmlPart(2)
invokeTag('field','g',19,['name':("hausnummer"),'type':("number"),'value':(lieferadresseInstance.hausnummer)],-1)
printHtmlPart(3)
expressionOut.print(hasErrors(bean: lieferadresseInstance, field: 'zusatz', 'error'))
printHtmlPart(5)
invokeTag('message','g',25,['code':("lieferadresse.zusatz.label"),'default':("Zusatz")],-1)
printHtmlPart(2)
invokeTag('textField','g',28,['name':("zusatz"),'value':(lieferadresseInstance?.zusatz)],-1)
printHtmlPart(3)
expressionOut.print(hasErrors(bean: lieferadresseInstance, field: 'postleitzahl', 'error'))
printHtmlPart(6)
invokeTag('message','g',34,['code':("lieferadresse.postleitzahl.label"),'default':("Postleitzahl")],-1)
printHtmlPart(7)
invokeTag('field','g',37,['name':("postleitzahl"),'type':("number"),'value':(lieferadresseInstance.postleitzahl),'required':("")],-1)
printHtmlPart(3)
expressionOut.print(hasErrors(bean: lieferadresseInstance, field: 'ort', 'error'))
printHtmlPart(8)
invokeTag('message','g',43,['code':("lieferadresse.ort.label"),'default':("Ort")],-1)
printHtmlPart(7)
invokeTag('textField','g',46,['name':("ort"),'required':(""),'value':(lieferadresseInstance?.ort)],-1)
printHtmlPart(3)
expressionOut.print(hasErrors(bean: lieferadresseInstance, field: 'land', 'error'))
printHtmlPart(9)
invokeTag('message','g',52,['code':("lieferadresse.land.label"),'default':("Land")],-1)
printHtmlPart(2)
invokeTag('select','g',55,['id':("land"),'name':("land.id"),'from':(org.strotmann.partner.Land.list()),'optionKey':("id"),'value':(lieferadresseInstance?.land?.id),'class':("many-to-one"),'noSelection':(['null': ''])],-1)
printHtmlPart(3)
expressionOut.print(hasErrors(bean: lieferadresseInstance, field: 'anfahrt', 'error'))
printHtmlPart(10)
invokeTag('message','g',61,['code':("lieferadresse.anfahrt.label"),'default':("Anfahrt")],-1)
printHtmlPart(2)
invokeTag('textArea','g',64,['name':("anfahrt"),'value':(lieferadresseInstance?.anfahrt),'rows':("2"),'cols':("80")],-1)
printHtmlPart(3)
expressionOut.print(hasErrors(bean: lieferadresseInstance, field: 'partner', 'error'))
printHtmlPart(11)
invokeTag('message','g',70,['code':("lieferadresse.partner.label"),'default':("Partner")],-1)
printHtmlPart(7)
if(true && (flash.partner)) {
printHtmlPart(12)
invokeTag('select','g',74,['id':("partner"),'name':("partner.id"),'from':(flash.partner),'optionKey':("id"),'required':(""),'value':(lieferadresseInstance?.partner?.id),'class':("many-to-one")],-1)
printHtmlPart(13)
}
else {
printHtmlPart(12)
invokeTag('select','g',77,['id':("partner"),'name':("partner.id"),'from':(org.strotmann.partner.Partner.list()),'optionKey':("id"),'required':(""),'value':(lieferadresseInstance?.partner?.id),'class':("many-to-one")],-1)
printHtmlPart(13)
}
printHtmlPart(14)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1424684309000L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
