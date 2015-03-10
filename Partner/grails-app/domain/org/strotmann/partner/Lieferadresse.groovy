package org.strotmann.partner

import java.util.List;

class Lieferadresse extends Adresse {

	String strasse
	Integer hausnummer
	String zusatz
	String anfahrt
	
	static belongsTo = [partner:Partner]
    
	static constraints = {
		strasse (nullable:true) //Unterschied zu Verwendung in Hausadresse
		hausnummer (nullable:true) // "
		zusatz (nullable:true) // "
		postleitzahl ()
		ort ()
		land (nullable:true)
		anfahrt (nullable:true)
		phOrt(nullable:true)
    }
	
	String toString() {
		"${strasse?:''},${hausnummer?:''},${postleitzahl?:''},${ort?:''},${zusatz?:''},${anfahrt?:''}"
	}
	
}
