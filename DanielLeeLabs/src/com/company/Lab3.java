package com.company;

import java.util.*;

class Lab3 {
    public static void main() {
        Scanner in = new Scanner(System.in);
        String input;
        boolean runAgain;

        do {
            System.out.println("Please enter a string to work on: ");
            System.out.println("Note: alphabetical characters will be converted to lower case");
            input = in.nextLine();
            System.out.println("Please pick a program function: ");
            System.out.println("1 for removing a given char from an inputted string: ");
            System.out.println("2 for removing all duplicates from an inputted string: ");
            System.out.println("3 for counting consonants and vowles in inputted string: ");
            System.out.println("4 for displaying the first non repeated character of a string then the repeating characters: ");
            String function = in.nextLine();

            switch (function) {
                case "1" -> {
                    System.out.println("Please enter a char to remove");
                    char remove = in.nextLine().toCharArray()[0];
                    System.out.println(removeGivenChar(input, remove));
                }
                case "2" -> System.out.println(removeDuplicates(input));
                case "3" -> characterTypeCount(input);
                case "4" -> System.out.println(wordMixUp(input));
                default -> System.out.println("Please enter 1, 2, 3, or 4");
            }

            System.out.println("Run program again? Enter y for yes: ");
            String runAgainInput = in.nextLine();
            runAgain = Objects.equals(runAgainInput, "y");
        } while (runAgain);

        System.out.println("Bye!");
    }

    public static String removeGivenChar(String string, char remove) {
        string = string.toLowerCase(Locale.ROOT);
        StringBuilder solution = new StringBuilder();

        for (char letter : string.toCharArray()) {
            if (letter != remove) {
                solution.append(letter);
            }
        }

        return solution.toString();
    }

    public static String removeDuplicates(String string) {
        string = string.toLowerCase(Locale.ROOT);
        Map<Character, Integer> duplicates = findDuplicates(string);

        StringBuilder solution = new StringBuilder();

        for (char letter : string.toCharArray()) {
            if (duplicates.get(letter) == 1) {
                solution.append(letter);
            }
        }

        return solution.toString();
    }

    public static Map<Character, Integer> findDuplicates(String string) {
        string = string.toLowerCase(Locale.ROOT);
        Map<Character, Integer> duplicateMap = new HashMap<>();

        for (char letter : string.toCharArray()) {
            duplicateMap.putIfAbsent(letter, 0);
            Integer currentCharacterCount = duplicateMap.get(letter);
            duplicateMap.put(letter, currentCharacterCount + 1);
        }

        return duplicateMap;
    }

    public static void characterTypeCount(String string) {
        string = string.toLowerCase(Locale.ROOT);

        final HashMap<Integer, Boolean> vowelAsciiValues = new HashMap<Integer, Boolean>() {{
            put(97, true);
            put(101, true);
            put(105, true);
            put(111, true);
            put(117, true);
        }};

        int vowelCount = 0;
        int consonantCount = 0;

        for (char letter : string.toLowerCase(Locale.ROOT).toCharArray()) {
            int ascii = letter;
            if (ascii < 65 || ascii > 122) {
                // letter is not in the english alphabet, just ignore
                continue;
            }

            if (vowelAsciiValues.containsKey(ascii)) {
                vowelCount++;
            } else {
                consonantCount++;
            }
        }

        System.out.println("Vowel count is: " + vowelCount);
        System.out.println("Consonant count is: " + consonantCount);
    }

    public static String wordMixUp(String string) {
        string = string.toLowerCase(Locale.ROOT);

        Map<Character, Integer> duplicates = findDuplicates(string);

        StringBuilder solution = new StringBuilder();

        solution.append(removeDuplicates(string));

        for (char letter : string.toCharArray()) {
            if (duplicates.get(letter) > 1) {
                solution.append(letter);
            }
        }

        return solution.toString();
    }
}
