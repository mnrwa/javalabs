package task10;

import org.junit.jupiter.api.Test;
import ru.bahanov.pracJava.task10.C.C;

import java.io.ByteArrayOutputStream;
import java.io.FileWriter;
import java.io.PrintStream;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class CTest {

    @Test
    void testDataProcessing() throws IOException {
        String testFilePath = "D:\\prac\\prac1\\src\\main\\java\\ru\\bahanov\\pracJava\\task10\\C\\data.txt";

        FileWriter writer = new FileWriter(testFilePath);
        writer.write("A 123 hello 3.14 x 45.6 world\n");
        writer.close();

        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;
        System.setOut(new PrintStream(baos));

        C.main(new String[]{});

        System.setOut(originalOut);

        String output = baos.toString();

        assertTrue(output.contains("Symbol: A"));
        assertTrue(output.contains("Integer: 123"));
        assertTrue(output.contains("Word: hello"));
        assertTrue(output.contains("Float: 3.14"));
        assertTrue(output.contains("Symbol: x"));
        assertTrue(output.contains("Float: 45.6"));
        assertTrue(output.contains("Word: world"));
    }
}
