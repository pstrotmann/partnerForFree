package org.strotmann.partner

import java.util.List;

class Branche {
 
	//naceKode = Nomenclature activités Communauté européenne
	
	String kode
	String bezeichnung
	
	static constraints = {
		kode(unique:true)
		bezeichnung()
    }
	
	String toString() {"${kode} ${bezeichnung}"}
	
	static List branchenKurz (int le) {
		List <Branche> bList = []
		Branche.findAll("from Branche as b order by b.kode").each {Branche it ->
			int l = [le,it.bezeichnung.length()].min()
			it.bezeichnung = it.bezeichnung.substring(0,l)
			bList << it
		}
		bList
	}
}
