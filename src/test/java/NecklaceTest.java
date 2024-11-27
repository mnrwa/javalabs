import org.junit.jupiter.api.Test;
import ru.bahanov.pracJava.task4.B.models.Gem;
import ru.bahanov.pracJava.task4.B.models.PreciousGem;
import ru.bahanov.pracJava.task4.B.models.SemiPreciousGem;
import ru.bahanov.pracJava.task4.B.services.Necklace;

import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

public class NecklaceTest {


    @Test
    public void testCalculateTotalWeight() {
        Necklace necklace = new Necklace();
        necklace.addGem(new PreciousGem("Алмаз", 1.5, 10000, 95));
        necklace.addGem(new SemiPreciousGem("Аметист", 2.0, 300, 70));

        assertEquals(3.5, necklace.calcTotalGramm(), 0.01);
    }

    @Test
    public void testCalculateTotalPrice() {
        Necklace necklace = new Necklace();
        necklace.addGem(new PreciousGem("Алмаз", 1.5, 10000, 95));
        necklace.addGem(new SemiPreciousGem("Аметист", 2.0, 300, 70));

        assertEquals(10300, necklace.calcTotalPrice(), 0.01);
    }


    @Test
    public void testFindGemsByTransparencyRange() {
        Necklace necklace = new Necklace();
        necklace.addGem(new PreciousGem("Алмаз", 1.5, 10000, 95));
        necklace.addGem(new SemiPreciousGem("Аметист", 2.0, 300, 70));
        necklace.addGem(new SemiPreciousGem("Топаз", 1.2, 700, 80));

        List<Gem> result = necklace.findGemsByTransparencyRange(75, 100);
        assertEquals(2, result.size());
        assertEquals("Алмаз", result.get(0).getName());
        assertEquals("Топаз", result.get(1).getName());
    }
}
