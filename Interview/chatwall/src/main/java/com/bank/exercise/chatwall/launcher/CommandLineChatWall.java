package com.bank.exercise.chatwall.launcher;

import com.bank.exercise.chatwall.ChatWall;

import java.util.List;
import java.util.Scanner;

public class CommandLineChatWall {
    private static final String PROMPT = ">";
    private static final ChatWall applicationInstance = new ChatWall();
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String... args) {
        System.out.println("Initiating application");
        start();
    }

    public static void start() {
        boolean exitInitiated = false;
        while (exitInitiated == false) {
            System.out.print(PROMPT);
            String input = scanner.nextLine();
            List<String> result = applicationInstance.executeCommand(input);
                   handleResult(result);
        }
    }

    private static void handleResult( List<String> result)   {
        for(String s : result){
            System.out.println(s);
        }
    }
}
