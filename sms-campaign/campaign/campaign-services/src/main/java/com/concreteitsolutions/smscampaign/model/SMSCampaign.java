package com.concreteitsolutions.smscampaign.model;

import lombok.*;

@Data
@Builder
@AllArgsConstructor
@ToString
public class SMSCampaign {

	private long reference;

	private final String name;

	private final String customerName;

	private final String smsContent;

	private final Integer prospectsLength;

	private CampaignState state;
}
