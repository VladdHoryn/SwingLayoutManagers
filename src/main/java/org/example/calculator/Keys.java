package org.example.calculator;

import javax.swing.*;
import java.awt.*;

public class Keys extends JPanel {
    private final Logics logics;

    public Keys(Logics logics){
        this.logics = logics;

        this.setLayout(new GridLayout(5,4 ));

        String[] labels = {
                "C", "±", "%", "÷",
                "7", "8", "9", "×",
                "4", "5", "6", "−",
                "1", "2", "3", "+",
                "⌫", "0", ".", "="
        };

        for (String label : labels) {
            JButton b = new JButton(label);
            b.setFont(b.getFont().deriveFont(16f));
            b.addActionListener(e -> logics.press(label));

            this.add(b);
        }
    }
}
