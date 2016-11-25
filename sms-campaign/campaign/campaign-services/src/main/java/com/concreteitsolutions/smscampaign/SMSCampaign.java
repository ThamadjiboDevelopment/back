package com.concreteitsolutions.smscampaign;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor(access = AccessLevel.PUBLIC, force = true)
@AllArgsConstructor
public class SMSCampaign {

	private long reference;

	private String name;

	private String customerName;

	private String smsContent;

	private int prospectQuantity;
}
