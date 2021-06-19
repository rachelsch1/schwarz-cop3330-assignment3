package assignment3.ex42.base;

/* Sometimes data comes in as a structured format that you have to break down and turn into records so you can process them. CSV, or comma-separated values, is a common standard for doing this.
Construct a program that reads in the following data file (you will need to create this data file yourself; name it `exercise42_input.txt`):
Ling,Mai,55900
Johnson,Jim,56500
Jones,Aaron,46000
Jones,Chris,34500
Swift,Geoffrey,14200
Xiong,Fong,65000
Zarnecki,Sabrina,51500
Process the records and display the results formatted as a table, evenly spaced, as shown in the example output.
Example Output
Last      First     Salary
--------------------------
Ling      Mai       55900
Johnson   Jim       56500
Jones     Aaron     46000
Jones     Chris     34500
Swift     Geoffrey  14200
Xiong     Fong      65000
Zarnecki  Sabrina   51500
Constraints
Write your own code to parse the data. Don't use a CSV parser.
 */

/*
UCF COP3330 Summer 2021 Assignment 3 Solution
Copyright 2021 Rachel Schwarz
 */

/* plan
- method: read in data from input file with string.split()
    put each array into a list of arrays, return list
- method: output list content as a table
 */

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.List;
import java.io.File;

public class ex42 {
    static File inputFile = new File("C:\\Users\\rachel\\Desktop\\code\\oop\\exercise42_input.txt");

    static Scanner scanner;

    static {
        try {
            scanner = new Scanner(inputFile);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        List<String[]> list = readInput(inputFile);

        printOutput(list);
    }

    public static List<String[]> readInput(File inputFile) {
        List<String[]> list = new ArrayList<>();
        String str;
        String[] arr;

        while(scanner.hasNextLine()) {
            str = scanner.nextLine();
            arr = str.split(",", 5);
            list.add(arr);
        }

        return list;
    }

    public static void printOutput(List<String[]> list) {
        System.out.format("%-10s%-10s%-10s\n", "Last", "First", "Salary");
        System.out.print("__________________________\n");

        for(String[] arr : list) {
            for (String a : arr) {
                System.out.format("%-10s", a);
            }
            System.out.print("\n");
        }
    }
}
