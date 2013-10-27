package com.bank.exercise.chatwall.command;


import java.util.List;

public class CommandDispatcher {
    private final List<Command> commands;
    private final Command fallbackCommand;

    public CommandDispatcher(List<Command> commands, Command fallbackCommand) {
        this.commands = commands;
        this.fallbackCommand = fallbackCommand;
    }

    public Command dispatch(String input) {
        for (Command command : commands) {
            if (command.matches(input)) {
                return command;
            }
        }
         return fallbackCommand;
    }
}
