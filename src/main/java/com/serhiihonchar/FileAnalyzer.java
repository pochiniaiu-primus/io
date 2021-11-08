package com.serhiihonchar;

import java.io.*;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class FileAnalyzer {

    public static void readingFromFile() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the path to the file where the word must be found: ");
        String filename = scanner.nextLine();
        File file = new File(filename);
        Charset charset = StandardCharsets.UTF_8;
        String content;
        int count = 0;

        try (InputStream inputStream = new FileInputStream(file)) {

            Scanner sc = new Scanner(System.in);
            System.out.println("Enter the word to be found: ");
            String word = sc.nextLine();

            byte[] bytes = new byte[(int) file.length()];

            int offset = 0;
            while (offset < bytes.length) {
                int result = inputStream.read(bytes, offset, bytes.length - offset);
                content = new String(bytes, charset);
                String[] s = content.split(" ");

                //  str = str.replaceAll("(\\r|\\n)", "");
                for (String wordExample : s) {
                    if (wordExample.equals(word)) {
                        count++;
                    }
                    offset += result;
                }
            }
            if (count == 0) {
                System.out.println("Word not found!");
            } else {
                System.out.println("Word: " + word + " was found! Count : " + count);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        readingFromFile();
    }
}