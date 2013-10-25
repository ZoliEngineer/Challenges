package com.bank.exercise.chatwall.command;

import com.google.common.base.Strings;
import com.bank.exercise.chatwall.state.ChatLine;
import com.bank.exercise.chatwall.state.Storage;
import com.bank.exercise.chatwall.state.User;
import com.google.common.collect.Lists;

import java.util.List;

class PublishCommand implements Command {
    private static final String ARROW = "->";

    private final String name;
    private final String message;

    private PublishCommand(String[] splitedCommandLine) {
        this.name = splitedCommandLine[0].trim();
        this.message = splitedCommandLine[1].trim();
    }

    @Override
    public boolean isExit() {
        return false;
    }

    @Override
    public List<String> execute(Storage storage) {
        User user = storage.getUser(name);
        ChatLine line = new ChatLine(user, message, System.currentTimeMillis());
        storage.publishMessage(user, line);
        return Lists.newArrayList(name + " said " + message);
    }

    public static Command create(String commandLine) {
        return new PublishCommand(commandLine.split(ARROW)); // Out of scope: input validation
    }

    public static boolean matches(String commandLine) {
        if (Strings.isNullOrEmpty(commandLine)) {
            return false;
        } else {
            return commandLine.contains(ARROW); // Out of scope: deeper check in case of invalid command
        }
    }
}