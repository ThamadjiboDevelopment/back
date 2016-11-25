package com.concreteitsolutions.smscampaign;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.concreteitsolutions.sms.SMSService;

@Component
public class SMSCampaignProcessImpl implements SMSCampaignProcess {

	private final SMSService smsService;

	private final SMSCampaignServiceImpl smsCampaignService;

	@Autowired
	public SMSCampaignProcessImpl(SMSService smsService, SMSCampaignServiceImpl smsCampaignService) {
		this.smsService = smsService;
		this.smsCampaignService = smsCampaignService;
	}

	public void send(long reference) {
		// 1. Get the sms campaign by reference
		SMSCampaign smsCampaign = smsCampaignService.findById(reference);
		// 2. Get the remaining credit of the account so the number of sms that can be send

		// 3. Check if the current credit is sufficient. If so, continue process else, throw an functional exception

		// 4. Retrieve in database, prospects to which the campaign will be send

		// 5. Send the campaign
		smsService.sendMultiple(null, smsCampaign.getSmsContent());

		// 6. Return the result of the campaign

	}
}
