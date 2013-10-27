package com.bank.exercise.chatwall;

import java.util.List;

import com.bank.exercise.chatwall.command.*;
import com.bank.exercise.chatwall.storage.MemoryChatStorage;
import com.bank.exercise.chatwall.storage.MemoryUserStorage;
import com.bank.exercise.chatwall.storage.Storage;
import com.bank.exercise.chatwall.storage.StorageImpl;
import com.google.common.collect.Lists;

public class ChatWall {

    // Dependency configuration. Preferred to be injected instead.
    private final Storage storage = new StorageImpl(new MemoryUserStorage(), new MemoryChatStorage());
    private final Command exitCommand = new ExitCommand();
    private final Command fallbackCommand = new FallbackCommand();
    private final List<Command> knownCommands = Lists.newArrayList(
            new PublishCommand(storage),//
            new ReadCommand(storage),//
            new FollowCommand(storage),//
            new WallCommand(storage),//
            exitCommand);

    CommandDispatcher commandDispatcher = new CommandDispatcher(knownCommands, fallbackCommand);

    /*public List<String> executeCommandOld(String commandString) {
        Command command = CommandFactory.createFromInput(commandString);
        List<String> result = command.execute(storage);
        if(command.isExit()){
            System.exit(0);
        }
        return result;
    }    */

    public List<String> executeCommand(String commandString) {
        Command command = commandDispatcher.dispatch(commandString);
        List<String> result = command.execute(commandString);
        if(command == exitCommand){
            System.exit(0);
        }
        return result;
    }
}
