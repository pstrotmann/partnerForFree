package org.strotmann.mail

import org.strotmann.partner.Partner;

class EmailEmpfaenger  {
	
	String emailAdresse
	Partner partner
	static belongsTo = [eMail:Email]

    static constraints = {
		emailAdresse (email: true)
		partner(nullable:true)
    }
	
	String toString() {"${partner?partner.toString()+',':''}${emailAdresse}" }
	
}
