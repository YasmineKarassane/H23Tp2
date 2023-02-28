
import forme.Cercle;
import forme.Forme;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CercleTest {

    @Test
    void calculerPerimetre() {
        Forme cercle = new Cercle(22);
        assertTrue(cercle.calculerPerimetre() == 138);
        assertFalse(cercle.calculerPerimetre() == 139);

    }

    @Test
    void calculerSurface() {
        Forme cercle = new Cercle(22);
        assertTrue(cercle.calculerSurface() == 1520);
        assertFalse(cercle.calculerSurface() == 1521);
    }
}