package com.bank.exercise.chatwall.state;

import com.bank.exercise.chatwall.model.ChatLine;
import com.bank.exercise.chatwall.model.User;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class MemoryChatStorage implements ChatStorage{
    Map<User, List<ChatLine>> chatLineRepository = new HashMap<>();

    @Override
    public void addLine(User user, ChatLine line) {
        List<ChatLine> timeLine = chatLineRepository.get(user);
        if(timeLine == null){
            timeLine = initTimeLine(user);
        }
        timeLine.add(line);
    }

    @Override
    public List<ChatLine> getWallOf(User user) {
        return chatLineRepository.get(user);
    }

    private List<ChatLine> initTimeLine(User user) {
        List<ChatLine> timeLine = new ArrayList<>();
        chatLineRepository.put(user, timeLine);
        return timeLine;
    }
}
