package com.bank.exercise.chatwall.state;

import java.util.Set;

public interface User {
    String getName();

    void subscribe(User user);

    Set<User> getSubscriptions();
}
