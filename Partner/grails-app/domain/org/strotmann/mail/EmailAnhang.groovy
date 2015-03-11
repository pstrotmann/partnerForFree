package org.strotmann.mail

class EmailAnhang {

	File datei
	
	static belongsTo = [eMail:Email]
	
    static constraints = {
		datei()
	}
	
	String toString() {"${this.datei?.name}" }
}
