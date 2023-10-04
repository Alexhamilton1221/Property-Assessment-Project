/*-------------------------------------------------------
# Student's Name: Alexander Hamilton
# Lab #1 main.java
# Lab Section: X02L
# Instructor's Name: Brian Brookwell
# CMPT 360
*------------------------------------------------------*/ 

import java.util.Scanner;

public class main
{
    public static void main(String[] args) {

        /**  Instance of functions class */
        functions functionInstance = new functions();

        /**  Instance of test_functions class */
        test_functions testfunctionInstance = new test_functions();


        /**  Ask user for test run or regular run*/
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter 't' or 'T' to test properties or any other key to get properties: ");
        String input = scanner.nextLine();

        if (input.equalsIgnoreCase("t")) {
            testfunctionInstance.test_get_properties();
        } else {
            functionInstance.get_properties(); 
        }
    }
}
