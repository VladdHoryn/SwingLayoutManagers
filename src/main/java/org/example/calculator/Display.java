package org.example.calculator;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class Display extends JPanel {
    private final JLabel history;
    private final JLabel value;

    public Display(){
        this.setLayout(new BorderLayout());

        history = new JLabel("");
        value = new JLabel("0");

        history.setHorizontalAlignment(SwingConstants.RIGHT);
        value.setHorizontalAlignment(SwingConstants.RIGHT);

        value.setFont(value.getFont().deriveFont(Font.BOLD, 30f));

        this.add(history, BorderLayout.NORTH);
        this.add(value, BorderLayout.CENTER);

        this.setBorder(new EmptyBorder(10, 15, 10, 15));
        this.setBackground(Color.CYAN);
    }

    public JLabel getHistory() {
        return history;
    }

    public JLabel getValue() {
        return value;
    }
}
