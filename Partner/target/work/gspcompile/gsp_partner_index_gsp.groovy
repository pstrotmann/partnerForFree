import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_partner_index_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/_index.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
createTagBody(1, {->
printHtmlPart(0)
invokeTag('captureMeta','sitemesh',2,['gsp_sm_xmlClosingForEmptyTag':("/"),'name':("layout"),'content':("main")],-1)
printHtmlPart(0)
createTagBody(2, {->
createTagBody(3, {->
invokeTag('message','g',3,['code':("app.title")],-1)
})
invokeTag('captureTitle','sitemesh',3,[:],3)
})
invokeTag('wrapTitleTag','sitemesh',3,[:],2)
printHtmlPart(1)
})
invokeTag('captureHead','sitemesh',86,[:],1)
printHtmlPart(2)
createTagBody(1, {->
printHtmlPart(3)
invokeTag('message','g',88,['code':("default.link.skip.label"),'default':("Skip to content&hellip;")],-1)
printHtmlPart(4)
invokeTag('message','g',90,['code':("app.title")],-1)
printHtmlPart(5)
invokeTag('message','g',94,['code':("app.title1")],-1)
printHtmlPart(6)
createClosureForHtmlPart(7, 2)
invokeTag('link','g',96,['controller':("matchcode")],2)
printHtmlPart(8)
createClosureForHtmlPart(9, 2)
invokeTag('link','g',97,['controller':("person"),'action':("list")],2)
printHtmlPart(10)
createTagBody(2, {->
invokeTag('message','g',99,['code':("entity.organisation")],-1)
})
invokeTag('link','g',99,['controller':("organisation"),'action':("list")],2)
printHtmlPart(11)
createClosureForHtmlPart(12, 2)
invokeTag('link','g',105,['controller':("bank")],2)
printHtmlPart(8)
createTagBody(2, {->
invokeTag('message','g',106,['code':("entity.notiz")],-1)
})
invokeTag('link','g',106,['controller':("notiz")],2)
printHtmlPart(13)
})
invokeTag('captureBody','sitemesh',1,[:],1)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1424172054000L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
