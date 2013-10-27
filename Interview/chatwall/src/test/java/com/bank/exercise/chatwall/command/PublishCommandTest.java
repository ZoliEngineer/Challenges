package com.bank.exercise.chatwall.command;

import com.bank.exercise.chatwall.model.ChatLine;
import com.bank.exercise.chatwall.storage.Storage;
import com.bank.exercise.chatwall.model.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentMatcher;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.List;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.Matchers.anyString;
import static org.mockito.Matchers.eq;
import static org.mockito.Matchers.same;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class PublishCommandTest {

    private static final String USER = "user";
    private static final String MESSAGE = "message";
    private static final String PROPER_COMMAND = USER
            + " -> " + MESSAGE;

    @Mock
    private Storage storage;


    @Test
    public void commandDoesntMatchNull() {
        assertFalse(PublishCommand.matches(null));
    }

    @Test
    public void commandDoesntMatchEmpty() {
        assertFalse(PublishCommand.matches(""));
    }

    @Test
    public void commandMatchesProperCommandString() {
        assertTrue(PublishCommand.matches(PROPER_COMMAND));
    }

    @Test
    public void whenCommandExecutedThenMessageIsSaved() {
        User user = mock(User.class);
        when(storage.getUser(eq(USER))).thenReturn(user);

        Command command = PublishCommand.create(PROPER_COMMAND);
        List<String> output = command.execute(storage);


        verify(storage).getUser(eq(USER));
        verify(storage).publishMessage(eq(user), argThat(new ArgumentMatcher<ChatLine>() {
            @Override
            public boolean matches(Object o) {
                if(o instanceof ChatLine){
                    ChatLine line = (ChatLine)o;
                    return MESSAGE.equals(line.getLine()) && USER.equals(line.getUserName()) ;
                }
                return false;
            }

        }));
        assertTrue(output.isEmpty());

    }


}

