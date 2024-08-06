package com.example.springmicronaut;

import jakarta.inject.Inject;
import jakarta.validation.ConstraintViolationException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class GreetingServiceTest {
    @Inject
    GreetingService greetingService;

    @Test
    void regexValidationNonDigitsWork() {
        assertDoesNotThrow(() -> greetingService.greeting("foo"));
        Executable e = () -> greetingService.greeting("12foo");
        assertThrows(ConstraintViolationException.class, e);
    }
}
