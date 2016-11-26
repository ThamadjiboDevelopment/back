package com.concreteitsolutions.smscampaign;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor(access = AccessLevel.PUBLIC, force = true)
@AllArgsConstructor
public class SMSCampaign {

	private final long reference;

	private final String name;

	private final String customerName;

	private final String smsContent;

	private final Integer prospectsLength;
}
