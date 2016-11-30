package com.concreteitsolutions.smscampaign;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.concreteitsolutions.generic.prospect.ProspectProcess;
import com.concreteitsolutions.generic.prospect.model.Prospect;
import com.concreteitsolutions.sms.SMSCoreFunctionalException;
import com.concreteitsolutions.sms.SMSService;
import com.concreteitsolutions.sms.credit.model.Credit;

@Component
public class SMSCampaignProcessImpl implements SMSCampaignProcess {

	private final SMSService smsService;

	private final SMSCampaignService smsCampaignService;

	private final ProspectProcess prospectProcess;

	@Autowired
	public SMSCampaignProcessImpl(SMSService smsService,
			SMSCampaignServiceImpl smsCampaignService,
			ProspectProcess prospectProcess) {
		this.smsService = smsService;
		this.smsCampaignService = smsCampaignService;
		this.prospectProcess = prospectProcess;
	}

	public void send(long reference) {

		/* 1. Get the sms campaign by reference */
		SMSCampaign smsCampaign = smsCampaignService.findById(reference);

		/* 2. Credit check */
		Credit credit = smsService.findRemainingCreditAndSMS();
		if (credit.getRemainingSMSQuantity() < smsCampaign.getProspectsLength()) {
		//	throw new SMSCampaignFunctionalException("Credit non suffisant pour envoyer les sms, veuillez recharger svp.");
		} else {
			throw new SMSCampaignFunctionalException(SMSCampaignFunctionalException.Error.EMPTY_LOGIN_FIELD, "le login fourni : \"\" n'est pas valide");
		}

		/* 3. */
		List<Prospect> prospectList = prospectProcess.find(null, smsCampaign.getProspectsLength());
		System.out.println("Prospect list : "+prospectList.toString());
		/* 4. Send the campaign */

		List<String> phoneNumberList = phoneNumbersFromProspects(prospectList);
		System.out.println("phone Number list : "+phoneNumberList.toString());
		smsService.sendMultiple(phoneNumberList, smsCampaign.getSmsContent(), smsCampaign.getCustomerName());

		/* 5. Return the result of the campaign */

	}

	private List<String> phoneNumbersFromProspects(List<Prospect> prospects) {
		List<String> phoneNumbers = new ArrayList<String>();
		for (Prospect p : prospects) {
			phoneNumbers.add(p.getPhoneNumber());
		}
		return phoneNumbers;
	}
}
