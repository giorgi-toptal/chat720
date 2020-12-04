package com.peranidze.chat720.model;

import androidx.annotation.StringRes;

import com.peranidze.chat720.R;

public enum UserStatus {
    OFFLINE(R.string.user_status_offline),
    ACTIVE(R.string.user_status_active);

    @StringRes
    private int statusRes;

    UserStatus(@StringRes int statusRes) {
        this.statusRes = statusRes;
    }

    @StringRes
    public int getStatusRes() {
        return statusRes;
    }

}
