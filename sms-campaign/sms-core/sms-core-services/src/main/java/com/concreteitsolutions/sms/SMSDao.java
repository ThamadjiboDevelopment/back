package com.concreteitsolutions.sms;

import java.io.IOException;
import java.util.List;

public interface SMSDao {

	void sendOne(final String telNumber, final String smsContent, final String sender) throws IOException;

	void sendMultiple(final List<String> phoneNumberList, final String smsContent, final String sender);

}
