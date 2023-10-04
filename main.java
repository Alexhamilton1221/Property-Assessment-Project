/*-------------------------------------------------------
# Student's Name: Alexander Hamilton
# main.java
# Lab Section: X02L
# Instructor's Name: Brian Brookwell
# CMPT 360
*------------------------------------------------------*/ 

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        /** Instance of functions class */
        Functions functionInstance = new Functions();

        /** Instance of test_functions class */
        Test_Functions testfunctionInstance = new Test_Functions();

        /** Ask the user for a test run or regular run */
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter 't' or 'T' to test properties or any other key to get properties: ");
        String input = scanner.nextLine();

        if (input.equalsIgnoreCase("t")) {
            testfunctionInstance.test_get_properties();
        } else {
            functionInstance.getProperties();
        }
    }
}
