package com.bank.exercise.chatwall.command;

import com.bank.exercise.chatwall.state.Storage;

import java.util.Collections;
import java.util.List;

class WallCommand implements Command {

    @Override
    public boolean isExit() {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public List<String> execute(Storage storage) {

        return Collections.emptyList();

    }

}