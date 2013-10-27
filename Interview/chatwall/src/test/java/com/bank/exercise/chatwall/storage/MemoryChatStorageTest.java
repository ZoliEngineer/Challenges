package com.bank.exercise.chatwall.storage;


import com.bank.exercise.chatwall.model.ChatLine;
import com.bank.exercise.chatwall.model.User;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;

public class MemoryChatStorageTest {
    ChatStorage chatStorage;

    @Before
    public void init() {
        chatStorage = new MemoryChatStorage();
    }

    @Test
    public void whenGetWallOfUnknownUserThanReturnsNull() {
        User user = mock(User.class);
        assertNull(chatStorage.getLines(user));
    }

    @Test
    public void whenLineIsSavedThenItCanBeQueriedByUser() {
        String message = "message";
        User user = mock(User.class);
        ChatLine line = new ChatLine(user, message, 0L);

        chatStorage.addLine(user, line);

        assertEquals(1, chatStorage.getLines(user).size());
        assertTrue(chatStorage.getLines(user).contains(line));
    }

    @Test
    public void whenMultipleLineIsSavedThenItCanBeQueriedByUser() {
        String message1 = "message1";
        String message2 = "message2";
        User user = mock(User.class);
        ChatLine line1 = new ChatLine(user, message1, 0L);
        ChatLine line2 = new ChatLine(user, message2, 0L);

        chatStorage.addLine(user, line1);
        chatStorage.addLine(user, line2);

        assertEquals(2, chatStorage.getLines(user).size());
        assertEquals(line1, chatStorage.getLines(user).get(0));
        assertEquals(line2, chatStorage.getLines(user).get(1));
    }

    @Test
    public void whenMultipleLineIsSavedByDifferentUsersThenItCanBeQueriedByUser() {
        String message1 = "message1";
        String message2 = "message2";
        User user1 = mock(User.class);
        User user2 = mock(User.class);
        ChatLine line1 = new ChatLine(user1, message1, 0L);
        ChatLine line2 = new ChatLine(user2, message2, 0L);

        chatStorage.addLine(user1, line1);
        chatStorage.addLine(user2, line2);

        assertEquals(1, chatStorage.getLines(user1).size());
        assertEquals(1, chatStorage.getLines(user2).size());
        assertTrue(chatStorage.getLines(user1).contains(line1));
        assertTrue(chatStorage.getLines(user2).contains(line2));
        assertFalse(chatStorage.getLines(user1).contains(line2));
        assertFalse(chatStorage.getLines(user2).contains(line1));
    }
}
