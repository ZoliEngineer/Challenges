package com.bank.exercise.chatwall.storage;

import com.bank.exercise.chatwall.model.User;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
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
}
