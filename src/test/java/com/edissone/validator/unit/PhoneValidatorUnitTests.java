package com.edissone.validator.unit;

import com.edissone.validator.*;
import org.junit.jupiter.api.*;

import java.util.stream.*;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

@DisplayName("phone validator unit tests")
class PhoneValidatorUnitTests {

    @TestFactory
    @DisplayName("should validate phone numbers - success")
    Stream<DynamicTest> shouldValidateNumbers_success() {
        final var input = Stream.of(
                // ukrainian
                "+380123456789", "+380 (12)-345-67-89", "+380 123456789",
                // spainish
                "+34123456789", "+34 123 456 789", "+34 123456789", "+34 123 456789", "+34 123456 789",
                // english
                "+441234567890", "+44 1234 567890", "+44 1234567890", "+44 1234 567 890"
        );

        return input.map(number -> DynamicTest.dynamicTest("validate number - success; input: " + number,
                () -> assertDoesNotThrow(() -> PhoneNumberValidator.validator(number).validate(number))));
    }

    @TestFactory
    @DisplayName("should validate phone numbers - failure, invalid format")
    Stream<DynamicTest> shouldValidateNumbers_failure_invalidFormat() {
        final var input = Stream.of(
                // ukrainian
                "+38012345678", "+380-(12)-3456789", "+380 1234567890", "+38012345678S",
                // spainish
                "+3412345678", "+34 (123) (456) 789", "+34 1234567890", "+34-123-456789", "+34=123456 789", "+3412345678S",
                // english
                "+44123456789", "+44123456789", "+44 (1234 5678902)", "+44+1234567890", "+44s1234 567 890"
        );
        return input.map(number -> DynamicTest.dynamicTest("validate number - failure, invalid format; input: " + number,
                () -> Assertions.assertThrows(IllegalArgumentException.class, () -> PhoneNumberValidator.validator(number).validate(number))));
    }

    @TestFactory
    @DisplayName("should validate phone numbers - failure, unsupported format")
    Stream<DynamicTest> shouldValidateNumbers_failure_unsupportedFormat() {
        final var input = Stream.of(
                "1234567890", "+1234567890", "+123 456 7890", "+123-456-7890",
                "+999123456789", "+99 1234 567890", "+99-1234-567890"
        );
        return input.map(number -> DynamicTest.dynamicTest("validate number - failure, unsupported format; input: " + number,
                () -> Assertions.assertThrows(IllegalArgumentException.class, () -> PhoneNumberValidator.validator(number).validate(number))));
    }


}
