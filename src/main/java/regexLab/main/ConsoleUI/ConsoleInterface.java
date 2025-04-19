package regexLab.main.ConsoleUI;
import automaton.DFA;
import regexLab.main.postalCodeAutomatons.IcelandPostalCodeAutomaton;
import regexLab.main.postalCodeAutomatons.RussianPostalCodeAutomaton;
import regexLab.main.postalCodeAutomatons.USZipCodeAutomaton;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.List;

/**
 * Console interface for postal code validation and generation.
 * Allows users to interact with different postal code automata.
 */
public class ConsoleInterface {
    private static final Scanner scanner = new Scanner(System.in);

    // Available automata
    private static final RussianPostalCodeAutomaton russianAutomaton = new RussianPostalCodeAutomaton();
    private static final USZipCodeAutomaton usAutomaton = new USZipCodeAutomaton();
    private static final IcelandPostalCodeAutomaton icelandAutomaton = new IcelandPostalCodeAutomaton();

    // String generator for creating valid postal codes
    private static final int MAX_GENERATION_LENGTH = 10;
    private static final int DEFAULT_GENERATION_COUNT = 1;

    public static void main(String[] args) {
        boolean running = true;

        System.out.println("Welcome to Postal Code Validator and Generator");

        while (running) {
            displayMainMenu();
            int choice = getIntInput(0, 3);

            switch (choice) {
                case 1:
                    handlePostalCodeValidation();
                    break;
                case 2:
                    handlePostalCodeGeneration();
                    break;
                case 3:
                    displayHelp();
                    break;
                case 0:
                    running = false;
                    System.out.println("Exiting program. Goodbye!");
                    break;
            }
        }

        scanner.close();
    }

    /**
     * Displays the main menu options.
     */
    private static void displayMainMenu() {
        System.out.println("\n===== MAIN MENU =====");
        System.out.println("1. Validate a postal code");
        System.out.println("2. Generate postal codes");
        System.out.println("3. Help");
        System.out.println("0. Exit");
        System.out.print("Enter your choice: ");
    }

    /**
     * Handles the postal code validation workflow.
     */
    private static void handlePostalCodeValidation() {
        System.out.println("\n===== POSTAL CODE VALIDATION =====");
        displayCountryMenu();

        int countryChoice = getIntInput(0, 3);
        if (countryChoice == 0) return;

        DFA selectedAutomaton = getAutomatonByChoice(countryChoice);
        String countryName = getCountryNameByChoice(countryChoice);

        System.out.print("Enter a " + countryName + " postal code to validate: ");
        String postalCode = scanner.next();

        boolean isValid = selectedAutomaton.accepts(postalCode);
        System.out.println("Result: The postal code '" + postalCode + "' is " +
                (isValid ? "VALID" : "INVALID") + " for " + countryName);

        if (!isValid) {
            System.out.println("Trace information:");
            System.out.println(selectedAutomaton.trace(postalCode));
        }
    }

    /**
     * Handles the postal code generation workflow.
     */
    private static void handlePostalCodeGeneration() {
        System.out.println("\n===== POSTAL CODE GENERATION =====");
        displayCountryMenu();

        int countryChoice = getIntInput(0, 3);
        if (countryChoice == 0) return;

        DFA selectedAutomaton = getAutomatonByChoice(countryChoice);
        String countryName = getCountryNameByChoice(countryChoice);

        System.out.print("How many postal codes do you want to generate? (default: " +
                DEFAULT_GENERATION_COUNT + "): ");

        int count;
        try {
            String input = scanner.next();
            if (input.trim().isEmpty()) {
                count = DEFAULT_GENERATION_COUNT;
            } else {
                count = Integer.parseInt(input);
                if (count <= 0) {
                    System.out.println("Invalid count. Using default: " + DEFAULT_GENERATION_COUNT);
                    count = DEFAULT_GENERATION_COUNT;
                }
            }
        } catch (NumberFormatException e) {
            System.out.println("Invalid input. Using default: " + DEFAULT_GENERATION_COUNT);
            count = DEFAULT_GENERATION_COUNT;
        }

        System.out.println("\nGenerating " + count + " valid " + countryName + " postal codes:");
        List<String> generatedCodes = new ArrayList<>();
        for(int i =0; i< count; i++){
            generatedCodes.add(selectedAutomaton.generateAcceptableString());
        }

        if (generatedCodes.isEmpty()) {
            System.out.println("Failed to generate any valid postal codes.");
        } else {
            for (int i = 0; i < generatedCodes.size(); i++) {
                System.out.println((i + 1) + ". " + generatedCodes.get(i));
            }
        }
    }

    /**
     * Displays the country selection menu.
     */
    private static void displayCountryMenu() {
        System.out.println("Select a country:");
        System.out.println("1. Russia");
        System.out.println("2. United States");
        System.out.println("3. Iceland");
        System.out.println("0. Back to main menu");
        System.out.print("Enter your choice: ");
    }

    /**
     * Displays help information.
     */
    private static void displayHelp() {
        System.out.println("\n===== HELP =====");
        System.out.println("This program allows you to validate and generate postal codes for different countries.");
        System.out.println("\nValid postal code formats:");
        System.out.println("- Russian postal code: 6 digits (e.g., 123456)");
        System.out.println("- US ZIP code: 5 digits or 5+4 digits with hyphen (e.g., 12345 or 12345-6789)");
        System.out.println("- Iceland postal code: 3 digits (e.g., 101)");

        System.out.println("\nPress Enter to continue...");
        scanner.nextLine(); // Consume the newline
        scanner.nextLine(); // Wait for user input
    }

    /**
     * Gets integer input from the user with validation.
     *
     * @param min Minimum valid value (inclusive)
     * @param max Maximum valid value (inclusive)
     * @return The validated integer input
     */
    private static int getIntInput(int min, int max) {
        int input = -1;
        boolean validInput = false;

        while (!validInput) {
            try {
                input = scanner.nextInt();
                if (input >= min && input <= max) {
                    validInput = true;
                } else {
                    System.out.print("Please enter a number between " + min + " and " + max + ": ");
                }
            } catch (InputMismatchException e) {
                System.out.print("Invalid input. Please enter a number: ");
                scanner.next(); // Clear the invalid input
            }
        }

        return input;
    }

    /**
     * Returns the appropriate automaton based on the user's choice.
     *
     * @param choice The user's country choice
     * @return The corresponding DFA
     */
    private static DFA getAutomatonByChoice(int choice) {
        switch (choice) {
            case 1: return russianAutomaton;
            case 2: return usAutomaton;
            case 3: return icelandAutomaton;
            default: throw new IllegalArgumentException("Invalid choice: " + choice);
        }
    }

    /**
     * Returns the country name based on the user's choice.
     *
     * @param choice The user's country choice
     * @return The corresponding country name
     */
    private static String getCountryNameByChoice(int choice) {
        switch (choice) {
            case 1: return "Russian";
            case 2: return "US";
            case 3: return "Iceland";
            default: throw new IllegalArgumentException("Invalid choice: " + choice);
        }
    }
}
