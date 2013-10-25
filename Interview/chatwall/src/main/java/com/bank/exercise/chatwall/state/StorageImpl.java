package com.bank.exercise.chatwall.state;


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
    public List<ChatLine> viewTimeLine(User user) {
        return chatStorage.getWallOf(user);
    }

    @Override
    public List<ChatLine> viewWall(User user) {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void publishMessage(User user, ChatLine chatLine) {
        chatStorage.addLine(user, chatLine);
    }
}
