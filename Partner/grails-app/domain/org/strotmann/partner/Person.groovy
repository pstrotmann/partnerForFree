package org.strotmann.partner

import java.util.List;
import grails.util.Holders

class Person extends Partner {
	
	String titel = ''
	String vorname = ''
	String geschlecht
	Date geburtsdatum
	Land nationalitaet
	boolean persoenlicheAnrede
	String phVorname
	String religion
	Branche beruf
	Branche taetigkeit
	
    static constraints = {
		titel(size:3..20,matches:"[a-zA-Z\\. ]+",nullable:true)
		vorname (size:1..30,matches:"[a-zäöüßA-ZÄÖÜ\\- .]+",nullable:true)
		name(blank:false,size:1..30,matches:"[a-zäöüßA-ZÄÖÜ\\- .]+",
			//unique:['vorname','geschlecht','geburtsdatum'],
			validator:
			{String name, Person p ->
				def existingPersons = Person.withCriteria {
						eq ("name",p.name) &&
						eq ("geschlecht",p.geschlecht)
					}
				def List dups = []
				existingPersons.each {Person person ->
					if (person.vorname == p.vorname &&
						person.geburtsdatum == p.geburtsdatum &&
						!(p.id && person.id == p.id)
						)
					dups << person
				}
				if(dups.size() > 0)
					return ['not.unique.message']
				else
					return true
			}
			)
		geschlecht (inList:["m", "f"])
		geburtsdatum (nullable:true)
		nationalitaet(nullable:true)
		persoenlicheAnrede(nullable:true)
		hausadresse (nullable:true)
		phVorname (nullable:true)
		religion (inList:religionen,nullable:true)
		beruf (nullable:true)
		taetigkeit (nullable:true)
    }
	
	String toString() {"${geschlecht == 'm'?'Herr':'Frau'} ${titel?titel:''} ${vorname?vorname:''} ${this.name} "}
	
	static List getPersonList () {
		Person.findAll("from Person order by name")
	}
	
	static List getPhPersonList () {
		
		List l1 = Person.findAll("from Person as p order by p.hausadresse.postleitzahl, p.phName, p.geschlecht, p.phVorname")
		List l2 = Person.findAll("from Person as p where p.hausadresse = null order by p.phName, p.geschlecht, p.phVorname")
		
		l1+l2
	}
	
	static Person zweiNachEins (Person p1, Person p2, Map c2) {
				
		if(c2.name) {
			p1.name = p2.name
			p1.phName = p2.phName
		}
		if(c2.titel)
			p1.titel = p2.titel
		if(c2.vorname) {
			p1.vorname = p2.vorname
			p1.phVorname = p2.phVorname
		}
		if(c2.geschlecht)
			p1.geschlecht = p2.geschlecht
		if(c2.anrede)
			p1.persoenlicheAnrede = p2.persoenlicheAnrede
		if(c2.geburtsdatum)
			p1.geburtsdatum = p2.geburtsdatum
		if(c2.hausadresse)
			p1.hausadresse = p2.hausadresse
		
		p1
	}
	
	static List getReligionen () {
		Holders.config.religion
	}
	
}
