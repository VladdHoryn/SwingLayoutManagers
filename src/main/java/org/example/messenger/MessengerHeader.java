package org.example.messenger;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class MessengerHeader extends JPanel {
    private final JLabel chatName;
    private final JLabel chatStatus;

    public MessengerHeader(String chatName){
        this.setLayout(new BorderLayout());

        this.chatName = new JLabel();
        this.chatStatus = new JLabel();

        this.chatName.setText(chatName);
        this.chatStatus.setText("online");
        this.chatStatus.setForeground(new Color(34, 177, 76));

        this.add(this.chatName, BorderLayout.WEST);
        this.add(this.chatStatus, BorderLayout.EAST);

        setBorder(new EmptyBorder(10, 5, 10, 5));
        setBackground(Color.GRAY);
    }
}
