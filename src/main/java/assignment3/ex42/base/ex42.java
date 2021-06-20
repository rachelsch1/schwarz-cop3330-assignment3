package assignment3.ex42.base;

/*
UCF COP3330 Summer 2021 Assignment 3 Solution
Copyright 2021 Rachel Schwarz
 */

/* plan
- method: read in data from input file with scanner
    use string.split() to remove commas + separate data
    put each array into a list of arrays, return list
- method: output list content as a table
    print header + line
    print each array with space formatting
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
