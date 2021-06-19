package assignment3.ex41.base;

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
import java.util.Collections;

public class ex41 {
    static File inputFile = new File("C:\\Users\\rachel\\Desktop\\code\\oop\\exercise41_input.txt");
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

        Collections.sort(list);

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
        writeFile.write("Total of " + list.size() + " names\n------------------\n");
        for(String str: list) {
            writeFile.write(str + System.lineSeparator());
        }
        writeFile.close();
    }
}
