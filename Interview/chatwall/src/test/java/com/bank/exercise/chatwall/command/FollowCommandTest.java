package com.bank.exercise.chatwall.command;


import com.bank.exercise.chatwall.state.Storage;
import com.bank.exercise.chatwall.model.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.Matchers.anyString;
import static org.mockito.Matchers.eq;
import static org.mockito.Matchers.same;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class FollowCommandTest {
    private static final String USER_1 = "user1";
    private static final String USER_2 = "user2";
    private static final String PROPER_COMMAND =  USER_1 + " follows " + USER_2;

    @Mock
    private Storage storage;

    @Test
    public void commandDoesntMatchNull() {
        assertFalse(FollowCommand.matches(null));
    }

    @Test
    public void commandDoesntMatchEmpty() {
        assertFalse(FollowCommand.matches(""));
    }

    @Test
    public void commandMatchesProperCommandString() {
        assertTrue(FollowCommand.matches(PROPER_COMMAND));
    }

    @Test
    public void commandExecutionStoresSubscriptionsForUser() {
        User user1 = mock(User.class);
        User user2 = mock(User.class);
        when(storage.getUser(anyString())).thenReturn(user1).thenReturn(user2);

        Command command = FollowCommand.create(PROPER_COMMAND);
        command.execute(storage);

        verify(storage).getUser(eq(USER_1));
        verify(storage).getUser(eq(USER_2));
        verify(user1).subscribe(same(user2));
    }
}
