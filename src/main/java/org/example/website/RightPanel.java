package org.example.website;

import javax.swing.*;
import java.awt.*;

public class RightPanel extends JPanel {
    public RightPanel(){
        this.setLayout(new GridBagLayout());

        this.add(new Label("Right Panel"));

        this.setBorder(BorderFactory.createMatteBorder(
                2, 2, 0, 0, Color.BLACK
        ));
    }
}
