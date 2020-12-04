package com.peranidze.chat720.chat;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DividerItemDecoration;

import com.peranidze.chat720.R;
import com.peranidze.chat720.chat.adapter.ChatAdapter;
import com.peranidze.chat720.databinding.FragmentChatBinding;
import com.peranidze.chat720.model.Message;
import com.peranidze.chat720.model.MessageType;
import com.peranidze.chat720.model.User;
import com.peranidze.chat720.model.UserStatus;
import com.peranidze.chat720.view.attachments.AttachmentActionAdapter;
import com.peranidze.chat720.view.attachments.AttachmentActionItem;

import java.util.ArrayList;
import java.util.List;
import java.util.PrimitiveIterator;

public class ChatFragment extends Fragment {

    public static final int REQUEST_CODE_PICK_IMAGE = 12;
    private static final int ANIMATION_DURATION = 100;

    private FragmentChatBinding binding;
    private ChatAdapter chatAdapter;
    private boolean isAttachmentsCardVisible = false;

    @Nullable
    @Override
    public View onCreateView(@NonNull final LayoutInflater inflater, @Nullable final ViewGroup container, @Nullable final Bundle savedInstanceState) {
        binding = FragmentChatBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull final View view, @Nullable final Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        bindInteractions();
        setupRecyclerView();
        setupAttachmentsAdapter();
        setupToolbar();
        setMockData();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

    private void bindInteractions() {
        binding.chatMiv.setonAttachmentsButtonClickListener(v -> {
            isAttachmentsCardVisible = !isAttachmentsCardVisible;
            if (isAttachmentsCardVisible) {
                showAttachmentsView();
            } else {
                hideAttachmentsView();
            }
        });
    }

    private void setupToolbar() {
        User user = getUserMock1();
        binding.toolbar.setTitle(user.getName());
        binding.toolbar.setSubTitle(user.getUserStatus().getStatusRes());
        binding.toolbar.loadAvatar(user.getAvatar());
    }

    private void setupRecyclerView() {
        chatAdapter = new ChatAdapter();
        binding.messageRv.addItemDecoration(getDivider());
        binding.messageRv.setAdapter(chatAdapter);
    }

    private void setupAttachmentsAdapter() {
        binding.attachmentsRv.setAdapter(makeAttachmentsAdapterMock());
    }

    private void showAttachmentsView() {
        binding.attachmentsView.setVisibility(View.VISIBLE);
        binding.attachmentsView.animate()
                .translationY(0)
                .alpha(1f)
                .setDuration(ANIMATION_DURATION)
                .setListener(new AnimatorListenerAdapter() {
                    @Override
                    public void onAnimationEnd(Animator animation) {
                        super.onAnimationEnd(animation);
                        binding.chatMiv.setAttachmentActionIcon(R.drawable.ic_close);
                    }
                });
    }

    private void hideAttachmentsView() {
        binding.attachmentsView.animate()
                .translationY(binding.attachmentsView.getHeight())
                .alpha(0.0f)
                .setDuration(ANIMATION_DURATION)
                .setListener(new AnimatorListenerAdapter() {
                    @Override
                    public void onAnimationEnd(Animator animation) {
                        super.onAnimationEnd(animation);
                        binding.attachmentsView.setVisibility(View.GONE);
                        binding.chatMiv.setAttachmentActionIcon(R.drawable.ic_add);
                    }
                });
    }

    private DividerItemDecoration getDivider() {
        DividerItemDecoration divider = new DividerItemDecoration(requireContext(), DividerItemDecoration.VERTICAL);
        divider.setDrawable(ContextCompat.getDrawable(requireContext(), R.drawable.divider_medium));
        return divider;
    }

    private void openImagePicking() {
        Intent intent = new Intent();
        intent.setType("image/*");
        intent.setAction(Intent.ACTION_GET_CONTENT);
        startActivityForResult(Intent.createChooser(intent, getResources().getString(R.string.attachment_pick_image)), REQUEST_CODE_PICK_IMAGE);
    }


    /**
     * MOCK
     **/

    private void setMockData() {
        User doctorStrange = getUserMock1();
        User hulk = getUserMock2();

        List<Message> messagesList = new ArrayList<Message>();
        messagesList.add(new Message(13124123, doctorStrange, MessageType.TEXT_INCOMING, "hi hulk", true, new ArrayList<String>(), 1607093441560L));
        messagesList.add(new Message(54123143, doctorStrange, MessageType.TEXT_INCOMING, "Death is what gives life meaning. To know your days are numbered. Your time is short. You'd think after all this time, I'd be ready. But look at me. Stretching one moment out into a thousand... just so that I can watch the snow.", true, new ArrayList<String>(), 1607043441560L));
        messagesList.add(new Message(12131243, doctorStrange, MessageType.TEXT_INCOMING, "knock knock!", true, new ArrayList<String>(), 1607013441560L));
        messagesList.add(new Message(14123112, doctorStrange, MessageType.TEXT_INCOMING, "team green", true, new ArrayList<String>(), 1607000441560L));
        messagesList.add(new Message(33423423, doctorStrange, MessageType.TEXT_INCOMING, "you want food?", false, new ArrayList<String>(), 1607093451260L));
        messagesList.add(new Message(12423321, hulk, MessageType.TEXT_OUTGOING, "hi dr strange", true, new ArrayList<String>(), 1606093451060L));
        messagesList.add(new Message(33423423, hulk, MessageType.TEXT_OUTGOING, "why u never talk to me", false, new ArrayList<String>(), 1607093451160L));

        chatAdapter.setMessages(messagesList);
    }

    private AttachmentActionAdapter makeAttachmentsAdapterMock() {
        ArrayList<AttachmentActionItem> attachmentsActionList = new ArrayList<AttachmentActionItem>();


        attachmentsActionList.add(new AttachmentActionItem(R.string.attachment_category_gallery, R.drawable.ic_gallery, v -> {
            openImagePicking();
        }));
        attachmentsActionList.add(new AttachmentActionItem(R.string.attachment_category_market, R.drawable.ic_online_shop));
        attachmentsActionList.add(new AttachmentActionItem(R.string.attachment_category_location, R.drawable.ic_location));
        attachmentsActionList.add(new AttachmentActionItem(R.string.attachment_category_payment, R.drawable.ic_card));
        attachmentsActionList.add(new AttachmentActionItem(R.string.attachment_category_gift, R.drawable.ic_gift));
        attachmentsActionList.add(new AttachmentActionItem(R.string.attachment_category_contact, R.drawable.ic_contact));

        AttachmentActionAdapter attachmentActionAdapter = new AttachmentActionAdapter();
        attachmentActionAdapter.setAttachmentActionItemsList(attachmentsActionList);

        return attachmentActionAdapter;
    }

    private User getUserMock1() {
        return new User(1, "Dr. strange", "https://mir-s3-cdn-cf.behance.net/project_modules/max_1200/8987ee44580247.588cae814a355.jpg", UserStatus.ACTIVE);
    }

    private User getUserMock2() {
        return new User(2, "Hulk", "https://static3.srcdn.com/wordpress/wp-content/uploads/2019/04/Movie-Hulk-Immortal-Thousands-of-Years-Old.jpg", UserStatus.ACTIVE);
    }


}
