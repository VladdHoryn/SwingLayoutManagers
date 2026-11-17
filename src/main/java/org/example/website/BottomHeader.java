package org.example.website;

import org.example.website.button.TextButton;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class BottomHeader extends JPanel {

    BottomHeader() {
        setBackground(new Color(35, 45, 65));

        setLayout(new BoxLayout(this, BoxLayout.X_AXIS));

        setBorder(new EmptyBorder(0, 8, 0, 8));

        add(createButton("Home"));
        add(Box.createHorizontalStrut(6));

        add(createButton("Products"));
        add(Box.createHorizontalStrut(6));

        add(createButton("Services"));
        add(Box.createHorizontalStrut(6));

        add(createButton("About"));

        add(Box.createHorizontalGlue());

        this.setBorder(BorderFactory.createMatteBorder(1,0,0,0, Color.BLACK));
    }

    private TextButton createButton(String text) {

        TextButton button = new TextButton(text);

        return button;
    }
}
