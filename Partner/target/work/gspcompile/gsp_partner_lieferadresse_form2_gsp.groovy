import org.strotmann.partner.Lieferadresse
import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_partner_lieferadresse_form2_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/lieferadresse/_form2.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
invokeTag('message','g',3,['code':("organisation.lieferadresse.label")],-1)
printHtmlPart(1)
invokeTag('message','g',6,['code':("hausadresse.strasse.label")],-1)
printHtmlPart(2)
invokeTag('message','g',7,['code':("hausadresse.hausnummer.label")],-1)
printHtmlPart(3)
invokeTag('message','g',8,['code':("hausadresse.zusatz.label")],-1)
printHtmlPart(4)
expressionOut.print(hasErrors(bean: lieferadresseInstance, field: 'strasse', 'error'))
printHtmlPart(5)
invokeTag('textField','g',12,['name':("strasse"),'maxlength':("50"),'pattern':(lieferadresseInstance.constraints.strasse.matches),'value':(lieferadresseInstance?.strasse)],-1)
printHtmlPart(6)
expressionOut.print(hasErrors(bean: lieferadresseInstance, field: 'hausnummer', 'error'))
printHtmlPart(5)
invokeTag('field','g',15,['name':("hausnummer"),'type':("number"),'min':("0"),'max':("99999"),'value':(lieferadresseInstance.hausnummer)],-1)
printHtmlPart(6)
expressionOut.print(hasErrors(bean: lieferadresseInstance, field: 'zusatz', 'error'))
printHtmlPart(5)
invokeTag('textField','g',18,['name':("zusatz"),'maxlength':("10"),'value':(lieferadresseInstance?.zusatz)],-1)
printHtmlPart(7)
invokeTag('message','g',23,['code':("hausadresse.postleitzahl.label")],-1)
printHtmlPart(2)
invokeTag('message','g',24,['code':("lieferadresse.ort.label"),'default':("Ort")],-1)
printHtmlPart(3)
invokeTag('message','g',25,['code':("lieferadresse.land.label"),'default':("Land")],-1)
printHtmlPart(8)
expressionOut.print(hasErrors(bean: lieferadresseInstance, field: 'postleitzahl', 'error'))
printHtmlPart(9)
invokeTag('field','g',29,['name':("postleitzahl"),'type':("number"),'min':("0"),'max':("99999"),'value':(lieferadresseInstance.postleitzahl)],-1)
printHtmlPart(6)
expressionOut.print(hasErrors(bean: lieferadresseInstance, field: 'ort', 'error'))
printHtmlPart(9)
invokeTag('textField','g',32,['name':("ort"),'maxlength':("50"),'pattern':(lieferadresseInstance.constraints.ort.matches),'value':(lieferadresseInstance?.ort)],-1)
printHtmlPart(10)
expressionOut.print(hasErrors(bean: lieferadresseInstance, field: 'land', 'error'))
printHtmlPart(5)
invokeTag('select','g',35,['id':("land"),'name':("land.id"),'from':(org.strotmann.partner.Land.list()),'optionKey':("id"),'value':(lieferadresseInstance?.land?.id),'class':("many-to-one"),'noSelection':(['null': ''])],-1)
printHtmlPart(11)
invokeTag('set','g',40,['var':("labelName"),'value':(message(code: 'organisation.lieferadresse.label'))],-1)
printHtmlPart(12)
invokeTag('message','g',41,['code':("default.auswaehlen.label"),'args':([labelName])],-1)
printHtmlPart(13)
expressionOut.print(hasErrors(bean: lieferadresseInstance, field: 'lieferadresse', 'error'))
printHtmlPart(5)
invokeTag('select','g',46,['id':("lieferadresse"),'name':("lieferadresse.id"),'from':(Lieferadresse.list()),'optionKey':("id"),'value':(personInstance?.lieferadresse?.id),'class':("many-to-one"),'noSelection':(['null': ''])],-1)
printHtmlPart(7)
invokeTag('message','g',51,['code':("lieferadresse.anfahrt.label")],-1)
printHtmlPart(14)
expressionOut.print(hasErrors(bean: lieferadresseInstance, field: 'anfahrt', 'error'))
printHtmlPart(9)
invokeTag('textArea','g',56,['name':("anfahrt"),'value':(lieferadresseInstance?.anfahrt),'rows':("5"),'cols':("80")],-1)
printHtmlPart(15)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1424604333000L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
