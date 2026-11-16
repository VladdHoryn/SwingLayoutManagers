package org.example.calculator;

import javax.swing.*;


public class Logics {
    private final Display display;

    private double firstNumber = 0;
    private String operator = "";
    private boolean newNumber = true;
    private boolean calculated = false;
    private boolean ifFirstOnDisplay = true;

    Logics(Display display){
        this.display = display;
    }

    public void press(String k){
        String value = display.getValue().getText();

        switch (k) {

            case "C": {
                display.getValue().setText("0");
                display.getHistory().setText("");

                firstNumber = 0;
                operator = "";
                newNumber = true;
                calculated = false;
                ifFirstOnDisplay = true;
                break;
            }

            case "⌫": {
                if (!newNumber && value.length() > 1) {
                    value = value.substring(0, value.length() - 1);

                    if (value.equals("-")) {
                        value = "0";
                        newNumber = true;
                    }

                    display.getValue().setText(value);
                } else {
                    display.getValue().setText("0");
                    newNumber = true;
                }
                break;
            }

            case "±": {
                if (!value.equals("0")) {
                    if (value.startsWith("-")) {
                        value = value.substring(1);
                    } else {
                        value = "-" + value;
                    }
                    display.getValue().setText(value);
                }
                break;
            }

            case "%": {
                double number = Double.parseDouble(value);
                number /= 100;
                display.getValue().setText(format(number));

                display.getHistory().setText(value + "%");
                newNumber = true;
                calculated = false;
                break;
            }

            case ".": {
                if (newNumber) {
                    display.getValue().setText("0.");
                    newNumber = false;
                } else if (!value.contains(".")) {
                    display.getValue().setText(value + ".");
                }
                break;
            }

            case "+":
            case "−":
            case "×":
            case "÷": {
                if (calculated) {
                    display.getHistory().setText(value);
                    calculated = false;
                }

                else if (!operator.isEmpty() && !newNumber) {
                    calculate();
                    value = display.getValue().getText();
                }

                firstNumber = Double.parseDouble(value);

                if (operator.isEmpty() || !newNumber) {
                    if(ifFirstOnDisplay){
                        display.getHistory().setText(
                                display.getValue().getText() + " " + k + " "
                        );
                    }
                    else{
                        display.getHistory().setText(
                                display.getHistory().getText() + " " + k + " "
                        );
                    }
                } else {
                    String history = display.getHistory().getText();

                    if (!history.isEmpty()) {
                        history = history.substring(0, history.length() - 2);
                    }

                    display.getHistory().setText(history + " " + k + " ");
                }

                operator = k;
                newNumber = true;
                break;
            }

            case "=": {
                if (operator.isEmpty()) {
                    break;
                }

                calculate();

                if (!display.getValue().getText().equals("Error")) {
                    operator = "";
                    calculated = true;
                }

                newNumber = true;
                break;
            }

            default: {
                if (k.matches("[0-9]")) {
                    if (calculated) {
                        display.getHistory().setText("");
                        calculated = false;
                        operator = "";
                        ifFirstOnDisplay = true;
                    }

                    if (newNumber || value.equals("0")) {
                        display.getValue().setText(k);
                        newNumber = false;
                    } else {
                        display.getValue().setText(value + k);
                    }
                }
                break;
            }
        }
    }

    private void calculate() {
        String value = display.getValue().getText();
        double secondNumber = Double.parseDouble(value);

        double result = 0;

        switch (operator) {
            case "+":
                result = firstNumber + secondNumber;
                break;

            case "−":
                result = firstNumber - secondNumber;
                break;

            case "×":
                result = firstNumber * secondNumber;
                break;

            case "÷":
                if (secondNumber == 0) {
                    display.getValue().setText("Error");
                    display.getHistory().setText("Division by zero");

                    operator = "";
                    newNumber = true;
                    calculated = false;
                    return;
                }

                result = firstNumber / secondNumber;
                break;
        }

        String resultText = format(result);

        display.getHistory().setText(
                display.getHistory().getText()
                        + value + " = " + resultText
        );

        display.getValue().setText(resultText);

        firstNumber = result;
    }

    private String format(double number) {
        if (number == (long) number) {
            return String.valueOf((long) number);
        }

        return String.valueOf(number);
    }
}
