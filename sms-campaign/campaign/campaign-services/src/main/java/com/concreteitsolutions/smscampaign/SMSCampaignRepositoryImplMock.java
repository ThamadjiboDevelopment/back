package com.concreteitsolutions.smscampaign;

import com.concreteitsolutions.smscampaign.model.SMSCampaign;
import org.springframework.stereotype.Component;

@Component
public class SMSCampaignRepositoryImplMock implements SMSCampaignRepository {

	public SMSCampaign find(Long reference) {
		return SMSCampaignDatabase.getSMSCampaigns().get(Integer.valueOf(Long.toString(reference)));
	}

	public long create(SMSCampaign smsCampaign) {
		return SMSCampaignDatabase.createSMSCampaign(smsCampaign);
	}

	public SMSCampaign edit(SMSCampaign smsCampaign) {
		return null;
	}

	public long delete(long reference) {
		return SMSCampaignDatabase.delete(reference);
	}
}
