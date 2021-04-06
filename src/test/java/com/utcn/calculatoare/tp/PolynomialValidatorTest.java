package com.utcn.calculatoare.tp;

import com.utcn.calculatoare.tp.polynomial.PolynomialValidator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class PolynomialValidatorTest {

    @ParameterizedTest
    @ValueSource(strings = {"-2x^2+5x^1", "3.66x^7", "-2x", "2.3", "3x+4", "6x^4-3"})
    void whenPolynomialValid_thenExpectOperationIsSuccessful(String polynomial) {
        Assertions.assertTrue(PolynomialValidator.validatePolynomial(polynomial));
    }

    @ParameterizedTest
    @ValueSource(strings = {"2x^2+5x^1--24", "3x^^7", "--6x^4-3", "2^x"})
    void whenPolynomialInvalid_thenExpectOperationIsUnsuccessful(String polynomial) {
        Assertions.assertFalse(PolynomialValidator.validatePolynomial(polynomial));
    }

}
