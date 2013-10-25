package com.bank.exercise.chatwall.command;

import com.bank.exercise.chatwall.state.Storage;

import java.util.Collections;
import java.util.List;

class ReadCommand implements Command {
    @Override
    public List<String> execute(Storage storage) {
        return Collections.emptyList();
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public boolean isExit() {
        return false;
    }
}
