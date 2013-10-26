package com.bank.exercise.chatwall.command;

import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class FallbackCommanTest {

    @Test
    public void commandAlwaysMatches(){
        assertTrue(FollowCommand.matches(null));
        assertTrue(FollowCommand.matches(""));
    }
}
