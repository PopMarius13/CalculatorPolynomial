package com.utcn.calculatoare.tp.polynomial;

import java.util.Objects;

public class Monomial implements Comparable<Monomial>{
    private double coefficient;
    private int degree;

    public Monomial(int degree, double coefficient) {
        this.coefficient = coefficient;
        this.degree = degree;
    }

    public double getCoefficient() {
        return coefficient;
    }

    public void setCoefficient(double coefficient) {
        this.coefficient = coefficient;
    }

    public int getDegree() {
        return degree;
    }

    public void setDegree(int degree) {
        this.degree = degree;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Monomial monomial = (Monomial) o;
        return degree == monomial.degree;
    }

    @Override
    public int hashCode() {
        return Objects.hash(coefficient, degree);
    }

    @Override
    public String toString() {
        return coefficient + "x^" + degree;
    }

    @Override
    public int compareTo(Monomial o) {
        return Double.compare(o.getDegree() , this.getDegree());
    }
}
