package org.strotmann.partner

import java.text.SimpleDateFormat
import java.util.List;

import grails.util.Holders

class Lastschriftmandat {
	
	Organisation glaeubiger
	int mandatTyp
	String mandatsReferenz
	Date gueltigAb
	Date gueltigBis
	Partner abweichenderSchuldner
	
	String toString() {glaeubiger?"${glaeubiger.glaeubigerId} ${mandatsReferenz}":""}
	
	static belongsTo = [bankverbindung:Bankverbindung]

    static constraints = {
		glaeubiger()
		mandatTyp (inList: mandatTypNum)
		mandatsReferenz(unique: ['bankverbindung', 'glaeubiger', 'gueltigAb'])
		gueltigAb()
		gueltigBis(nullable : true)
		abweichenderSchuldner(nullable : true)
    }
	
	static List getMandatTypNum() {
		List mTypen = []
		Holders.config.mandatTyp.each {
			mTypen << it.key
			}
		mTypen
	}
	
	String getMandatTypKlar() {
		grails.util.Holders.config.mandatTyp [mandatTyp]
	}
	
	String getGueltigAbKlar() {
		SimpleDateFormat df = new SimpleDateFormat("dd.MM.yyyy")
		df.format(gueltigAb)
	}
	
	Boolean getBasis() {
		!(bankverbindung.partner instanceof Organisation)
	}
	
	Boolean getFirma() {
		bankverbindung.partner instanceof Organisation
	}
	
	Partner getSchuldner() {
		abweichenderSchuldner?abweichenderSchuldner:bankverbindung.partner
	}
}
