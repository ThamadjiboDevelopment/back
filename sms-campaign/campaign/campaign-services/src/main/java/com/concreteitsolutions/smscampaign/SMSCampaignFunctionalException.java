package com.concreteitsolutions.smscampaign;

import lombok.Getter;

public class SMSCampaignFunctionalException extends FunctionalException {

	public SMSCampaignFunctionalException(final Error error, final String message) {
		super(error, message);
	}

	@Getter
	public enum Error implements CustomError {
		EMPTY_LOGIN_FIELD("Le champ login est vide"),
		EMPTY_PASSWORD_FIELD("Le champ password est vide");

		public final String message;

		Error(String message) {
			this.message = message;
		}

		public String message() {
			return message;
		}
	}
}
