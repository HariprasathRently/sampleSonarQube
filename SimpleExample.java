package com.example;

import java.util.List;

public class SimpleExample {

    public static void main(String[] args) {
        // Example with a potential null pointer exception
        String text = null;
        System.out.println(text.length()); // This will cause a NullPointerException
        
        // Example of an un/home/rently/Documents/MASTER AUTOMATION/RentlyQE-masterused variable (SonarQube will detect this)
        int unusedVariable = 100;

        // Example of a method with too many parameters (SonarQube will flag this)
        printMessage("Hello, World!", 123, true, 1.5);
    }

    // Example of a method with too many parameters (SonarQube will flag this)
    public static void printMessage(String message, int number, boolean flag, double value) {
        System.out.println(message + " " + number + " " + flag + " " + value);

        System.out.println(message + " " + number + " " + flag + " " + value);
        System.out.println(message + " " + number + " " + flag + " " + value);
        System.out.println(message + " " + number + " " + flag + " " + value);
    }
}
