package org.strotmann.partner

import java.util.List;
import java.util.Map;
import java.util.Properties;
import grails.util.Holders

class Organisation extends Partner {
	
	String nameZusatz 
	String rechtsform 
	Branche branche 
		
	static constraints = {
		name(blank:false,size:1..80,matches:"[a-zäöüßA-ZÄÖÜ0-9\\- .&,()/+]+",
			//unique:['nameZusatz','rechtsform']
			validator:
			{String name, Organisation o ->
				def existingOrganisations = Organisation.withCriteria {
						eq ("name",o.name)
					}
				def List dups = []
				existingOrganisations.each {Organisation org ->
					if (org.nameZusatz == o.nameZusatz &&
						org.rechtsform == o.rechtsform &&
						!(o.id && org.id == o.id)
						)
					dups << org
				}
				if(dups.size() > 0)
					return ['not.unique.message']
				else
					return true
			}
			)
		nameZusatz (size:1..50,matches:"[a-zäöüßA-ZÄÖÜ0-9\\- .&,()+]+",nullable:true)
		rechtsform (inList:rechtsformen,nullable:true)
		branche (nullable:true)
		hausadresse (nullable:true)
    }
	
	static List getMiniList () {
		Organisation.findAll("from Organisation as o order by o.name")
	}
		
	static List getPhOrganisationList () {
		
		List l1 = Organisation.findAll("from Organisation as o order by o.hausadresse.postleitzahl, o.phName")
		List l2 = Organisation.findAll("from Organisation as o where o.hausadresse = null order by o.phName")
		
		l1+l2
	}
	
	static List getRechnungssteller () {
		return(Organisation.findAll("from Organisation as o"+
									" where not o.rechtsform = 'Personengemeinschaft'"+
									" and exists (from Partnerrolle as paro where paro.rolle = 'Rechnungssteller' and paro.partner =o.id)"+
									" order by o.name"
			))
	}
	
	
	List <Object> getRollenobjekte () {
		List l = []
		def grailsApplication = new Partnerrolle().domainClass.grailsApplication
		Partnerrolle.rollenZuObjekt(this).each {Partnerrolle item ->
			Class clazz = grailsApplication.domainClasses.find { it.clazz.simpleName == item.objektname }.clazz
			l << clazz.get(item.objektId)
		} 
		l
	}
	
	static List getRechtsformen () {
		Holders.config.rechtsform
	}
	
	static Organisation zweiNachEins (Organisation o1, Organisation o2, Map c2) {
		if(c2.name) {
			o1.name = o2.name
			o1.phName = o2.phName
		}
		if(c2.nameZusatz)
			o1.nameZusatz = o2.nameZusatz
		if(c2.rechtsform)
			o1.rechtsform = o2.rechtsform
		if(c2.hausadresse)
			o1.hausadresse = o2.hausadresse
		o1
	}
	
}
