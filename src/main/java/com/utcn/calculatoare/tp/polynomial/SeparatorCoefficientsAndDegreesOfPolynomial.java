package com.utcn.calculatoare.tp.polynomial;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SeparatorCoefficientsAndDegreesOfPolynomial {

    private static final String REGEX_EXTRACTING_MONOMIAL_GROUP = "(([-+]([0-9]{1,13}(\\.[0-9]{1,13})?)+(?=x))?(-?[xX])(\\^(-?\\d+))?)|" +
                                                                    "([-+][xX])|" +
                                                                    "([-+]([0-9]{1,13}(\\.[0-9]{1,13})?)+)|" +
                                                                    "(((-?\\+?)([0-9]{1,13}(\\.[0-9]{1,13})?)+(?=x))?(-?[xX])(\\^(-?\\d+))?)|" +
                                                                    "((-?\\+?)[xX])|" +
                                                                    "((-?\\+?)([0-9]{1,13}(\\.[0-9]{1,13})?)+)";
    private static final Pattern PATTERN_EXTRACTING_MONOMIAL_GROUP = Pattern.compile(REGEX_EXTRACTING_MONOMIAL_GROUP);


    public static void extractingCoefficientsDegrees(String polynomial, List<Monomial> coefficientOfDegree) {
        Matcher matcherExtractingMonomialGroup = PATTERN_EXTRACTING_MONOMIAL_GROUP.matcher(polynomial);

        while (matcherExtractingMonomialGroup.find()) {
            String monomialGroup = matcherExtractingMonomialGroup.group();
            putCoefficientAndDegree(monomialGroup, coefficientOfDegree);
        }
    }

    public static void putCoefficientAndDegree(String monomialGroup, List<Monomial> coefficientOfDegree) {
        String[] numbers = monomialGroup.split("([xX]+\\^)|([xX])| ");

        if (numbers.length == 2 && !(numbers[0].equals("+") || numbers[0].equals("-") || numbers[0].equals(""))) {
            coefficientOfDegree.add(new Monomial(Integer.parseInt(numbers[1]), Double.parseDouble(numbers[0])));
        } else {
            if (numbers.length == 2) {
                numbers[0] = numbers[1];
            } else if (numbers.length == 1 && (numbers[0].equals("+") || numbers[0].equals("-"))) {
                numbers[0] = numbers[0] + "1";
            }
            if (monomialGroup.contains("^")) {
                int coefficient = (monomialGroup.contains("-")? -1 : 1);
                coefficientOfDegree.add(new Monomial(Integer.parseInt(numbers[0]), coefficient));
            } else {
                if (monomialGroup.contains("x") || monomialGroup.contains("X")) {
                    if (numbers.length == 0) {
                        int coefficient = (monomialGroup.contains("-")? -1 : 1);
                        coefficientOfDegree.add(new Monomial(1, coefficient));
                    } else {
                        coefficientOfDegree.add(new Monomial(1, Double.parseDouble(numbers[0])));
                    }
                } else {
                    coefficientOfDegree.add(new Monomial(0, Double.parseDouble(numbers[0])));
                }
            }
        }
    }
}
