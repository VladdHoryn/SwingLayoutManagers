package org.example.website.button;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.RoundRectangle2D;

public class IconButton extends JButton {

    private Color backgroundColor = new Color(0, 0, 0, 0);
    private Color hoverColor = new Color(255, 255, 255, 35);
    private Color pressedColor = new Color(255, 255, 255, 65);

    public IconButton(Icon icon) {
        super(icon);

        setPreferredSize(new Dimension(36, 36));
        setMinimumSize(new Dimension(36, 36));
        setMaximumSize(new Dimension(36, 36));

        setFocusPainted(false);
        setBorderPainted(false);
        setContentAreaFilled(false);
        setOpaque(false);

        setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

        setMargin(new Insets(0, 0, 0, 0));
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
                9, 9
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
}
