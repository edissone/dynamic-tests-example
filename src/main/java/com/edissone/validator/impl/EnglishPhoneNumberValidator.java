package com.edissone.validator.impl;

import com.edissone.validator.*;

import java.util.regex.*;

public class EnglishPhoneNumberValidator implements PhoneNumberValidator {
    private static final Pattern ENGLISH_PHONE_REGEX =
            Pattern.compile("^\\+44\\s?\\d{4}\\s?\\d{3}\\s?\\d{3}$");

    @Override
    public void validate(String phoneNumber) throws IllegalArgumentException {
        if (phoneNumber == null || !ENGLISH_PHONE_REGEX.matcher(phoneNumber).matches()) {
            throw new IllegalArgumentException("Invalid English international phone number format: " + phoneNumber);
        }
    }
}
