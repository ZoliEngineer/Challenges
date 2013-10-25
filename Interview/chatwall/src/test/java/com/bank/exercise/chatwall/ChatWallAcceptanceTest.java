package com.bank.exercise.chatwall;


import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class ChatWallAcceptanceTest {
    private ChatWall instance = new ChatWall();
    @Test
    public void verifyGivenScenario() throws InterruptedException {
        List<String> input = new ArrayList<>();
        input.add("Alice -> I love the weather today");
        input.add("Bob -> Oh, we lost!");
        input.add("Bob -> at least it's sunny");
        input.add("Alice");
        input.add("Bob");
        input.add("Charlie -> I'm in New York today! Anyone wants to have a coffee?");

        List<String> output = new ArrayList<>();

        for(String command : input){
            output.addAll(instance.executeCommand(command));
            Thread.sleep(1000);
        }

        for(String outLine : output){
            System.out.println(outLine);
        }
    }

}
