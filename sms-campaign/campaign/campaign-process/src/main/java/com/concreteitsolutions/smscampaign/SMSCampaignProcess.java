package com.concreteitsolutions.smscampaign;

public interface SMSCampaignProcess {

	/**
	 *  - Get the sms campaign by reference
	 *  - Get the remaining credit of the account so the number of sms that can be send, Check if the current credit is sufficient. If so, continue process else, throw an functional exception
	 *  - Retrieve in database, prospects to which the campaign will be send
	 *  -  Send the campaign
	 * Send the referenced sms campaign
	 * @param reference The identifier for the sms campaign
	 */
	void send(long reference);


}
