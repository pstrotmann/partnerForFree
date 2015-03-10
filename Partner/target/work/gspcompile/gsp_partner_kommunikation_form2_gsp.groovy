import org.strotmann.partner.Kommunikation
import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_partner_kommunikation_form2_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/kommunikation/_form2.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
invokeTag('message','g',4,['code':("person.kommunikationen.label")],-1)
printHtmlPart(1)
invokeTag('message','g',6,['code':("kommunikation.art.label"),'default':("Art")],-1)
printHtmlPart(2)
invokeTag('message','g',7,['code':("kommunikation.anwahl.label"),'default':("Anwahl")],-1)
printHtmlPart(2)
invokeTag('message','g',8,['code':("kommunikation.zusatz.label"),'default':("Zusatz")],-1)
printHtmlPart(3)
expressionOut.print(hasErrors(bean: kommunikationInstance, field: 'art', 'error'))
printHtmlPart(4)
invokeTag('select','g',12,['name':("art"),'from':(kommunikationInstance.constraints.art.inList),'value':(kommunikationInstance?.art),'valueMessagePrefix':("kommunikation.art"),'noSelection':(['': ''])],-1)
printHtmlPart(5)
expressionOut.print(hasErrors(bean: kommunikationInstance, field: 'anwahl', 'error'))
printHtmlPart(4)
invokeTag('textField','g',15,['name':("anwahl"),'value':(kommunikationInstance?.anwahl)],-1)
printHtmlPart(5)
expressionOut.print(hasErrors(bean: kommunikationInstance, field: 'zusatz', 'error'))
printHtmlPart(4)
invokeTag('textField','g',18,['name':("zusatz"),'value':(kommunikationInstance?.zusatz)],-1)
printHtmlPart(6)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1424804715000L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
