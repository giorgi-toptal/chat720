package com.peranidze.chat720.chat.adapter;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.peranidze.chat720.chat.adapter.viewholder.MessageIncomingViewHolder;
import com.peranidze.chat720.chat.adapter.viewholder.MessageOutgoingViewHolder;
import com.peranidze.chat720.databinding.ItemMessageIncomingBinding;
import com.peranidze.chat720.databinding.ItemMessageOutgoingBinding;
import com.peranidze.chat720.model.Message;
import com.peranidze.chat720.model.MessageType;
import com.peranidze.chat720.utils.DateTimeUtils;

import java.util.ArrayList;
import java.util.List;

public class ChatAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private static final int TYPE_TEXT_INCOMING = 1;
    private static final int TYPE_TEXT_OUTGOING = 2;

    private List<Message> messagesList = new ArrayList<>();

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        switch (viewType) {
            case TYPE_TEXT_INCOMING:
                return new MessageIncomingViewHolder(ItemMessageIncomingBinding
                        .inflate(LayoutInflater.from(parent.getContext()), parent, false));
            case TYPE_TEXT_OUTGOING:
                return new MessageOutgoingViewHolder(ItemMessageOutgoingBinding
                        .inflate(LayoutInflater.from(parent.getContext()), parent, false));
        }
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        boolean showDate = true;
        if (position > 0) {
            showDate = !DateTimeUtils.isSameDays(messagesList.get(position).getTimestamp(),
                    messagesList.get(position - 1).getTimestamp());
        }
        if (holder instanceof MessageIncomingViewHolder) {
            ((MessageIncomingViewHolder) holder).bind(messagesList.get(position), showDate);
        } else if (holder instanceof MessageOutgoingViewHolder) {
            ((MessageOutgoingViewHolder) holder).bind(messagesList.get(position), showDate);
        } else {
            throw new IllegalArgumentException("ViewHolder type not supported");
        }
    }

    @Override
    public int getItemCount() {
        return messagesList.size();
    }

    @Override
    public int getItemViewType(int position) {
        MessageType messageType = messagesList.get(position).getType();
        switch (messageType) {
            case TEXT_INCOMING:
                return TYPE_TEXT_INCOMING;
            case TEXT_OUTGOING:
                return TYPE_TEXT_OUTGOING;
            default:
                throw new IllegalArgumentException("Type " + messageType.name() + " not supported");
        }
    }

    public void setMessages(List<Message> messagesList) {
        messagesList.sort((o1, o2) -> (int) (o1.getTimestamp() - o2.getTimestamp()));
        DiffUtil.DiffResult diffResult = DiffUtil.calculateDiff(new MessageDiffUtil(messagesList, this.messagesList));
        diffResult.dispatchUpdatesTo(this);
        this.messagesList = messagesList;
    }
}
