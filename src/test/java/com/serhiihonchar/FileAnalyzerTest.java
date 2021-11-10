package com.serhiihonchar;

import com.serhiihonchar.fileanalyzer.FileAnalyzer;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FileAnalyzerTest {
    FileAnalyzer analyzer = new FileAnalyzer();

    public static void main(String[] args) {
       FileAnalyzer.main(new String[]{"story.txt", "duck"});
    }
}