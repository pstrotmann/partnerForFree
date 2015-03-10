import org.strotmann.partner.Hausadresse
import org.strotmann.partner.Land
import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_partner_hausadresse_form2_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/hausadresse/_form2.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
printHtmlPart(1)
invokeTag('message','g',4,['code':("person.hausadresse.label")],-1)
printHtmlPart(2)
invokeTag('message','g',7,['code':("hausadresse.strasse.label")],-1)
printHtmlPart(3)
invokeTag('message','g',8,['code':("hausadresse.hausnummer.label")],-1)
printHtmlPart(4)
invokeTag('message','g',9,['code':("hausadresse.zusatz.label")],-1)
printHtmlPart(5)
expressionOut.print(hasErrors(bean: hausadresseInstance, field: 'strasse', 'error'))
printHtmlPart(6)
invokeTag('textField','g',13,['name':("strasse"),'maxlength':("50"),'pattern':(hausadresseInstance.constraints.strasse.matches),'value':(hausadresseInstance?.strasse)],-1)
printHtmlPart(7)
expressionOut.print(hasErrors(bean: hausadresseInstance, field: 'hausnummer', 'error'))
printHtmlPart(6)
invokeTag('field','g',16,['name':("hausnummer"),'type':("number"),'min':("0"),'max':("99999"),'value':(hausadresseInstance.hausnummer)],-1)
printHtmlPart(7)
expressionOut.print(hasErrors(bean: hausadresseInstance, field: 'zusatz', 'error'))
printHtmlPart(6)
invokeTag('textField','g',19,['name':("zusatz"),'maxlength':("10"),'value':(hausadresseInstance?.zusatz)],-1)
printHtmlPart(8)
invokeTag('message','g',24,['code':("hausadresse.postleitzahl.label")],-1)
printHtmlPart(3)
invokeTag('message','g',25,['code':("hausadresse.ort.label"),'default':("Ort")],-1)
printHtmlPart(4)
invokeTag('message','g',26,['code':("hausadresse.land.label"),'default':("Land")],-1)
printHtmlPart(9)
expressionOut.print(hasErrors(bean: hausadresseInstance, field: 'postleitzahl', 'error'))
printHtmlPart(10)
invokeTag('field','g',30,['name':("postleitzahl"),'type':("number"),'min':("0"),'max':("99999"),'value':(hausadresseInstance.postleitzahl)],-1)
printHtmlPart(7)
expressionOut.print(hasErrors(bean: hausadresseInstance, field: 'ort', 'error'))
printHtmlPart(10)
invokeTag('textField','g',33,['name':("ort"),'maxlength':("50"),'pattern':(hausadresseInstance.constraints.ort.matches),'value':(hausadresseInstance?.ort)],-1)
printHtmlPart(11)
expressionOut.print(hasErrors(bean: hausadresseInstance, field: 'land', 'error'))
printHtmlPart(6)
invokeTag('select','g',36,['id':("land"),'name':("land.id"),'from':(org.strotmann.partner.Land.list()),'optionKey':("id"),'value':(hausadresseInstance?.land?.id),'class':("many-to-one"),'noSelection':(['null': ''])],-1)
printHtmlPart(12)
invokeTag('set','g',41,['var':("labelName"),'value':(message(code: 'person.hausadresse.label'))],-1)
printHtmlPart(13)
invokeTag('message','g',42,['code':("default.auswaehlen.label"),'args':([labelName])],-1)
printHtmlPart(5)
expressionOut.print(hasErrors(bean: hausadresseInstance, field: 'hausadresse', 'error'))
printHtmlPart(6)
invokeTag('select','g',46,['id':("hausadresse"),'name':("hausadresse.id"),'from':(org.strotmann.partner.Hausadresse.getMiniList()),'optionKey':("id"),'value':(personInstance?.hausadresse?.id),'class':("many-to-one"),'noSelection':(['null': ''])],-1)
printHtmlPart(14)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1424784436000L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
