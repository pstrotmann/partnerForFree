package org.strotmann.partner

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.sql.Timestamp;

class Historie {

	//Historisierung feldweise
	String userName
	Date gueAb
	
	String domainName
	long domainId
	
	String feldName
	
	String stringInhalt
	char charInhalt
	int intInhalt
	long longInhalt
	Date dateInhalt
	boolean booleanInhalt
	
    static constraints = {
		userName()
		gueAb()
		domainName()
		domainId()
		feldName(nullable:true)
		stringInhalt(nullable:true)
		charInhalt(nullable:true)
		intInhalt(nullable:true)
		longInhalt(nullable:true)
		dateInhalt(nullable:true)
		booleanInhalt(nullable:true)
    }
	
	String getFeldinhalt() {
		if (feldName == null) return null
		String fInhalt = null
		if (stringInhalt) fInhalt = stringInhalt
		if (charInhalt) fInhalt = charInhalt
		if (intInhalt > 0) fInhalt = intInhalt
		if (longInhalt > 0) fInhalt = longInhalt
		if (dateInhalt){
			 fInhalt = dateInhalt.getDateString()
		}
		if (fInhalt == null) fInhalt = booleanInhalt
		if (fInhalt == 'false') fInhalt = ' '
		fInhalt
	}
	
	Date getGueBis () {
		Date rDate
		if (feldName == null)
			if (getGeloescht(domainId, domainName))
				return gueAb
			else
				return null
		List <Historie> hList = []
		Historie headHisto = null
		hList = Historie.findAllByDomainNameAndDomainIdAndFeldNameAndGueAbGreaterThan(domainName,domainId,feldName,new Timestamp(gueAb.time))
		if (hList.empty) {
			headHisto = Historie.findByDomainNameAndDomainIdAndFeldName(domainName,domainId,null)
			rDate = headHisto.gueAb
			}
		else
			rDate = hList[0].gueAb
		Calendar calendar = Calendar.getInstance()
		calendar.setTime(rDate)
		calendar.add(Calendar.SECOND, -1)
		calendar.getTime()
	}
	
	static Boolean getGeloescht (Long domainId, String domainName) {
		def grailsApplication = new Person().domainClass.grailsApplication
		Class clazz = grailsApplication.domainClasses.find { it.clazz.simpleName == domainName }.clazz
		if (!clazz.get(domainId))
			return true
		
		false
	}
	
	static Date createDate (String domainName, Long domainId) {
		List <Historie> hList = Historie.findAllByDomainNameAndDomainId(domainName,domainId).sort{it.gueAb}
		hList[0].gueAb
	}
	
	static Boolean firstUpdate (String domainName, Long domainId, String feldName) {
		List <Historie> hList = Historie.findAllByDomainNameAndDomainIdAndFeldName(domainName,domainId,feldName)
		if (hList == null || hList.empty)
			return true
		else
			return false
	}
	
	static Historie createHistorie/*sierung*/ (String user, Object o) {
		Historie h = new Historie()
		h.userName = user
		h.gueAb = new Date()
		List namTeile = o.getClass().name.split('\\.')
		h.domainName = namTeile.last()
		h.domainId = o.id
		h
	}
	
	static List <Historie> updateHistorie/*sierung*/ (String user, Object alt, Object neu) {
		def hList = []
		List namTeile = alt.getClass().name.split('\\.')
		String altDomName = namTeile.last()
		Historie headHisto =
		Historie.findByDomainIdAndDomainNameAndFeldNameIsNull(alt.id,altDomName)
		Date headGueAb = null
		 alt.properties.each {item ->
			if (item.value instanceof String
			 || item.value instanceof Integer
			 || item.value instanceof Long
			 || item.value instanceof Character
			 || item.value instanceof Boolean
			 || item.value instanceof Timestamp
			 || item.value == null
			 	)  
				if (abweichungNeu(neu, item)) {
					Historie h = new Historie()
					h.userName = user
					if (item.key.endsWith('Id'))
						h.feldName = item.key.substring(0, item.key.length() - 2)
					else
						h.feldName = item.key
					if (firstUpdate(altDomName,alt.id,h.feldName))
						h.gueAb = createDate(altDomName,alt.id)
					else
						h.gueAb = headHisto.gueAb
					h.domainName = altDomName 
					h.domainId = alt.id
					
					if (item.value instanceof String) 
						h.stringInhalt = item.value
					if (item.value instanceof Integer)
						h.intInhalt = item.value
					if (item.value instanceof Long)
						h.longInhalt = item.value
					if (item.value instanceof Character)
						h.charInhalt = item.value
					if (item.value instanceof Boolean)
						h.booleanInhalt = item.value
					if (item.value instanceof Timestamp)
						h.dateInhalt = item.value
					hList << h
					if (!headGueAb)
						headGueAb = new Date()
				}
		}
		 if (headGueAb)
		 	headHisto.gueAb = headGueAb
		hList << headHisto
		hList
	}
	
