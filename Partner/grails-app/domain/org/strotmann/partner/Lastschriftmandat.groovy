package org.strotmann.partner

import java.util.List;
import grails.util.Holders

class Lastschriftmandat {
	
	String glaeubigerId
	String mandatsReferenz
	Partner abweichenderSchuldner
	
	static belongsTo = [bankverbindung:Bankverbindung]

    static constraints = {
		glaeubigerId(inList:glaeubigerIds)
		mandatsReferenz()
		abweichenderSchuldner(nullable : true)
    }
	
	static List getGlaeubigerIds () {
		Holders.config.glaeubigerId
	}
}
