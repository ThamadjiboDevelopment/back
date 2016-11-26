package com.concreteitsolutions.smscampaign;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SMSCampaignServiceImpl implements SMSCampaignService {

	private final SMSCampaignRepository smsCampaignRepository;

	@Autowired
	public SMSCampaignServiceImpl(SMSCampaignRepository smsCampaignRepository){
		this.smsCampaignRepository = smsCampaignRepository;
	}

	public SMSCampaign findById(final long reference) {
		return smsCampaignRepository.find(reference);
	}
}
