import org.strotmann.partner.Person
import org.strotmann.partner.Branche
import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_partner_person_form_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/person/_form.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
printHtmlPart(1)
expressionOut.print(hasErrors(bean: personInstance, field: 'name', 'error'))
printHtmlPart(2)
invokeTag('message','g',6,['code':("person.name.label"),'default':("Name")],-1)
printHtmlPart(3)
invokeTag('textField','g',9,['name':("name"),'maxlength':("30"),'pattern':(personInstance.constraints.name.matches),'required':(""),'value':(personInstance?.name)],-1)
printHtmlPart(4)
expressionOut.print(hasErrors(bean: personInstance, field: 'hausadresse', 'error'))
printHtmlPart(5)
invokeTag('message','g',14,['code':("person.hausadresse.label")],-1)
printHtmlPart(6)
invokeTag('select','g',17,['id':("hausadresse"),'name':("hausadresse.id"),'from':(org.strotmann.partner.Hausadresse.getMiniList()),'optionKey':("id"),'value':(personInstance?.hausadresse?.id),'class':("many-to-one"),'noSelection':(['null': ''])],-1)
printHtmlPart(4)
expressionOut.print(hasErrors(bean: personInstance, field: 'hausadresse', 'error'))
printHtmlPart(7)
invokeTag('message','g',23,['code':("person.hausadresse.label"),'default':(" ")],-1)
printHtmlPart(8)
createTagBody(1, {->
expressionOut.print(message(code: 'default.newSimple.label'))
})
invokeTag('link','g',27,['controller':("hausadresse"),'action':("create"),'params':(['partner.id': personInstance?.id])],1)
printHtmlPart(9)
expressionOut.print(hasErrors(bean: personInstance, field: 'titel', 'error'))
printHtmlPart(10)
invokeTag('message','g',33,['code':("person.titel.label")],-1)
printHtmlPart(6)
invokeTag('textField','g',36,['name':("titel"),'maxlength':("20"),'pattern':(personInstance.constraints.titel.matches),'value':(personInstance?.titel)],-1)
printHtmlPart(4)
expressionOut.print(hasErrors(bean: personInstance, field: 'vorname', 'error'))
printHtmlPart(11)
invokeTag('message','g',41,['code':("person.vorname.label")],-1)
printHtmlPart(6)
invokeTag('textField','g',44,['name':("vorname"),'maxlength':("30"),'pattern':(personInstance.constraints.vorname.matches),'value':(personInstance?.vorname)],-1)
printHtmlPart(4)
expressionOut.print(hasErrors(bean: personInstance, field: 'geschlecht', 'error'))
printHtmlPart(12)
invokeTag('message','g',49,['code':("person.geschlecht.label")],-1)
printHtmlPart(3)
invokeTag('select','g',52,['name':("geschlecht"),'from':(personInstance.constraints.geschlecht.inList),'value':(personInstance?.geschlecht),'valueMessagePrefix':("person.geschlecht"),'noSelection':(['': ''])],-1)
printHtmlPart(4)
expressionOut.print(hasErrors(bean: personInstance, field: 'geburtsdatum', 'error'))
printHtmlPart(13)
invokeTag('message','g',57,['code':("person.geburtsdatum.label")],-1)
printHtmlPart(6)
invokeTag('datePicker','g',60,['name':("geburtsdatum"),'precision':("day"),'years':(1920..2040),'value':(personInstance?.geburtsdatum),'default':("none"),'noSelection':(['': ''])],-1)
printHtmlPart(4)
expressionOut.print(hasErrors(bean: personInstance, field: 'persoenlicheAnrede', 'error'))
printHtmlPart(14)
invokeTag('message','g',65,['code':("person.persoenlicheAnrede.label")],-1)
printHtmlPart(6)
invokeTag('checkBox','g',68,['name':("persoenlicheAnrede"),'value':(personInstance?.persoenlicheAnrede)],-1)
printHtmlPart(4)
expressionOut.print(hasErrors(bean: personInstance, field: 'nationalitaet', 'error'))
printHtmlPart(15)
invokeTag('message','g',73,['code':("person.nationalitaet.label")],-1)
printHtmlPart(6)
invokeTag('select','g',76,['id':("nationalitaet"),'name':("nationalitaet.id"),'from':(org.strotmann.partner.Land.list()),'optionKey':("id"),'value':(personInstance?.nationalitaet?.id),'class':("many-to-one"),'noSelection':(['null': ''])],-1)
printHtmlPart(16)
expressionOut.print(hasErrors(bean: personInstance, field: 'religion', 'error'))
printHtmlPart(17)
invokeTag('message','g',82,['code':("person.religion.label")],-1)
printHtmlPart(6)
invokeTag('select','g',85,['name':("religion"),'from':(personInstance.constraints.religion.inList),'value':(personInstance?.religion),'valueMessagePrefix':("person.religion"),'noSelection':(['': ''])],-1)
printHtmlPart(4)
expressionOut.print(hasErrors(bean: personInstance, field: 'beruf', 'error'))
printHtmlPart(18)
invokeTag('message','g',90,['code':("person.beruf.label")],-1)
printHtmlPart(6)
invokeTag('select','g',93,['id':("beruf"),'name':("beruf.id"),'from':(Branche.branchenKurz(65)),'optionKey':("id"),'value':(personInstance?.beruf?.id),'class':("many-to-one"),'noSelection':(['null': ''])],-1)
printHtmlPart(4)
expressionOut.print(hasErrors(bean: personInstance, field: 'taetigkeit', 'error'))
printHtmlPart(19)
invokeTag('message','g',98,['code':("person.taetigkeit.label")],-1)
printHtmlPart(6)
invokeTag('select','g',101,['id':("taetigkeit"),'name':("taetigkeit.id"),'from':(Branche.branchenKurz(65)),'optionKey':("id"),'value':(personInstance?.taetigkeit?.id),'class':("many-to-one"),'noSelection':(['null': ''])],-1)
printHtmlPart(4)
expressionOut.print(hasErrors(bean: personInstance, field: 'bankverbindung', 'error'))
printHtmlPart(20)
invokeTag('message','g',106,['code':("person.bankverbindungen.label")],-1)
printHtmlPart(21)
for( b in (personInstance?.bankverbindungen) ) {
printHtmlPart(22)
createTagBody(2, {->
expressionOut.print(b?.encodeAsHTML())
})
invokeTag('link','g',112,['controller':("bankverbindung"),'action':("show"),'id':(b.id)],2)
printHtmlPart(23)
}
printHtmlPart(24)
createTagBody(1, {->
expressionOut.print(message(code: 'default.add.label', args: [message(code: 'bankverbindung.label', default: 'Bankverbindung')]))
})
invokeTag('link','g',115,['controller':("bankverbindung"),'action':("create"),'params':(['person.id': personInstance?.id])],1)
printHtmlPart(25)
expressionOut.print(hasErrors(bean: personInstance, field: 'kommunikation', 'error'))
printHtmlPart(26)
invokeTag('message','g',123,['code':("person.kommunikationen.label")],-1)
printHtmlPart(21)
for( k in (personInstance?.kommunikationen) ) {
printHtmlPart(22)
createTagBody(2, {->
expressionOut.print(k?.encodeAsHTML())
})
invokeTag('link','g',129,['controller':("kommunikation"),'action':("show"),'id':(k.id)],2)
printHtmlPart(23)
}
printHtmlPart(27)
createTagBody(1, {->
expressionOut.print(message(code: 'default.add.label', args: [message(code: 'kommunikation.label', default: 'Kommunikation')]))
})
invokeTag('link','g',133,['controller':("kommunikation"),'action':("create"),'params':(['person.id': personInstance?.id])],1)
printHtmlPart(28)
expressionOut.print(hasErrors(bean: personInstance, field: 'partnerrolle', 'error'))
printHtmlPart(29)
invokeTag('message','g',142,['code':("person.partnerrollen.label")],-1)
printHtmlPart(21)
for( p in (personInstance?.partnerrollen) ) {
printHtmlPart(22)
createTagBody(2, {->
expressionOut.print(p?.encodeAsHTML())
})
invokeTag('link','g',148,['controller':("partnerrolle"),'action':("show"),'id':(p.id)],2)
printHtmlPart(23)
}
printHtmlPart(30)
invokeTag('select','g',152,['name':("partnerrolleInstance.rolle"),'from':(flash.rollenZuObjektnameListe),'value':(partnerrolleInstance?.rolle),'valueMessagePrefix':("partnerrolle.objektname")],-1)
printHtmlPart(31)
invokeTag('actionSubmit','g',153,['action':("toRolle"),'value':(message(code: 'default.button.create.label', default: 'Create'))],-1)
printHtmlPart(32)
expressionOut.print(hasErrors(bean: personInstance, field: 'notizen', 'error'))
printHtmlPart(33)
invokeTag('message','g',162,['code':("person.notizen.label"),'default':("Notizen")],-1)
printHtmlPart(21)
for( n in (org.strotmann.notiz.Notiz.getNotizen('Person',personInstance.id)) ) {
printHtmlPart(22)
createTagBody(2, {->
expressionOut.print(n)
})
invokeTag('link','g',168,['controller':("notiz"),'action':("show"),'id':(n.id)],2)
printHtmlPart(23)
}
printHtmlPart(24)
createTagBody(1, {->
expressionOut.print(message(code: 'default.add.label', args: [message(code: 'notiz.label', default: 'Notiz')]))
})
invokeTag('link','g',171,['controller':("notiz"),'action':("create"),'params':(['person.id': personInstance?.id])],1)
printHtmlPart(34)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1424267182000L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
