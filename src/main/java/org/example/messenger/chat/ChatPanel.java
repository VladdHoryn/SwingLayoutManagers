package org.example.messenger.chat;

import lombok.Getter;
import lombok.Setter;

import javax.swing.*;
import java.awt.*;

@Getter
@Setter
public class ChatPanel extends JPanel {
    private String currentUser;

    public ChatPanel(String currentUser) {
        this.currentUser = currentUser;

        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        setBackground(Color.GRAY);
    }

    public void updateCurrentUser(String currentUser) {
        for (Component component : getComponents()) {
            if (component instanceof MessageRow row) {
                row.updateMessage(
                        row.getMessage(),
                        currentUser
                );
            }
        }
    }

    public void addMessage(Message message) {
        MessageRow row = new MessageRow(message, currentUser);

        row.setAlignmentX(Component.LEFT_ALIGNMENT);

        add(row);

        revalidate();
        repaint();
    }
}
