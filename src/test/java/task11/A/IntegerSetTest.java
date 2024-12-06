package task11.A;

import org.junit.jupiter.api.*;
import ru.bahanov.pracJava.task11.A.IntegerSet;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class IntegerSetTest {

    private IntegerSet set1;
    private IntegerSet set2;

    @BeforeEach
    void setUp() {
        set1 = new IntegerSet();
        set1.add(1);
        set1.add(2);
        set1.add(3);
        set1.add(4);

        set2 = new IntegerSet();
        set2.add(3);
        set2.add(4);
        set2.add(5);
        set2.add(6);
    }

    @Test
    void testIntersection() {
        IntegerSet intersection = set1.intersection(set2);
        assertTrue(intersection.contains(3), "Пересечение должно содержать 3");
        assertTrue(intersection.contains(4), "Пересечение должно содержать 4");
        assertFalse(intersection.contains(1), "Пересечение не должно содержать 1");
        assertFalse(intersection.contains(2), "Пересечение не должно содержать 2");
        assertFalse(intersection.contains(5), "Пересечение не должно содержать 5");
        assertFalse(intersection.contains(6), "Пересечение не должно содержать 6");
    }

    @Test
    void testUnion() {
        IntegerSet union = set1.union(set2);
        assertTrue(union.contains(1), "Объединение должно содержать 1");
        assertTrue(union.contains(2), "Объединение должно содержать 2");
        assertTrue(union.contains(3), "Объединение должно содержать 3");
        assertTrue(union.contains(4), "Объединение должно содержать 4");
        assertTrue(union.contains(5), "Объединение должно содержать 5");
        assertTrue(union.contains(6), "Объединение должно содержать 6");
    }

    @Test
    void testAddAndContains() {
        IntegerSet set = new IntegerSet();
        set.add(10);
        set.add(20);

        assertTrue(set.contains(10), "Множество должно содержать 10");
        assertTrue(set.contains(20), "Множество должно содержать 20");
        assertFalse(set.contains(30), "Множество не должно содержать 30");
    }

    @Test
    void testRemove() {
        set1.remove(1);
        set1.remove(5);

        assertFalse(set1.contains(1), "Множество не должно содержать 1 после удаления");
        assertFalse(set1.contains(5), "Множество не должно содержать 5, так как его нет в множестве");
    }
}
