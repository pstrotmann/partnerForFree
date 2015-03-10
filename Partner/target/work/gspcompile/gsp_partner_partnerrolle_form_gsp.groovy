import org.strotmann.partner.Partnerrolle
import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_partner_partnerrolle_form_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/partnerrolle/_form.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
expressionOut.print(hasErrors(bean: partnerrolleInstance, field: 'rolle', 'error'))
printHtmlPart(1)
invokeTag('message','g',7,['code':("partnerrolle.rolle.label"),'default':("Rolle")],-1)
printHtmlPart(2)
invokeTag('select','g',10,['name':("rolle"),'from':([flash.rolle]),'required':(""),'value':(partnerrolleInstance?.rolle),'valueMessagePrefix':("partnerrolle.rolle")],-1)
printHtmlPart(3)
expressionOut.print(hasErrors(bean: partnerrolleInstance, field: 'objektname', 'error'))
printHtmlPart(4)
invokeTag('message','g',15,['code':("partnerrolle.objektname.label"),'default':("Objektname")],-1)
printHtmlPart(2)
invokeTag('select','g',18,['name':("objektname"),'from':([flash.objektname]),'required':(""),'value':(partnerrolleInstance?.objektname),'valueMessagePrefix':("partnerrolle.objektname")],-1)
printHtmlPart(5)
if(true && (flash.objektname == 'Organisation')) {
printHtmlPart(6)
expressionOut.print(hasErrors(bean: partnerrolleInstance, field: 'organisation', 'error'))
printHtmlPart(7)
invokeTag('message','g',25,['code':("partnerrolle.organisation.label"),'default':("Organisation")],-1)
printHtmlPart(8)
invokeTag('select','g',28,['id':("organisation"),'name':("organisation.id"),'from':(org.strotmann.partner.Organisation.getMiniList()),'optionKey':("id"),'value':(partnerrolleInstance?.objektId),'class':("many-to-one"),'noSelection':(['null': ''])],-1)
printHtmlPart(9)
}
printHtmlPart(10)
if(true && (flash.objektname == 'Person')) {
printHtmlPart(6)
expressionOut.print(hasErrors(bean: partnerrolleInstance, field: 'person', 'error'))
printHtmlPart(7)
invokeTag('message','g',35,['code':("partnerrolle.person.label"),'default':("Person")],-1)
printHtmlPart(8)
invokeTag('select','g',38,['id':("person"),'name':("person.id"),'from':(org.strotmann.partner.Person.personList),'optionKey':("id"),'value':(partnerrolleInstance?.objektId),'class':("many-to-one"),'noSelection':(['null': ''])],-1)
printHtmlPart(9)
}
printHtmlPart(11)
expressionOut.print(hasErrors(bean: partnerrolleInstance, field: 'partner', 'error'))
printHtmlPart(12)
invokeTag('message','g',44,['code':("partnerrolle.partner.label"),'default':("Partner")],-1)
printHtmlPart(2)
invokeTag('select','g',47,['id':("partner"),'name':("partner.id"),'from':(flash.partner),'optionKey':("id"),'required':(""),'value':(partnerrolleInstance?.partner?.id),'class':("many-to-one")],-1)
printHtmlPart(5)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1422608821000L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
