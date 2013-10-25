package com.bank.exercise.chatwall;

import static org.junit.Assert.assertEquals;

import com.bank.exercise.chatwall.ChatLineFormatter;
import org.junit.Test;

public class ChatLineFormatterTest {
    private static final String TEST_USER = "Charlie";
    private static final String TEST_CHAT_LINE = "Hello world!";

    @Test
    public void verifyChatLineFormat1Second() {
        int seconds = 1;

        String formattedString = ChatLineFormatter.format(TEST_USER, TEST_CHAT_LINE, 0, seconds * 1000, true);

        assertEquals("Charlie - Hello world! (1 second ago)", formattedString);

    }

    @Test
    public void verifyChatLineFormat5SecondsWithUser() {
        int seconds = 5;

        String formattedString = ChatLineFormatter.format(TEST_USER, TEST_CHAT_LINE, 0, seconds * 1000, true);

        assertEquals("Charlie - Hello world! (5 seconds ago)", formattedString);
    }

    @Test
    public void verifyChatLineFormat1MinuteWithUser() {
        int seconds = 60;

        String formattedString = ChatLineFormatter.format(TEST_USER, TEST_CHAT_LINE, 0, seconds * 1000, true);

        assertEquals("Charlie - Hello world! (1 minute ago)", formattedString);

    }

    @Test
    public void verifyChatLineFormat5MinutesWithUser() {
        int seconds = 300;

        String formattedString = ChatLineFormatter.format(TEST_USER, TEST_CHAT_LINE, 0, seconds * 1000, true);

        assertEquals("Charlie - Hello world! (5 minutes ago)", formattedString);

    }

    @Test
    public void verifyChatLineFormat1SecondWithOutUser() {
        int seconds = 1;

        String formattedString = ChatLineFormatter.format(TEST_USER, TEST_CHAT_LINE, 0, seconds * 1000, false);

        assertEquals("Hello world! (1 second ago)", formattedString);

    }

    @Test
    public void verifyChatLineFormat5SecondsWithOutUser() {
        int seconds = 5;

        String formattedString = ChatLineFormatter.format(TEST_USER, TEST_CHAT_LINE, 0, seconds * 1000, false);

        assertEquals("Hello world! (5 seconds ago)", formattedString);
    }

    @Test
    public void verifyChatLineFormat1MinuteWithOutUser() {
        int seconds = 60;

        String formattedString = ChatLineFormatter.format(TEST_USER, TEST_CHAT_LINE, 0, seconds * 1000, false);

        assertEquals("Hello world! (1 minute ago)", formattedString);

    }

    @Test
    public void verifyChatLineFormat5MinutesWithOutUser() {
        int seconds = 300;

        String formattedString = ChatLineFormatter.format(TEST_USER, TEST_CHAT_LINE, 0, seconds * 1000, false);

        assertEquals("Hello world! (5 minutes ago)", formattedString);

    }
}
