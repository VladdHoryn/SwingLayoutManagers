package org.example.website;

import javax.swing.*;
import java.awt.*;

public class LeftPanel extends JPanel {
    public LeftPanel(){
        this.setLayout(new GridBagLayout());

        this.add(new Label("Left Panel"));

        this.setBorder(BorderFactory.createMatteBorder(
                2, 0, 0, 2, Color.BLACK
        ));
    }
}
