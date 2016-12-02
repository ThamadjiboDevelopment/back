package com.concreteitsolutions.smscampaign;

import com.concreteitsolutions.framework.api.model.APIResponse;
import com.concreteitsolutions.smscampaign.model.SMSCampaignSearchView;
import com.concreteitsolutions.smscampaign.model.SMSCampaignView;
import com.sun.istack.internal.NotNull;
import org.hibernate.validator.constraints.NotBlank;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/campaigns")
public interface SMSCampaignController {

	@Valid
	@RequestMapping(value = "/{reference}/send", method = RequestMethod.POST)
	ResponseEntity<APIResponse> sendCampaign(@PathVariable("reference") @NotBlank String reference);

	@Valid
	@RequestMapping(value = "/create", method = RequestMethod.POST)
	ResponseEntity<APIResponse> create(@Valid @RequestBody SMSCampaignView smsCampaignView);

	@RequestMapping(value = "/{reference}", method = RequestMethod.GET)
	ResponseEntity<APIResponse> findByReference(@PathVariable("reference") final String reference);

	@RequestMapping(value = "/search", method = RequestMethod.GET)
	List<SMSCampaignView> find(final SMSCampaignSearchView smsCampaignSearchView);

	@RequestMapping(value = "/{reference}/edit", method = RequestMethod.PATCH)
	ResponseEntity<APIResponse>  editSMSCampaign(@PathVariable("reference") final String reference, @RequestBody final SMSCampaignView smsCampaignView);

	@RequestMapping(value = "/{reference}", method = RequestMethod.POST)
	ResponseEntity<APIResponse> delete(@PathVariable("reference") final String reference);

	/**
	 * TODO: Create a controller for unknown paths
	 */
}
