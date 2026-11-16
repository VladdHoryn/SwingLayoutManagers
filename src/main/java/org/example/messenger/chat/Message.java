package org.example.messenger.chat;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class Message {
    private final String text;
    private final String owner;

    public boolean isOwner(String name) {
        return this.owner.equals(name);
    }
}
