package org.example.website;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class BottomHeader extends JPanel {
    BottomHeader(){
        this.setBackground(Color.RED);
        this.setLayout(new BoxLayout(this, BoxLayout.X_AXIS));

        this.add(new JButton("click"));
        this.add(new JButton("click"));
        this.add(new JButton("click"));
        this.add(new JButton("click"));

        this.add(Box.createHorizontalGlue());

        this.setBorder(new EmptyBorder(0, 5, 0, 5));
    }
}
