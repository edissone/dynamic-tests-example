package com.edissone.validator.impl;

import com.edissone.validator.*;

import java.util.regex.*;

public class SpainPhoneNumberValidator implements PhoneNumberValidator {
    private static final Pattern SPAIN_PHONE_REGEX =
            Pattern.compile("^\\+34\\s?\\d{3}\\s?\\d{3}\\s?\\d{3}$");

    @Override
    public void validate(String phoneNumber) throws IllegalArgumentException {
        if (phoneNumber == null || !SPAIN_PHONE_REGEX.matcher(phoneNumber).matches()) {
            throw new IllegalArgumentException("Invalid Spain international phone number format: " + phoneNumber);
        }
    }
}
