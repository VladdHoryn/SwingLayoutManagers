package org.example.calculator;

import javax.swing.*;
import java.awt.*;

public class MainPanel extends JPanel {
    private final Display display;
    private final Keys keys;

    public MainPanel(){
        this.setLayout(new BorderLayout());

        display = new Display();
        keys = new Keys();

        this.add(display, BorderLayout.NORTH);
        this.add(keys, BorderLayout.CENTER);

        this.setPreferredSize(new Dimension(300, 400));
        this.setBackground(Color.GRAY);
    }
}
