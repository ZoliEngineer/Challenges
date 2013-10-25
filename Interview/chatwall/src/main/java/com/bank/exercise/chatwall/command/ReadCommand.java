package com.bank.exercise.chatwall.command;

import com.bank.exercise.chatwall.model.ChatLine;
import com.bank.exercise.chatwall.ChatLineFormatter;
import com.bank.exercise.chatwall.storage.Storage;
import com.bank.exercise.chatwall.model.User;
import com.google.common.base.Strings;

import java.util.ArrayList;
import java.util.List;

class ReadCommand implements Command {

    private final String userName;

    public ReadCommand(String commandLine) {
        this.userName = commandLine.trim();
    }

    @Override
    public List<String> execute(Storage storage) {
        User user = storage.getUser(userName);
        List<ChatLine> timeLine = storage.viewTimeLine(user);


        return createOutput(timeLine);
    }

    private List<String> createOutput(List<ChatLine> timeLine) {
        List<String> output = new ArrayList<>(timeLine.size());
        for(ChatLine line : timeLine)          {
            output.add(ChatLineFormatter.format(line.getUserName(), line.getLine(), line.getTimeOfPost(), System.currentTimeMillis(), false));
        }
        return output;
    }

    @Override
    public boolean isExit() {
        return false;
    }

    public static boolean matches(String commandLine) {
        if (Strings.isNullOrEmpty(commandLine)) {
            return false;
        } else {
            return true; // Out of scope: deeper check in case of invalid command
        }
    }

    public static Command create(String commandLine) {
        return new ReadCommand(commandLine); // Out of scope: input validation
    }
}
