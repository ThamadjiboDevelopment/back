package com.concreteitsolutions.sms;

import org.springframework.stereotype.Component;

@Component
public class SMSControllerImpl {

	public String sendSms(String content) {
		System.out.println("Sending smscampaign having content : " + content);
		return "smscampaign sent";
	}

	public String sendSms() {
		return null;
	}
}
