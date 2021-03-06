package com.concreteitsolutions.smscampaign;

import com.concreteitsolutions.framework.api.model.APIResponse;
import com.concreteitsolutions.smscampaign.model.SMSCampaignSearchView;
import com.concreteitsolutions.smscampaign.model.SMSCampaignView;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/campaigns")
public interface SMSCampaignController {

	@RequestMapping(value = "/{reference}/send", method = RequestMethod.POST)
	ResponseEntity<APIResponse> sendCampaign(@PathVariable("reference") String reference);

	@RequestMapping(value = "/create", method = RequestMethod.POST)
	ResponseEntity<APIResponse> create(@RequestBody SMSCampaignView smsCampaignView);

	@RequestMapping(value = "/{reference}", method = RequestMethod.GET)
	ResponseEntity<APIResponse> findByReference(@PathVariable("reference") final String reference);

	@RequestMapping(value = "/search", method = RequestMethod.GET)
	List<SMSCampaignView> find( @RequestBody final SMSCampaignSearchView smsCampaignSearchView);

	@RequestMapping(value = "/{reference}/edit", method = RequestMethod.PUT)
	ResponseEntity<APIResponse> edit(@PathVariable("reference") final String reference, @RequestBody final SMSCampaignView smsCampaignView);

	@RequestMapping(value = "/{reference}", method = RequestMethod.POST)
	ResponseEntity<APIResponse> delete(@PathVariable("reference") final String reference);

	/**
	 * TODO: Create a controller for unknown paths
	 */
}
