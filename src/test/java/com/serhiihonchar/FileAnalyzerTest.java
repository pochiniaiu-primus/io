package com.serhiihonchar;

import com.serhiihonchar.fileanalyzer.FileAnalyzer;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FileAnalyzerTest {
    FileAnalyzer analyzer = new FileAnalyzer();
    File path = new File("story.txt");
    String word = "duck";

    @Test
    @DisplayName("Test finds the number of words in the file")
    void testShouldReturnRightCountOfWord() {
        assertEquals(2, analyzer.readingFromFile(path, word));
    }
}