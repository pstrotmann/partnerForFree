import org.strotmann.partner.Organisation
import org.strotmann.partner.Branche
import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_partner_organisation_form2_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/organisation/_form2.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
printHtmlPart(1)
invokeTag('message','g',6,['code':("organisation.name.label"),'default':("Name")],-1)
printHtmlPart(2)
invokeTag('message','g',7,['code':("organisation.nameZusatz.label"),'default':("Name Zusatz")],-1)
printHtmlPart(3)
expressionOut.print(hasErrors(bean: organisationInstance, field: 'name', 'error'))
printHtmlPart(4)
invokeTag('textField','g',12,['name':("name"),'maxlength':("80"),'pattern':(organisationInstance.constraints.name.matches),'required':(""),'value':(organisationInstance?.name)],-1)
printHtmlPart(5)
expressionOut.print(hasErrors(bean: organisationInstance, field: 'nameZusatz', 'error'))
printHtmlPart(4)
invokeTag('textField','g',15,['name':("nameZusatz"),'maxlength':("50"),'pattern':(organisationInstance.constraints.nameZusatz.matches),'value':(organisationInstance?.nameZusatz)],-1)
printHtmlPart(6)
invokeTag('message','g',21,['code':("organisation.rechtsform.label"),'default':("Rechtsform")],-1)
printHtmlPart(2)
invokeTag('message','g',22,['code':("organisation.branche.label"),'default':("Branche")],-1)
printHtmlPart(3)
expressionOut.print(hasErrors(bean: organisationInstance, field: 'rechtsform', 'error'))
printHtmlPart(4)
invokeTag('select','g',27,['name':("rechtsform"),'from':(organisationInstance.constraints.rechtsform.inList),'value':(organisationInstance?.rechtsform),'valueMessagePrefix':("organisation.rechtsform"),'noSelection':(['': ''])],-1)
printHtmlPart(5)
expressionOut.print(hasErrors(bean: organisationInstance, field: 'branche', 'error'))
printHtmlPart(4)
invokeTag('select','g',30,['id':("branche"),'name':("branche.id"),'from':(Branche.branchenKurz(65)),'optionKey':("id"),'value':(personInstance?.branche?.id),'class':("many-to-one"),'noSelection':(['null': ''])],-1)
printHtmlPart(7)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1423849534000L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
