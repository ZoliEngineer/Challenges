package com.bank.exercise.chatwall.storage;

import com.bank.exercise.chatwall.model.SimpleUser;
import com.bank.exercise.chatwall.model.User;

import java.util.HashMap;
import java.util.Map;

public class MemoryUserStorage implements UserStorage {

    private final Map<String, User> userRepository = new HashMap<>();

    @Override
    public User get(String name) {
        User user = userRepository.get(name);
        if (user == null) {
            user = createUser(name);
        }
        return user;
    }

    private User createUser(String name) {
        User user = new SimpleUser(name);
        userRepository.put(name, user);
        return user;
    }
}
