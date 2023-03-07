/*
420-202 – TP2 – Traitement de données orienté objet
Lien GIT Hub : https://github.com/YasmineKarassane/H23Tp2/commits/main
Nom : Karassane, Yasmine; ton DA
Nom : Riverin, Gabriel; 2244454
 */

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
        JeuMemoire jeu = new JeuMemoire();

        String attendue = jeu.getGrille()[1][1].toString();
        assertFalse(attendue.equals(null));
        assertEquals(attendue, jeu.getGrille()[1][1].toString());
    }

    @Test
    void getNiveau() {
        JeuMemoire jeu = new JeuMemoire();
        assertEquals(1, jeu.getNiveau());
        jeu.setNiveauPlusUn();
        assertEquals(2, jeu.getNiveau());
        jeu.setNiveauPlusUn();
        jeu.setNiveauPlusUn();
        jeu.setNiveauPlusUn();
        assertEquals(5, jeu.getNiveau());
        jeu.setNiveauPlusUn();
        assertEquals(6, jeu.getNiveau());
        jeu.setNiveauPlusUn();
        assertEquals(6, jeu.getNiveau());

    }

    @Test
    void getNomForme() {
        JeuMemoire jeu1 = new JeuMemoire();
        String attendue = jeu1.getNomForme(1, 1);

        assertFalse(attendue.equals(null));
        assertEquals(attendue, jeu1.getNomForme(1, 1));
    }

    @Test
    void getVecteur() {
        JeuMemoire jeu = new JeuMemoire();
        jeu.getVecteur().trier();
        assertEquals(" Cercle bleu Cercle jaune Cercle noir Cercle orange Cercle rouge Cercle rouge Cercle vert Rectangle bleu Rectangle jaune Rectangle noir Rectangle orange Rectangle rouge Rectangle rouge Rectangle vert Triangle bleu Triangle jaune Triangle noir Triangle orange Triangle rouge Triangle vert", jeu.getVecteur().toString());
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
        JeuMemoire jeu1 = new JeuMemoire();

        assertFalse(jeu1.jouerOrdi().get(1).equals(jeu1.jouerOrdi().get(2)) && jeu1.jouerOrdi().get(1).equals(jeu1.jouerOrdi().get(3)));
    }
}