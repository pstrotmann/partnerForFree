import org.strotmann.partner.Land
import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_partner_land_form_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/land/_form.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
expressionOut.print(hasErrors(bean: landInstance, field: 'kfzKz', 'error'))
printHtmlPart(1)
invokeTag('message','g',7,['code':("land.kfzKz.label"),'default':("Kfz Kz")],-1)
printHtmlPart(2)
invokeTag('textField','g',10,['name':("kfzKz"),'required':(""),'value':(landInstance?.kfzKz)],-1)
printHtmlPart(3)
expressionOut.print(hasErrors(bean: landInstance, field: 'name', 'error'))
printHtmlPart(4)
invokeTag('message','g',16,['code':("land.name.label"),'default':("Name")],-1)
printHtmlPart(2)
invokeTag('textField','g',19,['name':("name"),'required':(""),'value':(landInstance?.name)],-1)
printHtmlPart(5)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1420731722000L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
