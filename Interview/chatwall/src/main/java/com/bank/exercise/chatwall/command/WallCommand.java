package com.bank.exercise.chatwall.command;

import com.bank.exercise.chatwall.ChatLineFormatter;
import com.bank.exercise.chatwall.model.ChatLine;
import com.bank.exercise.chatwall.model.User;
import com.bank.exercise.chatwall.storage.Storage;
import com.google.common.base.Strings;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

class WallCommand implements Command {
    private static final String WALL_COMMAND_PART = "wall";

    private final String userName;

    public WallCommand(String[] splitedCommandLine) {
        this.userName = splitedCommandLine[0];
    }

    @Override
    public boolean isExit() {
        return false;
    }

    @Override
    public List<String> execute(Storage storage) {
        User user = storage.getUser(userName);
        Set<User> subscriptions = user.getSubscriptions();
        List<ChatLine> allLines = new ArrayList<>();

        for(User subscription : subscriptions){
            allLines.addAll(storage.viewTimeLine(subscription));
        }
        allLines.addAll(storage.viewTimeLine(user));
        Collections.sort(allLines);

        return createOutput(allLines);

    }

    private List<String> createOutput(List<ChatLine> timeLine) { //TODO: duplicated
        List<String> output = new ArrayList<>(timeLine.size());
        for(ChatLine line : timeLine)          {
            output.add(ChatLineFormatter.format(line.getUserName(), line.getLine(), line.getTimeOfPost(), System.currentTimeMillis(), false));
        }
        return output;
    }

    public static boolean matches(String commandLine) {
        if (Strings.isNullOrEmpty(commandLine)) {
            return false;
        } else {
            return commandLine.contains(WALL_COMMAND_PART); // Out of scope: deeper check in case of invalid command
        }
    }

    public static Command create(String commandLine) {
        return new WallCommand(commandLine.split(WALL_COMMAND_PART)); // Out of scope: input validation
    }

}