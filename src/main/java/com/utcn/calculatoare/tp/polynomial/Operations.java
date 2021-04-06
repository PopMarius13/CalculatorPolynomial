package com.utcn.calculatoare.tp.polynomial;

import java.util.List;

public interface Operations<T> {
    T addition(T polynomial1 , T polynomial2);
    T subtraction(T polynomial1 , T polynomial2);
    T multiplication(T polynomial1 , T polynomial2);
    List<T> division(T polynomial1 , T polynomial2);
    T derivative(T polynomial);
    T integration(T polynomial);

}
