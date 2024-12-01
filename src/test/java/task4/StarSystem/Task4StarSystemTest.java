package task4.StarSystem;

import org.junit.jupiter.api.Test;
import ru.bahanov.pracJava.task4.A.Moon;
import ru.bahanov.pracJava.task4.A.Planet;
import ru.bahanov.pracJava.task4.A.Star;
import ru.bahanov.pracJava.task4.A.StarSystem;

import static org.junit.jupiter.api.Assertions.*;
import java.util.List;

public class Task4StarSystemTest {

    @Test
    public void testStarCreation() {
        Star sun = new Star("Солнце");
        assertEquals("Солнце", sun.getName());
    }

    @Test
    public void testPlanetCreationAndMoons() {
        Planet earth = new Planet("Земля");
        Moon moon = new Moon("Луна");
        earth.addMoon(moon);

        List<Moon> moons = earth.getMoons();
        assertEquals(1, moons.size());
        assertEquals("Луна", moons.get(0).getName());
    }

    @Test
    public void testPlanetEquality() {
        Planet earth1 = new Planet("Земля");
        Planet earth2 = new Planet("Земля");
        Planet mars = new Planet("Марс");

        assertEquals(earth1, earth2);
        assertNotEquals(earth1, mars);
    }

    @Test
    public void testMoonEquality() {
        Moon moon1 = new Moon("Луна");
        Moon moon2 = new Moon("Луна");
        Moon phobos = new Moon("Фобос");

        assertEquals(moon1, moon2);
        assertNotEquals(moon1, phobos);
    }

    @Test
    public void testStarSystemAddPlanet() {
        Star sun = new Star("Солнце");
        StarSystem solarSystem = new StarSystem(sun);

        Planet earth = new Planet("Земля");
        solarSystem.addPlanet(earth);

        Moon moon = new Moon("Луна");
        earth.addMoon(moon);

        solarSystem.printPlanetCount();
    }
}
