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
	
	SortedSet emailEmpfaengers
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
		org.apache.commons.mail.Email email = new SimpleEmail()
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
		try {
			email.send()
			return 0
		} catch (Exception e) {
			e.printStackTrace()
			return -1
		}
	}
}
