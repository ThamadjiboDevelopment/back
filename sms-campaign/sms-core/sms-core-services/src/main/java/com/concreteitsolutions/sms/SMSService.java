package com.concreteitsolutions.sms;

import java.util.List;

public interface SMSService {

	void sendOne(String telNumber, String smsContent);

	void sendMultiple(List<String> telNumberList, String smsContent);
}
