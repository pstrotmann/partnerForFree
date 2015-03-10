package org.strotmann.partner;

import com.twilio.sdk.TwilioRestClient;
import com.twilio.sdk.TwilioRestException;
import com.twilio.sdk.resource.factory.MessageFactory;
import com.twilio.sdk.resource.instance.Message;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;

import java.util.ArrayList;
import java.util.List;
 
public class SendSms {
	/*
	 curl -X POST https://api.twilio.com/2010-04-01/Accounts/ACb35f187884ebf4736dbb42e48bffdeae/SMS/Messages.json \
    -u ACb35f187884ebf4736dbb42e48bffdeae:b9f2a00b6dba352a6874003b62f8d73b \
    --data-urlencode "From=+13304231006" \
    --data-urlencode "To=+4917651621548" \
    --data-urlencode 'Body=test bei Twilio erfolgreich'
	 * */
	 
 
  // Find your Account Sid and Token at twilio.com/user/account
  public static final String ACCOUNT_SID = "ACb35f187884ebf4736dbb42e48bffdeae";
  public static final String AUTH_TOKEN = "b9f2a00b6dba352a6874003b62f8d73b";
 
  public static void main(String[] args) throws TwilioRestException {
    try {
		TwilioRestClient client = new TwilioRestClient(ACCOUNT_SID, AUTH_TOKEN);
 
		// Build a filter for the MessageList
		List<NameValuePair> params = new ArrayList<NameValuePair>();
		params.add(new BasicNameValuePair("Body", "kaum zu glauben, aber klappt"));
		params.add(new BasicNameValuePair("To", "+4917651621548"));
		params.add(new BasicNameValuePair("From", "+13304231006"));
 
		MessageFactory messageFactory = client.getAccount().getMessageFactory();
		Message message = messageFactory.create(params);
		System.out.println(message.getSid());
	} catch (TwilioRestException e) {
		System.out.println(e.getErrorMessage());
		e.printStackTrace();
	}
  }
}
