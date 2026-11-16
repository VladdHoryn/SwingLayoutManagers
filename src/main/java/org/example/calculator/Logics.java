package org.example.calculator;

import javax.swing.*;


public class Logics {
    private final Display display;

    private double firstNumber = 0;
    private String operator = "";
    private boolean newNumber = true;

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
                firstNumber = Double.parseDouble(value);
                display.getHistory().setText(
                        display.getHistory().getText() + value + " " + k + " "
                );
                operator = k;
                newNumber = true;
                break;
            }

            case "=": {
                if (operator.isEmpty()) {
                    break;
                }

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
                            return;
                        }
                        result = firstNumber / secondNumber;
                        break;
                }

                String resultText = format(result);

                display.getHistory().setText(
                        display.getHistory().getText() + value + " = " + resultText
                );

                display.getValue().setText(resultText);

                operator = "";
                newNumber = true;
                break;
            }

            default: {
                if (k.matches("[0-9]")) {
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
    private String format(double number) {
        if (number == (long) number) {
            return String.valueOf((long) number);
        }

        return String.valueOf(number);
    }
}
