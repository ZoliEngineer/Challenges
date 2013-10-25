package com.bank.exercise.chatwall.state;

import com.bank.exercise.chatwall.model.User;

public interface UserStorage {
    public User get(String name);
}
