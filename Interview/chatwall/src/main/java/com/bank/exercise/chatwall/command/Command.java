package com.bank.exercise.chatwall.command;

import com.bank.exercise.chatwall.state.Storage;

import java.util.List;

public interface Command {

    List<String>  execute(Storage storage);

    boolean isExit();



}
