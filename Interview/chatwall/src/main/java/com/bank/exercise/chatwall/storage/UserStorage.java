package com.bank.exercise.chatwall.storage;

import com.bank.exercise.chatwall.model.User;

public interface UserStorage {
    public User get(String name);
}
