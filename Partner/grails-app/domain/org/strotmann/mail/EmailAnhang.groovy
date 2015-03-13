package org.strotmann.mail

class EmailAnhang {

	String dateiname
	
	static belongsTo = [eMail:Email]
	
    static constraints = {
		dateiname()
	}
	
	String toString() {"${this.dateiname}" }
}
