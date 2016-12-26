package com.concreteitsolutions.generic.prospect.model;

import lombok.Data;

@Data
public class ProspectView {

    private final long id;

    private final String firstName;

    private final String lastName;

    private final String phoneNumber;

    private final String email;
}
