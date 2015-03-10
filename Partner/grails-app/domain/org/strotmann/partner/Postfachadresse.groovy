package org.strotmann.partner

class Postfachadresse extends Adresse {
	
    int postfach
	
	static belongsTo = [partner:Partner]
    
	static constraints = {
		postfach(nullable:true)
		postleitzahl (min:1000, max:99999,unique:['postfach','partner'])
    	ort (maxLength:30, blank:false)
		phOrt(nullable:true)
		land (nullable:true)
    }
    
    String toString() {
		if (this.postfach > 0)
			return "${this.postfach}  , ${this.postleitzahl}  ${this.ort}"
		else
			return "${this.postleitzahl}  ${this.ort}"
	}
	
	static String ort (String o) {
		umlEntfernen (o)
	}
	
	static String umlEntfernen (String u) {
		Map umlaute = ['ä':'ae','Ä':'Ae','ü':'ue','Ü':'Ue','ö':'oe','Ö':'Oe','ß':'ss',' ':'']
		umlaute.each {key, value ->
			u = u.replace(key, value)
		}
		u
	}
}
