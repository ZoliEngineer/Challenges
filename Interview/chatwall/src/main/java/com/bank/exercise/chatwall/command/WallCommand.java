package com.bank.exercise.chatwall.command;

import com.bank.exercise.chatwall.storage.Storage;
import com.google.common.base.Strings;

import java.util.Collections;
import java.util.List;

class WallCommand implements Command {
    private static final String WALL_COMMAND_PART = "wall";

    @Override
    public boolean isExit() {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public List<String> execute(Storage storage) {

        return Collections.emptyList();

    }

    public static boolean matches(String commandLine) {
        if (Strings.isNullOrEmpty(commandLine)) {
            return false;
        } else {
            return commandLine.contains(WALL_COMMAND_PART); // Out of scope: deeper check in case of invalid command
        }
    }

}