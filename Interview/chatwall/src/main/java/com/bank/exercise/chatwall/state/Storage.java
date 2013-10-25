package com.bank.exercise.chatwall.state;


import java.util.List;

public interface Storage {
    User getUser(String name);

    List<ChatLine> viewTimeLine(User user);

    List<ChatLine> viewWall(User user);

    void publishMessage(User user, ChatLine chatLine);
}
