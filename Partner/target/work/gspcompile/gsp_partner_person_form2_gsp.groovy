import org.strotmann.partner.Person
import org.strotmann.partner.Branche
import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_partner_person_form2_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/person/_form2.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
printHtmlPart(1)
invokeTag('message','g',5,['code':("person.personalData.label")],-1)
printHtmlPart(2)
invokeTag('message','g',7,['code':("person.name.label")],-1)
printHtmlPart(3)
invokeTag('message','g',8,['code':("person.vorname.label")],-1)
printHtmlPart(3)
invokeTag('message','g',9,['code':("person.titel.label")],-1)
printHtmlPart(4)
expressionOut.print(hasErrors(bean: personInstance, field: 'name', 'error'))
printHtmlPart(5)
invokeTag('textField','g',13,['name':("name"),'maxlength':("30"),'pattern':(personInstance.constraints.name.matches),'required':(""),'value':(personInstance?.name)],-1)
printHtmlPart(6)
expressionOut.print(hasErrors(bean: personInstance, field: 'vorname', 'error'))
printHtmlPart(5)
invokeTag('textField','g',16,['name':("vorname"),'maxlength':("30"),'pattern':(personInstance.constraints.vorname.matches),'value':(personInstance?.vorname)],-1)
printHtmlPart(6)
expressionOut.print(hasErrors(bean: personInstance, field: 'titel', 'error'))
printHtmlPart(5)
invokeTag('textField','g',19,['name':("titel"),'maxlength':("20"),'pattern':(personInstance.constraints.titel.matches),'value':(personInstance?.titel)],-1)
printHtmlPart(7)
invokeTag('message','g',23,['code':("person.geschlecht.label")],-1)
printHtmlPart(3)
invokeTag('message','g',24,['code':("person.geburtsdatum.label")],-1)
printHtmlPart(3)
invokeTag('message','g',25,['code':("person.persoenlicheAnrede.label")],-1)
printHtmlPart(4)
expressionOut.print(hasErrors(bean: personInstance, field: 'geschlecht', 'error'))
printHtmlPart(5)
invokeTag('select','g',29,['name':("geschlecht"),'from':(personInstance.constraints.geschlecht.inList),'required':(""),'value':(personInstance?.geschlecht),'valueMessagePrefix':("person.geschlecht"),'noSelection':(['': ''])],-1)
printHtmlPart(6)
expressionOut.print(hasErrors(bean: personInstance, field: 'geburtsdatum', 'error'))
printHtmlPart(5)
invokeTag('datePicker','g',32,['name':("geburtsdatum"),'precision':("day"),'years':(1920..2020),'value':(personInstance?.geburtsdatum),'default':("none"),'noSelection':(['': ''])],-1)
printHtmlPart(6)
expressionOut.print(hasErrors(bean: personInstance, field: 'persoenlicheAnrede', 'error'))
printHtmlPart(5)
invokeTag('checkBox','g',35,['name':("persoenlicheAnrede"),'value':(personInstance?.persoenlicheAnrede)],-1)
printHtmlPart(7)
invokeTag('message','g',39,['code':("person.nationalitaet.label")],-1)
printHtmlPart(3)
invokeTag('message','g',40,['code':("person.religion.label")],-1)
printHtmlPart(4)
expressionOut.print(hasErrors(bean: personInstance, field: 'nationalitaet', 'error'))
printHtmlPart(5)
invokeTag('select','g',44,['id':("nationalitaet"),'name':("nationalitaet.id"),'from':(org.strotmann.partner.Land.list()),'optionKey':("id"),'value':(personInstance?.nationalitaet?.id),'class':("many-to-one"),'noSelection':(['null': ''])],-1)
printHtmlPart(6)
expressionOut.print(hasErrors(bean: personInstance, field: 'religion', 'error'))
printHtmlPart(5)
invokeTag('select','g',47,['name':("religion"),'from':(personInstance.constraints.religion.inList),'value':(personInstance?.religion),'valueMessagePrefix':("person.religion"),'noSelection':(['': ''])],-1)
printHtmlPart(8)
invokeTag('message','g',52,['code':("person.beruf.label")],-1)
printHtmlPart(3)
invokeTag('message','g',53,['code':("person.taetigkeit.label")],-1)
printHtmlPart(4)
expressionOut.print(hasErrors(bean: personInstance, field: 'beruf', 'error'))
printHtmlPart(5)
invokeTag('select','g',57,['id':("beruf"),'name':("beruf.id"),'from':(Branche.branchenKurz(35)),'optionKey':("id"),'value':(personInstance?.beruf?.id),'class':("many-to-one"),'noSelection':(['null': ''])],-1)
printHtmlPart(6)
expressionOut.print(hasErrors(bean: personInstance, field: 'Tätigkeit', 'error'))
printHtmlPart(5)
invokeTag('select','g',60,['id':("taetigkeit"),'name':("taetigkeit.id"),'from':(Branche.branchenKurz(35)),'optionKey':("id"),'value':(personInstance?.taetigkeit?.id),'class':("many-to-one"),'noSelection':(['null': ''])],-1)
printHtmlPart(9)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1424248239000L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
