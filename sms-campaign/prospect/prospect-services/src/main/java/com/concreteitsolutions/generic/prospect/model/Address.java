package com.concreteitsolutions.generic.prospect.model;

/**
 * Created by tahirou on 26/11/2016.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PUBLIC, force = true)
public class Address {

    private final String country;

    private final String postalCode;

    private final String firstLine;

    private final String complementaryAddress;
}
