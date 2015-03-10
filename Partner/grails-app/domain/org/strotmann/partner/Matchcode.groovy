package org.strotmann.partner
import org.apache.commons.codec.language.ColognePhonetic

class Matchcode {
	
	String partnerart
	String name
	String geschlecht
	String vorname
	String strasse
	int postleitzahl
	String ort	
			
	static constraints = {
		partnerart(inList:["p", "o"])
		name()
		geschlecht(inList:["m", "w"])
		vorname()
		strasse()
		postleitzahl()
		ort()
	}
	
	//Harter Matchcode 
	static List getMatches(Map params) {
		
		String hName = params.name+'%'
		String hVorname = params.vorname+'%'
		String hStrasse = params.strasse+'%'
		String hOrt = params.ort+'%'
		
		def List loHi = plzLoHi(params.postleitzahl)
		def plzLo = loHi[0]
		def plzHi = loHi[1]
		
		def query
		List <Person> pList = []
		List <Organisation> oList = []
		
		if (params.partnerart == 'p' || params.partnerart == '') {
			//Abfrage Person mit Hausadresse
			query = Person.where
			 {name =~ hName &&
			  geschlecht =~ params.geschlecht+'%' &&
			  (vorname =~ hVorname || vorname == null) &&
			  hausadresse != null &&
			  hausadresse.strasse =~ hStrasse &&
			  (hausadresse.postleitzahl >= plzLo && hausadresse.postleitzahl < plzHi) && 
			  hausadresse.ort =~ hOrt
			 }
			pList = query.findAll()
			
			//Abfrage Person ohne Hausadresse
			query = Person.where
			 {name =~ hName &&
			  (vorname =~ hVorname || vorname == null) &&
			  geschlecht =~ params.geschlecht+'%' &&
			  hausadresse == null
			 }
			pList = pList + query.findAll() 
		}
		
		
		if ((params.partnerart == 'o' || params.partnerart == '') && params.vorname == '' && params.geschlecht =='') {
			//Abfrage Organisation mit Hausadresse
			query = Organisation.where
			 {name =~ hName &&
			  hausadresse != null &&
			  hausadresse.strasse =~ hStrasse &&
			  (hausadresse.postleitzahl >= plzLo && hausadresse.postleitzahl < plzHi) &&
			  hausadresse.ort =~ hOrt
			 }
			oList = query.findAll()
			
			//Abfrage Organisation ohne Hausadresse
			query = Organisation.where
			 {name =~ hName &&
			  hausadresse == null
			 }
			oList = oList + query.findAll()
			}
	
		return mcList(pList,oList).sort{it.name}
	}
	
	//Phonetischer Matchcode
	static List getPhMatches(Map params) {
		
		String pName = koePhone(params.name)+'%'
		String pVorname = koePhone(params.vorname)+'%'
		String pStrasse = koePhone(params.strasse)+'%'
		String pOrt = koePhone(params.ort)+'%'
		
		def List loHi = plzLoHi(params.postleitzahl)
		def plzLo = loHi[0]
		def plzHi = loHi[1]
		
		def query
		List <Person> pList = []
		List <Organisation> oList = []
		
		if (params.partnerart == 'p' || params.partnerart == '') {
			//Abfrage Person mit Hausadresse
			query = Person.where
			 {phName =~ pName &&
			  geschlecht =~ params.geschlecht+'%' &&
			  (phVorname =~ pVorname || vorname == null) &&
			  hausadresse != null &&
			  hausadresse.phStrasse =~ pStrasse &&
			  (hausadresse.postleitzahl >= plzLo && hausadresse.postleitzahl < plzHi) && 
			  hausadresse.phOrt =~ pOrt
			 }
			pList = query.findAll()
			
			//Abfrage Person ohne Hausadresse
			query = Person.where
			 {phName =~ pName &&
			  (phVorname =~ pVorname || vorname == null) &&
			  geschlecht =~ params.geschlecht+'%' &&
			  hausadresse == null
			 }
			pList = pList + query.findAll() 
		}
		
		
		if ((params.partnerart == 'o' || params.partnerart == '') && params.vorname == '' && params.geschlecht =='') {
			//Abfrage Organisation mit Hausadresse
			query = Organisation.where
			 {phName =~ pName &&
			  hausadresse != null &&
			  hausadresse.phStrasse =~ pStrasse &&
			  (hausadresse.postleitzahl >= plzLo && hausadresse.postleitzahl < plzHi) &&
			  hausadresse.phOrt =~ pOrt
			 }
			oList = query.findAll()
			
			//Abfrage Organisation ohne Hausadresse
			query = Organisation.where
			 {phName =~ pName &&
			  hausadresse == null
			 }
			oList = oList + query.findAll()
			}
	
		return mcList(pList,oList).sort{it.name}
	}
	
	static List plzLoHi (String plz) {
		
		def plzLo = 0
		def plzHi = 0
		def int p = 0
		
		if (plz != null)
			p = new Integer(plz)
		if (p==0)
			plz = ""
		plzLo = p * 10 ** (5 - plz.length())
		plzHi = (p + 1) * 10 ** (5 - plz.length())
		
		[plzLo, plzHi]
	}
	
	static List <Matchcode> mcList (List pList, List oList) {
		//Ausgabeliste (mcList) versorgen
		List liste = []
		(pList+oList).each {item ->
			Matchcode mc = new Matchcode()
			mc.id = item.id 
			
			mc.name = item.name
			if (item instanceof Person) {
				mc.partnerart = 'p'
				mc.vorname = item.vorname
				mc.geschlecht = item.geschlecht
				}
			else
				mc.partnerart = 'o'
			if (item.hausadresse != null) {
				mc.strasse = item.hausadresse.strasse+" "+item.hausadresse.hausnummer
				mc.postleitzahl = item.hausadresse.postleitzahl
				mc.ort = item.hausadresse.ort
				}
			else if (item instanceof Organisation && item.postfachadressen != null){
				
				Postfachadresse pAdr = item.postfachadressen[0]
				if (pAdr != null) {
					mc.postleitzahl = pAdr.postleitzahl
					mc.ort = pAdr.ort
				}
				
			}
			
			liste << mc
			}
			
		liste
	}
	
	static String koePhone(String n) {
		ColognePhonetic cPh = new ColognePhonetic()
		cPh.colognePhonetic(n)
	}
}
