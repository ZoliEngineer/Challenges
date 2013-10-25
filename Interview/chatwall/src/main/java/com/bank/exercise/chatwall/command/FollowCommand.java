package com.bank.exercise.chatwall.command;

import com.bank.exercise.chatwall.storage.Storage;
import com.bank.exercise.chatwall.model.User;
import com.google.common.base.Strings;

import java.util.Collections;
import java.util.List;

class FollowCommand implements Command {
    private static final String FOLLOW_COMMAND_PART = "follows";

    private final String userName;
    private final String userNameToFollow;

    private FollowCommand(String[] splitedCommandLine) {
        this.userName = splitedCommandLine[0].trim();
        this.userNameToFollow = splitedCommandLine[1].trim();
    }

    @Override
    public boolean isExit() {
        return false;
    }

    @Override
    public List<String> execute(Storage storage) {
        User currentUser = storage.getUser(userName);
        User userToFollow = storage.getUser(userNameToFollow);
        currentUser.subscribe(userToFollow);
        return Collections.emptyList();
    }

    public static boolean matches(String commandLine) {
        if (Strings.isNullOrEmpty(commandLine)) {
            return false;
        } else {
            return commandLine.contains(FOLLOW_COMMAND_PART); // Out of scope: deeper check in case of invalid command
        }
    }

    public static Command create(String commandLine) {
        return new FollowCommand(commandLine.split(FOLLOW_COMMAND_PART)); // Out of scope: input validation
    }

}