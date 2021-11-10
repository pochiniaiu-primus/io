package com.serhiihonchar.fileanalyzer;

import java.io.*;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

public class FileAnalyzer {
    static File file;
    static String word;

    public static void main(String[] args) {
        file = new File(args[0]);
        word = args[1];
        readingFromFile();
    }

    public static void readingFromFile() {

        Charset charset = StandardCharsets.UTF_8;
        String content;
        int count = 0;

        try (InputStream inputStream = new FileInputStream(file)) {

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
}