package com.concreteitsolutions.sms;

import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class SMSServiceImpl implements SMSService {

	public void sendMultiple(List<String> telNumberList, String smsMessage) {

	}

	public void sendOne(String telNumber, String smsContent) {

	}
}
