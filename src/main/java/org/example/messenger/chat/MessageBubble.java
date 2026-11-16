package org.example.messenger.chat;

import javax.swing.*;
import java.awt.*;

public class MessageBubble extends JPanel{
    private JLabel text;

    MessageBubble(Message message, String currentUser){
        this.text = new JLabel();

        text.setFont(new Font("Arial", Font.PLAIN, 14));
        setOpaque(false);
        text.setBorder(
                BorderFactory.createEmptyBorder(10, 15, 10, 15)
        );

        add(text);

        updateMessage(message, currentUser);
    }

    public void updateMessage(Message message, String currentUser) {
        text.setText(message.getText());

        boolean isOwner = message.isOwner(currentUser);

        if (isOwner) {
            setBackground(new Color(190, 240, 200));
        } else {
            setBackground(new Color(230, 230, 230));
        }

        text.setForeground(Color.BLACK);

        repaint();
    }

    @Override
    protected void paintComponent(Graphics g){
        Graphics2D g2 = (Graphics2D) g.create();

        g2.setRenderingHint(
                RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON
        );

        g2.setColor(getBackground());

        g2.fillRoundRect(
                0, 0,
                getWidth(),
                getHeight(),
                20, 20
        );

        g2.dispose();
    }
}
