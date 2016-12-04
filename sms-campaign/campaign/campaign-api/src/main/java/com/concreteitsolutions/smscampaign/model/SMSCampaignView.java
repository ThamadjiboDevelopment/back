package com.concreteitsolutions.smscampaign.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

@Data
@NoArgsConstructor(access = AccessLevel.PUBLIC, force = true)
@AllArgsConstructor
@ToString
@JsonInclude(JsonInclude.Include.NON_NULL)
public class SMSCampaignView {

	private String reference;

	private String name;

	private String customerName;

	private String smsContent;

	private String prospectLength;

	private CampaignState state;

	public SMSCampaign toSMSCampaign(){

		return SMSCampaign.builder()
				.name(name)
				.customerName(customerName)
				.smsContent(smsContent)
				.prospectsLength(Integer.valueOf(prospectLength).intValue())
				.build();
	}

	public static SMSCampaignView from(final SMSCampaign smsCampaign){
		System.out.println("SMS Campaign  that is being returned : "+smsCampaign.toString());
		SMSCampaignView view = new SMSCampaignView(Long.toString(smsCampaign.getReference()), smsCampaign.getName(), smsCampaign.getCustomerName(), smsCampaign.getSmsContent(), Integer.toString(smsCampaign.getProspectsLength()), smsCampaign.getState());

		System.out.println("SMS Campaign view that is being returned : "+view.toString());
		return view;
	}
}
