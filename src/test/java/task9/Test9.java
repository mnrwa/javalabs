package task9;

import org.junit.jupiter.api.*;
import ru.bahanov.pracJava.task9.A;

import java.io.*;
import java.nio.file.*;
import java.util.*;
import static org.junit.jupiter.api.Assertions.*;

class Test9 {
    private static final String TEST_FILE = "D:\\prac\\prac1\\src\\main\\java\\ru\\bahanov\\pracJava\\task9\\data.txt";
    private A processor;

    @BeforeEach
    void setUp() throws IOException {
        processor = new A();
        Files.deleteIfExists(Paths.get(TEST_FILE));
    }

    @AfterEach
    void tearDown() throws IOException {
        // Удаляем файл после теста
        Files.deleteIfExists(Paths.get(TEST_FILE));
    }

    @Test
    void testValidFile() throws IOException {
        List<String> lines = Arrays.asList(
                "en_US;1234.56",
                "ru_RU;789,01",
                "fr_FR;456.78"
        );
        Files.write(Paths.get(TEST_FILE), lines);

        ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));

        processor.main(new String[]{TEST_FILE});

        String output = out.toString();
        assertTrue(output.contains("Сумма: 3703,68"));
        assertTrue(output.contains("Среднее: 1234.56"));
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

        processor.main(new String[]{"D:\\prac\\prac1\\src\\main\\java\\ru\\bahanov\\pracJava\\task9\\data.txt"});

        String errorOutput = err.toString();
        assertTrue(errorOutput.contains("Файл не найден"));
    }

    @Test
    void testEmptyFile() throws IOException {
        Files.createFile(Paths.get(TEST_FILE));

        ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));

        processor.main(new String[]{TEST_FILE});

        String output = out.toString();
        assertTrue(output.contains("Сумма: 3703,68"));
        assertTrue(output.contains("Среднее: 1234.56"));
    }

    @Test
    void testOutOfMemoryError() throws IOException {
        StringBuilder largeData = new StringBuilder();
        for (int i = 0; i < 10_000_000; i++) {
            largeData.append("en_US;1.0\n");
        }
        Files.write(Paths.get(TEST_FILE), Collections.singletonList(largeData.toString()));

        ByteArrayOutputStream err = new ByteArrayOutputStream();
        System.setErr(new PrintStream(err));

        processor.main(new String[]{TEST_FILE});

        String errorOutput = err.toString();
        assertTrue(errorOutput.contains("Ошибка: недостаточно памяти для выполнения операции."));
    }
}
