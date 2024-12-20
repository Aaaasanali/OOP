package utils;

import java.util.Scanner;

public class InputPrompt {

    private static Scanner scanner = new Scanner(System.in);

    // Prompt method
    public static String promptInput(String message) {
        System.out.print(message);
        String input = scanner.nextLine();
        if (input.equalsIgnoreCase("quit")) {
            System.out.println("Operation cancelled.");
            return null; // Returning null to signify the user wants to quit
        }
        return input;
    }
}