package org.example.messenger.send;

import org.example.messenger.chat.ChatPanel;
import org.example.messenger.chat.Message;

import javax.swing.*;
import java.awt.*;

public class SendPanel extends JPanel {
    private JTextField input;
    private JButton send;
    private final ChatPanel chat;

    public SendPanel(ChatPanel chat){
        setLayout(new BorderLayout());

        this.input = new JTextField();
        this.send = new JButton("Send");
        this.chat = chat;

        send.addActionListener(e -> sendMessage());

        add(input, BorderLayout.CENTER);
        add(send, BorderLayout.EAST);
    }

    private void sendMessage(){
        chat.addMessage(new Message(input.getText(), chat.getCurrentUser()));
    }
}
