package org.strotmann.partner

import java.text.SimpleDateFormat
import java.util.List;
import org.strotmann.notiz.Notiz
import grails.util.Holders

class Lastschriftmandat {
	
	Organisation glaeubiger
	int mandatTyp
	String mandatsReferenz
	Bankverbindung bankverbindung
	Date gueltigAb
	Date gueltigBis
	Partner abweichenderSchuldner
	Integer vorankuendigungsfrist 
		
	String toString() {glaeubiger?"${glaeubiger.glaeubigerId} ${mandatsReferenz}":""}
	
	static belongsTo = [schuldner:Partner]

    static constraints = {
		glaeubiger()
		mandatTyp (inList: mandatTypNum)
		mandatsReferenz(unique: ['schuldner'])
		bankverbindung(nullable : true)
		gueltigAb(nullable : true)
		gueltigBis(nullable : true)
		abweichenderSchuldner(nullable : true)
		vorankuendigungsfrist(nullable : true, matches:"[0-9]+")
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
	
	String dateKlar(Date d) {
		SimpleDateFormat df = new SimpleDateFormat("dd.MM.yyyy")
		df.format(d)
	}
	
	Boolean getBasis() {
		Person.get(schuldner.id)?true:false
	}
	
	Boolean getFirma() {
		Organisation.get(schuldner.id)?true:false
	}
	
	Partner getDebitor() {
		abweichenderSchuldner?abweichenderSchuldner:schuldner
	}
	
	void erinnerungVorankuendigung() {
		Notiz n = new Notiz()
		n.anlagetermin = new Date()
		use (groovy.time.TimeCategory) {
			n.wiedervorlagetermin = gueltigAb - vorankuendigungsfrist.days
		}
		n.notiztext = "Abbuchung spätestens am ${dateKlar(n.wiedervorlagetermin)} ankündigen"
		n.referenz = "lastschriftmandat.id:${id} ${this.toString()}"
		n.save(flush:true)
	}
}
