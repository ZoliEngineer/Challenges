package com.bank.exercise.chatwall.state;


import com.bank.exercise.chatwall.model.ChatLine;
import com.bank.exercise.chatwall.model.User;

import java.util.List;

public interface Storage {
    User getUser(String name);

    List<ChatLine> viewTimeLine(User user);

    List<ChatLine> viewWall(User user);

    void publishMessage(User user, ChatLine chatLine);
}
