package org.strotmann.partner

import java.util.SortedSet;
import grails.rest.*
@Resource(uri='/partner')

class Partner implements Comparable {
	 
	String name
	String phName 
	
	Hausadresse hausadresse 
	
	SortedSet partnerrollen //ist,spielt Rolle
	static hasMany = [kommunikationen:Kommunikation,
						bankverbindungen:Bankverbindung,
						partnerrollen:Partnerrolle,
						postfachadressen:Postfachadresse,
						lieferadressen:Lieferadresse]
	
	
	static mapping = {
		tablePerHierarchy false 
		kommunikationen lazy:false
		bankverbindungen lazy:false
		postfachadressen lazy:false
		lieferadressen lazy:false
		hausadresse lazy:false
	}
		
	static constraints = {
		name()
		phName(nullable:true)
		hausadresse (nullable:true)
	}
	
	String toString() {"${this.name}" }
	
	int compareTo(obj) {
		name.compareTo(obj.name)
	}
	
	Integer getPostfachNr() {
		postfachadressen.size() > 0 ? postfachadressen[0].postfach:null
	}
	
	String getStrasseHausnummer() {
		hausadresse?"${hausadresse.strasse} ${hausadresse.hausnummer} ${hausadresse.zusatz?hausadresse.zusatz:''}":""
	}
	
	String getPlzOrt() {
		hausadresse?"${hausadresse.postleitzahl} ${hausadresse.ort}":""
	}
	
	String getPostfachPlzOrt() {
		postfachadressen.size() > 0 ? "${postfachadressen[0].postleitzahl} ${postfachadressen[0].ort}":""
	}
	
}
