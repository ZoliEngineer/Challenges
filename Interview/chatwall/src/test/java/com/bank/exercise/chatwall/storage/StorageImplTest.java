package com.bank.exercise.chatwall.storage;

import com.bank.exercise.chatwall.model.ChatLine;
import com.bank.exercise.chatwall.model.User;
import com.google.common.collect.Lists;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.mockito.Matchers.*;

@RunWith(MockitoJUnitRunner.class)
public class StorageImplTest {
    @Mock
    private UserStorage userStorage;

    @Mock
    private ChatStorage chatStorage;

    private Storage storage;


    @Before
    public void init() {
        storage = new StorageImpl(userStorage, chatStorage);
    }

    @Test
    public void whenGetUserCalledUserStorageIsQueried() {
        String name = "name";
        User user = mock(User.class);
        when(userStorage.get(eq(name))).thenReturn(user);

        assertEquals(user, storage.getUser(name));
    }

    @Test
    public void whenGetMessagesForCalledThenChatStorageIsQueried(){
        String message = "message";
        User user = mock(User.class);
        ChatLine line = new ChatLine(user, message, 0L);
        when(chatStorage.getLines(eq(user))).thenReturn(Lists.newArrayList(line));

        List<ChatLine> linesOfUser=    storage.getMessagesOf(user);

        assertEquals(1,linesOfUser.size());
        assertEquals(line, linesOfUser.get(0));
    }

    @Test
    public void whenPublishMessageCalledThenMessageSavedInChatStorage(){
        String message = "message";
        User user = mock(User.class);
        ChatLine line = new ChatLine(user, message, 0L);

        storage.publishMessage(user, line);

        verify(chatStorage).addLine(same(user), same(line));
    }
}
