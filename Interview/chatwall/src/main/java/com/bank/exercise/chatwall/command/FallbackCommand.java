package com.bank.exercise.chatwall.command;

import com.bank.exercise.chatwall.storage.Storage;
import com.google.common.base.Strings;

import java.util.Collections;
import java.util.List;

public class FallbackCommand implements Command {

    private static final FallbackCommand INSTANCE = new FallbackCommand();

    private FallbackCommand() {
    }

    @Override
    public boolean isExit() {
        return false;
    }

    @Override
    public List<String> execute(Storage storage) {
        System.out.println("Unknown command");
        return Collections.emptyList();
    }

    public static Command create() {
        return INSTANCE;
    }

    public static boolean matches(String commandLine) {
        return true;
    }

}
