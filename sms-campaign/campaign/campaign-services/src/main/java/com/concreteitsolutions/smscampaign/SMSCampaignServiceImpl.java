package com.concreteitsolutions.smscampaign;

import com.concreteitsolutions.smscampaign.exceptions.SMSCampaignFunctionalException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.concreteitsolutions.smscampaign.model.SMSCampaign;

@Component
public class SMSCampaignServiceImpl implements SMSCampaignService {

	private final SMSCampaignRepository smsCampaignRepository;

	@Autowired
	public SMSCampaignServiceImpl(SMSCampaignRepository smsCampaignRepository) {
		this.smsCampaignRepository = smsCampaignRepository;
	}

	public SMSCampaign findById(Long reference) {

		SMSCampaign smsCampaign = smsCampaignRepository.find(reference);

		if (smsCampaign != null) {
			return smsCampaign;
		}
		throw new SMSCampaignFunctionalException(SMSCampaignFunctionalException.Error.SMS_CAMPAIGN_RESOURCE_NOT_FOUND, "Id de la campagne : "+ reference);
	}

	public long create(SMSCampaign smsCampaign) {
		return smsCampaignRepository.create(smsCampaign);
	}

	public SMSCampaign edit(SMSCampaign smsCampaign) {
		return smsCampaignRepository.edit(smsCampaign);
	}

	public long delete(long reference) {
		return smsCampaignRepository.delete(reference);
	}
}
