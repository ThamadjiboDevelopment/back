package com.concreteitsolutions.smscampaign;

import org.springframework.stereotype.Component;

@Component
public class SMSCampaignRepositoryImplMock implements SMSCampaignRepository {

	public SMSCampaign find(long reference) {
		return SMSCampaignDatabase.getSMSCampaigns().get(Integer.valueOf(Long.toString(reference)));
	}
}
