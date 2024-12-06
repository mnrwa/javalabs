package task10;

import org.junit.jupiter.api.*;
import java.io.*;
import java.nio.file.*;

import static org.junit.jupiter.api.Assertions.*;

class Atest {

    @Test
    void Atest() throws IOException {
        Path tempFile = Files.createTempFile("data", ".txt");
        Files.writeString(tempFile, "Когда жизнь как солнце\nВ весна ты");

        String[] wordList = {"жизнь", "Когда", "ты", "весна", "солнце"};
        int[] expectedFrequencies = {1, 1, 1, 1, 1};
        int[] frequencies = new int[wordList.length];

        try (BufferedReader reader = new BufferedReader(new FileReader(tempFile.toFile()))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] words = line.toLowerCase().replaceAll("[^а-яё\\s]", "").split("\\s+");
                for (String word : words) {
                    for (int i = 0; i < wordList.length; i++) {
                        if (word.equals(wordList[i].toLowerCase())) {
                            frequencies[i]++;
                        }
                    }
                }
            }
        }

        for (int i = 0; i < frequencies.length; i++) {
            System.out.println(wordList[i] + ": " + frequencies[i]);
        }

        assertArrayEquals(expectedFrequencies, frequencies);

        Files.delete(tempFile);
    }

}
