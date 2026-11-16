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

        setOpaque(false);

        updateMessage(message, currentUser);
    }

    public void updateMessage(Message message, String currentUser){
        removeAll();

        boolean isOwner = message.isOwner(currentUser);
        this.message = message;

        bubble.updateMessage(message, currentUser);

        if (isOwner) {
            this.setLayout(new FlowLayout(FlowLayout.RIGHT));
            add(bubble);
        } else {
            this.setLayout(new FlowLayout(FlowLayout.LEFT));
            add(bubble);
        }

        revalidate();
        repaint();
    }

    @Override
    public Dimension getMaximumSize() {
        return new Dimension(
                Integer.MAX_VALUE,
                getPreferredSize().height
        );
    }
}
