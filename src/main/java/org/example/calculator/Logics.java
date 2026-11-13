package org.example.calculator;

import javax.swing.*;

public class Logics {
    private final Display display;
    private final Keys keys;

    Logics(Display display, Keys keys){
        this.display = display;
        this.keys = keys;
    }

    public void press(String k){
        switch (k){
            case "C": {
                display.getValue().setText("1");
            }
        }
    }
}
