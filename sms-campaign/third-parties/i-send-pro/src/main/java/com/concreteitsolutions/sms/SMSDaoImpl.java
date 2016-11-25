package com.concreteitsolutions.sms;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.concreteitsolutions.sms.model.sms.MultipleSMS;
import com.concreteitsolutions.sms.model.sms.SMSResponse;
import com.concreteitsolutions.sms.model.sms.SingleSMS;

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

			ResponseEntity<SMSResponse> smsResponse = iSendProClient.exchange(singleSMSRequest, SMSResponse.class);

			System.out.println("Sms response : " + smsResponse.toString());

		} catch (URISyntaxException e) {
			e.printStackTrace();
		}
	}

	public void sendMultiple(final List<String> phoneNumberList, final String smsContent, final String sender) {
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

}
