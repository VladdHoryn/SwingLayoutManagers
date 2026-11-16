package org.example.messenger;

import lombok.Getter;
import org.example.messenger.chat.ChatPanel;
import org.example.messenger.chat.Message;
import org.example.messenger.header.MessengerHeader;
import org.example.messenger.selector.UserSelector;
import org.example.messenger.send.SendPanel;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class MessengerPanel extends JPanel {
    @Getter
    private String currentUser = "Vlad";

    private final MessengerHeader header;
    private final ChatPanel chat;
    private final SendPanel send;
    private final UserSelector userSelector;

    public MessengerPanel(){
        this.setLayout(new BorderLayout());

        userSelector = new UserSelector();
        this.header = new MessengerHeader("New Chat");
        this.chat = new ChatPanel("Vlad");
        send = new SendPanel(chat);

        add(header, BorderLayout.NORTH);
        add(userSelector, BorderLayout.EAST);
        add(chat, BorderLayout.CENTER);
        add(send, BorderLayout.SOUTH);

        userSelector.addPropertyChangeListener("currentUser",
                e -> setCurrentUser());


        chat.addMessage(new Message("Hi, How is t going?", "Vlad"));
        chat.addMessage(new Message("Hi, not too bad", "Ann"));
        chat.addMessage(new Message("How about you?", "Ann"));

        this.setBackground(Color.GRAY);
        this.setBorder(new EmptyBorder(20, 10, 20, 10));
    }

    public void setCurrentUser() {
        currentUser = userSelector.getCurrentUser();
        chat.updateCurrentUser(currentUser);
    }
}
