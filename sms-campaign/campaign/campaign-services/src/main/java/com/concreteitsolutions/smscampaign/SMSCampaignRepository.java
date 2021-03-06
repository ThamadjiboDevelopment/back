package com.concreteitsolutions.smscampaign;

import com.concreteitsolutions.smscampaign.model.SMSCampaign;

public interface SMSCampaignRepository {

	SMSCampaign find(final long reference);

	long create(final SMSCampaign smsCampaign);

	SMSCampaign edit(final SMSCampaign smsCampaign);

	long delete(final long reference);
}
