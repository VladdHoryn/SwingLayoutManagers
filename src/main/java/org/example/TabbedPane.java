package org.example;

import org.example.calculator.CalculatorPanel;

import javax.swing.*;
import java.awt.*;

public class TabbedPane extends JTabbedPane {
    private final CalculatorPanel calculatorPanel;

    TabbedPane(){
        calculatorPanel = new CalculatorPanel();

        JPanel wrapper = new JPanel(new GridBagLayout());

        wrapper.add(calculatorPanel);

        this.addTab("Calculator", wrapper);
    }
}
