import org.strotmann.partner.Lieferadresse
import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_partner_lieferadresseshow_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/lieferadresse/show.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
printHtmlPart(1)
createTagBody(1, {->
printHtmlPart(2)
invokeTag('captureMeta','sitemesh',6,['gsp_sm_xmlClosingForEmptyTag':(""),'name':("layout"),'content':("main")],-1)
printHtmlPart(2)
invokeTag('set','g',7,['var':("entityName"),'value':(message(code: 'lieferadresse.label', default: 'Lieferadresse'))],-1)
printHtmlPart(2)
createTagBody(2, {->
createTagBody(3, {->
invokeTag('message','g',8,['code':("default.show.label"),'args':([entityName])],-1)
})
invokeTag('captureTitle','sitemesh',8,[:],3)
})
invokeTag('wrapTitleTag','sitemesh',8,[:],2)
printHtmlPart(3)
})
invokeTag('captureHead','sitemesh',9,[:],1)
printHtmlPart(3)
createTagBody(1, {->
printHtmlPart(4)
invokeTag('message','g',11,['code':("default.link.skip.label"),'default':("Skip to content&hellip;")],-1)
printHtmlPart(5)
expressionOut.print(createLink(uri: '/'))
printHtmlPart(6)
invokeTag('message','g',14,['code':("default.home.label")],-1)
printHtmlPart(7)
createTagBody(2, {->
invokeTag('message','g',15,['code':("default.list.label"),'args':([entityName])],-1)
})
invokeTag('link','g',15,['class':("list"),'action':("index")],2)
printHtmlPart(8)
createTagBody(2, {->
invokeTag('message','g',16,['code':("default.new.label"),'args':([entityName])],-1)
})
invokeTag('link','g',16,['class':("create"),'action':("create")],2)
printHtmlPart(9)
invokeTag('message','g',20,['code':("default.show.label"),'args':([entityName])],-1)
printHtmlPart(10)
if(true && (flash.message)) {
printHtmlPart(11)
expressionOut.print(flash.message)
printHtmlPart(12)
}
printHtmlPart(13)
if(true && (lieferadresseInstance?.strasse)) {
printHtmlPart(14)
invokeTag('message','g',28,['code':("lieferadresse.strasse.label"),'default':("Strasse")],-1)
printHtmlPart(15)
invokeTag('fieldValue','g',30,['bean':(lieferadresseInstance),'field':("strasse")],-1)
printHtmlPart(16)
}
printHtmlPart(17)
if(true && (lieferadresseInstance?.hausnummer)) {
printHtmlPart(18)
invokeTag('message','g',37,['code':("lieferadresse.hausnummer.label"),'default':("Hausnummer")],-1)
printHtmlPart(19)
invokeTag('fieldValue','g',39,['bean':(lieferadresseInstance),'field':("hausnummer")],-1)
printHtmlPart(16)
}
printHtmlPart(17)
if(true && (lieferadresseInstance?.zusatz)) {
printHtmlPart(20)
invokeTag('message','g',46,['code':("lieferadresse.zusatz.label"),'default':("Zusatz")],-1)
printHtmlPart(21)
invokeTag('fieldValue','g',48,['bean':(lieferadresseInstance),'field':("zusatz")],-1)
printHtmlPart(16)
}
printHtmlPart(17)
if(true && (lieferadresseInstance?.postleitzahl)) {
printHtmlPart(22)
invokeTag('message','g',55,['code':("lieferadresse.postleitzahl.label"),'default':("Postleitzahl")],-1)
printHtmlPart(23)
invokeTag('fieldValue','g',57,['bean':(lieferadresseInstance),'field':("postleitzahl")],-1)
printHtmlPart(16)
}
printHtmlPart(17)
if(true && (lieferadresseInstance?.ort)) {
printHtmlPart(24)
invokeTag('message','g',64,['code':("lieferadresse.ort.label"),'default':("Ort")],-1)
printHtmlPart(25)
invokeTag('fieldValue','g',66,['bean':(lieferadresseInstance),'field':("ort")],-1)
printHtmlPart(16)
}
printHtmlPart(17)
if(true && (lieferadresseInstance?.land)) {
printHtmlPart(26)
invokeTag('message','g',73,['code':("lieferadresse.land.label"),'default':("Land")],-1)
printHtmlPart(27)
createTagBody(3, {->
expressionOut.print(lieferadresseInstance?.land?.encodeAsHTML())
})
invokeTag('link','g',75,['controller':("land"),'action':("show"),'id':(lieferadresseInstance?.land?.id)],3)
printHtmlPart(16)
}
printHtmlPart(17)
if(true && (lieferadresseInstance?.anfahrt)) {
printHtmlPart(28)
invokeTag('message','g',82,['code':("lieferadresse.anfahrt.label"),'default':("Anfahrt")],-1)
printHtmlPart(29)
invokeTag('fieldValue','g',84,['bean':(lieferadresseInstance),'field':("anfahrt")],-1)
printHtmlPart(16)
}
printHtmlPart(17)
if(true && (lieferadresseInstance?.partner)) {
printHtmlPart(30)
invokeTag('message','g',91,['code':("lieferadresse.partner.label"),'default':("Partner")],-1)
printHtmlPart(31)
createTagBody(3, {->
expressionOut.print(lieferadresseInstance?.partner?.encodeAsHTML())
})
invokeTag('link','g',93,['controller':("organisation"),'action':("show"),'id':(lieferadresseInstance?.partner?.id)],3)
printHtmlPart(16)
}
printHtmlPart(32)
createTagBody(2, {->
printHtmlPart(33)
createTagBody(3, {->
invokeTag('message','g',101,['code':("default.button.edit.label"),'default':("Edit")],-1)
})
invokeTag('link','g',101,['class':("edit"),'action':("edit"),'resource':(lieferadresseInstance)],3)
printHtmlPart(34)
invokeTag('actionSubmit','g',102,['class':("delete"),'action':("delete"),'value':(message(code: 'default.button.delete.label', default: 'Delete')),'onclick':("return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');")],-1)
printHtmlPart(35)
})
invokeTag('form','g',104,['url':([resource:lieferadresseInstance, action:'delete']),'method':("DELETE")],2)
printHtmlPart(36)
})
invokeTag('captureBody','sitemesh',106,[:],1)
printHtmlPart(37)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1424602425000L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
