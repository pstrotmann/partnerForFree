import org.strotmann.partner.Organisation
import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_partner_organisationshow_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/organisation/show.gsp" }
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
invokeTag('set','g',7,['var':("entityName"),'value':(message(code: 'organisation.label', default: 'Organisation'))],-1)
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
expressionOut.print(createLink(uri: "/menu", params: [lang: session.user.sprache]))
printHtmlPart(6)
invokeTag('message','g',14,['code':("default.home.label")],-1)
printHtmlPart(7)
createTagBody(2, {->
invokeTag('message','g',15,['code':("default.list.label"),'args':([entityName])],-1)
})
invokeTag('link','g',15,['class':("list"),'action':("list")],2)
printHtmlPart(8)
createTagBody(2, {->
invokeTag('message','g',16,['code':("default.new.label"),'args':([entityName])],-1)
})
invokeTag('link','g',16,['class':("create"),'action':("create")],2)
printHtmlPart(8)
createTagBody(2, {->
invokeTag('message','g',17,['code':("default.histo.label"),'args':([entityName])],-1)
})
invokeTag('link','g',17,['class':("list"),'controller':("historie"),'action':("domList"),'params':([dom:organisationInstance,domId:organisationInstance?.id,domName:entityName])],2)
printHtmlPart(9)
invokeTag('message','g',21,['code':("default.show.label"),'args':([entityName])],-1)
printHtmlPart(10)
if(true && (flash.message)) {
printHtmlPart(11)
expressionOut.print(flash.message)
printHtmlPart(12)
}
printHtmlPart(13)
if(true && (organisationInstance?.name)) {
printHtmlPart(14)
invokeTag('message','g',29,['code':("organisation.name.label"),'default':("Name")],-1)
printHtmlPart(15)
invokeTag('fieldValue','g',31,['bean':(organisationInstance),'field':("name")],-1)
printHtmlPart(16)
}
printHtmlPart(17)
if(true && (organisationInstance?.nameZusatz)) {
printHtmlPart(18)
invokeTag('message','g',38,['code':("organisation.nameZusatz.label"),'default':("Name Zusatz")],-1)
printHtmlPart(19)
invokeTag('fieldValue','g',40,['bean':(organisationInstance),'field':("nameZusatz")],-1)
printHtmlPart(16)
}
printHtmlPart(17)
if(true && (organisationInstance?.rechtsform)) {
printHtmlPart(20)
invokeTag('message','g',47,['code':("organisation.rechtsform.label"),'default':("Rechtsform")],-1)
printHtmlPart(21)
invokeTag('fieldValue','g',49,['bean':(organisationInstance),'field':("rechtsform")],-1)
printHtmlPart(16)
}
printHtmlPart(22)
if(true && (organisationInstance?.branche)) {
printHtmlPart(23)
invokeTag('message','g',56,['code':("organisation.branche.label"),'default':("Branche")],-1)
printHtmlPart(24)
invokeTag('fieldValue','g',58,['bean':(organisationInstance),'field':("branche")],-1)
printHtmlPart(16)
}
printHtmlPart(25)
if(true && (organisationInstance?.hausadresse)) {
printHtmlPart(26)
invokeTag('message','g',65,['code':("organisation.hausadresse.label"),'default':("Hausadresse")],-1)
printHtmlPart(27)
createTagBody(3, {->
expressionOut.print(organisationInstance?.hausadresse?.encodeAsHTML())
})
invokeTag('link','g',67,['controller':("hausadresse"),'action':("show"),'id':(organisationInstance?.hausadresse?.id)],3)
printHtmlPart(16)
}
printHtmlPart(17)
if(true && (organisationInstance?.bankverbindungen)) {
printHtmlPart(28)
invokeTag('message','g',74,['code':("organisation.bankverbindungen.label"),'default':("Bankverbindungen")],-1)
printHtmlPart(29)
for( b in (organisationInstance.bankverbindungen) ) {
printHtmlPart(30)
createTagBody(4, {->
expressionOut.print(b?.encodeAsHTML())
})
invokeTag('link','g',77,['controller':("bankverbindung"),'action':("show"),'id':(b.id)],4)
printHtmlPart(31)
}
printHtmlPart(32)
}
printHtmlPart(17)
if(true && (organisationInstance?.kommunikationen)) {
printHtmlPart(33)
invokeTag('message','g',85,['code':("organisation.kommunikationen.label"),'default':("Kommunikationskanäle")],-1)
printHtmlPart(29)
for( k in (organisationInstance.kommunikationen) ) {
printHtmlPart(34)
createTagBody(4, {->
expressionOut.print(k?.encodeAsHTML())
})
invokeTag('link','g',88,['controller':("kommunikation"),'action':("show"),'id':(k.id)],4)
printHtmlPart(31)
}
printHtmlPart(32)
}
printHtmlPart(17)
if(true && (organisationInstance?.postfachadressen)) {
printHtmlPart(35)
invokeTag('message','g',96,['code':("organisation.postfachadresse.label"),'default':("Postfachadresse")],-1)
printHtmlPart(29)
for( p in (organisationInstance.postfachadressen) ) {
printHtmlPart(36)
createTagBody(4, {->
expressionOut.print(p?.encodeAsHTML())
})
invokeTag('link','g',99,['controller':("postfachadresse"),'action':("show"),'id':(p.id)],4)
printHtmlPart(31)
}
printHtmlPart(32)
}
printHtmlPart(22)
if(true && (organisationInstance?.lieferadressen)) {
printHtmlPart(37)
invokeTag('message','g',107,['code':("organisation.lieferadresse.label"),'default':("Lieferadresse")],-1)
printHtmlPart(29)
for( p in (organisationInstance.lieferadressen) ) {
printHtmlPart(38)
createTagBody(4, {->
expressionOut.print(p?.encodeAsHTML())
})
invokeTag('link','g',110,['controller':("lieferadresse"),'action':("show"),'id':(p.id)],4)
printHtmlPart(31)
}
printHtmlPart(32)
}
printHtmlPart(22)
if(true && (organisationInstance?.partnerrollen)) {
printHtmlPart(39)
invokeTag('message','g',118,['code':("organisation.partnerrollen.label"),'default':("ist")],-1)
printHtmlPart(29)
for( p in (organisationInstance.partnerrollen) ) {
printHtmlPart(40)
createTagBody(4, {->
expressionOut.print(p?.encodeAsHTML())
})
invokeTag('link','g',121,['controller':(p.objektname),'action':("show"),'id':(p.objektId)],4)
printHtmlPart(31)
}
printHtmlPart(32)
}
printHtmlPart(22)
if(true && (org.strotmann.partner.Partnerrolle.rollenZuObjekt(organisationInstance))) {
printHtmlPart(39)
invokeTag('message','g',129,['code':("organisation.partnerrollen.label"),'default':("hat")],-1)
printHtmlPart(29)
for( ro in (org.strotmann.partner.Partnerrolle.rollenZuObjekt(organisationInstance)) ) {
printHtmlPart(41)
if(true && (ro.partner.instanceOf(org.strotmann.partner.Person))) {
printHtmlPart(42)
createTagBody(5, {->
expressionOut.print(ro.rolle)
printHtmlPart(43)
expressionOut.print(ro.partner)
})
invokeTag('link','g',133,['controller':("person"),'action':("show"),'id':(ro.partner.id)],5)
printHtmlPart(31)
}
else {
printHtmlPart(42)
createTagBody(5, {->
expressionOut.print(ro.rolle)
printHtmlPart(43)
expressionOut.print(ro.partner)
})
invokeTag('link','g',136,['controller':("organisation"),'action':("show"),'id':(ro.partner.id)],5)
printHtmlPart(31)
}
printHtmlPart(41)
}
printHtmlPart(32)
}
printHtmlPart(44)
invokeTag('message','g',144,['code':("organisation.notizen.label"),'default':("Notizen")],-1)
printHtmlPart(29)
for( n in (org.strotmann.notiz.Notiz.getNotizen('Organisation',organisationInstance.id)) ) {
printHtmlPart(45)
createTagBody(3, {->
expressionOut.print(n)
})
invokeTag('link','g',147,['controller':("notiz"),'action':("show"),'id':(n.id)],3)
printHtmlPart(31)
}
printHtmlPart(46)
createTagBody(2, {->
printHtmlPart(47)
invokeTag('hiddenField','g',155,['name':("id"),'value':(organisationInstance?.id)],-1)
printHtmlPart(48)
createTagBody(3, {->
invokeTag('message','g',156,['code':("default.button.edit.label"),'default':("Edit")],-1)
})
invokeTag('link','g',156,['class':("edit"),'action':("edit"),'id':(organisationInstance?.id)],3)
printHtmlPart(48)
invokeTag('actionSubmit','g',157,['method':("DELETE"),'class':("delete"),'action':("delete"),'value':(message(code: 'default.button.delete.label', default: 'Delete')),'onclick':("return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');")],-1)
printHtmlPart(49)
})
invokeTag('form','g',159,['url':([resource:organisationInstance, action:'delete']),'method':("DELETE")],2)
printHtmlPart(50)
})
invokeTag('captureBody','sitemesh',161,[:],1)
printHtmlPart(51)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1424345055000L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
