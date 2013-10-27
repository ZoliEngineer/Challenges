package com.bank.exercise.chatwall.command;

import com.bank.exercise.chatwall.model.ChatLine;
import com.bank.exercise.chatwall.storage.Storage;
import com.bank.exercise.chatwall.model.User;
import com.google.common.collect.Lists;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.Matchers.anyString;
import static org.mockito.Matchers.eq;
import static org.mockito.Matchers.same;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class ReadCommandTest {
    private static final String USER = "user";
    private static final String PROPER_COMMAND = USER;

    @Mock
    private Storage storage;

    @Test
    public void commandDoesntMatchNull() {
        assertFalse(ReadCommand.matches(null));
    }

    @Test
    public void commandDoesntMatchEmpty() {
        assertFalse(ReadCommand.matches(""));
    }

    @Test
    public void commandMatchesProperCommandString() {
        assertTrue(ReadCommand.matches(PROPER_COMMAND));
    }

    @Test
    public void commandExecutionreturnsAllChatLinesOfUser() {
        User user = mock(User.class);
        String message = "message";
        ChatLine chatLine = new ChatLine(user, message, System.currentTimeMillis());

        when(storage.getUser(eq(USER))).thenReturn(user);
        when(storage.getMessagesOf(eq(user))).thenReturn(Lists.newArrayList(chatLine));

        Command command = ReadCommand.create(PROPER_COMMAND);
        List<String> output = command.execute(storage);

        verify(storage).getUser(eq(USER));
        verify(storage).getMessagesOf(same(user));
        assertTrue(output.get(0).contains(message));
        assertFalse(output.isEmpty());
    }

}
