
package jeu;

import forme.Couleur;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.awt.*;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class JeuMemoireTest {

    static public JeuMemoire jeu = new JeuMemoire();
    static public ArrayList<Point> vecteurPoints = jeu.jouerOrdi();

    @Test
    void getGrille() {

    }

    @Test
    void getNiveau() {

    }

    @Test
    void getNomForme() {

        System.out.println(jeu.getNomForme(1, 1));
        System.out.println(jeu.getNomForme(1, 2));
        System.out.println(jeu.getNomForme(2, 1));
        System.out.println(jeu.getNomForme(2, 4));
    }

    @Test
    void getVecteur() {

    }

    @Test
    void jouerHumain() {

        Point point0 = vecteurPoints.get(0);
        Point point1 = vecteurPoints.get(1);
        assertTrue(jeu.jouerHumain(point0.y, point0.x));
        assertTrue(jeu.jouerHumain(point1.y, point1.x));

        Point point0v2 = jeu.jouerOrdi().get(0);
        assertTrue(jeu.jouerHumain(point0v2.y, point0v2.x));
        assertFalse(jeu.jouerHumain(point0v2.y, point0v2.x));

        Point point1v3 = jeu.jouerOrdi().get(1);
        assertFalse(jeu.jouerHumain(point1v3.y, point1v3.x));
        assertTrue(jeu.jouerHumain(point1v3.y, point1v3.x));

        Point point = jeu.jouerOrdi().get(2);
        assertFalse(jeu.jouerHumain(point1v3.y, point1v3.x));
        assertFalse(jeu.jouerHumain(point0.y, point0.x));
        assertFalse(jeu.jouerHumain(point1.y, point1.x));
    }

    @Test
    void jouerOrdi() {

    }
}