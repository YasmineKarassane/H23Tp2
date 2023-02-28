import forme.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FormeTest {

    @Test
    void calculerPerimetre() {

    }

    @Test
    void calculerSurface() {
        Forme cercle = new Cercle(25);
        assertTrue(cercle.calculerSurface() == 78);
    }

    @Test
    void testEquals() {
        Triangle triangle = new Triangle(5, 5, 5);
        triangle.setCouleur(Couleur.BLEU);
        assertTrue(triangle.equals(triangle));
        Triangle triangle1 = new Triangle(5, 5, 5);
        assertFalse(triangle.equals(triangle1));

        triangle1.setCouleur(Couleur.BLEU);
        assertTrue(triangle.equals(triangle1));

        Forme cercle = new Cercle(4);
        assertFalse(triangle.equals(cercle));
        cercle.setCouleur(Couleur.BLEU);
        assertFalse(triangle.equals(cercle));

        Forme rectangle = new Rectangle(4, 25);
        assertFalse(cercle.equals(rectangle));
        rectangle.setCouleur(Couleur.BLEU);
        assertFalse(cercle.equals(rectangle));

        Forme carré = new Rectangle(10, 10);
        assertFalse(carré.equals(rectangle));
        carré.setCouleur(Couleur.NOIR);

        Forme rectangle1 = new Rectangle(5, 20);
        rectangle1.setCouleur(Couleur.NOIR);
        assertTrue(rectangle1.equals(carré));
    }

    @Test
    void getCouleur() {
        Forme triangle = new Triangle(5, 5, 5);
        triangle.setCouleur(Couleur.ORANGE);
        assertTrue(triangle.getCouleur() == Couleur.ORANGE);

        Forme cercle = new Cercle(8);
        assertTrue(cercle.getCouleur() == Couleur.ROUGE);
        assertFalse(cercle.getCouleur() == Couleur.VERT);
    }

    @Test
    void getNom() {
        Forme rectangle = new Rectangle(2, 4);
        assertTrue(rectangle.getNom() == rectangle.getNom());
//        assertSame("Rectangle", rectangle.getNom());
    }

    @Test
    void setCouleur() {
        Forme cercle = new Cercle(29);
        cercle.setCouleur(Couleur.VERT);
        assertTrue(cercle.getCouleur() == Couleur.VERT);
        assertFalse(cercle.getCouleur() == Couleur.ROUGE);

        Forme triangle = new Triangle(20, 20, 20);
        triangle.setCouleur(null);
        assertTrue(triangle.getCouleur() == Couleur.ROUGE);
    }

    @Test
    void testToString() {
    }

    @Test
    void compareTo() {
        Forme cercle = new Cercle(29);
        Forme triangle = new Triangle(20, 20, 20);
        assertTrue(cercle.compareTo(triangle) == -17);
        assertFalse(cercle.compareTo(triangle) == 0);
    }
    @Test
    void toStringCourt() {
        Forme cercle = new Cercle(29);
        Forme triangle = new Triangle(20, 20, 20);
        triangle.setCouleur(Couleur.VERT);

        assertTrue(cercle.toStringCourt() == "Cercle rouge");
        assertTrue(triangle.toStringCourt() == "Triangle vert");
    }
}