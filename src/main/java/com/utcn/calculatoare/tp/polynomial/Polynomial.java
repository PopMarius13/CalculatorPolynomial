package com.utcn.calculatoare.tp.polynomial;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Polynomial {

    private final List<Monomial> monomials = new ArrayList<>();

    public Polynomial(String polynomial) {
        setPolynomial(polynomial);
    }

    public Polynomial() {
    }

    public void setPolynomial(String polynomial) {
        polynomial = polynomial.replace(" ", "");
        if (PolynomialValidator.validatePolynomial(polynomial)) {
            SeparatorCoefficientsAndDegreesOfPolynomial.extractingCoefficientsDegrees(polynomial, monomials);
        }
    }

    public void putMonomial(int degree, double coefficient) {
        monomials.add(new Monomial(degree, coefficient));
    }

    public List<Monomial> getMonomials() {
        return monomials;
    }

    public void sortMonomials() {
        Collections.sort(monomials);
    }

    public String getMonomialString(Monomial monomial) {
        String monomialString;
        DecimalFormat df = new DecimalFormat("#.##");
        if (monomials.get(0).equals(monomial)) {
            monomialString = (monomial.getCoefficient() == 1 && monomial.getDegree() != 0) ?
                    "" : df.format(monomial.getCoefficient()) + "";
        } else {
            monomialString = (monomial.getCoefficient() > 0) ? " +" : " ";
            monomialString += (monomial.getCoefficient() == 1 && monomial.getDegree() != 0) ?
                    "" : df.format(monomial.getCoefficient()) + "";
        }
        monomialString += (monomial.getDegree() > 0) ? "x" : "";
        monomialString += (monomial.getDegree() > 1) ? "^" + monomial.getDegree() : "";

        return monomialString;
    }

    @Override
    public String toString() {
        if (getMonomials().size() == 0) {
            return "0";
        }

        StringBuilder polynomial = new StringBuilder();
        sortMonomials();

        for (Monomial monomial : monomials) {
            polynomial.append(getMonomialString(monomial));
        }
        return polynomial.toString();
    }

}
