package com.utcn.calculatoare.tp.polynomial;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PolynomialValidator {

    private static final String REGEX_EXTRACTING_MONOMIAL_GROUP = "(([-+]([0-9]{1,13}(\\.[0-9]{1,13})?)+(?=x))?(-?[xX])(\\^(-?\\d+))?)|" +
                                                                "([-+][xX])|" +
                                                                "([-+]([0-9]{1,13}(\\.[0-9]{1,13})?)+)|" +
                                                                "(((-?\\+?)([0-9]{1,13}(\\.[0-9]{1,13})?)+(?=x))?(-?[xX])(\\^(-?\\d+))?)|" +
                                                                "((-?\\+?)[xX])|" +
                                                                "((-?\\+?)([0-9]{1,13}(\\.[0-9]{1,13})?)+)";
    private static final Pattern PATTERN_EXTRACTING_MONOMIAL_GROUP = Pattern.compile(REGEX_EXTRACTING_MONOMIAL_GROUP);

    public static boolean validatePolynomial(String polynomial) {
        if (polynomial.isEmpty()) {
            return false;
        }

        Matcher matcherExtractingMonomialGroup = PATTERN_EXTRACTING_MONOMIAL_GROUP.matcher(polynomial);
        int sizeGroups = 0;

        while (matcherExtractingMonomialGroup.find()) {
            sizeGroups += matcherExtractingMonomialGroup.group().length();
        }

        return sizeGroups == polynomial.length();
    }
}
