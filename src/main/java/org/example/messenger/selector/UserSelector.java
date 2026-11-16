package org.example.messenger.selector;

import javax.swing.*;
import java.awt.*;

public class UserSelector extends JPanel {

    private final JComboBox<String> users;

    public UserSelector() {
        setLayout(new FlowLayout(FlowLayout.LEFT));

        users = new JComboBox<>(new String[]{
                "Vlad",
                "Ann"
        });

        add(new JLabel("Current user:"));
        add(users);

        users.addActionListener(e -> {
            firePropertyChange(
                    "currentUser",
                    null,
                    getCurrentUser()
            );
        });
    }

    public String getCurrentUser() {
        return (String) users.getSelectedItem();
    }

    public void addUser(String username) {
        users.addItem(username);
    }
}
