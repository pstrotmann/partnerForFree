package org.strotmann.partner

class Land {

    String kfzKz
	String name
	
	static constraints = {
		kfzKz(unique:true)
		name()
    }
	
	String toString() {"${kfzKz} ${name}"}
		
}
