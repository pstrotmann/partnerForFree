package org.strotmann.partner

import grails.transaction.Transactional;
import org.springframework.dao.DataIntegrityViolationException
import org.strotmann.benutzer.Benutzer
import org.strotmann.notiz.Notiz
import grails.rest.*
import grails.converters.JSON
import grails.util.Holders

class PartnerController extends RestfulController {

	def scaffold = true
	
	static responseFormats = ['json', 'xml']
	PartnerController() {
		super(Partner)
	}
	
	//localhost:8080/Partner/partner/get?id=1956
	//localhost:8080/Partner/partner/get?name=Giebel
	def get(){
		def entry = params.find{ k, v -> Partner.metaClass.hasMetaProperty k }
		if( entry ) {
		  if (entry.key == 'id')
			  entry.value = entry.value.toLong()
		  	
		  render (Partner.withCriteria() { eq (entry.key, entry.value) } as JSON)
		}
		 else
		  render text:'not found!'
	}
	
	//localhost:8080/Partner/partner/getViaParo?rolle=Kunde&objektname=Auftrag&objektId=129
	def getViaParo(){
		Partnerrolle paro = new Partnerrolle()
		params.each{k,v ->
			if (k == 'rolle') paro.rolle = v
			if (k == 'objektname') paro.objektname = v
			if (k == 'objektId') paro.objektId = Long.parseLong(v)
		}
		paro = Partnerrolle.getPaRolle(paro)
		if (paro)
			render (Partner.withCriteria() { eq ('id', paro.partner.id) } as JSON)
		else
			render text:'not found!'
	}
	
	//localhost:8080/Partner/partner/saveRolle?id=894&oldId=2344&rolle=Kunde&objektname=Auftrag&objektId=257
	def saveRolle(){
		Partnerrolle paro = new Partnerrolle()
		Partner partner = null
		Long oldId = null
		params.each{k,v ->
			if (k == 'id') partner = Partner.get(Long.parseLong(v))
			if (k == 'oldId') oldId = Long.parseLong(v)
			if (k == 'rolle') paro.rolle = v
			if (k == 'objektname') paro.objektname = v
			if (k == 'objektId') paro.objektId = Long.parseLong(v)
		}
				
		if (oldId > 0) {
			paro.partner = Partner.get(oldId)
			paro = Partnerrolle.getPartnerrolle(paro)
			}
		paro.partner = partner	
		
		if (paro.save(flush: true))
			render text:'ok'
		else {
			paro.errors.each {
			println it
			}
			render text:'Speicherfehler'
		}
	}
	
	//localhost:8080/Partner/partner/loeRolle?rolle=Kunde&objektname=Auftrag&objektId=257
	def loeRolle(){
		Partnerrolle paro = new Partnerrolle()
		params.each{k,v ->
			if (k == 'rolle') paro.rolle = v
			if (k == 'objektname') paro.objektname = v
			if (k == 'objektId') paro.objektId = Long.parseLong(v)
		}
		paro = Partnerrolle.getPaRolle(paro)
		paro.delete(flush: true)
		render text:'ok'
	}
	
	//localhost:8080/Partner/partner/saveRueckUri?anwendung=Sale:Auftrag&uri=134.255.238.190:8080/Sale-0.1/auftrag
	def saveRueckUri(){
		String renderText
		RueckUri rueckUri = RueckUri.getRueckUri(params.anwendung)
		if (rueckUri)
			if (rueckUri.uri == params.uri) 
				renderText = 'ok'
			else {
				rueckUri.uri = params.uri
				renderText = 'save'
			}
		else {
			rueckUri = new RueckUri()
			rueckUri.anwendung = params.anwendung
			rueckUri.uri = params.uri
			renderText = 'save'
		}
		if (renderText == 'save')
			if (rueckUri.save(flush: true))
				renderText = 'ok'
			else {
				rueckUri.errors.each {
				println it
				}
				renderText = 'Speicherfehler'
			}
		
		render text:renderText
	}
	
	//localhost:8080/Partner/partner/loginAppUser?name=peter&passwort=wuffwuff
	def loginAppUser(){
		String renderText
		def u = Benutzer.findByName(params.name)
		if (u) {
			if (u.passwort == params.passwort) 
				renderText = "ok"
			else 
				renderText = "Passwort falsch"
		}
		else 
			renderText = "User unbekannt"
		
		if(renderText == "ok"){
			def Notiz n = Notiz.find("from Notiz as n where n.notiztext = 'appUser'")
			if (n) 
				n.referenz = u.id.toString()
			else {
				n = new Notiz()
				n.anlagetermin = new Date()
				n.wiedervorlagetermin = new Date()
				n.notiztext = "appUser"
				n.referenz = u.id.toString()
			}
			n.save(flush: true)
		}	
		
		render text:renderText
	}
}