	static List <Historie> zweiNachEinsHistorie/*sierung*/ (String user, Object neu, Object alt, Map c2) {
		
		List hList = []
		Historie h
		List namTeile = alt.getClass().name.split('\\.')
		String domName = namTeile.last()
		Historie headHisto =
		Historie.findByDomainIdAndDomainNameAndFeldNameIsNull(neu.id,domName)
		Date hGueAb = headHisto.gueAb
		headHisto.gueAb = new Date()
		hList << headHisto
				
		c2.each {entry ->
			if (entry.value) {
				h = new Historie()
				h.userName = user
				h.domainId = neu.id
				h.domainName = domName
				h.feldName = entry.key
				
				if (neu.properties[entry.key] instanceof String)
					h.stringInhalt = neu.properties[entry.key]
				if (neu.properties[entry.key] instanceof Character)
					h.charInhalt = neu.properties[entry.key]
				if (neu.properties[entry.key] instanceof Timestamp || neu.properties[entry.key] instanceof Date)
					h.dateInhalt = neu.properties[entry.key]
				if (neu.properties[entry.key] instanceof Integer)
					h.intInhalt = neu.properties[entry.key]
				if (neu.properties[entry.key] instanceof Long)
					h.longInhalt = neu.properties[entry.key]
				if (neu.properties[entry.key] instanceof Boolean)
					h.booleanInhalt = neu.properties[entry.key]
					
				if (firstUpdate(domName,alt.id,h.feldName))
					h.gueAb = createDate(domName,alt.id)
				else
					h.gueAb = headHisto.gueAb
				hList << h
			}
		}
		
		//Verweis Neu auf Alt 
		h = new Historie()
		h.userName = user
		h.domainId = neu.id
		h.domainName = domName
		h.gueAb = hGueAb
		h.feldName = 'altDomain'
		h.longInhalt = alt.id
		hList << h
		
		//Verweis Alt auf neu
		h = new Historie()
		h.userName = user
		h.domainId = alt.id
		h.domainName = domName
		h.gueAb = hGueAb
		h.feldName = 'neuDomain'
		h.longInhalt = neu.id
		hList << h
		
		hList
	}
	
	static Boolean abweichungNeu (Object neu, Object item) {
		if (neu == null)
			return true
		if (neu.properties[item.key] == null && item.value instanceof Long) {
			String itemKey
			if (item.key.endsWith('Id')) {
				itemKey = item.key.substring(0, item.key.length() - 2)
				if (oneNull(neu.properties[itemKey], item.value))
					return true
				if (neu.properties[itemKey].id == item.value)
					return false
				else
					return true
			}
		}
		if (oneNull(neu.properties[item.key], item.value))
			return true
		
		if (neu.properties[item.key] !=  item.value ) 
			return true
		
		false
	}
	
	static boolean oneNull(Object o1, Object o2) {
		if (o1 && !o2 || !o1 && o2)
		   return true
		else
			return false		
	}
	
	static List <Historie> domList (String domainName, String domainId) {
		List hList = Historie.findAllByDomainNameAndDomainId(domainName,new Long(domainId)).sort{it.gueAb}
		hList.reverse(true)
	}
	
	static List <Historie> loeList (String domainName) {
		List <Historie> loeList = []
		List <Historie> l = Historie.findAllByDomainNameAndFeldNameIsNull(domainName)
		l.each { 
			if (it.getGeloescht(it.domainId, it.domainName)) {
				String s = feldinhalte(domainName, it.domainId)
				it.feldName = s.split('___')[0]
				it.stringInhalt = s.split('___')[1] 
				loeList << it
			}
		}
		loeList
	}
	
	static String feldinhalte (String domainName, Long domainId) {
		String inhalte = ''
		String namen = ''
		Date lastGueBis
		List <Historie> l = Historie.findAllByDomainNameAndDomainIdAndFeldNameIsNotNull(domainName,domainId)
		List <Historie> lSort = l.sort{it.gueAb}
		if (!lSort.empty)
			lastGueBis = lSort.last().gueBis
		List <Historie> lLast = []
		lSort.each {
			if (it.gueBis == lastGueBis)
				lLast << it
		}
		lLast.each {
			String t = ''
			if (it.feldinhalt != 'false' && !it.feldName.startsWith('ph')) {
				if (inhalte.length() == 0)
					t = ''
				else
					t = ', '
				
			inhalte = inhalte +t+ it.feldinhalt
			namen = namen +t+ it.feldName
				
			}
		}
		namen+'___'+inhalte
	}
}
