package com.bank.exercise.chatwall.command;

import com.bank.exercise.chatwall.model.ChatLine;
import com.bank.exercise.chatwall.storage.Storage;
import com.bank.exercise.chatwall.model.User;
import com.google.common.collect.Lists;
import com.google.common.collect.Sets;
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
public class WallCommandTest {
    private static final String USER1 = "user1";
    private static final String USER2 = "user2";
    private static final String PROPER_COMMAND = USER1 + " wall";

    @Mock
    private Storage storage;

    @Test
    public void commandDoesntMatchNull() {
        assertFalse(WallCommand.matches(null));
    }

    @Test
    public void commandDoesntMatchEmpty() {
        assertFalse(WallCommand.matches(""));
    }

    @Test
    public void commandMatchesProperCommandString() {
        assertTrue(WallCommand.matches(PROPER_COMMAND));
    }

    @Test
    public void commandExecutionreturnsAllChatLinesOfUserSubscriptions() {
        User user1 = mock(User.class);
        User user2 = mock(User.class);
        when(user1.getName()).thenReturn(USER1);
        when(user2.getName()).thenReturn(USER2);
        String message1 = "ownMessage";
        String message2 = "subscribedMessage";
        ChatLine chatLine1 = new ChatLine(user1, message1, 1000);
        ChatLine chatLine2 = new ChatLine(user2, message2, 100000);


        when(storage.getUser(eq(USER1))).thenReturn(user1);
        when(user1.getSubscriptions()).thenReturn(Sets.newHashSet(user2));
        when(storage.getMessagesOf(eq(user1))).thenReturn(Lists.newArrayList(chatLine1));
        when(storage.getMessagesOf(eq(user2))).thenReturn(Lists.newArrayList(chatLine2));

        Command command = WallCommand.create(PROPER_COMMAND);
        List<String> output = command.execute(storage);

        System.out.println(output.get(0));
        System.out.println(output.get(1));

        verify(storage).getUser(eq(USER1));
        verify(storage).getMessagesOf(same(user1));
        verify(storage).getMessagesOf(same(user2));
        assertEquals(2, output.size());
        assertTrue(output.get(0).contains(message1));
        assertTrue(output.get(1).contains(message2));
        assertTrue(output.get(0).contains(USER1));
        assertTrue(output.get(1).contains(USER2));

    }

    @Test
    public void verifyOrderOfMessages(){

    }
}
