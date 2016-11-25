package com.concreteitsolutions.smscampaign;

public interface SMSCampaignProcess {

	/**
	 * Send the referenced sms campaign
	 * @param reference The identifier for the sms campaign
	 */
	void send(long reference);


}
