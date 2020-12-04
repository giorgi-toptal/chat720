package com.peranidze.chat720.chat.adapter.viewholder;

import android.text.format.DateUtils;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.peranidze.chat720.databinding.ItemMessageOutgoingBinding;
import com.peranidze.chat720.model.Message;

public class MessageOutgoingViewHolder extends RecyclerView.ViewHolder {

    @NonNull
    private final ItemMessageOutgoingBinding binding;

    public MessageOutgoingViewHolder(@NonNull ItemMessageOutgoingBinding binding) {
        super(binding.getRoot());
        this.binding = binding;
    }

    public void bind(@NonNull Message message, boolean showDate) {
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
        if (message.hasSeen()) {
            binding.seenIv.setVisibility(View.VISIBLE);
        } else {
            binding.seenIv.setVisibility(View.GONE);
        }
    }
}
