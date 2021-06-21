package assignment3.ex45.base;

/* There will be times when you'll need to read in one file, modify it, and then write a modified version of that file to a new file.

Given an input file named `exercise45_input.txt`, read the file and look for all occurrences of the word utilize. Replace each occurrence with use. Write the modified file to a new file.

Example Output
Given the input file of

One should never utilize the word "utilize" in writing. Use "use" instead.
For example, "She uses an IDE to write her Java programs" instead of "She
utilizes an IDE to write her Java programs".
The program should generate

One should never use the word "use" in writing. Use "use" instead.
For example, "She uses an IDE to write her Java programs" instead of "She
uses an IDE to write her Java programs".
Constraints
Prompt for the name of the output file.
Write the output to a new file. */

/*
UCF COP3330 Summer 2021 Assignment 3 Solution
Copyright 2021 Rachel Schwarz
 */

/* plan
- in main, define path
- method: read input
    use readAllBytes to read the entire input file to a string
- use replaceAll to replace forms of utilize with use
- print modified string to new file with FileWriter
 */

import java.io.FileNotFoundException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class ex45 {
    static File inputFile = new File("C:\\Users\\rachel\\Desktop\\code\\oop\\exercise45_input.txt");
    static FileWriter writeFile;

    static {
        try {
            writeFile = new FileWriter("exercise45_output.txt");
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
        String path = "C:\\Users\\rachel\\Desktop\\code\\oop\\exercise45_input.txt";
        String str = readInput(inputFile, path);

        String replaceStr = str.replaceAll("utilize", "use");
        replaceStr = replaceStr.replaceAll("utilizes", "uses");
        replaceStr = replaceStr.replaceAll("\"utilize\"", "\"use\"");

        writeFile.write(replaceStr);
        writeFile.close();
    }

    public static String readInput(File inputFile, String path) {
        String str = "";
        try
        {
            str = new String ( Files.readAllBytes( Paths.get(path) ) );
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }

        return str;
    }
}

