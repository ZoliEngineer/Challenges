package com.bank.exercise.chatwall.command;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class CommandFactoryTest {

    @Test
    public void whenCreateCalledWithExitThenReturnsExitCommand() {
        String input = "exit";
        Command command = CommandFactory.createFromInput(input);

        assertEquals(ExitCommand.class, command.getClass());
    }

    @Test
    public void whenInputContainsArrowThanReturnsPublisCommand() {
        String input = "before -> after";
        Command command = CommandFactory.createFromInput(input);

        assertEquals(PublishCommand.class, command.getClass());
    }

    @Test
    public void whenInputContainsFollowThanReturnsFollowCommand() {
        String input = "before follows after";
        Command command = CommandFactory.createFromInput(input);

        assertEquals(PublishCommand.class, command.getClass());
    }

    @Test
    public void whenCreateCalledWithNullThenReturnsDefaultCommand() {
        String input = null;
        Command command = CommandFactory.createFromInput(input);

        assertEquals(FallbackCommand.class, command.getClass());
    }

    @Test
    public void whenCreateCalledWithEmptyStringThenReturnsDefaultCommand() {
        String input = "";
        Command command = CommandFactory.createFromInput(input);

        assertEquals(FallbackCommand.class, command.getClass());
    }

    @Test
    public void whenCreateCalledWithUnknownStringThenReturnsDefaultCommand() {
        String input = "invaliddata123";
        Command command = CommandFactory.createFromInput(input);

        assertEquals(FallbackCommand.class, command.getClass());
    }
}
