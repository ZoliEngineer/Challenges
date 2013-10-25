package com.bank.exercise.chatwall.command;

import com.bank.exercise.chatwall.state.Storage;

import java.util.Collections;
import java.util.List;

public class DefaultCommand implements Command {

    private static final DefaultCommand INSTANCE = new DefaultCommand();

    private DefaultCommand() {
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

}
