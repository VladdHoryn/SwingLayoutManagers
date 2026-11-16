package org.example.messenger;

import javax.swing.*;
import java.awt.*;

public class MessengerPanel extends JPanel {
    private final MessengerHeader header;

    public MessengerPanel(){
        this.setLayout(new BorderLayout());

        this.header = new MessengerHeader("New Chat");

        add(header, BorderLayout.NORTH);
    }
}
