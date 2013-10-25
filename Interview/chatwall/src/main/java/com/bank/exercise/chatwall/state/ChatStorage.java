package com.bank.exercise.chatwall.state;

import java.util.List;

public interface ChatStorage {
    void addLine(User user, ChatLine line);

    List<ChatLine> getWallOf(User user);
}
