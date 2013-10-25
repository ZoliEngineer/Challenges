package com.bank.exercise.chatwall.storage;

import com.bank.exercise.chatwall.model.ChatLine;
import com.bank.exercise.chatwall.model.User;

import java.util.List;

public interface ChatStorage {
    void addLine(User user, ChatLine line);

    List<ChatLine> getWallOf(User user);
}
