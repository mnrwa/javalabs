package task7;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

class DiscriminantCalculatorTest {

    @FunctionalInterface
    interface DiscriminantCalculator {
        double calculate(double a, double b, double c);
    }

    @Test
    void testDiscriminantCalculation() {
        DiscriminantCalculator discriminant = (a, b, c) -> (b * b) - (4 * a * c);

        assertEquals(41.0, discriminant.calculate(1, 7, 2), 0.001);
        assertEquals(0.0, discriminant.calculate(1, 2, 1), 0.001);
        assertEquals(21.0, discriminant.calculate(1, 5, 1), 0.001);
        assertEquals(-15.0, discriminant.calculate(2, 1, 2), 0.001);
    }
}
