package com.utcn.calculatoare.tp.polynomial;

public class Main {

    public static void main(String[] args) {

        Polynomial polynomial1 = new Polynomial("x^3-x^2+6.56x-6");
        PolynomialOperations operations = new PolynomialOperations();

        Polynomial polynomial2 = new Polynomial("x^2-2");
        System.out.println(polynomial1 + "      +     " + polynomial2);
        System.out.println(operations.addition(polynomial1, polynomial2));
        System.out.println("--------------");

        polynomial2 = new Polynomial("x-2");
        System.out.println(polynomial1 + "     -     " + polynomial2);
        System.out.println(operations.subtraction(polynomial1, polynomial2));
        System.out.println("--------------");

        polynomial2 = new Polynomial("x-2");
        System.out.println(polynomial1 + "    *    " + polynomial2);
        System.out.println(operations.multiplication(polynomial1, polynomial2));
        System.out.println("--------------");

        polynomial1 = new Polynomial("x^3-2x^2+6x-5");
        polynomial2 = new Polynomial("x^2-1");
        System.out.println(polynomial1 + "    /     " + polynomial2);
        System.out.println(operations.division(polynomial1, polynomial2).get(0));
        System.out.println(operations.division(polynomial1, polynomial2).get(1));
        System.out.println("--------------");

        System.out.println(polynomial1);
        System.out.println(operations.derivative(polynomial1));
        System.out.println("--------------");

        System.out.println(polynomial1);
        System.out.println(operations.integration(polynomial1));

        System.out.println(polynomial2.equals(new Polynomial("x^2-1")));

    }


}

