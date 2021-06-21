package assignment3.ex45.base;

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

    static Scanner scanner;

    static {
        try {
            scanner = new Scanner(inputFile);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws IOException {
        Scanner input = new Scanner(System.in);
        String path = "C:\\Users\\rachel\\Desktop\\code\\oop\\exercise45_input.txt";
        String str = readInput(inputFile, path);

        String replaceStr = str.replaceAll("utilize", "use");
        replaceStr = replaceStr.replaceAll("utilizes", "uses");
        replaceStr = replaceStr.replaceAll("\"utilize\"", "\"use\"");

        System.out.print("What is the name of the output file? ");
        String output = input.nextLine();
        FileWriter writeFile = new FileWriter(output);

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

