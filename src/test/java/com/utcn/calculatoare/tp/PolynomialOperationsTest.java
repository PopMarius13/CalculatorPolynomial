package com.utcn.calculatoare.tp;

import com.utcn.calculatoare.tp.polynomial.Polynomial;
import com.utcn.calculatoare.tp.polynomial.PolynomialOperations;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class PolynomialOperationsTest {

    private static Polynomial polynomial1;
    private static Polynomial polynomial2;
    private static Polynomial resultCorrect;
    private static PolynomialOperations operations;

    @BeforeEach
    public void setUp(){
        polynomial1 = new Polynomial("x^3 - 2x^2 + 6x -5");
        polynomial2 = new Polynomial("x^2 - 1");
        operations = new PolynomialOperations();
    }

    @Test
    void additionTest() {
        Polynomial result = operations.addition(polynomial1 , polynomial2);
        resultCorrect = new Polynomial("x^3-x^2+6x-6");
        Assertions.assertEquals(resultCorrect.toString(), result.toString());

        resultCorrect = new Polynomial("x^3-x^2+6x+6");
        Assertions.assertNotEquals(result.toString(), resultCorrect.toString());
    }

    @Test
    void subtractionTest() {
        Polynomial result = operations.subtraction(polynomial1 , polynomial2);
        resultCorrect = new Polynomial("x^3-3x^2+6x-4");
        Assertions.assertEquals(resultCorrect.toString(), result.toString());

        resultCorrect = new Polynomial("x^3+3x^2+6x-4");
        Assertions.assertNotEquals(resultCorrect.toString(), result.toString());
    }

    @Test
    void multiplicationTest() {
        Polynomial result = operations.multiplication(polynomial1 , polynomial2);
        resultCorrect = new Polynomial("x^5 - 2x^4 + 5x^3 - 3x^2 - 6x + 5");
        Assertions.assertEquals(resultCorrect.toString(), result.toString());

        resultCorrect = new Polynomial("x^5 - 2x^4 + 5x^3 - 5x^2 - 6x + 5");
        Assertions.assertNotEquals(resultCorrect.toString(), result.toString());
    }

    @Test
    void divisionTest() {
        List<Polynomial> result = operations.division(polynomial1 , polynomial2);
        List<Polynomial> resultCorrect = new ArrayList<>();
        resultCorrect.add(0 ,new Polynomial("x - 2"));
        resultCorrect.add(1 ,new Polynomial("7x - 7"));
        Assertions.assertEquals(resultCorrect.get(0).toString(), result.get(0).toString());
        Assertions.assertEquals(resultCorrect.get(1).toString(), result.get(1).toString());

        resultCorrect.add(0 ,new Polynomial("x + 2"));
        resultCorrect.add(1 ,new Polynomial("2x - 7"));
        Assertions.assertNotEquals(resultCorrect.get(0).toString(), result.get(0).toString());
        Assertions.assertNotEquals(resultCorrect.get(1).toString(), result.get(1).toString());
    }

    @Test
    void derivativeTest() {
        Polynomial result = operations.derivative(polynomial1);
        resultCorrect = new Polynomial("3x^2 - 4x^1 + 6");
        Assertions.assertEquals(resultCorrect.toString(), result.toString());

        resultCorrect = new Polynomial("3x^2 + 4x^1 + 6");
        Assertions.assertNotEquals(resultCorrect.toString(), result.toString());
    }

    @Test
    void integrationTest() {
        Polynomial result = operations.integration(polynomial1);
        double coeff = 2.0/3.0;
        resultCorrect = new Polynomial("0.25x^4 -" + coeff + "x^3 + 3x^2 - 5x");
        Assertions.assertEquals(resultCorrect.toString(), result.toString());

        resultCorrect = new Polynomial("0.25x^4 -" + coeff + "x^3 - 3x^2 - 5x");
        Assertions.assertNotEquals(resultCorrect.toString(), result.toString());
    }


}
