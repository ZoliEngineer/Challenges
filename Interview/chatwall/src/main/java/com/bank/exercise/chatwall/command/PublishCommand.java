package com.bank.exercise.chatwall.command;

import com.google.common.base.Strings;
import com.bank.exercise.chatwall.model.ChatLine;
import com.bank.exercise.chatwall.storage.Storage;
import com.bank.exercise.chatwall.model.User;

import java.util.Collections;
import java.util.List;

class PublishCommand implements Command {
    private static final String PUBLISH_COMMAN_PART = "->";

    private final String userName;
    private final String message;

    private PublishCommand(String[] splitedCommandLine) {
        this.userName = splitedCommandLine[0].trim();
        this.message = splitedCommandLine[1].trim();
    }

    @Override
    public boolean isExit() {
        return false;
    }

    @Override
    public List<String> execute(Storage storage) {
        User user = storage.getUser(userName);
        ChatLine line = new ChatLine(user, message, System.currentTimeMillis());
        storage.publishMessage(user, line);
        return Collections.emptyList();
    }

    public static Command create(String commandLine) {
        return new PublishCommand(commandLine.split(PUBLISH_COMMAN_PART)); // Out of scope: input validation
    }

    public static boolean matches(String commandLine) {
        if (Strings.isNullOrEmpty(commandLine)) {
            return false;
        } else {
            return commandLine.contains(PUBLISH_COMMAN_PART); // Out of scope: deeper check in case of invalid command
        }
    }
}