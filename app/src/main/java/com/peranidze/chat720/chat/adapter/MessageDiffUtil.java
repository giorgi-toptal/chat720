package com.peranidze.chat720.chat.adapter;

import androidx.recyclerview.widget.DiffUtil;

import com.peranidze.chat720.model.Message;

import java.util.List;

public class MessageDiffUtil extends DiffUtil.Callback {

    private List<Message> newItems;
    private List<Message> oldItems;

    public MessageDiffUtil(List<Message> newItems, List<Message> oldItems) {
        this.newItems = newItems;
        this.oldItems = oldItems;
    }

    @Override
    public int getOldListSize() {
        return oldItems.size();
    }

    @Override
    public int getNewListSize() {
        return newItems.size();
    }

    @Override
    public boolean areItemsTheSame(int oldItemPosition, int newItemPosition) {
        return oldItems.get(oldItemPosition).getId() == newItems.get(newItemPosition).getId();
    }

    @Override
    public boolean areContentsTheSame(int oldItemPosition, int newItemPosition) {
        return oldItems.get(oldItemPosition).equals(newItems.get(newItemPosition));
    }
}
