package org.example;

import org.example.calculator.CalculatorPanel;
import org.example.messenger.MessengerPanel;
import org.example.website.WebsitePanel;

import javax.swing.*;
import java.awt.*;

public class TabbedPane extends JTabbedPane {
    private final CalculatorPanel calculatorPanel;
    private final WebsitePanel websitePanel;
    private final MessengerPanel messengerPanel;

    TabbedPane(){
        calculatorPanel = new CalculatorPanel();
        websitePanel = new WebsitePanel();
        messengerPanel = new MessengerPanel();

        JPanel wrapper = new JPanel(new GridBagLayout());

        wrapper.add(calculatorPanel);

        this.addTab("Calculator", wrapper);
        this.addTab("Website", websitePanel);
        this.addTab("Messenger", messengerPanel);
    }
}
