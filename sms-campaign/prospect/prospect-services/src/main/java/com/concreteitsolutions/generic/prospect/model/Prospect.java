package com.concreteitsolutions.generic.prospect.model;

import java.util.List;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PUBLIC, force = true)
public class Prospect {

	private final String firstName;

	private final String lastName;

	private final String phoneNumber;

	private final List<PreferenceCategory> preferenceCategoryList;

	private final Address address;
}
