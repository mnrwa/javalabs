package task8;

import org.junit.jupiter.api.Test;
import ru.bahanov.pracJava.task8.A.TextProcessor;
import static org.junit.jupiter.api.Assertions.*;

public class ATest {

    @Test
    public void testRemoveCharacter() {
        String input = "Влюбленность начинается с того.";
        String expected = "Влюбленнсть начинается с тг.";
        assertEquals(expected, TextProcessor.processText(input, 'о', 0, 0));
    }

    @Test
    public void testInsertCharacter() {
        String input = "Влюбленность";
        String expected = "ВлюTбленность";
        assertEquals(expected, TextProcessor.processText(input, 'T', 2, 1));
    }

    @Test
    public void testInsertCharacterInvalidPosition() {
        String input = "Тест";
        String expected = "Тест";
        assertEquals(expected, TextProcessor.processText(input, '@', 10, 1));
    }
}
