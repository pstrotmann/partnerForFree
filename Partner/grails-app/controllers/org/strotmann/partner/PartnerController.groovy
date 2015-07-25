package org.strotmann.partner

import grails.transaction.Transactional;
import org.springframework.dao.DataIntegrityViolationException
import grails.rest.*
import grails.converters.JSON

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
	
	//localhost:8080/Partner/partner/createRolle?id=163&rolle=Kunde&objektname=Organisation&objektId=132
	def createRolle(){
		Partnerrolle paro = new Partnerrolle()
		params.each{k,v ->
			if (k == 'id') paro.partner = Partner.get(Long.parseLong(v))
			if (k == 'rolle') paro.rolle = v
			if (k == 'objektname') paro.objektname = v
			if (k == 'objektId') paro.objektId = Long.parseLong(v)
		}
		
		if (paro.save())
			render text:'ok'
		else {
			paro.errors.each {
			println it
			}
			render text:'Speicherfehler'
		}
	}
		
}
