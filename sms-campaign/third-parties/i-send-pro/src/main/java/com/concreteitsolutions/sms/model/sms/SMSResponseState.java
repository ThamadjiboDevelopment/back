package com.concreteitsolutions.sms.model.sms;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor(access = AccessLevel.PUBLIC, force = true)
@AllArgsConstructor
public class SMSResponseState {

	@JsonProperty("etat")
	private List<SMSResponseStateContent> smsResponseStateContentList;
}
