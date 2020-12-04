package com.peranidze.chat720.chat.adapter.viewholder;

import android.text.format.DateUtils;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.peranidze.chat720.databinding.ItemMessageIncomingBinding;
import com.peranidze.chat720.model.Message;

public class MessageIncomingViewHolder extends RecyclerView.ViewHolder {

    @NonNull
    private final ItemMessageIncomingBinding binding;

    public MessageIncomingViewHolder(@NonNull ItemMessageIncomingBinding binding) {
        super(binding.getRoot());
        this.binding = binding;
    }

    public void bind(@NonNull Message message, boolean showDate) {
        Glide.with(itemView.getContext())
                .load(message.getUser().getAvatar())
                .into(binding.avatarIv);
        binding.messageTv.setText(message.getBody());
        binding.timestampTv.setText(DateUtils.formatDateTime(itemView.getContext(),
                message.getTimestamp(), DateUtils.FORMAT_SHOW_TIME));
        if (showDate) {
            binding.dateTv.setVisibility(View.VISIBLE);
            binding.dateTv.setText(DateUtils.getRelativeDateTimeString(itemView.getContext(),
                    message.getTimestamp(), DateUtils.DAY_IN_MILLIS, DateUtils.WEEK_IN_MILLIS, 0));
        } else {
            binding.dateTv.setVisibility(View.GONE);
        }
    }
}
