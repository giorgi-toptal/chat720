package com.peranidze.chat720.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.FrameLayout;

import androidx.annotation.DrawableRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.peranidze.chat720.databinding.ViewMessageInputBinding;


public class MessageInputView extends FrameLayout {

    @NonNull
    private ViewMessageInputBinding binding;

    public MessageInputView(@NonNull Context context) {
        super(context);
        init(context);
    }

    public MessageInputView(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    public MessageInputView(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);
    }

    public MessageInputView(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init(context);
    }

    public void setonAttachmentsButtonClickListener(OnClickListener listener) {
        binding.attachmentsBtn.setOnClickListener(listener);
    }

    public void setonActionButtonClickListener(OnClickListener listener) {
        binding.actionBtn.setOnClickListener(listener);
    }

    public void setAttachmentActionIcon(@DrawableRes int iconRes) {
        binding.attachmentsBtn.setIconResource(iconRes);
    }

    private void init(Context context) {
        binding = ViewMessageInputBinding.inflate(LayoutInflater.from(context), this, true);
    }
}
