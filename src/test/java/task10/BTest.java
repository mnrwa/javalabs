package task10;

import org.junit.jupiter.api.*;
import ru.bahanov.pracJava.task10.B.Gem;
import ru.bahanov.pracJava.task10.B.Necklace;
import ru.bahanov.pracJava.task10.B.PreciousGem;
import ru.bahanov.pracJava.task10.B.SemiPreciousGem;
import ru.bahanov.pracJava.task10.B.NecklaceConnector;

import java.io.*;
import java.nio.file.*;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class BTest {

    private Necklace necklace;

    @BeforeEach
    void setUp() {
        necklace = new Necklace();
        necklace.addGem(new PreciousGem("Алмаз", 1.5, 5000, 92.0));
        necklace.addGem(new PreciousGem("Изумруд", 2.0, 4000, 90.0));
        necklace.addGem(new SemiPreciousGem("Аметист", 1.2, 200, 80.0));
        necklace.addGem(new SemiPreciousGem("Топаз", 3.0, 300, 85.0));
    }

    @Test
    void testTotalWeight() {
        double expectedWeight = 1.5 + 2.0 + 1.2 + 3.0; // Подсчитайте правильный вес
        assertEquals(expectedWeight, necklace.getTotalWeight(), 0.001, "Общий вес не совпадает");
    }

    @Test
    void testTotalPrice() {
        double expectedPrice = 1.5 * 5000 + 2.0 * 4000 + 1.2 * 200 + 3.0 * 300;
        assertEquals(expectedPrice, necklace.getTotalPrice(), 0.001, "Общая стоимость не совпадает");
    }

    @Test
    void testFindGemsByTransparency() {
        List<Gem> result = necklace.findGemsByTransparency(80.0, 90.0);
        assertEquals(3, result.size(), "Количество найденных камней не совпадает");
        assertTrue(result.stream().anyMatch(g -> g.getName().equals("Топаз")), "Топаз отсутствует в результатах");
        assertTrue(result.stream().anyMatch(g -> g.getName().equals("Аметист")), "Аметист отсутствует в результатах");
    }

    @Test
    void testSortByPrice() {
        necklace.sortByPrice();
        List<Gem> gems = necklace.findGemsByTransparency(0, 100);
        assertEquals("Аметист", gems.get(0).getName(), "Первый камень после сортировки должен быть Аметист");
        assertEquals("Топаз", gems.get(1).getName(), "Второй камень после сортировки должен быть Топаз");
        assertEquals("Алмаз", gems.get(2).getName(), "Третий камень после сортировки должен быть Алмаз");
        assertEquals("Изумруд", gems.get(3).getName(), "Четвёртый камень после сортировки должен быть Изумруд");
    }

    @Test
    void testSerialization() throws IOException, ClassNotFoundException {
        Path tempFile = Files.createTempFile("necklace", ".dat");

        NecklaceConnector.saveNecklace(necklace, tempFile.toString());

        Necklace loadedNecklace = NecklaceConnector.loadNecklace(tempFile.toString());

        assertNotNull(loadedNecklace, "Ожерелье должно быть успешно десериализовано");
        assertEquals(necklace.getTotalWeight(), loadedNecklace.getTotalWeight(), 0.001, "Вес десериализованного ожерелья не совпадает");
        assertEquals(necklace.getTotalPrice(), loadedNecklace.getTotalPrice(), 0.001, "Стоимость десериализованного ожерелья не совпадает");

        Files.delete(tempFile);
    }
}
