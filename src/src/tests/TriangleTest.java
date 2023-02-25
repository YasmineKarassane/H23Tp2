
import forme.Triangle;
import forme.TypeTriangle;
import org.junit.jupiter.api.Test;
import Exceptions.CoteInvalide;
import Exceptions.TriangleInvalide;

import static org.junit.jupiter.api.Assertions.*;

class TriangleTest {

    @Test
    void calculerPerimetre() {
        Triangle triangle = new Triangle(3, 4, 5);
        assertEquals(12, triangle.calculerPerimetre());
        assertNotEquals(1, triangle.calculerPerimetre());
        assertNotEquals(12.20, triangle.calculerPerimetre(), 0.0);
        assertNotEquals(-12, triangle.calculerPerimetre());

        Triangle triangle0 = new Triangle(10, 20, 29);
        assertEquals(59, triangle0.calculerPerimetre());
    }

    @Test
    void calculerSurface() {
        Triangle triangle = new Triangle(4, 3, 5);
        assertEquals(6, triangle.calculerSurface());
        assertNotEquals(8, triangle.calculerSurface());

        Triangle triangle0 = new Triangle(10, 20, 29);
        assertEquals(52, triangle0.calculerSurface());
        assertNotEquals(52.27, triangle0.calculerSurface(), 0.0);
        assertNotEquals(5, triangle0.calculerSurface());

    }

    @Test
    void coteEstValide() {
        assertThrows(CoteInvalide.class, () -> Triangle.coteEstValide(-3));
        assertThrows(CoteInvalide.class, () -> Triangle.coteEstValide(0));
        assertThrows(CoteInvalide.class, () -> Triangle.coteEstValide(31));
        assertTrue(Triangle.coteEstValide(1));
        assertTrue(Triangle.coteEstValide(30));
        assertTrue(Triangle.coteEstValide(15));
    }

    @Test
    void estRectangle() {
        Triangle triangle = new Triangle(4, 3, 5);
        assertTrue(triangle.estRectangle());
        Triangle triangle0 = new Triangle(3, 3, 5);
        assertFalse(triangle0.estRectangle());
    }

    @Test
    void estTriangle() {
        assertTrue(Triangle.estTriangle(4, 3, 5));
        assertTrue(Triangle.estTriangle(6, 3, 8));
        assertThrows(TriangleInvalide.class, () -> Triangle.estTriangle(25, 1, 3));
    }

    @Test
    void getCoteA() {
        Triangle triangle = new Triangle(4, 3, 5);
        assertTrue(triangle.getCoteA() == 4);
        assertFalse(triangle.getCoteA() == 5);
        assertFalse(triangle.getCoteA() == 3);
        assertFalse(triangle.getCoteA() == -4);
    }

    @Test
    void getCoteB() {
        Triangle triangle = new Triangle(4, 3, 5);
        assertTrue(triangle.getCoteB() == 3);
        assertFalse(triangle.getCoteB() == 5);
        assertFalse(triangle.getCoteB() == 4);
        assertFalse(triangle.getCoteB() == -3);
    }

    @Test
    void getCoteC() {
        Triangle triangle = new Triangle(4, 3, 5);
        assertTrue(triangle.getCoteC() == 5);
        assertFalse(triangle.getCoteC() == 4);
        assertFalse(triangle.getCoteC() == 3);
        assertFalse(triangle.getCoteC() == -5);
    }

    @Test
    void getType() {
        Triangle triangle = new Triangle(4, 3, 5);
        assertTrue(triangle.getType() == TypeTriangle.RECTANGLE);
        assertFalse(triangle.getType() == TypeTriangle.ISOCELE);
        assertFalse(triangle.getType() == TypeTriangle.EQUILATERAL);
        assertFalse(triangle.getType() == TypeTriangle.SCALENE);

        Triangle triangle0 = new Triangle(10, 10, 8);
        assertTrue(triangle0.getType() == TypeTriangle.ISOCELE);
        assertFalse(triangle0.getType() == TypeTriangle.EQUILATERAL);
        assertFalse(triangle0.getType() == TypeTriangle.RECTANGLE);
        assertFalse(triangle0.getType() == TypeTriangle.SCALENE);

        Triangle triangle1 = new Triangle(5, 5, 5);
        assertTrue(triangle1.getType() == TypeTriangle.EQUILATERAL);
        assertFalse(triangle1.getType() == TypeTriangle.ISOCELE);
        assertFalse(triangle1.getType() == TypeTriangle.RECTANGLE);
        assertFalse(triangle1.getType() == TypeTriangle.SCALENE);

        Triangle triangle2 = new Triangle(8, 15, 9);
        assertTrue(triangle2.getType() == TypeTriangle.SCALENE);
        assertFalse(triangle2.getType() == TypeTriangle.ISOCELE);
        assertFalse(triangle2.getType() == TypeTriangle.RECTANGLE);
        assertFalse(triangle2.getType() == TypeTriangle.EQUILATERAL);
    }


//    @Test
//    void testToString() {
//        Forme triangle = new Triangle( 5,7,10);
//        triangle.setCouleur(Couleur.JAUNE);
//        assertTrue(triangle.toString() == "Triangle jaune scalène 5, 7, 10 (où 5 est coteA, 7 est coteB et 10 est coteC)");
//    }
}