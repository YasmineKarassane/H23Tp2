package jeu;

import forme.Forme;
import forme.VecteurFormes;

import java.awt.*;
import java.util.ArrayList;
import java.util.Random;

public class JeuMemoire implements IJeuMemoire {

    public static int COLONNE = 4;
    public static int LIGNE = 5;
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
        String newString = "";

        for (int i = 0; i < stringRecue.length() && !newString.equalsIgnoreCase("rectangle") &&
                !newString.equalsIgnoreCase("cercle") && !newString.equalsIgnoreCase("triangle"); i++) {
            newString += stringRecue.charAt(i);
        }
        newString += " ";

        for (int i = 0; i < stringRecue.length(); i++) {
            newString += stringRecue.charAt(i);
        }

        while (newString.length() < longueur) {
            newString += " ";
        }

        return newString;
    }

    public static int getNombreAleatoireEntreBorne(int min, int max) {
        if (min >= max) {
            throw new IllegalArgumentException("max doit être plus grand que min");
        }
        Random r = new Random();
        return r.nextInt((max - min) + 1) + min;
    }

    private Point choisirForme() {
        int x = getNombreAleatoireEntreBorne(1, COLONNE);
        int y = getNombreAleatoireEntreBorne(1, LIGNE);

        Point point = new Point(x, y);

        return point;
    }

    public Forme[][] getGrille() {
        return grilleDeJeu;
    }

    /**
     * Connaître le niveau du jeu.
     *
     * @return le niveau du jeu
     */
    @Override
    public int getNiveau() {
        return niveau;
    }

    /**
     * Obtenir sous forme de chaîne sans espace le nom et la couleur de la forme
     * à l'emplacement désiré dans la grille.
     *
     * @param ligne   coordonnée ligne de la matrice grille
     * @param colonne coordonnée colonne de la matrice grille
     * @return nom et couleur concaténée en chaîne de caractère
     */
    @Override
    public String getNomForme(int ligne, int colonne) {
        return getGrille()[ligne][colonne].getNom() + getGrille()[ligne][colonne].getCouleur();
    }

    public VecteurFormes getVecteur() {
        return vecteurFormes;
    }

    /**
     * Valide si la coordonnée jouée par le joueur humain est valide et dans
     * l'ordre selon les coordonnées générées par l'ordinateur. Voir la méthode
     * "jouerOrdi()"
     *
     * @param ligne   coordonnée ligne de la grille
     * @param colonne coordonnée colonne dans la grille
     * @return oui ou non si la coordonnée du joueur est la coordonnée jouée par
     * l'ordi dans l'ordre respecté.
     */
    @Override
    public boolean jouerHumain(int ligne, int colonne) {
        return false;
    }

    /**
     * L'intelligence du jeu. Génère un tableau de coordonnées (des objets <b>Point(colonne, ligne)</b>)
     * au hasard. Les points générés doivent être valides dans la grille de jeu.
     * Le nombre de points générés est en relation avec le niveau courant du jeu.
     * Il obéit à la règle suivante :
     * <p>
     * Le nombre de points générés = niveau courant du jeu + 2
     *
     * <b>Il est important qu'un même point ne soit pas choisi 2 fois.</b>
     * <b>Note</b>: la classe java.awt.Point encapsule un x et un y. Alors que dans le JeuMemoire,
     * on utilise plutôt colonne et ligne. Ainsi, x correspond à colonne et y à ligne.
     *
     * @return la liste des coordonnées <b>Point(colonne, ligne)</b> des formes choisies dans la grille.
     */
    @Override
    public ArrayList<Point> jouerOrdi() {
        int j = -1;
        for (int i = 0; i < getNiveau(); i++) {
            do {
                j++;
                choisirForme();
            } while (choisirForme().equals(vecteurPoints.get(j)));
        }

        return vecteurPoints;
    }

    public static void main(String[] args) {

    }

    private void preparerGrilleDeJeu() {

    }

    private void preparerVecteurFormes() {

    }

    /**
     * Ajoute 1 au niveau si celui-ci est en-dessous de 6, autrement il demeure à 6.
     */
    @Override
    public void setNiveauPlusUn() {
        this.niveau = this.niveau + 1;
    }

    @Override
    public String toString() {
        return "JeuMemoire{}";
    }
}
