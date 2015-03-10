import org.strotmann.partner.Person
import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_partner_personshow_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/person/show.gsp" }
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
invokeTag('set','g',7,['var':("entityName"),'value':(message(code: 'person.label', default: 'Person'))],-1)
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
printHtmlPart(9)
expressionOut.print(createLink(uri: '/matchcode/create'))
printHtmlPart(6)
invokeTag('message','g',17,['code':("default.mcSuch.label")],-1)
printHtmlPart(7)
createTagBody(2, {->
invokeTag('message','g',18,['code':("default.histo.label"),'args':([entityName])],-1)
})
invokeTag('link','g',18,['class':("list"),'controller':("historie"),'action':("domList"),'params':([dom:personInstance,domId:personInstance?.id,domName:entityName])],2)
printHtmlPart(10)
invokeTag('message','g',22,['code':("default.show.label"),'args':([entityName])],-1)
printHtmlPart(11)
if(true && (flash.message)) {
printHtmlPart(12)
expressionOut.print(flash.message)
printHtmlPart(13)
}
printHtmlPart(14)
if(true && (personInstance?.name)) {
printHtmlPart(15)
invokeTag('message','g',30,['code':("person.name.label")],-1)
printHtmlPart(16)
invokeTag('fieldValue','g',32,['bean':(personInstance),'field':("name")],-1)
printHtmlPart(17)
}
printHtmlPart(18)
if(true && (personInstance?.titel)) {
printHtmlPart(19)
invokeTag('message','g',39,['code':("person.titel.label")],-1)
printHtmlPart(20)
invokeTag('fieldValue','g',41,['bean':(personInstance),'field':("titel")],-1)
printHtmlPart(17)
}
printHtmlPart(18)
if(true && (personInstance?.vorname)) {
printHtmlPart(21)
invokeTag('message','g',48,['code':("person.vorname.label")],-1)
printHtmlPart(22)
invokeTag('fieldValue','g',50,['bean':(personInstance),'field':("vorname")],-1)
printHtmlPart(17)
}
printHtmlPart(18)
if(true && (personInstance?.geschlecht)) {
printHtmlPart(23)
invokeTag('message','g',57,['code':("person.geschlecht.label")],-1)
printHtmlPart(24)
invokeTag('fieldValue','g',59,['bean':(personInstance),'field':("geschlecht")],-1)
printHtmlPart(17)
}
printHtmlPart(18)
if(true && (personInstance?.geburtsdatum)) {
printHtmlPart(25)
invokeTag('message','g',66,['code':("person.geburtsdatum.label")],-1)
printHtmlPart(26)
invokeTag('formatDate','g',68,['date':(personInstance?.geburtsdatum),'format':("dd.MM.yyyy")],-1)
printHtmlPart(17)
}
printHtmlPart(27)
if(true && (personInstance?.persoenlicheAnrede)) {
printHtmlPart(28)
invokeTag('message','g',75,['code':("person.persoenlicheAnrede.label")],-1)
printHtmlPart(29)
invokeTag('formatBoolean','g',77,['boolean':(personInstance?.persoenlicheAnrede),'true':("persönlich"),'false':("formal")],-1)
printHtmlPart(30)
}
printHtmlPart(27)
if(true && (personInstance?.nationalitaet)) {
printHtmlPart(31)
invokeTag('message','g',84,['code':("person.nationalitaet.label")],-1)
printHtmlPart(32)
expressionOut.print(personInstance?.nationalitaet?.encodeAsHTML())
printHtmlPart(17)
}
printHtmlPart(27)
if(true && (personInstance?.religion)) {
printHtmlPart(33)
invokeTag('message','g',93,['code':("person.religion.label")],-1)
printHtmlPart(34)
expressionOut.print(personInstance?.religion?.encodeAsHTML())
printHtmlPart(17)
}
printHtmlPart(27)
if(true && (personInstance?.beruf)) {
printHtmlPart(35)
invokeTag('message','g',102,['code':("person.beruf.label")],-1)
printHtmlPart(36)
invokeTag('fieldValue','g',104,['bean':(personInstance),'field':("beruf")],-1)
printHtmlPart(17)
}
printHtmlPart(27)
if(true && (personInstance?.taetigkeit)) {
printHtmlPart(35)
invokeTag('message','g',111,['code':("person.taetigkeit.label")],-1)
printHtmlPart(37)
invokeTag('fieldValue','g',113,['bean':(personInstance),'field':("taetigkeit")],-1)
printHtmlPart(17)
}
printHtmlPart(18)
if(true && (personInstance?.hausadresse)) {
printHtmlPart(38)
invokeTag('message','g',120,['code':("person.hausadresse.label")],-1)
printHtmlPart(39)
createTagBody(3, {->
expressionOut.print(personInstance?.hausadresse?.encodeAsHTML())
})
invokeTag('link','g',122,['controller':("hausadresse"),'action':("show"),'id':(personInstance?.hausadresse?.id)],3)
printHtmlPart(17)
}
printHtmlPart(27)
if(true && (personInstance?.bankverbindungen)) {
printHtmlPart(40)
invokeTag('message','g',129,['code':("person.bankverbindungen.label")],-1)
printHtmlPart(41)
for( b in (personInstance.bankverbindungen) ) {
printHtmlPart(42)
createTagBody(4, {->
expressionOut.print(b?.encodeAsHTML())
})
invokeTag('link','g',132,['controller':("bankverbindung"),'action':("show"),'id':(b.id)],4)
printHtmlPart(43)
}
printHtmlPart(44)
}
printHtmlPart(18)
if(true && (personInstance?.kommunikationen)) {
printHtmlPart(45)
invokeTag('message','g',140,['code':("person.kommunikationen.label")],-1)
printHtmlPart(41)
for( k in (personInstance.kommunikationen) ) {
printHtmlPart(46)
createTagBody(4, {->
expressionOut.print(k?.encodeAsHTML())
})
invokeTag('link','g',143,['controller':("kommunikation"),'action':("show"),'id':(k.id)],4)
printHtmlPart(43)
}
printHtmlPart(44)
}
printHtmlPart(18)
if(true && (personInstance?.partnerrollen)) {
printHtmlPart(47)
invokeTag('message','g',151,['code':("person.partnerrollen.label.ist")],-1)
printHtmlPart(41)
for( p in (personInstance.partnerrollen) ) {
printHtmlPart(48)
createTagBody(4, {->
expressionOut.print(p?.encodeAsHTML())
})
invokeTag('link','g',154,['controller':(p.objektname),'action':("show"),'id':(p.objektId)],4)
printHtmlPart(43)
}
printHtmlPart(44)
}
printHtmlPart(27)
if(true && (org.strotmann.partner.Partnerrolle.rollenZuObjekt(personInstance))) {
printHtmlPart(47)
invokeTag('message','g',162,['code':("person.partnerrollen.label.hat")],-1)
printHtmlPart(41)
for( ro in (org.strotmann.partner.Partnerrolle.rollenZuObjekt(personInstance)) ) {
printHtmlPart(49)
if(true && (ro.partner.instanceOf(org.strotmann.partner.Person))) {
printHtmlPart(50)
createTagBody(5, {->
expressionOut.print(ro.rolle)
printHtmlPart(51)
expressionOut.print(ro.partner)
})
invokeTag('link','g',166,['controller':("person"),'action':("show"),'id':(ro.partner.id)],5)
printHtmlPart(43)
}
else {
printHtmlPart(50)
createTagBody(5, {->
expressionOut.print(ro.rolle)
printHtmlPart(51)
expressionOut.print(ro.partner)
})
invokeTag('link','g',169,['controller':("organisation"),'action':("show"),'id':(ro.partner.id)],5)
printHtmlPart(43)
}
printHtmlPart(49)
}
printHtmlPart(44)
}
printHtmlPart(52)
invokeTag('message','g',177,['code':("person.notizen.label")],-1)
printHtmlPart(41)
for( n in (org.strotmann.notiz.Notiz.getNotizen('Person',personInstance.id)) ) {
printHtmlPart(53)
createTagBody(3, {->
expressionOut.print(n)
})
invokeTag('link','g',180,['controller':("notiz"),'action':("show"),'id':(n.id)],3)
printHtmlPart(43)
}
printHtmlPart(54)
createTagBody(2, {->
printHtmlPart(55)
invokeTag('hiddenField','g',188,['name':("id"),'value':(personInstance?.id)],-1)
printHtmlPart(56)
createTagBody(3, {->
invokeTag('message','g',189,['code':("default.button.edit.label"),'default':("Edit")],-1)
})
invokeTag('link','g',189,['class':("edit"),'action':("edit"),'id':(personInstance?.id)],3)
printHtmlPart(56)
invokeTag('actionSubmit','g',190,['class':("delete"),'action':("delete"),'value':(message(code: 'default.button.delete.label', default: 'Delete')),'onclick':("return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');")],-1)
printHtmlPart(57)
})
invokeTag('form','g',192,['url':([resource:personInstance, action:'delete']),'method':("DELETE")],2)
printHtmlPart(58)
})
invokeTag('captureBody','sitemesh',194,[:],1)
printHtmlPart(59)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1424186124000L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
