package com.utcn.calculatoare.tp.polynomial;

import java.util.ArrayList;
import java.util.List;

public class PolynomialOperations implements Operations<Polynomial> {

    @Override
    public Polynomial addition(Polynomial polynomial1, Polynomial polynomial2) {
        return additionOrSubtraction(polynomial1, polynomial2, true);
    }

    @Override
    public Polynomial subtraction(Polynomial polynomial1, Polynomial polynomial2) {
        return additionOrSubtraction(polynomial1, polynomial2, false);
    }

    @Override
    public Polynomial multiplication(Polynomial polynomial1, Polynomial polynomial2) {
        Polynomial result = new Polynomial();

        for (Monomial monomial1 : polynomial1.getMonomials()) {
            result = addition(result, multiplicationMonomialWithPolynomial(monomial1, polynomial2));
        }

        return result;
    }

    @Override
    public List<Polynomial> division(Polynomial polynomial1, Polynomial polynomial2) {
        if(polynomial2.getMonomials().size() == 0) {
            return null;
        }

        polynomial1.sortMonomials();
        polynomial2.sortMonomials();

        Polynomial quotient = new Polynomial();
        Polynomial remainder = new Polynomial(polynomial1.toString());

        while (remainder.getMonomials().size() > 0 && getHighestDegree(remainder) >= getHighestDegree(polynomial2)) {
            double coefficient = (getHighestCoefficient(remainder) / getHighestCoefficient(polynomial2));
            int degree = (int) (getHighestDegree(remainder) - getHighestDegree(polynomial2));

            quotient.putMonomial(degree, coefficient);
            remainder = subtraction(remainder, multiplicationMonomialWithPolynomial(new Monomial(degree, coefficient), polynomial2));
        }

        List<Polynomial> result = new ArrayList<>();
        result.add(quotient);
        result.add(remainder);

        return result;
    }

    @Override
    public Polynomial derivative(Polynomial polynomial) {
        Polynomial result = new Polynomial();
        for (Monomial monomial : polynomial.getMonomials()) {
            if (monomial.getDegree() > 0) {
                result.putMonomial(monomial.getDegree() - 1, monomial.getCoefficient() * monomial.getDegree());
            }
        }
        return result;
    }

    @Override
    public Polynomial integration(Polynomial polynomial) {
        Polynomial result = new Polynomial();
        for (Monomial monomial : polynomial.getMonomials()) {
            result.putMonomial(monomial.getDegree() + 1, monomial.getCoefficient() / (monomial.getDegree() + 1));
        }
        return result;
    }

    private Polynomial additionOrSubtraction(Polynomial polynomial1, Polynomial polynomial2, boolean operator) {
        Polynomial result = new Polynomial();

        for (Monomial monomial1 : polynomial1.getMonomials()) {
            if (polynomial2.getMonomials().contains(monomial1)) {
                for (Monomial monomial2 : polynomial2.getMonomials()) {
                    if (monomial2.equals(monomial1)) {
                        if (getCalcCoefficient(monomial1, monomial2, operator) != 0) {
                            result.putMonomial(monomial1.getDegree(), getCalcCoefficient(monomial1, monomial2, operator));
                        }
                    }
                }
            } else {
                result.putMonomial(monomial1.getDegree(), monomial1.getCoefficient());
            }
        }

        for (Monomial monomial : polynomial2.getMonomials()) {
            if (!polynomial1.getMonomials().contains(monomial)) {
                result.putMonomial(monomial.getDegree(), signalOfOperation(monomial.getCoefficient(), operator));
            }
        }
        return result;
    }

    private double getCalcCoefficient(Monomial monomial1, Monomial monomial2, boolean operator) {
        return monomial1.getCoefficient() + signalOfOperation(monomial2.getCoefficient(), operator);
    }

    private double signalOfOperation(double x, boolean signal) {
        return (signal) ? x : -x;
    }

    private double getHighestDegree(Polynomial polynomial) {
        return polynomial.getMonomials().get(0).getDegree();
    }

    private double getHighestCoefficient(Polynomial polynomial) {
        return polynomial.getMonomials().get(0).getCoefficient();
    }

    private Polynomial multiplicationMonomialWithPolynomial(Monomial monomial, Polynomial polynomial) {
        Polynomial result = new Polynomial();

        for (Monomial monomial1 : polynomial.getMonomials()) {
            result.putMonomial(monomial.getDegree() + monomial1.getDegree(),
                    monomial.getCoefficient() * monomial1.getCoefficient());
        }

        return result;
    }

}
