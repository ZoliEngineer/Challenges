package com.bank.exercise.chatwall;

import java.util.List;

import com.bank.exercise.chatwall.command.Command;
import com.bank.exercise.chatwall.command.CommandFactory;
import com.bank.exercise.chatwall.storage.MemoryChatStorage;
import com.bank.exercise.chatwall.storage.MemoryUserStorage;
import com.bank.exercise.chatwall.storage.Storage;
import com.bank.exercise.chatwall.storage.StorageImpl;

public class ChatWall {
    private final Storage storage = new StorageImpl(new MemoryUserStorage(), new MemoryChatStorage());

    public List<String> executeCommand(String commandString) {
        Command command = CommandFactory.createFromInput(commandString);
        List<String> result = command.execute(storage);
        if(command.isExit()){
            System.exit(0);
        }
        return result;
    }
}
