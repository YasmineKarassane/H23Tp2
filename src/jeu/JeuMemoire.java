package jeu;

import forme.Forme;
import forme.VecteurFormes;

import java.awt.*;
import java.util.ArrayList;
import java.util.Random;

public class JeuMemoire implements IJeuMemoire {

    /**
     * Nombre maximal de niveaux de jeu.
     */
    public static final int NIVEAU_MAX = 6;
    public static int COLONNE = 5;
    public static int LIGNE = 4;

    private static int LONGUEUR_CHAINE = 2;
    public static int NBR_ELEMENTS_GRILLE = 20;

    private final Forme[][] grilleDeJeu = new Forme[4][5];
    private int niveau = 1;
    private VecteurFormes vecteurFormes;
    private ArrayList<Point> vecteurPoints;

    public JeuMemoire() {
        preparerVecteurFormes();
        preparerGrilleDeJeu();
    }

    private String ajouterEspaces(int longueur, String stringRecue) {
        String newString = "";

        for (int i = 0; i < stringRecue.length(); i++) {
            newString += stringRecue.charAt(i);
        }

        while (newString.length() < longueur - 1) {
            newString += " ";
        }
        newString += "|";

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
        int x = getNombreAleatoireEntreBorne(1, COLONNE -1);
        int y = getNombreAleatoireEntreBorne(1, LIGNE-1);

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
        return getGrille()[ligne][colonne].getNom() + getGrille()[ligne][colonne].getCouleur().getNom();
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
        boolean estValide;
        Point point = new Point(colonne, ligne);

        estValide = vecteurPoints.get(0).equals(point);
        vecteurPoints.remove(0);

        return estValide;
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
        vecteurPoints = new ArrayList<>();
<<<<<<< Updated upstream

        for (int i = 0; i < getNiveau() + 2; i++) {
            vecteurPoints.add(i,choisirForme());

            for (int j = 0; j < i; j++) {
                if (vecteurPoints.get(i).equals(vecteurPoints.get(j))) {
                    vecteurPoints.set(i,choisirForme());
                    j--;
=======
        for (int i = 0; i < (getNiveau() + 2); i++) {
            vecteurPoints.add(i, choisirForme());
            boolean estPareil = false;

            do {

                for (int j = 0; j < vecteurPoints.size(); j++) {
                    vecteurPoints.set(i, choisirForme());
                    estPareil = vecteurPoints.get(i).equals(vecteurPoints.get(j));
                    if (estPareil) {
                        estPareil = false;
                    }
>>>>>>> Stashed changes
                }
            }

        }


        return vecteurPoints;
    }


    private void preparerGrilleDeJeu() {
        int indexVecteur = 0;
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 5; j++) {
                grilleDeJeu[i][j] = vecteurFormes.getVecteur().get(indexVecteur);
                indexVecteur++;
            }
        }
    }

    private void preparerVecteurFormes() {
        this.vecteurFormes = new VecteurFormes();
        this.vecteurFormes.remplir(NBR_ELEMENTS_GRILLE);
        vecteurFormes.melanger();
    }

    /**
     * Ajoute 1 au niveau si celui-ci est en-dessous de 6, autrement il demeure à 6.
     */
    @Override
    public void setNiveauPlusUn() {
        if (niveau < NIVEAU_MAX) {
            this.niveau = niveau + 1;
        }
    }

    @Override
    public String toString() {
        String stringARetourné = null;

        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 5; j++) {
                stringARetourné += ajouterEspaces(17, grilleDeJeu[i][j].toStringCourt());
            }
        }

        return stringARetourné;
    }

    public static void main(String[] args) {
        new JeuMemoire();

    }
}
