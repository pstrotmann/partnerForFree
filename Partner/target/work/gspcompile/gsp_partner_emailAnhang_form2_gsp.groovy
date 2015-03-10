import org.strotmann.mail.EmailAnhang
import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_partner_emailAnhang_form2_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/emailAnhang/_form2.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
expressionOut.print(hasErrors(bean: emailAnhangInstance, field: 'datei', 'error'))
printHtmlPart(1)
invokeTag('message','g',7,['code':("emailAnhang.datei.label"),'default':("Datei")],-1)
printHtmlPart(2)
expressionOut.print(hasErrors(bean: emailAnhangInstance, field: 'eMail', 'error'))
printHtmlPart(3)
invokeTag('message','g',16,['code':("emailAnhang.eMail.label"),'default':("E Mail")],-1)
printHtmlPart(4)
invokeTag('select','g',19,['id':("eMail"),'name':("eMail.id"),'from':(org.strotmann.mail.Email.list()),'optionKey':("id"),'required':(""),'value':(emailAnhangInstance?.eMail?.id),'class':("many-to-one")],-1)
printHtmlPart(5)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1425036887000L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
