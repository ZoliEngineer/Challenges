package com.bank.exercise.chatwall.command;


public class CommandFactory {

    public static Command createFromInput(String input) {
        if (ExitCommand.matches(input)) {
            return ExitCommand.create();
        } else if (PublishCommand.matches(input)) {
            return PublishCommand.create(input);
        } else if (ReadCommand.matches(input)){
            return ReadCommand.create(input);
        } else if (FollowCommand.matches(input)){
            return FollowCommand.create(input);
        } else if (WallCommand.matches(input)){
            return WallCommand.create(input);
        } else    {
            return FallbackCommand.create();
        }
    }
}
