package org.strotmann.benutzer

class Benutzer {
	
	String name
	String passwort
	String sprache

    static constraints = {
		name(unique:true)
		passwort()
		sprache(inList:["de", "en"])
    }
}
