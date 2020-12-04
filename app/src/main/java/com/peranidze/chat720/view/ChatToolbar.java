package com.peranidze.chat720.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.FrameLayout;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.StringRes;

import com.bumptech.glide.Glide;
import com.peranidze.chat720.databinding.ToolbarChatBinding;

public class ChatToolbar extends FrameLayout {

    @NonNull
    private ToolbarChatBinding binding;

    public ChatToolbar(@NonNull Context context) {
        super(context);
        init(context);
    }

    public ChatToolbar(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    public ChatToolbar(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);
    }

    public ChatToolbar(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init(context);
    }

    public void setTitle(CharSequence title) {
        binding.titleTv.setText(title);
    }

    public void setSubTitle(CharSequence subTitle) {
        binding.subtitleTv.setText(subTitle);
    }

    public void setSubTitle(@StringRes int subTitle) {
        binding.subtitleTv.setText(subTitle);
    }

    public void loadAvatar(String avatarRes) {
        Glide.with(this)
                .load(avatarRes)
                .into(binding.avatarIv);
    }

    private void init(Context context) {
        binding = ToolbarChatBinding.inflate(LayoutInflater.from(context), this, true);
    }
}