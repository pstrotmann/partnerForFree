package org.strotmann.partner

import java.util.List;

import grails.util.Holders

class Partnerrolle implements Comparable {
	
	String rolle
	String objektname
	long objektId
	
	static belongsTo = [partner:Partner]
	
    static constraints = {
		//rolle(inList:getRollen(), unique: ['id','objektname', 'objektId'])
		//objektname (inList:getObjektnamen())
		rolle(unique: ['objektname', 'objektId','partner'])
		objektname ()
		
    }
	
	int compareTo(obj) {
		String c = rolle+objektname+objektId
		String oc = obj.rolle+obj.objektname+obj.objektId
		c.compareTo(oc)
	}
	
	String toString() {
		return 	"${this.rolle}:${getRollenwert(this.rolle)} ${objekt}"
	}
	
	String getBeschreibung(){
		rolle+','+objektname+','+objektId
	}
	
	Person getPerson () {
		def p
		try {
			p = Person.get(this.partner.id)
		} catch (Exception e) {	}
		return (p?:null)
	}
	
	static List getRollen () {		
		List rList = []		
		Holders.config.pRolle.each {rList << it.key}
		Holders.config.oRolle.each {rList << it.key}
		rList.unique()		
	}
	
	static List getObjektnamen () {
		List rList = []
		Holders.config.pRolle.each {rList << it.value}
		Holders.config.oRolle.each {rList << it.value}
		rList.unique()	
	}
	
	static List rollenZuObjektname (String pArt) {
		List rList = []
		if (pArt == 'p')
			Holders.config.pRolle.each {rList << it.key+' zu '+it.value}
		else //pArt == 'o'
			Holders.config.oRolle.each {rList << it.key+' zu '+it.value}
		rList
	}
	 
	String getRollenwert (String r) {
		if (partner instanceof Person)
			Holders.config.pRolle[r]
		else //Organisation	
			Holders.config.oRolle[r]
	}
	
	Object getObjekt() {
		def grailsApplication = new Partnerrolle().domainClass.grailsApplication
		Class clazz = grailsApplication.domainClasses.find { it.clazz.simpleName == this.objektname }.clazz
		clazz.get(objektId)		
	}
	
	static /*<Partnerrolle>*/ List rollenZuObjekt (Object objekt) {
		String objektname = objekt.getClass().getSimpleName()
		Long objektId = objekt.id
		Partnerrolle.findAll("from Partnerrolle as p where '${objektname}' = p.objektname and ${objektId} = p.objektId order by p.rolle")
	}
	
	static List <Object> getRollenobjekte (Object objekt) {
		List l = []
		def grailsApplication = new Partnerrolle().domainClass.grailsApplication
		Partnerrolle.rollenZuObjekt(objekt).each {Partnerrolle item ->
			Class clazz = grailsApplication.domainClasses.find { it.clazz.simpleName == item.objektname }.clazz
			l << clazz.get(item.objektId)
		}
		l
	}
	
	//lesen der Partnerrolle ohne id zu kennen
	static Partnerrolle getPartnerrolle (Partnerrolle paro) {
		Partnerrolle p =
		Partnerrolle.find ("from Partnerrolle as p where p.rolle = '${paro.rolle}' and p.objektname = '${paro.objektname}' and p.objektId = ${paro.objektId} and p.partner.id = ${paro.partner.id}")
		if (p)
			return p
		else
			return paro
	}
	
}
