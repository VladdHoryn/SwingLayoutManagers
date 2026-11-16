package org.example.messenger.chat;

import lombok.Getter;

import javax.swing.*;
import java.awt.*;

@Getter
public class MessageRow extends JPanel {
    private MessageBubble bubble;
    private Message message;

    public MessageRow(Message message, String currentUser){
        this.bubble = new MessageBubble(message, currentUser);
        this.message = message;

        this.setLayout(new FlowLayout());

        updateMessage(message, currentUser);
    }

    public void updateMessage(Message message, String currentUser){
        removeAll();

        boolean isOwner = message.isOwner(currentUser);

        bubble.updateMessage(message, currentUser);

        if (isOwner) {
            add(bubble, BorderLayout.EAST);
        } else {
            add(bubble, BorderLayout.WEST);
        }

        revalidate();
        repaint();
    }
}
