package task8;

import org.junit.jupiter.api.Test;
import ru.bahanov.pracJava.task8.B.WordSorter;

import java.util.ArrayList;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

public class BTest {

    @Test
    public void testRemoveExtraSpaces() {
        String input = "  Влюбленность   начинается\tс того.  ";
        String cleanedText = WordSorter.cleanText(input);
        assertEquals("Влюбленность начинается с того.", cleanedText);
    }

    @Test
    public void testSortWordsAlphabetically() {
        List<String> words = List.of("Влюбленность", "начинается", "с", "того", "человек", "другого");
        List<String> sortedWords = WordSorter.sortWords(new ArrayList<>(words)); // Создаем копию для мутации
        List<String> expectedOrder = List.of("Влюбленность", "другого", "начинается", "с", "того", "человек");
        assertEquals(expectedOrder, sortedWords);
    }
}
