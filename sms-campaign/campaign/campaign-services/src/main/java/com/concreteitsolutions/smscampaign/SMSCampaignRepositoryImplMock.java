package com.concreteitsolutions.smscampaign;

import com.concreteitsolutions.smscampaign.model.SMSCampaign;
import org.springframework.stereotype.Component;

@Component
public class SMSCampaignRepositoryImplMock implements SMSCampaignRepository {

	public SMSCampaign find(long reference) {
		return SMSCampaignDatabase.getSMSCampaignByReference(reference);
	}

	public long create(SMSCampaign smsCampaign) {
		return SMSCampaignDatabase.createSMSCampaign(smsCampaign);
	}

	public SMSCampaign edit(SMSCampaign smsCampaign) {
		return SMSCampaignDatabase.edit(smsCampaign);
	}

	public long delete(long reference) {
		return SMSCampaignDatabase.delete(reference);
	}
}
