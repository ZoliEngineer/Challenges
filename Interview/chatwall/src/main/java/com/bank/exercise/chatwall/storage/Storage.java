package com.bank.exercise.chatwall.storage;


import com.bank.exercise.chatwall.model.ChatLine;
import com.bank.exercise.chatwall.model.User;

import java.util.List;

public interface Storage {
    User getUser(String name);

    List<ChatLine> getMessagesOf(User user);

    void publishMessage(User user, ChatLine chatLine);
}
