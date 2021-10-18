package com.company;

import java.util.*;

public class Lab4 {
    public static void main(String[] args) {
        MainMenu.main();
    }
}

class MainMenu {

    public static void main() {
        Scanner in = new Scanner(System.in);

        System.out.println("Enter 1 for SumLimit");
        System.out.println("Enter 2 for SquirrelPlay");
        System.out.println("Enter 3 for GreenTicket");
        System.out.println("Enter 4 for CountXX");
        System.out.println("Enter 5 for StringTimes");

        String classType = in.nextLine();

        switch (classType) {
            case "1" -> {
                System.out.println("Please enter an integer");
                int a = in.nextInt();
                System.out.println("Please enter an another integer");
                int b = in.nextInt();

                SumLimit sl = new SumLimit(a, b);
                sl.a = 10;
                System.out.println("The solution is: " + sl.solution());
            }

            case "2" -> {
                System.out.println("What is the temperature?");
                int temp = in.nextInt();
                System.out.println("Is it summer? for yes type in:  true  (anything else will be false)");
                boolean summer = Objects.equals(in.next(), "true");

                SquirrelPlay sp = new SquirrelPlay(temp, summer);
                System.out.println("Are the squirrels playing?:" + sp.solution());
            }

            case "3" -> {
                System.out.println("Please enter first number: ");
                int a = in.nextInt();
                System.out.println("Please enter second number: ");
                int b = in.nextInt();
                System.out.println("Please enter third number: ");
                int c = in.nextInt();

                GreenTicket gt = new GreenTicket(a,b,c);

                System.out.println("The solution is: " + gt.solution());
            }

            case "4" -> {
                System.out.println("Please enter a string");
                String input = in.next();
                CountXX cx = new CountXX(input);
                System.out.println("The solution is: " + cx.solution());
            }

            case "5" -> {
                System.out.println("Please enter a string");
                String string = in.next();
                System.out.println("Please enter a number");
                int times = in.nextInt();

                StringTimes st = new StringTimes(string, times);

                System.out.println("The solution is: " + st.solution());
            }
        }
    }

}

class SumLimit {
    public int a;
    public int b;

    SumLimit(int a, int b) {
        this.a = a;
        this.b = b;
    }

    public Integer solution() {
        Integer numDigitsForA = a / 10;
        Integer numDigitsForSum = sum() / 10;

        if (numDigitsForSum.equals(numDigitsForA)) {
            return sum();
        } else {
            return null;
        }
    }

    public int sum() {
        return this.a + this.b;
    }
}

class SquirrelPlay {
    public int temp;
    public boolean summer;

    SquirrelPlay(int temp, boolean summer) {
        this.temp = temp;
        this.summer = summer;
    }

    public boolean solution() {
        if (temp < 60) return false;
        if (summer) return temp <= 100;
        return temp <= 90;
    }
}

class GreenTicket {
    public int a;
    public int b;
    public int c;

    GreenTicket(int a, int b, int c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public int solution() {
        if ( a == b && a == c) return 20;
        if ( a != b && b != c && a != c) return 0;
        return 10;
    }
}

class CountXX {
    public String input;

    public CountXX(String input) {
        this.input = input.toLowerCase(Locale.ROOT);
    }

    public int solution() {
        int count = 0;
        for(int i = 0; i < input.length() - 1; i++) {
            if (input.charAt(i) == 'x' && input.charAt(i + 1) == 'x') {
                count++;
            }
        }

        return count;
    }
}

class StringTimes {
    public String input;
    public int times;

    public StringTimes(String input, int times) {
        this.input = input;
        this.times = times;
    }

    public String solution() {
        return String.valueOf(input).repeat(Math.max(0, times));
    }
}

