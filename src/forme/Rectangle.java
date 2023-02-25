package forme;

import Exceptions.FormeException;

/**
 * Classe Rectangle
 * Cette classe hérite de la classe Forme. Elle permet de construire un rectangle.
 *
 * @author Yasmine Karassane
 * @version 1.0 2020/02/16
 */
public class Rectangle extends Forme {

    /**
     * Hauteur du rectangle
     */
    private int hauteur;

    /**
     * Largeur du rectangle
     */
    private int largeur;

    /**
     * Constructeur de la classe Rectangle. Il a besoin d'une hauteur et d'une largeur pour former un rectangle.
     * @param hauteur du rectangle
     * @param largeur du rectangle
     */
    public Rectangle(int hauteur, int largeur) {
        setHauteur(hauteur);
        setLargeur(largeur);
    }

    /**
     * Calcule le périmètre du rectangle.
     * @return le perimètre.
     */
    public int calculerPerimetre() {
        return hauteur * 2 + largeur * 2;
    }

    /**
     * Calcule la surface du rectangle.
     * @return l'aire.
     */
    public int calculerSurface() {
        return hauteur * largeur;
    }

    /**
     * Vérifie que la hauteur est valide.
     * @param hauteur à vérifier.
     * @return true si la hauteur est valide et false si elle ne l'est pas.
     */
    public static boolean hauteurEstValide(int hauteur) {
        return MAX_VAL >= hauteur && MIN_VAL <= hauteur;
    }

    /**
     * Vérifie si la largeur est valide.
     * @param largeur à vérifier.
     * @return true si la largeur est valide est false si elle ne l'est pas.
     */
    public static boolean largeurEstValide(int largeur) {
        return MAX_VAL >= largeur && MIN_VAL <= largeur;
    }

    /**
     * Renvoie la hauteur.
     * @return hauteur
     */
    public int getHauteur() {
        return hauteur;

    }

    /**
     * Renvoie la largeur.
     * @return largeur
     */
    public int getLargeur() {
        return largeur;
    }

    /**
     * Vérifie si la hauteur donnée est valide. Si elle l'est cette hauteur devient la hauteur du rectangle,
     * sinon une exception est levée.
     * @param hauteur du rectangle
     */
    public void setHauteur(int hauteur) {
        if (hauteurEstValide(hauteur)) {
            this.hauteur = hauteur;
        } else
            throw new FormeException();
    }

    /**
     * Vérifie si la largeur donnée est valide. Si elle l'est cette largeur devient la largeur du rectangle,
     * sinon une exception est levée.
     * @param largeur du rectangle
     */
    public void setLargeur(int largeur) {
        if (largeurEstValide(largeur)) {
            this.largeur = largeur;
        } else throw new FormeException();
    }

    /**
     * Génère un String qui donne la hauteur et la largeur de mon rectangle.
     * @return un String qui donne les dimensions de mon rectangle.
     */
    @Override
    public String toString() {
        return super.toString() + hauteur + ", " + largeur + " (où " + hauteur + " est la hauteur et " + largeur + " est la largeur)";
    }
}
