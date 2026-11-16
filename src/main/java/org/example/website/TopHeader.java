package org.example.website;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class TopHeader extends JPanel {
    TopHeader(){
        this.setBackground(Color.BLUE);

        this.setLayout(new BoxLayout(this, BoxLayout.X_AXIS));

        this.add(Box.createHorizontalGlue());

        this.add(new JButton("click"));
        this.add(new JButton("click"));
        this.add(new JButton("click"));
        this.add(new JButton("click"));

        this.setBorder(new EmptyBorder(0, 5, 0, 5));
    }
}
