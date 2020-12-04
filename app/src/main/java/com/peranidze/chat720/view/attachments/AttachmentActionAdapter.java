package com.peranidze.chat720.view.attachments;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.peranidze.chat720.databinding.ItemAttachmentActionBinding;

import java.util.ArrayList;
import java.util.List;

public class AttachmentActionAdapter extends RecyclerView.Adapter<AttachmentActionAdapter.ViewHolder> {

    private List<AttachmentActionItem> attachmentActionItemsList = new ArrayList<>();

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(ItemAttachmentActionBinding
                .inflate(LayoutInflater.from(parent.getContext()), parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull AttachmentActionAdapter.ViewHolder holder, int position) {
        holder.bind(attachmentActionItemsList.get(position));
    }

    @Override
    public int getItemCount() {
        return attachmentActionItemsList.size();
    }

    public void setAttachmentActionItemsList(List<AttachmentActionItem> attachmentActionItemsList) {
        this.attachmentActionItemsList = attachmentActionItemsList;
        notifyDataSetChanged();
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        @NonNull
        private final ItemAttachmentActionBinding binding;

        public ViewHolder(@NonNull ItemAttachmentActionBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

        public void bind(AttachmentActionItem attachmentActionItem) {
            if (attachmentActionItem.getClickListener() != null) {
                itemView.setOnClickListener(attachmentActionItem.getClickListener());
            }
            binding.iconIv.setImageResource(attachmentActionItem.icon);
            binding.titleTv.setText(attachmentActionItem.title);
        }
    }
}
