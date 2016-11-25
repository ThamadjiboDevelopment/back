package com.concreteitsolutions.smscampaign;

import com.concreteitsolutions.smscampaign.model.SMSCampaignSearchView;
import com.concreteitsolutions.smscampaign.model.SMSCampaignView;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/campaigns")
public interface SMSCampaignController {

	@RequestMapping(value = "/create", method = RequestMethod.POST)
	String create(SMSCampaignView smsCampaignView);

	@RequestMapping(value = "/search/{reference}", method = RequestMethod.GET)
	SMSCampaignView findByReference(@PathVariable("reference") long reference);

	@RequestMapping(value = "/search", method = RequestMethod.GET)
	List<SMSCampaignView> find(SMSCampaignSearchView smsCampaignSearchView);

	@RequestMapping(value = "/{reference}/edit", method = RequestMethod.PATCH)
	SMSCampaignView editSMSCampaign(@PathVariable("reference") long reference, SMSCampaignView smsCampaignView);

	@RequestMapping(value = "/{reference}", method = RequestMethod.POST)
	String find(@PathVariable("reference") long reference);

	/**
	 * TODO: Create a controller for unknown paths
	 */
}
