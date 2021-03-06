package com.concreteitsolutions.smscampaign;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.concreteitsolutions.framework.api.model.APIException;
import com.concreteitsolutions.framework.api.model.APIResponse;
import com.concreteitsolutions.framework.api.model.ExceptionType;
import com.concreteitsolutions.sms.SMSCoreFunctionalException;
import com.concreteitsolutions.smscampaign.exceptions.SMSCampaignFunctionalException;
import com.concreteitsolutions.smscampaign.model.SMSCampaignSearchView;
import com.concreteitsolutions.smscampaign.model.SMSCampaignView;

@Component
public class SMSCampaignControllerImpl implements SMSCampaignController {

	private final SMSCampaignProcess smsCampaignProcess;

	private final SMSCampaignService smsCampaignService;

	@Autowired
	public SMSCampaignControllerImpl(SMSCampaignProcess smsCampaignProcess, SMSCampaignService smsCampaignService) {
		this.smsCampaignProcess = smsCampaignProcess;
		this.smsCampaignService = smsCampaignService;
	}

	/**
	 *		SEND
	 **/
	public ResponseEntity<APIResponse> sendCampaign(@PathVariable("reference") String reference) {

		APIResponse campaignCreationResponse;

		try {

			System.out.println("Reference id : " + reference);

			smsCampaignProcess.send(Long.parseLong(reference));

			campaignCreationResponse = APIResponse.builder().entity("SMS Well sent").build();

			return ResponseEntity.ok(campaignCreationResponse);

		} catch (SMSCampaignFunctionalException | SMSCoreFunctionalException e) {

			APIException campaignException = APIException.builder().exceptionType(ExceptionType.FUNCTIONAL)
					.code(e.getError()).message(e.getError().message()).developerMessage(e.getMessage()).build();

			campaignCreationResponse = APIResponse.builder().exception(campaignException).build();

			HttpStatus httpStatus = determineHTTPStatus(campaignException.getExceptionType());

			return ResponseEntity.status(httpStatus).body(campaignCreationResponse);

		}
	}

	/**
	 *		CREATE
	 **/
	public ResponseEntity<APIResponse> create(@RequestBody SMSCampaignView smsCampaignView) {

		System.out.println("Well entered in sms campaign creation");

		long createdSMSCampaignId = smsCampaignProcess.create(smsCampaignView.toSMSCampaign());

		APIResponse smsCampaignCreationResponse = APIResponse.builder()
				.entity("Resource well created")
				.build();

		URI uriLocation = generateLocationURI(createdSMSCampaignId);

		return ResponseEntity.created(uriLocation).body(smsCampaignCreationResponse);
	}


	/**
	 *		FIND BY REFERENCE
	 **/
	public ResponseEntity<APIResponse> findByReference(@PathVariable("reference") final String reference) {

		APIResponse campaignResponse = null;

		try {
			SMSCampaignView smsCampaignView =  SMSCampaignView.from(smsCampaignService.findById(Long.parseLong(reference)));

			campaignResponse = APIResponse.builder()
					.entity(smsCampaignView)
					.build();

			return ResponseEntity.ok(campaignResponse);

		} catch (SMSCampaignFunctionalException e){

			APIException apiException = APIException.builder()
					.exceptionType(ExceptionType.FUNCTIONAL)
					.code(e.getError())
					.message(e.getError().message())
					.developerMessage(e.getMessage())
					.build();

			APIResponse apiResponse = APIResponse.builder()
					.entity(apiException)
					.build();

			HttpStatus httpStatus = determineHTTPStatus(apiException.getExceptionType());

			return ResponseEntity.status(httpStatus).body(apiResponse);
		}

	}


	/**
	 *		FIND
	 **/
	public List<SMSCampaignView> find(SMSCampaignSearchView smsCampaignSearchView) {
		return null;
	}


	/**
	 *		EDIT
	 **/
	public ResponseEntity<APIResponse> edit(@PathVariable("reference") String reference, @RequestBody SMSCampaignView SMSCampaignView) {

		APIResponse campaignEditResponse = null;

		try {

			SMSCampaignView editedSMSCampaignView = SMSCampaignView.from(smsCampaignProcess.edit(Long.parseLong(reference), SMSCampaignView.toSMSCampaign()));

			campaignEditResponse = APIResponse.builder()
					.entity(editedSMSCampaignView)
					.build();

			return ResponseEntity.ok(campaignEditResponse);

		} catch(SMSCampaignFunctionalException e) {

			APIException campaignException = APIException.builder().exceptionType(ExceptionType.FUNCTIONAL)
					.code(e.getError()).message(e.getError().message()).developerMessage(e.getMessage()).build();

			campaignEditResponse = APIResponse.builder().exception(campaignException).build();

			HttpStatus httpStatus = determineHTTPStatus(campaignException.getExceptionType());

			return ResponseEntity.status(httpStatus).body(campaignEditResponse);

		}

	}


	/**
	 *		DELETE
	 **/
	public ResponseEntity<APIResponse> delete(@PathVariable("reference") String reference) {

		long deletedSMSCampaignId = smsCampaignService.delete(Long.parseLong(reference));

		APIResponse deletedSMSCampaignResponse = APIResponse.builder()
				.entity("La campagne avec le numéro de référence : "+deletedSMSCampaignId + "a été bien supprimé" )
				.build();

		return ResponseEntity.ok(deletedSMSCampaignResponse);
	}



	/**-----------------------------
	 *
	 * PRIVATE FUNCTIONS
	 *
	 * -----------------------------
	 */

	private HttpStatus determineHTTPStatus(ExceptionType exceptionType) {

		switch (exceptionType) {
			case FUNCTIONAL:
				return HttpStatus.BAD_REQUEST;
			case TECHNICAL:
				return HttpStatus.INTERNAL_SERVER_ERROR;
		}
		return null;
	}

	private URI generateLocationURI(long id){
		try {
			URI uri = new URI("http://localhost:8080/sms-campaign/campaigns/"+id);
			return uri;
		} catch (URISyntaxException e) {
			e.printStackTrace();
			return null;
		}
	}
}
