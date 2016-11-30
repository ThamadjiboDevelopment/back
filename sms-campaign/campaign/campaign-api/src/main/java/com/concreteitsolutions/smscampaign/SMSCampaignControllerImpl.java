package com.concreteitsolutions.smscampaign;

import java.util.List;

import com.concreteitsolutions.sms.SMSCoreFunctionalException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;

import com.concreteitsolutions.smscampaign.model.SMSCampaignSearchView;
import com.concreteitsolutions.smscampaign.model.SMSCampaignView;

@Component
public class SMSCampaignControllerImpl implements SMSCampaignController {

	private final SMSCampaignProcess smsCampaignProcess;

	@Autowired
	public SMSCampaignControllerImpl(SMSCampaignProcess smsCampaignProcess) {
		this.smsCampaignProcess = smsCampaignProcess;
	}

	public String sendCampaign(@PathVariable("reference") long reference) {
		try {
			smsCampaignProcess.send(reference);
			return "campagn sent";
		} catch (SMSCampaignFunctionalException e){

			System.out.println("SMS Campaign exception catched with code : "+e.getError() +" and message = "+ e.getError().message()+" and developerMessage : "+e.getMessage());
			return "error catched";
		} catch(SMSCoreFunctionalException e){
			System.out.println("SMS core exception catched");
			return "sms core exception well catched";
		}
	}

	public String create(SMSCampaignView smsCampaignView) {
		return null;
	}

	public SMSCampaignView findByReference(@PathVariable("reference") long reference) {
		return null;
	}

	public List<SMSCampaignView> find(SMSCampaignSearchView smsCampaignSearchView) {
		return null;
	}

	public SMSCampaignView editSMSCampaign(@PathVariable("reference") long reference, SMSCampaignView smsCampaignView) {
		return null;
	}

	public String delete(@PathVariable("reference") long reference) {
		return null;
	}
}
