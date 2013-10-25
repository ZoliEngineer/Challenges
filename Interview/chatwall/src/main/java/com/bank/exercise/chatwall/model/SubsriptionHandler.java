package com.bank.exercise.chatwall.model;

import java.util.Set;

public interface SubsriptionHandler {
    void subscribe(User user);

    Set<User> getSubscriptions();
}
