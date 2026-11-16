package org.example.website;

import javax.swing.*;

public class HeaderPanel extends JPanel {
    private final TopHeader topHeader;
    private final BottomHeader bottomHeader;

    HeaderPanel(TopHeader topHeader, BottomHeader bottomHeader){
        this.topHeader = topHeader;
        this.bottomHeader = bottomHeader;

        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        this.add(topHeader);
        this.add(bottomHeader);
    }
}
