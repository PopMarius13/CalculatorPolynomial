package com.utcn.calculatoare.tp;

import com.utcn.calculatoare.tp.polynomial.Monomial;
import com.utcn.calculatoare.tp.polynomial.SeparatorCoefficientsAndDegreesOfPolynomial;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class SeparatorCoefficientsAndDegreesOfPolynomialTest {

    private static String polynomial;
    private static List<Monomial>  coefficientOfDegree;

    @BeforeAll
    public static void setUp() {
        polynomial = "-22.4x^7+4.6x^5-3x^4+9x^2-x-6";
        coefficientOfDegree = new ArrayList<>();
        coefficientOfDegree.add(new Monomial(7, -22.4));
        coefficientOfDegree.add(new Monomial(0, -6));
        coefficientOfDegree.add(new Monomial(1, -1));
        coefficientOfDegree.add(new Monomial(2, 9));
        coefficientOfDegree.add(new Monomial(4, -3));
        coefficientOfDegree.add(new Monomial(5, 4.6));
    }

    @Test
    void extractingCoefficientsDegreesTest() {
        List<Monomial> result = new ArrayList<>() {
        };
        SeparatorCoefficientsAndDegreesOfPolynomial.extractingCoefficientsDegrees(polynomial , result);

        Assertions.assertNotNull(result);
        for(Monomial monomial : coefficientOfDegree) {
            Assertions.assertTrue(result.contains(monomial));
            for(Monomial monomial1 : result) {
                if(monomial.getDegree() == monomial1.getDegree()) {
                    Assertions.assertEquals(monomial.getCoefficient() , monomial1.getCoefficient());
                }
            }
        }
    }

}
