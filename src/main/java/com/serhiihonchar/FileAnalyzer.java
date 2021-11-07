package com.serhiihonchar;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.Scanner;

public class FileAnalyzer {
    public static void main(String[] args) throws Exception {
//        File file = null;
//        if (0 < args.length) {
//            String filename = args[0];
//            file = new File(filename);
//        }
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the path to the file where the word must be found: ");
        String filename = scanner.nextLine();
        File file = new File(filename);
        int count = 0;
        String s;
        String[] buffer;

        FileReader fileReader = new FileReader(file);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the word to be found: ");
        String word = sc.nextLine();


        while ((s = bufferedReader.readLine()) != null) {
            buffer = s.split(" ");
            for (String chr : buffer) {
                if (chr.equals(word)) {
                    count++;
                }
            }
        }
        if (count == 0) {
            System.out.println("Word not found!");
        } else {
            System.out.println("Word: " + word + " found! Count : " + count);
        }
        fileReader.close();
    }
}