package com.concreteitsolutions.sms.model.sms;

import com.concreteitsolutions.sms.model.SMSStatusCode;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor(access = AccessLevel.PUBLIC, force = true)
@AllArgsConstructor
public class SMSResponseStateContent {

	@JsonProperty(value = "code", required = true)
	private SMSStatusCode statusCode;

	@JsonProperty(value = "tel", required = true)
	private String telNumber;

	@JsonProperty("smslong")
	private String longSMS;

	@JsonProperty("message")
	private String statusCodeDescription;
}
