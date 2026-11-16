package org.example.messenger.header;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.geom.Path2D;

public class MessengerHeader extends JPanel {
    private final JLabel chatName;
    private final JLabel chatStatus;

    public MessengerHeader(String chatName){
        this.setLayout(new BorderLayout());

        this.chatName = new JLabel();
        this.chatStatus = new JLabel();

        this.chatName.setText(chatName);
        this.chatName.setFont(new Font("Arial", Font.PLAIN, 18));

        this.chatStatus.setText("online");
        this.chatStatus.setForeground(new Color(34, 177, 76));
        this.chatStatus.setFont(new Font("Arial", Font.PLAIN, 11));

        this.add(this.chatName, BorderLayout.WEST);
        this.add(this.chatStatus, BorderLayout.EAST);

        setBorder(new EmptyBorder(10, 5, 10, 5));
        setBackground(new Color(220, 220, 220));

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

        int radius = 20;
        int width = getWidth();
        int height = getHeight();

        Path2D path = new Path2D.Float();

        path.moveTo(0, radius);
        path.quadTo(0, 0, radius, 0);

        path.lineTo(width - radius, 0);
        path.quadTo(width, 0, width, radius);

        path.lineTo(width, height);
        path.lineTo(0, height);

        path.closePath();

        g2.fill(path);
        g2.dispose();
    }
}
