package org.example.website.button;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.RoundRectangle2D;

public class TextButton extends JButton {

    private Color backgroundColor = new Color(0, 0, 0, 0);
    private Color hoverColor = new Color(255, 255, 255, 30);
    private Color pressedColor = new Color(255, 255, 255, 60);

    private int cornerRadius = 9;

    public TextButton(String text) {
        super(text);

        setFont(new Font("Arial", Font.PLAIN, 14));
        setForeground(Color.WHITE);

        setFocusPainted(false);
        setBorderPainted(false);
        setContentAreaFilled(false);
        setOpaque(false);

        setRolloverEnabled(true);

        setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

        setBorder(BorderFactory.createEmptyBorder(8, 14, 8, 14));
    }

    @Override
    protected void paintComponent(Graphics g) {

        Graphics2D g2 = (Graphics2D) g.create();

        g2.setRenderingHint(
                RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON
        );

        Color color = backgroundColor;

        if (getModel().isPressed()) {
            color = pressedColor;
        } else if (getModel().isRollover()) {
            color = hoverColor;
        }

        g2.setColor(color);

        g2.fill(new RoundRectangle2D.Float(
                0, 0,
                getWidth(),
                getHeight(),
                cornerRadius,
                cornerRadius
        ));

        g2.dispose();

        super.paintComponent(g);
    }

    public void setButtonColors(
            Color background,
            Color hover,
            Color pressed) {

        this.backgroundColor = background;
        this.hoverColor = hover;
        this.pressedColor = pressed;

        repaint();
    }

    public void setCornerRadius(int radius) {
        this.cornerRadius = radius;
        repaint();
    }
}
