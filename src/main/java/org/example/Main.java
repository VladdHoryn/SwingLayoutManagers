package org.example;

import org.example.calculator.MainPanel;

import javax.swing.*;
import java.awt.*;

public class Main {
    public static void main(String[] args) {
        JFrame mainFrame = new JFrame();

        mainFrame.setLayout(new GridBagLayout());

        mainFrame.add(new MainPanel());

        mainFrame.setSize(600, 700);
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrame.setLocationRelativeTo(null);
        mainFrame.setVisible(true);
    }
}
