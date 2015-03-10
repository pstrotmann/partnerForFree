package org.strotmann.notiz

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.strotmann.partner.Organisation;
import org.strotmann.partner.Person;

import grails.util.Holders
import grails.plugins.rest.client.*

class Notiz {

	Date anlagetermin
	Date wiedervorlagetermin
	String notiztext
	String referenz
		
	static constraints = {
    }
	
	String toString() {"${this.notiztext}"}
	
	long getRefId() {
		referenz.split(":")[1].split(" ")[0].toLong()
	}
	
	String getRefDomain() {
		referenz.split("\\.")[0].toUpperCase()
	}
	
	boolean refDomIs (String domName) {
		referenz.split("\\.")[0].toUpperCase() == domName.toUpperCase()
	}
	
	static List getMatches(Map params) { 
		params.notiztext = '%'+params.notiztext+'%'
		params.referenz = params.referenz+'%'
		String anlOp = params.notizInstance.anlOp
		String wvOp = params.notizInstance.wvOp
		Date wiedervorlage = params.wiedervorlagetermin
		Date anlage = params.anlagetermin
		def opMap = [ '<': 'lt', '<=': 'lte', '=': 'eq', '>': 'gt', '>=': 'gte' ]
		def c = Notiz.createCriteria()
		c.list {
			if (anlOp in opMap.keySet())
				"${opMap[anlOp]}"("anlagetermin", anlage)
			ilike("notiztext", params.notiztext)
			ilike("referenz", params.referenz)
			if (wvOp in opMap.keySet())
				"${opMap[wvOp]}"("wiedervorlagetermin", wiedervorlage)
		}
	}
	
	static List getRefs(String domName) {
		List refList = []
		List l
		if (domName && domName != ' ') {
			switch(domName){
				case "Organisation" : l = Organisation.findAll("from Organisation as x order by x.name") ; break
				case "Person" : l = Person.findAll("from Person as x order by x.name") ; break
			}
			l.each {item -> refList << "${domName}.id:${item.id} ${item.toString()}"}
		}
		else {
			l = Organisation.findAll("from Organisation as o order by o.name")
			l.each {item -> refList << "Organisation.id:${item.id} ${item.toString()}"}
			l = Person.findAll("from Person as p order by p.name")
			l.each {item -> refList << "Person.id:${item.id} ${item.toString()}"}
			
		}
		refList
	}
	
	static List getDomNamen () {
		grails.util.Holders.config.domname
	}
	
	static List <Notiz> getNotizen (String domName, Object id) {
		if (id == null)
			return []
		String r = "${domName}.id:${id.toString()}%"
		def c = Notiz.createCriteria()
		c.list {
			ilike("referenz",  "${r}")
		}
	}
}
