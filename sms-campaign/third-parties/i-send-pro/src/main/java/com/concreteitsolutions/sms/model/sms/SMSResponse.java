package com.concreteitsolutions.sms.model.sms;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor(access = AccessLevel.PUBLIC, force = true)
@AllArgsConstructor
public class SMSResponse {

	@JsonProperty(value = "etat", required = true)
	private SMSResponseState state;
}
