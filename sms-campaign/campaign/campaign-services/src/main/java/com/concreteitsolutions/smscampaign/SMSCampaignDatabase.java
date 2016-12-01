package com.concreteitsolutions.smscampaign;

import java.util.ArrayList;
import java.util.List;

import com.concreteitsolutions.smscampaign.model.SMSCampaign;

import lombok.Data;

@Data
public class SMSCampaignDatabase {

	public static List<SMSCampaign> smsCampaignList;

	public static int smsCampaignCounter = 0;

	static {
		smsCampaignList = new ArrayList<SMSCampaign>();
	}

	public static List<SMSCampaign> getSMSCampaigns() {
		return smsCampaignList;
	}

	public static long createSMSCampaign(SMSCampaign smsCampaign) {

		System.out.println("Creating new SMS Campaign in database : "+smsCampaign);
		smsCampaignList.add(smsCampaignCounter, smsCampaign);
		smsCampaign.setReference(smsCampaignCounter);
		int currentSmsCampaignId = smsCampaignCounter;
		smsCampaignCounter += 1;

		return currentSmsCampaignId;
	}

	public static SMSCampaign edit(SMSCampaign smsCampaign) {
		smsCampaignList.remove(smsCampaign.getReference());
		smsCampaignList.add(Long.valueOf(smsCampaign.getReference()).intValue(), smsCampaign);

		return smsCampaign;
	}

	public static long delete(long reference) {
		smsCampaignList.remove(Long.valueOf(reference).intValue());

		return reference;
	}


}
