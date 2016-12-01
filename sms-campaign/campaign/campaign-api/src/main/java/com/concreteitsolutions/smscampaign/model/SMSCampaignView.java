package com.concreteitsolutions.smscampaign.model;

import com.sun.istack.internal.NotNull;
import lombok.*;

@Data
@NoArgsConstructor(access = AccessLevel.PUBLIC, force = true)
@AllArgsConstructor
public class SMSCampaignView {

	private final long reference;

	@NotNull
	private String name;

	@NotNull
	private String customerName;

	@NotNull
	private String smsContent;

	private String prospectLength;

	public SMSCampaign toSMSCampaign(){

		return SMSCampaign.builder()
				.reference(reference)
				.name(name)
				.customerName(customerName)
				.smsContent(smsContent)
				.prospectsLength(Integer.valueOf(prospectLength).intValue())
				.build();
	}

	public static SMSCampaignView from(final SMSCampaign smsCampaign){
		return new SMSCampaignView(smsCampaign.getReference(), smsCampaign.getName(), smsCampaign.getCustomerName(), smsCampaign.getSmsContent(), smsCampaign.getProspectsLength().toString());
	}
}
