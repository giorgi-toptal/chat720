package com.peranidze.chat720.model;

import androidx.annotation.NonNull;

import java.util.List;

public class Message {
    private long id;
    @NonNull
    private User user;
    @NonNull
    private MessageType type;
    @NonNull
    private String body;
    private boolean hasSeen;
    private List<String> reactions;
    @NonNull
    private long timestamp;

    public Message(final long id, @NonNull final User user, @NonNull final MessageType type, @NonNull final String body, final boolean hasSeen, final List<String> reactions, final long timestamp) {
        this.id = id;
        this.user = user;
        this.type = type;
        this.body = body;
        this.hasSeen = hasSeen;
        this.reactions = reactions;
        this.timestamp = timestamp;
    }

    public long getId() {
        return this.id;
    }

    public void setId(final long id) {
        this.id = id;
    }

    @NonNull
    public User getUser() {
        return this.user;
    }

    public void setUser(@NonNull final User user) {
        this.user = user;
    }

    @NonNull
    public MessageType getType() {
        return this.type;
    }

    public void setType(@NonNull final MessageType type) {
        this.type = type;
    }

    @NonNull
    public String getBody() {
        return this.body;
    }

    public void setBody(@NonNull final String body) {
        this.body = body;
    }

    public boolean hasSeen() {
        return this.hasSeen;
    }

    public void hasSeen(final boolean hasSeen) {
        this.hasSeen = hasSeen;
    }

    public List<String> getReactions() {
        return this.reactions;
    }

    public void setReactions(final List<String> reactions) {
        this.reactions = reactions;
    }

    public long getTimestamp() {
        return this.timestamp;
    }

    public void setTimestamp(final long timestamp) {
        this.timestamp = timestamp;
    }
}
