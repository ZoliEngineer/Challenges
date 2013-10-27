package com.bank.exercise.chatwall.storage;


import com.bank.exercise.chatwall.model.ChatLine;
import com.bank.exercise.chatwall.model.User;

import java.util.List;

public class StorageImpl implements Storage{
    private final UserStorage userStorage;
    private final ChatStorage chatStorage;

    public StorageImpl(UserStorage userStorage, ChatStorage chatStorage){
        this.chatStorage = chatStorage;
        this.userStorage = userStorage;
    }

    @Override
    public User getUser(String name) {
        return userStorage.get(name);
    }

    @Override
    public List<ChatLine> getMessagesOf(User user) {
        return chatStorage.getLines(user);
    }

    @Override
    public void publishMessage(User user, ChatLine chatLine) {
        chatStorage.addLine(user, chatLine);
    }
}
