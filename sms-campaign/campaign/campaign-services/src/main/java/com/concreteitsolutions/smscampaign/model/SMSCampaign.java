package com.concreteitsolutions.smscampaign.model;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PUBLIC, force = true)
@Entity
public class SMSCampaign {

	private long reference;

	private final String name;

	private final String customerName;

	private final String smsContent;

	private final Integer prospectsLength;

	@Enumerated(EnumType.STRING)
	private CampaignState state;
}
