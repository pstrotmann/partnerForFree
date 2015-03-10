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
		
}
