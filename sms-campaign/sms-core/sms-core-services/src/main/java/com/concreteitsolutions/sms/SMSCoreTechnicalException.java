package com.concreteitsolutions.sms;

import com.concreteitsolutions.commonframework.core.exceptions.CustomError;
import com.concreteitsolutions.commonframework.core.exceptions.CustomException;

import lombok.Getter;

public class SMSCoreTechnicalException extends CustomException {

	public SMSCoreTechnicalException(CustomError error) {
		super(error);
	}

	public SMSCoreTechnicalException(CustomError error, String message) {
		super(error, message);
	}

	@Getter
	public enum Error implements CustomError {

		CAMPAIGN_CREATION_ERROR("Erreur technique rencontrée lors de la création de la campagne");

		public final String message;

		Error(String message) {
			this.message = message;
		}

		public String message() {
			return message;
		}
	}
}
