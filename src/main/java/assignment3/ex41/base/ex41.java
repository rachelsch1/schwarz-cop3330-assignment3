package assignment3.ex41.base;

/* Alphabetizing the contents of a file, or sorting its contents, is a great way to get comfortable manipulating a file in your program.
        Create a program that reads in the following list of names from a file called `exercise41_input.txt` and sorts the list alphabetically:
        Ling, Mai
        Johnson, Jim
        Zarnecki, Sabrina
        Jones, Chris
        Jones, Aaron
        Swift, Geoffrey
        Xiong, Fong
        Then print the sorted list to a file called `exercise41_output.txt` that looks like the following example output.
        Example Output
        Total of 7 names
        -----------------
        Johnson, Jim
        Jones, Aaron
        Jones, Chris
        Ling, Mai
        Swift, Geoffrey
        Xiong, Fong
        Zarnecki, Sabrina
        Constraint
        Don't hard-code the number of names. */
/*
UCF COP3330 Summer 2021 Assignment 3 Solution
Copyright 2021 Rachel Schwarz
 */

/* plan
- method: loop that reads in names
        in each loop iteration, use scanner to read input, add string to list- return list
- use java.util.Collections.sort(list) to sort the names alphabetically
- method: print names to output file
 */

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.List;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class ex41 {
    static File inputFile = new File("exercise41_input.txt");
    static FileWriter writeFile;

    static {
        try {
            writeFile = new FileWriter("exercise41_output.txt");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static Scanner scanner;

    static {
        try {
            scanner = new Scanner(inputFile);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws IOException {
        List<String> list = new ArrayList<>();
        list = readInput(inputFile);

        printOutput(list, writeFile);
    }

    public static List<String> readInput(File inputFile) {
        List<String> list = new ArrayList<>();

        while(scanner.hasNextLine()) {
            list.add(scanner.nextLine());
        }

        return list;
    }

    public static void printOutput(List<String> list, FileWriter writeFile) throws IOException {
        for(Object str: list) {
            writeFile.write(str + System.lineSeparator());
        }
    }
}
