package org.strotmann.partner

class Adresse {
	
	int postleitzahl
	String ort
	String phOrt
	Land land
	
	static mapping = {
		tablePerHierarchy false
	}
	//nur für Github test
}
