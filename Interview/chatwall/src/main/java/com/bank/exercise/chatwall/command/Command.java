package com.bank.exercise.chatwall.command;

import com.bank.exercise.chatwall.storage.Storage;

import java.util.List;

public interface Command {

    List<String>  execute(Storage storage);

    List<String>  execute(String commandLine);

    boolean matches(String input);

    boolean isExit();



}
