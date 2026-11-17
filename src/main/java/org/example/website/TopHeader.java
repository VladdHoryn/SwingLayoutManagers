package org.example.website;

import org.example.website.button.IconButton;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.net.URL;

public class TopHeader extends JPanel {

    private static final int ICON_MAX_SIZE = 20;
    private static final int BUTTON_SIZE = 36;
    private static final int BUTTON_GAP = 6;

    TopHeader() {
        setBackground(new Color(35, 45, 65));

        setLayout(new BoxLayout(this, BoxLayout.X_AXIS));

        setBorder(new EmptyBorder(0, 8, 0, 8));

        add(Box.createHorizontalGlue());

        add(createButton("/icons/search.jpg"));
        add(Box.createHorizontalStrut(6));

        add(createButton("/icons/bell.jpg"));
        add(Box.createHorizontalStrut(6));

        add(createButton("/icons/settings.jpg"));
        add(Box.createHorizontalStrut(6));

        add(createButton("/icons/user.jpg"));
    }

    private IconButton createButton(String path) {

        Icon icon = loadIcon(path, ICON_MAX_SIZE);

        IconButton button = new IconButton(icon);

        button.setPreferredSize(
                new Dimension(BUTTON_SIZE, BUTTON_SIZE)
        );

        button.setMinimumSize(
                new Dimension(BUTTON_SIZE, BUTTON_SIZE)
        );

        button.setMaximumSize(
                new Dimension(BUTTON_SIZE, BUTTON_SIZE)
        );

        return button;
    }

    private Icon loadIcon(String path, int maxSize) {

        URL resource = getClass().getResource(path);

        if (resource == null) {
            throw new IllegalArgumentException(
                    "Icon not found: " + path
            );
        }

        ImageIcon original = new ImageIcon(resource);

        int originalWidth = original.getIconWidth();
        int originalHeight = original.getIconHeight();

        if (originalWidth <= 0 || originalHeight <= 0) {
            throw new IllegalArgumentException(
                    "Invalid icon: " + path
            );
        }

        // Preserve aspect ratio
        double scale = Math.min(
                1.0,
                Math.min(
                        (double) maxSize / originalWidth,
                        (double) maxSize / originalHeight
                )
        );

        int width = Math.max(1, (int) Math.round(originalWidth * scale));
        int height = Math.max(1, (int) Math.round(originalHeight * scale));

        Image scaledImage = original.getImage().getScaledInstance(
                width,
                height,
                Image.SCALE_SMOOTH
        );

        return new ImageIcon(scaledImage);
    }
}
