package com.concreteitsolutions.sms;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.concurrent.SynchronousQueue;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import com.concreteitsolutions.sms.model.MultipleSMS;
import com.concreteitsolutions.sms.model.SMSResponse;
import com.concreteitsolutions.sms.model.SingleSMS;

@Component
public class SMSDaoImpl implements SMSDao {

	private RestTemplate iSendProClient;

	private static final String KEY_ID = "8129be2a2bd7e774a9604b1c0e591df5";

	private static final String HOST = "https://apirest.isendpro.com/cgi-bin";

	private static final String SINGLE_SMS_PATH = "/sms";

	private static final String MULTIPLE_SMS_PATH = "/smsmulti";

	// To place in IsendProTestFactory class
	public static final String MOCK_URL = "http://demo8280665.mockable.io";

	@Autowired
	public SMSDaoImpl(RestTemplate iSendProClient) {
		this.iSendProClient = iSendProClient;
	}

	public void sendOne(final String telNumber, final String smsContent, final String sender) {

		SingleSMS singleSms = new SingleSMS(KEY_ID, smsContent, telNumber, sender);

		try {
			RequestEntity<SingleSMS> singleSMSRequest = RequestEntity.post(new URI(HOST + SINGLE_SMS_PATH))
					.contentType(MediaType.APPLICATION_JSON).body(singleSms);

			ResponseEntity<SMSResponse> smsResponseResponseEntity = iSendProClient.exchange(singleSMSRequest, SMSResponse.class);
	//		ResponseEntity<String> smsResponseResponseEntity = iSendProClient.exchange(singleSMSRequest, String.class);

			System.out.println("Sms response : " + smsResponseResponseEntity.toString());

		} catch (URISyntaxException e) {
			e.printStackTrace();
		} catch(HttpClientErrorException e) {
			System.out.println("erreur requete");
			System.out.println(e.getResponseBodyAsString());
			SMSResponse smsResponseError = null;
			try {
				smsResponseError = retrieveSMSResponseErrorFromJson(e.getResponseBodyAsString());
				throw new SMSCoreFunctionalException("");
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}
	}

	public void sendMultiple(final List<String> phoneNumberList, final String smsContent, final String sender) {
		System.out.println("Sending multiple sms");
		MultipleSMS multipleSMS = new MultipleSMS(KEY_ID, phoneNumberList, smsContent, sender);

		try {
			RequestEntity<MultipleSMS> multipleSMSRequest = RequestEntity.post(new URI(HOST + MULTIPLE_SMS_PATH))
					.contentType(MediaType.APPLICATION_JSON).body(multipleSMS);

			ResponseEntity<SMSResponse> smsResponse = iSendProClient.exchange(multipleSMSRequest, SMSResponse.class);

			System.out.println("Sms response : " + smsResponse.toString());

		} catch (URISyntaxException e) {
			e.printStackTrace();
		}
	}

	private SMSResponse retrieveSMSResponseErrorFromJson(String smsResponseString) throws IOException {
		ObjectMapper objectMapper = new ObjectMapper();
		SMSResponse smsResponse = new SMSResponse();

		smsResponse = objectMapper.readValue(smsResponseString, SMSResponse.class);

		System.out.println("Deserializing .. :"+smsResponse);
		return smsResponse;
	}
}
