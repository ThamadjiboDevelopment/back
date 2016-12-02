package com.concreteitsolutions.generic.prospect.model;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PUBLIC, force = true)
public class Address {

	private final String country;

	private final long postalCode;

	private final String town;

	private final String firstLine;

	private final String complementaryInformations;

}
