package com.peranidze.chat720.view.attachments;

import android.view.View;

import androidx.annotation.DrawableRes;
import androidx.annotation.Nullable;
import androidx.annotation.StringRes;

public class AttachmentActionItem {
    @StringRes
    int title;
    @DrawableRes
    int icon;
    @Nullable
    private View.OnClickListener clickListener;

    public AttachmentActionItem(final int title, final int icon) {
        this.title = title;
        this.icon = icon;
    }

    public AttachmentActionItem(final int title, final int icon, @Nullable final View.OnClickListener clickListener) {
        this.title = title;
        this.icon = icon;
        this.clickListener = clickListener;
    }

    @Nullable
    public View.OnClickListener getClickListener() {
        return this.clickListener;
    }

    public void setClickListener(@Nullable final View.OnClickListener clickListener) {
        this.clickListener = clickListener;
    }
}
