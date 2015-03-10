import org.strotmann.partner.Matchcode
import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_partner_matchcode_form_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/matchcode/_form.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
expressionOut.print(hasErrors(bean: matchcodeInstance, field: 'partnerart', 'error'))
printHtmlPart(1)
invokeTag('message','g',7,['code':("matchcode.partnerart.label"),'default':("Partnerart")],-1)
printHtmlPart(2)
invokeTag('select','g',10,['name':("partnerart"),'value':(matchcodeInstance?.partnerart),'from':(['p', 'o']),'noSelection':(['':' '])],-1)
printHtmlPart(3)
expressionOut.print(hasErrors(bean: matchcodeInstance, field: 'name', 'error'))
printHtmlPart(4)
invokeTag('message','g',16,['code':("matchcode.name.label"),'default':("Name")],-1)
printHtmlPart(2)
invokeTag('textField','g',19,['name':("name"),'value':(matchcodeInstance?.name)],-1)
printHtmlPart(3)
expressionOut.print(hasErrors(bean: matchcodeInstance, field: 'geschlecht', 'error'))
printHtmlPart(5)
invokeTag('message','g',25,['code':("matchcode.geschlecht.label"),'default':("Geschlecht")],-1)
printHtmlPart(2)
invokeTag('select','g',28,['name':("geschlecht"),'value':(matchcodeInstance?.geschlecht),'from':(['m', 'f']),'noSelection':(['':' '])],-1)
printHtmlPart(3)
expressionOut.print(hasErrors(bean: matchcodeInstance, field: 'vorname', 'error'))
printHtmlPart(6)
invokeTag('message','g',34,['code':("matchcode.vorname.label"),'default':("Vorname")],-1)
printHtmlPart(2)
invokeTag('textField','g',37,['name':("vorname"),'value':(matchcodeInstance?.vorname)],-1)
printHtmlPart(3)
expressionOut.print(hasErrors(bean: matchcodeInstance, field: 'strasse', 'error'))
printHtmlPart(7)
invokeTag('message','g',43,['code':("matchcode.strasse.label"),'default':("Strasse")],-1)
printHtmlPart(2)
invokeTag('textField','g',46,['name':("strasse"),'value':(matchcodeInstance?.strasse)],-1)
printHtmlPart(3)
expressionOut.print(hasErrors(bean: matchcodeInstance, field: 'postleitzahl', 'error'))
printHtmlPart(8)
invokeTag('message','g',52,['code':("matchcode.postleitzahl.label"),'default':("Postleitzahl")],-1)
printHtmlPart(2)
invokeTag('field','g',55,['name':("postleitzahl"),'type':("number"),'value':(matchcodeInstance.postleitzahl),'required':("")],-1)
printHtmlPart(3)
expressionOut.print(hasErrors(bean: matchcodeInstance, field: 'ort', 'error'))
printHtmlPart(9)
invokeTag('message','g',61,['code':("matchcode.ort.label"),'default':("Ort")],-1)
printHtmlPart(2)
invokeTag('textField','g',64,['name':("ort"),'value':(matchcodeInstance?.ort)],-1)
printHtmlPart(10)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1424430838000L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
