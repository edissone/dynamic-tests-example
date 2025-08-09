package com.edissone.validator.impl;

import com.edissone.validator.*;

import java.util.regex.*;

import static java.util.Objects.isNull;

public class UkrainePhoneNumberValidator implements PhoneNumberValidator {
    private static final Pattern UKRAINE_PHONE_REGEX =
            Pattern.compile("^\\+380\\s?\\(?\\d{2}\\)?[\\s-]?\\d{3}[\\s-]?\\d{2}[\\s-]?\\d{2}$");

    @Override
    public void validate(String phoneNumber) throws IllegalArgumentException {
        if (isNull(phoneNumber) || !UKRAINE_PHONE_REGEX.matcher(phoneNumber).matches()) {
            throw new IllegalArgumentException("Invalid Ukraine international phone number format: " + phoneNumber);
        }
    }
}
