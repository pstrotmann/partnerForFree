package org.strotmann.mail

import com.twilio.sdk.TwilioRestClient
import com.twilio.sdk.TwilioRestException
import com.twilio.sdk.resource.factory.MessageFactory
import com.twilio.sdk.resource.instance.Message

import org.apache.http.NameValuePair
import org.apache.http.message.BasicNameValuePair

import grails.util.Holders

class Sms {

    String inhalt
	long sender
	long empfaenger
	Date datum
	
	static constraints = {
		inhalt()
		sender()
		empfaenger()
		datum()
    }
	
	String toString() {"${empfaenger},${inhalt}" }
	
	int sendSms() throws TwilioRestException {
		
		try {
			TwilioRestClient client = new TwilioRestClient(Holders.config.ACCOUNT_SID, Holders.config.AUTH_TOKEN)
	 
			// Build a filter for the MessageList
			List<NameValuePair> params = new ArrayList<NameValuePair>()
			params.add(new BasicNameValuePair("Body", inhalt))
			params.add(new BasicNameValuePair("To", "+${empfaenger.toString()}"))
			params.add(new BasicNameValuePair("From", Holders.config.From))
	 
			MessageFactory messageFactory = client.getAccount().getMessageFactory()
			Message message = messageFactory.create(params)
			return 0
		} catch (TwilioRestException e) {
			println(e.getErrorMessage())
			return -1
		}
	}
	
	String getEmpfaengerAufb() {
		
		String s = empfaenger.toString()
		if(s.length() < 5)
			''
		else
			"0${s.substring(0,2)}-0${s.substring(2,5)}-${s.substring(5)}"
	}
}
