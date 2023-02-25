import forme.Forme;
import forme.Rectangle;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RectangleTest {

    @Test
    void calculerPerimetre() {
        Forme rectangle = new Rectangle(4, 5);
        assertTrue(rectangle.calculerPerimetre() == 18);
        assertFalse(rectangle.calculerPerimetre() == 30);
        assertFalse(rectangle.calculerPerimetre() == 18.2);

        Forme rectangle0 = new Rectangle(18, 23);
        assertTrue(rectangle0.calculerPerimetre() == 82);
        assertFalse(rectangle.calculerPerimetre() == 120);
        assertFalse(rectangle.calculerPerimetre() == 82.8);
    }

    @Test
    void calculerSurface() {
        Forme rectangle = new Rectangle(4, 5);
        assertTrue(rectangle.calculerSurface() == 20);
        assertFalse(rectangle.calculerSurface() == 20.4);
        assertFalse(rectangle.calculerSurface() == 0);

        Forme rectangle0 = new Rectangle(18, 23);
        assertTrue(rectangle0.calculerSurface() == 414);
        assertFalse(rectangle0.calculerSurface() == 0);
        assertFalse(rectangle0.calculerSurface() == 414.7);
    }
}