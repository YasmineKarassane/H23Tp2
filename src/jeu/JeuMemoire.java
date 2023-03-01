package jeu;

import forme.Forme;
import forme.VecteurFormes;

import java.awt.*;
import java.util.ArrayList;

public abstract class JeuMemoire implements IJeuMemoire {

    public static int COULEUR;
    public static int LIGNE;
    private static int LONGUEUR_CHAINE;
    public static int NBR_ELEMENTS_GRILLE;

    private final Forme[][] grilleDeJeu = new Forme[4][5];
    private int niveau;
    private VecteurFormes vecteurFormes;
    private ArrayList<Point> vecteurPoints;

    public JeuMemoire() {
        this.vecteurFormes.remplir(20);
        vecteurFormes.melanger();

        int indexVecteur = 0;
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 5; j++) {
                grilleDeJeu[i][j] = vecteurFormes.getVecteur().get(indexVecteur);
                indexVecteur++;
            }
        }
    }

    private String ajouterEspaces(int longueur, String stringRecue) {
        return null;
    }

    private Point choisirForme() {
        return null;
    }

    public Forme[][] getGrille() {
        return grilleDeJeu;
    }

    @Override
    public int getNiveau() {
        return niveau;
    }

    public String getNomForme(int ligne, int colonne) {
        return getGrille()[ligne][colonne].getNom() + getGrille()[ligne][colonne].getCouleur();
    }

    public VecteurFormes getVecteur() {
        return vecteurFormes;
    }

    public abstract boolean jouerHumain(int colonne, int ligne);

    public abstract ArrayList<Point> jouerOrdi();

    public static void main(String[] args) {

    }

    private void preparerGrilleDeJeu() {

    }

    private void preparerVecteurFormes() {

    }

    public void setNiveauPlusUn() {
        this.niveau = this.niveau + 1;
    }

    @Override
    public String toString() {
        return "JeuMemoire{}";
    }
}
