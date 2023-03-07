package jeu;

import forme.Couleur;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class JeuMemoireTest {

    @Test
    void getGrille() {
        JeuMemoire jeu = new JeuMemoire();

        assertEquals("", jeu.getGrille());
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
        jeu1.getVecteur().trier();

        assertEquals("Cerclebleu", jeu1.getNomForme(1, 1));
    }

    @Test
    void getVecteur() {
        JeuMemoire jeu = new JeuMemoire();
        jeu.getVecteur().trier();
        assertEquals(" Cercle bleu Cercle jaune Cercle noir Cercle orange Cercle rouge Cercle rouge Cercle vert Rectangle bleu Rectangle jaune Rectangle noir Rectangle orange Rectangle rouge Rectangle rouge Rectangle vert Triangle bleu Triangle jaune Triangle noir Triangle orange Triangle rouge Triangle vert", jeu.getVecteur().toString());
    }

    @Test
    void jouerHumain() {
    }

    @Test
    void jouerOrdi() {
        JeuMemoire jeu1 = new JeuMemoire();

        assertFalse(jeu1.jouerOrdi().get(1).equals(jeu1.jouerOrdi().get(2)) && jeu1.jouerOrdi().get(1).equals(jeu1.jouerOrdi().get(3)));
    }
}