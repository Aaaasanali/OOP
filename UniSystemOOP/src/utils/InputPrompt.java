package utils;

import java.util.Scanner;

public class InputPrompt {

    public transient static Scanner scanner = new Scanner(System.in);

    // Prompt method for string inputs
    public static String promptInput(String message) {
        System.out.print(message);
        String input = scanner.nextLine();
        if (input.equalsIgnoreCase("quit")) {
            System.out.println("Operation cancelled.");
            return null; // Returning null to signify the user wants to quit
        }
        return input;
    }

    // Prompt method for integer inputs
    public static int promptIntInput(String message) {
        while (true) {
            System.out.print(message);
            String input = scanner.nextLine();
            if (input.equalsIgnoreCase("quit")) {
                System.out.println("Operation cancelled.");
                return -1; // Returning -1 to signify the user wants to quit
            }
            try {
                return Integer.parseInt(input);
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a valid number.");
            }
        }
    }
}