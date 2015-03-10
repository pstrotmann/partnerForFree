import org.strotmann.partner.Organisation
import org.strotmann.partner.Branche
import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_partner_organisation_form_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/organisation/_form.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
printHtmlPart(1)
expressionOut.print(hasErrors(bean: organisationInstance, field: 'name', 'error'))
printHtmlPart(2)
invokeTag('message','g',5,['code':("organisation.name.label"),'default':("Name")],-1)
printHtmlPart(3)
invokeTag('textField','g',8,['name':("name"),'maxlength':("80"),'pattern':(organisationInstance.constraints.name.matches),'required':(""),'value':(organisationInstance?.name)],-1)
printHtmlPart(4)
expressionOut.print(hasErrors(bean: organisationInstance, field: 'hausadresse', 'error'))
printHtmlPart(5)
invokeTag('message','g',13,['code':("organisation.hausadresse.label"),'default':("Hausadresse")],-1)
printHtmlPart(6)
invokeTag('select','g',16,['id':("hausadresse"),'name':("hausadresse.id"),'from':(org.strotmann.partner.Hausadresse.getMiniList()),'optionKey':("id"),'value':(organisationInstance?.hausadresse?.id),'class':("many-to-one"),'noSelection':(['null': ''])],-1)
printHtmlPart(4)
expressionOut.print(hasErrors(bean: organisationInstance, field: 'hausadresse', 'error'))
printHtmlPart(7)
invokeTag('message','g',22,['code':("person.hausadresse.label"),'default':(" ")],-1)
printHtmlPart(8)
createTagBody(1, {->
expressionOut.print(message(code: 'default.newSimple.label'))
})
invokeTag('link','g',26,['controller':("hausadresse"),'action':("create"),'params':(['partner.id': organisationInstance?.id])],1)
printHtmlPart(9)
expressionOut.print(hasErrors(bean: organisationInstance, field: 'nameZusatz', 'error'))
printHtmlPart(10)
invokeTag('message','g',32,['code':("organisation.nameZusatz.label"),'default':("Name Zusatz")],-1)
printHtmlPart(6)
invokeTag('textField','g',35,['name':("nameZusatz"),'maxlength':("50"),'pattern':(organisationInstance.constraints.nameZusatz.matches),'value':(organisationInstance?.nameZusatz)],-1)
printHtmlPart(4)
expressionOut.print(hasErrors(bean: organisationInstance, field: 'rechtsform', 'error'))
printHtmlPart(11)
invokeTag('message','g',40,['code':("organisation.rechtsform.label"),'default':("Rechtsform")],-1)
printHtmlPart(6)
invokeTag('select','g',43,['name':("rechtsform"),'from':(organisationInstance.constraints.rechtsform.inList),'value':(organisationInstance?.rechtsform),'valueMessagePrefix':("organisation.rechtsform"),'noSelection':(['': ''])],-1)
printHtmlPart(4)
expressionOut.print(hasErrors(bean: organisationInstance, field: 'branche', 'error'))
printHtmlPart(12)
invokeTag('message','g',48,['code':("organisation.branche.label"),'default':("Branche")],-1)
printHtmlPart(6)
invokeTag('select','g',51,['id':("branche"),'name':("branche.id"),'from':(Branche.branchenKurz(65)),'optionKey':("id"),'value':(organisationInstance?.branche?.id),'class':("many-to-one"),'noSelection':(['null': ''])],-1)
printHtmlPart(4)
expressionOut.print(hasErrors(bean: organisationInstance, field: 'bankverbindung', 'error'))
printHtmlPart(13)
invokeTag('message','g',56,['code':("organisation.bankverbindungen.label"),'default':("Bankverbindungen")],-1)
printHtmlPart(14)
for( b in (organisationInstance?.bankverbindungen) ) {
printHtmlPart(15)
createTagBody(2, {->
expressionOut.print(b?.encodeAsHTML())
})
invokeTag('link','g',62,['controller':("bankverbindung"),'action':("show"),'id':(b.id)],2)
printHtmlPart(16)
}
printHtmlPart(17)
createTagBody(1, {->
expressionOut.print(message(code: 'default.add.label', args: [message(code: 'bankverbindung.label', default: 'Bankverbindung')]))
})
invokeTag('link','g',65,['controller':("bankverbindung"),'action':("create"),'params':(['organisation.id': organisationInstance?.id])],1)
printHtmlPart(18)
expressionOut.print(hasErrors(bean: organisationInstance, field: 'kommunikation', 'error'))
printHtmlPart(19)
invokeTag('message','g',73,['code':("organisation.kommunikationen.label"),'default':("Kommunikationskanäle")],-1)
printHtmlPart(14)
for( k in (organisationInstance?.kommunikationen) ) {
printHtmlPart(15)
createTagBody(2, {->
expressionOut.print(k?.encodeAsHTML())
})
invokeTag('link','g',79,['controller':("kommunikation"),'action':("show"),'id':(k.id)],2)
printHtmlPart(16)
}
printHtmlPart(17)
createTagBody(1, {->
expressionOut.print(message(code: 'default.add.label', args: [message(code: 'kommunikation.label', default: 'Kommunikation')]))
})
invokeTag('link','g',82,['controller':("kommunikation"),'action':("create"),'params':(['organisation.id': organisationInstance?.id])],1)
printHtmlPart(20)
expressionOut.print(hasErrors(bean: organisationInstance, field: 'partnerrolle', 'error'))
printHtmlPart(21)
invokeTag('message','g',91,['code':("organisation.partnerrollen.label"),'default':("Partnerrollen")],-1)
printHtmlPart(22)
for( p in (organisationInstance?.partnerrollen) ) {
printHtmlPart(15)
createTagBody(2, {->
expressionOut.print(p?.encodeAsHTML())
})
invokeTag('link','g',96,['controller':("partnerrolle"),'action':("show"),'id':(p.id)],2)
printHtmlPart(16)
}
printHtmlPart(23)
invokeTag('select','g',101,['name':("partnerrolleInstance.rolle"),'from':(flash.rollenZuObjektnameListe),'value':(partnerrolleInstance?.rolle),'valueMessagePrefix':("partnerrolle.objektname")],-1)
printHtmlPart(24)
invokeTag('actionSubmit','g',102,['action':("toRolle"),'value':(message(code: 'default.button.create.label', default: 'Create'))],-1)
printHtmlPart(25)
expressionOut.print(hasErrors(bean: organisationInstance, field: 'postfachadresse', 'error'))
printHtmlPart(26)
invokeTag('message','g',110,['code':("organisation.postfachadresse.label"),'default':("Postfachadresse")],-1)
printHtmlPart(14)
for( p in (organisationInstance?.postfachadressen) ) {
printHtmlPart(15)
createTagBody(2, {->
expressionOut.print(p?.encodeAsHTML())
})
invokeTag('link','g',116,['controller':("postfachadresse"),'action':("show"),'id':(p.id)],2)
printHtmlPart(16)
}
printHtmlPart(17)
createTagBody(1, {->
expressionOut.print(message(code: 'default.add.label', args: [message(code: 'postfachadresse.label', default: 'Postfachadresse')]))
})
invokeTag('link','g',119,['controller':("postfachadresse"),'action':("create"),'params':(['organisation.id': organisationInstance?.id])],1)
printHtmlPart(18)
expressionOut.print(hasErrors(bean: organisationInstance, field: 'lieferadresse', 'error'))
printHtmlPart(27)
invokeTag('message','g',127,['code':("organisation.lieferadresse.label"),'default':("Lieferadresse")],-1)
printHtmlPart(14)
for( p in (organisationInstance?.lieferadressen) ) {
printHtmlPart(15)
createTagBody(2, {->
expressionOut.print(p?.encodeAsHTML())
})
invokeTag('link','g',133,['controller':("lieferadresse"),'action':("show"),'id':(p.id)],2)
printHtmlPart(16)
}
printHtmlPart(17)
createTagBody(1, {->
expressionOut.print(message(code: 'default.add.label', args: [message(code: 'lieferadresse.label', default: 'Lieferadresse')]))
})
invokeTag('link','g',136,['controller':("lieferadresse"),'action':("create"),'params':(['organisation.id': organisationInstance?.id])],1)
printHtmlPart(18)
expressionOut.print(hasErrors(bean: organisationInstance, field: 'notizen', 'error'))
printHtmlPart(28)
invokeTag('message','g',144,['code':("organisation.notizen.label"),'default':("Notizen")],-1)
printHtmlPart(14)
for( n in (org.strotmann.notiz.Notiz.getNotizen('Organisation',organisationInstance.id)) ) {
printHtmlPart(15)
createTagBody(2, {->
expressionOut.print(n)
})
invokeTag('link','g',150,['controller':("notiz"),'action':("show"),'id':(n.id)],2)
printHtmlPart(16)
}
printHtmlPart(17)
createTagBody(1, {->
expressionOut.print(message(code: 'default.add.label', args: [message(code: 'notiz.label', default: 'Notiz')]))
})
invokeTag('link','g',153,['controller':("notiz"),'action':("create"),'params':(['organisation.id': organisationInstance?.id])],1)
printHtmlPart(29)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1424344940000L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
