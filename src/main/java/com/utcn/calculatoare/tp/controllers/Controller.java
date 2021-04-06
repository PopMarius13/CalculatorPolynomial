package com.utcn.calculatoare.tp.controllers;

import com.utcn.calculatoare.tp.polynomial.Polynomial;
import com.utcn.calculatoare.tp.polynomial.PolynomialOperations;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.util.List;

public class Controller {
    public TextField polynomial1;
    public TextField polynomial2;
    public Button add;
    public Button sub;
    public Button mul;
    public Button div;
    public Button der;
    public Button inte;
    public TextField result1;
    public TextField result2;
    public Label resultText1;
    public Label resultText2;

    public PolynomialOperations operations = new PolynomialOperations();

    public void initialize() {
        setVisibilityResult2(false);
    }

    public void handleClickAdd(){
        String polynomialString1 = polynomial1.getText();
        String polynomialString2 = polynomial2.getText();

        setVisibilityResult2(false);
        resultText1.setText("Result addition:");
        result1.setText(operations.addition(new Polynomial(polynomialString1) , new Polynomial(polynomialString2)).toString());
    }

    public void handleClickSub(){
        String polynomialString1 = polynomial1.getText();
        String polynomialString2 = polynomial2.getText();

        setVisibilityResult2(false);
        resultText1.setText("Result subtraction:");
        result1.setText(operations.subtraction(new Polynomial(polynomialString1) , new Polynomial(polynomialString2)).toString());
    }

    public void handleClickMul(){
        String polynomialString1 = polynomial1.getText();
        String polynomialString2 = polynomial2.getText();

        setVisibilityResult2(false);
        resultText1.setText("Result multiplication:");
        result1.setText(operations.multiplication(new Polynomial(polynomialString1) , new Polynomial(polynomialString2)).toString());
    }

    public void handleClickDiv(){
        String polynomialString1 = polynomial1.getText();
        String polynomialString2 = polynomial2.getText();

        List<Polynomial> result = operations.division(new Polynomial(polynomialString1) , new Polynomial(polynomialString2));

        setVisibilityResult2(true);
        resultText1.setText("Result quotient:");
        resultText2.setText("Result remainder:");
        result1.setText(result.get(0).toString());
        result2.setText(result.get(1).toString());
    }

    public void handleClickDer(){
        String polynomialString1 = polynomial1.getText();
        String polynomialString2 = polynomial2.getText();

        setVisibilityResult2(true);
        resultText1.setText("Result derivative polynomial1:");
        resultText2.setText("Result derivative polynomial1:");
        result1.setText(operations.derivative(new Polynomial(polynomialString1)).toString());
        result2.setText(operations.derivative(new Polynomial(polynomialString2)).toString());
    }

    public void handleClickInte(){
        String polynomialString1 = polynomial1.getText();
        String polynomialString2 = polynomial2.getText();

        setVisibilityResult2(true);
        resultText1.setText("Result integration polynomial1:");
        resultText2.setText("Result integration polynomial1:");
        result1.setText(operations.integration(new Polynomial(polynomialString1)).toString());
        result2.setText(operations.integration(new Polynomial(polynomialString2)).toString());
    }

    private void setVisibilityResult2(boolean visibility) {
        resultText2.setVisible(visibility);
        result2.setVisible(visibility);
    }
}
