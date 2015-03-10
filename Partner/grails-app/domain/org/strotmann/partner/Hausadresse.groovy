package org.strotmann.partner

class Hausadresse extends Adresse implements Comparable {
	
	String strasse
	int hausnummer
	String zusatz 
	String phStrasse
	
    static constraints = {
		strasse (blank:false,size:3..50,matches:"[a-zäöüßA-ZÄÖÜ\\- .0-9]+")
		hausnummer (min:1, max:1000)
		zusatz (size:1..10,nullable:true)
		postleitzahl (min:1000, max:99999,
			//unique:['strasse','hausnummer','zusatz']
			validator:
			{int postleitzahl, Hausadresse h ->
				def existingHausadressen = Hausadresse.withCriteria {
						eq ("postleitzahl",h.postleitzahl) &&
						eq ("strasse",h.strasse) &&
						eq ("hausnummer",h.hausnummer)
					}
				def List dups = []
				existingHausadressen.each {Hausadresse hAdr ->
					if (hAdr.zusatz == h.zusatz && 
						!(h.id && hAdr.id == h.id)
						)
					dups << hAdr
				}
				if(dups.size() > 0)
					return ['not.unique.message']
				else
					return true
			}
		)
		ort (blank:false,size:3..50,matches:"[a-zäöüßA-ZÄÖÜ\\- .,()/]+")
		phStrasse(nullable:true)
		phOrt(nullable:true)
		land (nullable:true)
    }
	
	String toString() {"${this.strasse}  ${this.hausnummer} ${this.zusatz?zusatz:''}, ${this.postleitzahl}  ${this.ort}" }
	
	int compareTo(obj) {
		postleitzahl+strasse.compareTo(obj.postleitzahl+obj.strasse)		
	}
	
	static List getMiniList () {
		return(Hausadresse.findAll("from Hausadresse as h order by h.postleitzahl, h.strasse"))
	}
	
	static String strHnr(String str, String hnr) {
		str = umlEntfernen (str)
		str+hnr
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
	
	List <Partner> getBewohner () {
		return(Partner.findAll("from Partner as p where p.hausadresse.id = ${this.id} order by p.name"))
	}
}
