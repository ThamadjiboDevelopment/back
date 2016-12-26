package com.concreteitsolutions.smscampaign.model;

import lombok.*;

import javax.persistence.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PUBLIC, force = true)
@Entity
public class SMSCampaign {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	private long reference;

	private String name;

	private String customerName;

	private String smsContent;

	private Integer prospectsLength;

	@Enumerated(EnumType.STRING)
	private CampaignState state;
}
