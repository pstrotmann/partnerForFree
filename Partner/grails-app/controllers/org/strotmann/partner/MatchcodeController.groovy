package org.strotmann.partner

import org.springframework.dao.DataIntegrityViolationException
import org.strotmann.partner.Matchcode;

class MatchcodeController {

    static allowedMethods = [save: "POST", update: "POST", delete: "POST"]

    def index() {
		redirect(action: "create", params: params)
    }

    def list(Integer max) {
		def matchcodeInstanceList
		if (params.create == 'harter Matchcode' )
			matchcodeInstanceList = Matchcode.getMatches(params)
		else
			//phonetischer Matchcode
			matchcodeInstanceList = Matchcode.getPhMatches(params)
		params.max = Math.min(max ?: 10, 100)
		[matchcodeInstanceList: matchcodeInstanceList, matchcodeInstanceTotal: Matchcode.count()]
    }
	
	def create() {
		[matchcodeInstance: new Matchcode(params)]		
    }
}
