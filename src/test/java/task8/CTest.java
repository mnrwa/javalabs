package task8;

import org.junit.jupiter.api.Test;
import ru.bahanov.pracJava.task8.C.TextCompressor;

import static org.junit.jupiter.api.Assertions.*;

public class CTest {

    @Test
    public void testCompressionBasic() {
        String input = "hellowoooorld";
        String expectedCompressed = "hel2owo4rld";
        assertEquals(expectedCompressed, TextCompressor.compress(input));
    }

    @Test
    public void testDecompressionBasic() {
        String compressedInput = "hel2owo4rld";
        String expectedDecompressed = "hellowoooorld";
        assertEquals(expectedDecompressed, TextCompressor.decompress(compressedInput));
    }

    @Test
    public void testCompressionNoRepeats() {
        String input = "abcdef";
        String expectedCompressed = "abcdef";
        assertEquals(expectedCompressed, TextCompressor.compress(input));
    }

    @Test
    public void testDecompressionNoRepeats() {
        String compressedInput = "abcdef";
        String expectedDecompressed = "abcdef";
        assertEquals(expectedDecompressed, TextCompressor.decompress(compressedInput));
    }

    @Test
    public void testCompressionAllRepeats() {
        String input = "aaa";
        String expectedCompressed = "a3";
        assertEquals(expectedCompressed, TextCompressor.compress(input));
    }

    @Test
    public void testDecompressionAllRepeats() {
        String compressedInput = "a3";
        String expectedDecompressed = "aaa";
        assertEquals(expectedDecompressed, TextCompressor.decompress(compressedInput));
    }

    @Test
    public void testCompressionMixedCase() {
        String input = "AAAbbbCCC";
        String expectedCompressed = "A3b3C3";
        assertEquals(expectedCompressed, TextCompressor.compress(input));
    }

    @Test
    public void testDecompressionMixedCase() {
        String compressedInput = "A3b3C3";
        String expectedDecompressed = "AAAbbbCCC";
        assertEquals(expectedDecompressed, TextCompressor.decompress(compressedInput));
    }

    @Test
    public void testEmptyString() {
        String input = "";
        String expectedCompressed = "";
        assertEquals(expectedCompressed, TextCompressor.compress(input));
        assertEquals(expectedCompressed, TextCompressor.decompress(input));
    }

    @Test
    public void testCompressionLargeRepeats() {
        String input = "bbbbbbbbbb";
        String expectedCompressed = "b10";
        assertEquals(expectedCompressed, TextCompressor.compress(input));
    }

    @Test
    public void testDecompressionLargeRepeats() {
        String compressedInput = "b5";
        String expectedDecompressed = "bbbbb";
        assertEquals(expectedDecompressed, TextCompressor.decompress(compressedInput));
    }

    @Test
    public void testInvalidInputDecompress() {
        String compressedInput = "abc7";
        String expectedDecompressed = "abccccccc";
        assertEquals(expectedDecompressed, TextCompressor.decompress(compressedInput));
    }
}
