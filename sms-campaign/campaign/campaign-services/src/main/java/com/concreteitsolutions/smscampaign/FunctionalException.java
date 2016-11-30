package com.concreteitsolutions.smscampaign;

import lombok.Getter;

@Getter
public class FunctionalException extends RuntimeException {

	private final CustomError error;

	public FunctionalException(Error error) {
		super(error.getMessage());
		this.error = null;
	}

	public FunctionalException(final CustomError error, final String message) {
		super(message);
		this.error = error;
	}
}
