package assignment3.ex43.base;

/*Programming languages can create files and folders too.

Create a program that generates a website skeleton with the following specifications:

Prompt for the name of the site.
Prompt for the author of the site.
Ask if the user wants a folder for JavaScript files.
Ask if the user wants a folder for CSS files.
Generate an index.html file that contains the name of the site inside the <title> tag and the author in a <meta> tag.
Example Output
Site name: awesomeco
Author: Max Power
Do you want a folder for JavaScript? y
Do you want a folder for CSS? y
Created ./website/awesomeco
Created ./website/awesomeco/index.html
Created ./website/awesomeco/js/
Created ./website/awesomeco/css/
The user should then find these files and directories created in the working directory of your program.
 */

/*
UCF COP3330 Summer 2021 Assignment 3 Solution
Copyright 2021 Rachel Schwarz
 */

/* plan
- in main, prompt for site name, author, javascript folder, and css folder
- method: main folder
    create main folder and create html file, return true if folder created, false if not
- if js prompt y : method: js folder
    create js folder in main folder, return true if folder created, false if not
- if css prompt y : method css folder
    create css folder in main folder, return true if folder created, false if not
- method: print output
    pass boolean for each folder, print statement for each true
 */

// new File("/path/directory").mkdirs();

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class ex43 {
    public static void main(String[] args) throws IOException {
        Scanner input = new Scanner(System.in);

        System.out.print("Site name: ");
        String siteName = input.nextLine();
        System.out.print("Author: ");
        String author = input.nextLine();
        System.out.print("Do you want a folder for JavaScript? ");
        String js = input.nextLine();
        System.out.print("Do you want a folder for CSS? ");
        String css = input.nextLine();

        boolean mainFolder;
        mainFolder = createMainFolder(siteName, author);
        boolean jsFolder = false;
        boolean cssFolder = false;

        if(js.equals("y")) {
            jsFolder = createJsFolder(siteName);
        }
        if(css.equals("y")) {
            cssFolder = createCssFolder(siteName);
        }

        printOutput(mainFolder, jsFolder, cssFolder, siteName);
    }

    public static boolean createMainFolder(String siteName, String author) throws IOException {
        File htmlFile = new File("C:\\Users\\rachel\\Desktop\\code\\oop\\website\\" + siteName + "\\index.html");
        boolean status = htmlFile.mkdirs();
        BufferedWriter bw = new BufferedWriter(new FileWriter(htmlFile));
        bw.write("<html><title>"+siteName+"</title><meta>"+author+"</meta></html>");
        bw.close();

        return status;
    }

    public static boolean createJsFolder(String siteName) {
        File jsFolder = new File("C:\\Users\\rachel\\Desktop\\code\\oop\\website\\" + siteName + "\\js");
        boolean status = jsFolder.mkdirs();
        return status;
    }

    public static boolean createCssFolder(String siteName) {
        File cssFolder = new File("C:\\Users\\rachel\\Desktop\\code\\oop\\website\\" + siteName + "\\css");
        boolean status = cssFolder.mkdirs();
        return status;
    }

    public static void printOutput(boolean mainFolder, boolean jsFolder, boolean cssFolder, String siteName) {
        if(mainFolder) {
            System.out.println("Created ./website/"+siteName);
            System.out.println("Created ./website/"+siteName+"/index.html");
        }

        if(jsFolder) {
            System.out.println("Created ./website/"+siteName+"/js/");
        }

        if(cssFolder) {
            System.out.println("Created ./website/"+siteName+"/css/");
        }
    }
}
