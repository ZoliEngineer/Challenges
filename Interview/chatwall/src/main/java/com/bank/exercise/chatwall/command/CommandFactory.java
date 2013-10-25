package com.bank.exercise.chatwall.command;


public class CommandFactory {

    public static Command createFromInput(String input) {
        if (ExitCommand.matches(input)) {
            return ExitCommand.create();
        } else if (PublishCommand.matches(input)) {
            return PublishCommand.create(input);
        } else if (ReadCommand.matches(input)){
            return ReadCommand.create(input);
        } else    {
            return DefaultCommand.create();
        }
    }
}
