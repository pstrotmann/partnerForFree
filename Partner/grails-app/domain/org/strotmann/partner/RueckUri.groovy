package org.strotmann.partner

class RueckUri {

    String anwendung
	String uri
	
	static constraints = {
		anwendung()
		uri()
    }
	
	static String getUri(String anwendung) {
		RueckUri rueckUri = RueckUri.find ("from RueckUri as rue where rue.anwendung = '${anwendung}'")
		rueckUri.uri
    }
}
