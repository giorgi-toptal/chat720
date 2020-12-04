package com.peranidze.chat720.model;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class User {
    private long id;
    @NonNull
    private String name;
    @Nullable
    private String avatar;
    @NonNull
    private UserStatus userStatus;

    public User(final long id, @NonNull final String name, @Nullable final String avatar, @NonNull final UserStatus userStatus) {
        this.id = id;
        this.name = name;
        this.avatar = avatar;
        this.userStatus = userStatus;
    }

    public long getId() {
        return this.id;
    }

    public void setId(final long id) {
        this.id = id;
    }

    @NonNull
    public String getName() {
        return this.name;
    }

    public void setName(@NonNull final String name) {
        this.name = name;
    }

    @Nullable
    public String getAvatar() {
        return this.avatar;
    }

    public void setAvatar(@Nullable final String avatar) {
        this.avatar = avatar;
    }

    @NonNull
    public UserStatus getUserStatus() {
        return this.userStatus;
    }

    public void setUserStatus(@NonNull final UserStatus userStatus) {
        this.userStatus = userStatus;
    }
}
