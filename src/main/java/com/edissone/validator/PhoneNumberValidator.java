package com.edissone.validator;

import com.edissone.validator.impl.*;

public interface PhoneNumberValidator {

    void validate(String phoneNumber) throws IllegalArgumentException;

    static PhoneNumberValidator validator(String phoneNumber) throws IllegalArgumentException {
        return switch (phoneNumber) {
            case String s when s.startsWith("+380") -> new UkrainePhoneNumberValidator();
            case String s when s.startsWith("+44") -> new EnglishPhoneNumberValidator();
            case String s when s.startsWith("+34") -> new SpainPhoneNumberValidator();
            default -> throw new IllegalArgumentException("Unsupported phone number format.");
        };
    }

}
