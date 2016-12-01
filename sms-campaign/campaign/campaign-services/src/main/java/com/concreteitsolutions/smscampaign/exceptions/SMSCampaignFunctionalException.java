package com.concreteitsolutions.smscampaign.exceptions;

import com.concreteitsolutions.commonframework.core.exceptions.CustomError;
import com.concreteitsolutions.commonframework.core.exceptions.CustomException;
import lombok.Getter;

public class SMSCampaignFunctionalException extends CustomException {

	public SMSCampaignFunctionalException(final Error error, final String message) {
		super(error, message);
	}

	public SMSCampaignFunctionalException(final Error error) {
		super(error);
	}

	@Getter
	public enum Error implements CustomError {

		SMS_CREDIT_USED_UP("Le crédit SMS dont vous disposez ne vous permet pas de réaliser cette campagne. Veuillez recharger SVP.");

		public final String message;

		Error(String message) {
			this.message = message;
		}

		public String message() {
			return message;
		}
	}
}
