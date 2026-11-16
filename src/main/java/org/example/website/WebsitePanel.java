package org.example.website;

import javax.swing.*;
import java.awt.*;

public class WebsitePanel extends JPanel {
    private final HeaderPanel header;
    private final LeftPanel left;
    private final RightPanel right;

    public WebsitePanel(){
        this.setLayout(new BorderLayout());

        this.header = new HeaderPanel(new TopHeader(), new BottomHeader());
        this.left = new LeftPanel();
        this.right = new RightPanel();

        this.add(header, BorderLayout.NORTH);
        this.add(left, BorderLayout.WEST);
        this.add(right, BorderLayout.EAST);
    }
}
