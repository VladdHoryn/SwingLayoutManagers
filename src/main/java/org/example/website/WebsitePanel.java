package org.example.website;

import javax.swing.*;
import java.awt.*;

public class WebsitePanel extends JPanel {
    private final HeaderPanel header;

    public WebsitePanel(){
        this.setLayout(new BorderLayout());

        this.header = new HeaderPanel(new TopHeader(), new BottomHeader());

        this.add(header, BorderLayout.NORTH);
    }
}
