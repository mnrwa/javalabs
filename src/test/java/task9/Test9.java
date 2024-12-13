package task9;

import org.junit.jupiter.api.*;
import ru.bahanov.pracJava.task9.FileNumberProcessor;

import java.io.*;
import java.nio.file.*;
import java.util.*;
import static org.junit.jupiter.api.Assertions.*;

class Test9 {
    private static final String TEST_FILE = "src/test/java/task9/data.txt";
    private FileNumberProcessor processor;

    @BeforeEach
    void setUp() throws IOException {
        processor = new FileNumberProcessor();
        Files.deleteIfExists(Paths.get(TEST_FILE));
    }

    @AfterEach
    void tearDown() throws IOException {
        Files.deleteIfExists(Paths.get(TEST_FILE));
    }

    @Test
    void testInvalidFormat() throws IOException {
        List<String> lines = Arrays.asList(
                "en_US;1234.56",
                "invalid_format",
                "ru_RU;789,01"
        );
        Files.write(Paths.get(TEST_FILE), lines);

        ByteArrayOutputStream err = new ByteArrayOutputStream();
        System.setErr(new PrintStream(err));

        processor.main(new String[]{TEST_FILE});

        String errorOutput = err.toString();
        assertTrue(errorOutput.contains("Некорректный формат строки: invalid_format"));
    }

    @Test
    void testInvalidNumber() throws IOException {
        List<String> lines = Arrays.asList(
                "en_US;1.7E309",
                "ru_RU;123,45"
        );
        Files.write(Paths.get(TEST_FILE), lines);

        ByteArrayOutputStream err = new ByteArrayOutputStream();
        System.setErr(new PrintStream(err));

        processor.main(new String[]{TEST_FILE});

        String errorOutput = err.toString();
        assertTrue(errorOutput.contains("Число превышает допустимое значение"));
    }

    @Test
    void testMissingFile() {
        ByteArrayOutputStream err = new ByteArrayOutputStream();
        System.setErr(new PrintStream(err));

        processor.main(new String[]{"src/test/java/task9/data.txt"});

        String errorOutput = err.toString();
        assertTrue(errorOutput.contains("Файл не найден"));
    }



}
