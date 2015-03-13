package org.strotmann.mail

import java.util.SortedSet;

import org.apache.commons.mail.*
import org.strotmann.partner.Partner

import grails.util.Holders

class Email {
	
	String sender
	String emailBetreff
	String emailText
	Boolean gesendet
	Date sendedatum
	
	static hasMany = [emailEmpfaengers:EmailEmpfaenger,
					  anhaenge:EmailAnhang]
	
    static constraints = {
		sender (email: true)
		emailBetreff()
		emailText()
		gesendet (nullable:true)
		sendedatum (nullable:true)
	}
	
	String toString() {"${this.emailBetreff}" }
	
	int sendMail() {
		org.apache.commons.mail.MultiPartEmail email = new MultiPartEmail()
		email.setHostName(Holders.config.smtpServer)
		email.setSmtpPort(new Integer(Holders.config.smtpPort))
		email.setAuthenticator(new DefaultAuthenticator(Holders.config.mailUser, Holders.config.mailPasswort))
		email.setSSLOnConnect(true)
		email.setFrom(Holders.config.mailFrom)
		email.setSubject(emailBetreff)
		email.setMsg(emailText)
		
		emailEmpfaengers.each {EmailEmpfaenger it ->
			email.addTo(it.emailAdresse)
		}
		
		anhaenge.each {EmailAnhang it ->
			EmailAttachment attachment = new EmailAttachment();
			attachment.setPath(it.dateiname);
			attachment.setDisposition(EmailAttachment.ATTACHMENT);
			//attachment.setDescription("Länder mit int KfzKz");
			//attachment.setName("Land");
			email.attach(attachment)
		}
		try {
			email.send()
			return 0
		} catch (Exception e) {
			e.printStackTrace()
			return -1
		}
	}
}
