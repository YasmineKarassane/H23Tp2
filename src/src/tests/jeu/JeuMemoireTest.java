package jeu;

import forme.Couleur;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class JeuMemoireTest {

    @Test
    void getGrille() {
    }

    @Test
    void getNiveau() {

    }

    @Test
    void getNomForme() {
        JeuMemoire jeu1 = new JeuMemoire();
        System.out.println(jeu1.getNomForme(1,1));
        System.out.println(jeu1.getNomForme(1,2));
        System.out.println(jeu1.getNomForme(2,1));
        System.out.println(jeu1.getNomForme(2,4));
    }

    @Test
    void getVecteur() {
    }

    @Test
    void jouerHumain() {
    }

    @Test
    void jouerOrdi() {
    }
}