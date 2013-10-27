package com.bank.exercise.chatwall.command;

import com.bank.exercise.chatwall.storage.Storage;

import java.util.Collections;
import java.util.List;

public class ExitCommand implements Command {
    private static final String PATTERN = "exit";

    private static final ExitCommand INSTANCE = new ExitCommand();


    @Override
    public boolean isExit() {
        return true;
    }

    @Override
    public List<String> execute(Storage storage) {
        System.out.println("Exiting application");
        return Collections.emptyList();
    }

    @Override
    public List<String> execute(String input) {
        System.out.println("Exiting application");
        return Collections.emptyList();
    }


    public boolean matches(String commandLine) {
        return PATTERN.equals(commandLine);
    }

    public static Command create() {
        return INSTANCE;
    }
}
