package com.company;

import java.util.*;


public class Main {
    public static void main(String[] args) {
        var lab5 = new Lab5();
        new Lab5Tests(lab5);
    }
}

class Lab5 {
    public int countA(char[] chars) {
        int count = 0;
        for (char letter : chars) {
            if (letter == 'a') {
                count++;
            }
        }

        return count;
    }

    public char[] deleteSpaces(char[] chars) {
        int spaceCount = 0;
        char[] solution = new char[chars.length];

        for (int i = 0; i < chars.length; i++) {
            int letter = chars[i];
            if (letter == 32) {
                spaceCount++;
            } else {
                solution[i - spaceCount] = chars[i];
            }
        }

        return Arrays.copyOf(solution, chars.length - spaceCount);
    }

    public char[] findDuplicateLetters(char[] chars) {
        var charCountMap = new HashMap<Character, Integer>();

        for (char letter : chars) {
            if (charCountMap.containsKey(letter)) {
                charCountMap.put(letter, charCountMap.get(letter) + 1);
            } else {
                charCountMap.put(letter, 1);
            }
        }

        var solution = new char[0];

        for (char key: charCountMap.keySet()) {
            var value = charCountMap.get(key);

            if (value > 1) {
                solution = Arrays.copyOf(solution, solution.length + 1);
                solution[solution.length - 1] = key;
            }
        }

        return solution;
    }

    public String reverseBySpace(String input) {
        var inputSplit = input.split(" ");

        String solution = "";

        for (int i = inputSplit.length - 1; i >= 0; i--) {
            solution += inputSplit[i];

            if (i != 0) {
                solution += " ";
            }
        }

        return solution;
    }
}

class Lab5Tests {

    Lab5 lab5;

    public Lab5Tests(Lab5 lab5) {
        this.lab5 = lab5;

        char[] input1 = { 'a', 'a' };
        int expected = 2;
        int result = lab5.countA(input1);
        System.out.println("[a, a] should become 2 => " + (result == expected));

        char[] input2 = { 'b', 'a' };
        int expected2 = 1;
        int result2 = lab5.countA(input2);
        System.out.println("[b, a] should become 1 => " + (result2 == expected2));


        char[] input3 = { 'b', ' ', 'a' };
        char[] expected3 = {'b', 'a'};
        System.out.println("[b,' ',a] should become ['b', 'a'] => " + Arrays.equals(lab5.deleteSpaces(input3), expected3));


        char[] input4 = {'b', 'b', 'a'};
        char[] expected4 = {'b'};
        char[] result4 = lab5.findDuplicateLetters(input4);
        System.out.println("{'b', 'b', 'a'} should become ['b'] => " + Arrays.equals(result4, expected4));


        
        String input5 = "reverse me please";
        String expected5 = "please me reverse";
        String result5 = lab5.reverseBySpace(input5);
        System.out.println("`reverse me please` should equal `please me reverse` => " + expected5.equals(result5));
    }
}
