module CalculatorPolynomial {
    requires javafx.controls;
    requires javafx.fxml;

    exports com.utcn.calculatoare.tp;
    exports com.utcn.calculatoare.tp.controllers;

    opens fxml;
}