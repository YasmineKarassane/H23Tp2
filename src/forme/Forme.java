package forme; /**
 * Classe Forme
 * Cette classe est la super classe qui donne à rectangle, cercle et triangle.
 *
 * @author Yasmine Karassane
 * @version 1.0 2020/02/16
 */

import java.util.Objects;

public abstract class Forme implements Comparable<Forme> {

    /**
     * Couleur par défaut de notre forme. Dans ce cas, c'est rouge.
     */
    public static Couleur COULEUR_DEFAUT = Couleur.ROUGE;

    /**
     * Valeur maximale des données des formes (rayon, hauteur, base et côtés)
     */
    public static final int MAX_VAL = 30;

    /**
     * Valeur minimale des données des formes (rayon, hauteur, base et côtés)
     */
    public static final int MIN_VAL = 1;

    /**
     * Couleur de la forme
     */
    private Couleur couleur;

    /**
     * Nom de la forme
     */
    private String nom;

    /**
     * Constructeur, le nom est le nom de la classe en String
     * et la couleur est la couleur par défaut à moins que l'on donne une couleur à la forme avec setCouleur.
     */
    public Forme(String nom) {
        this.nom = nom;
        setCouleur(couleur);
    }

    /**
     * Force les classes qui héritent de celle-ci d'avoir une méthode qui calcule le périmètre.
     *
     * @return le périmètre
     */
    public abstract int calculerPerimetre();

    /**
     * Force les classes qui héritent de celle-ci d'avoir une méthode qui calcule la surface.
     *
     * @return l'aire
     */
    public abstract int calculerSurface();

    /**
     * Dit si les deux objects sont égaux. Ils sont égaux s'ils ont le même nom, la même couleur
     * et la même surface.
     *
     * @param nvlForme : forme avec laquelle nous décidons si elle est égale à notre forme d'instance.
     * @return true si les deux formes sont égales et false si elles ne le sont pas
     */
    @Override
    public boolean equals(Object nvlForme) {
        if (this == nvlForme) return true;
        if (nvlForme == null || getClass() != nvlForme.getClass()) return false;
        Forme forme = (Forme) nvlForme;
        return Objects.equals(nom, forme.nom) && Objects.equals(couleur, forme.couleur) && Objects.equals(calculerSurface(), forme.calculerSurface());
    }

    /**
     * Renvoie la couleur de la forme d'instance.
     *
     * @return la couleur de la forme
     */
    public Couleur getCouleur() {
        return couleur;
    }

    /**
     * Renvoie le nom de la forme d'instance.
     *
     * @return le nom de la forme
     */
    public String getNom() {
        return nom;
    }

    /**
     * Donne une couleur à la forme
     *
     * @param couleur : couleur que l'on donne à la forme. Elle doit être de type Couleur.
     */
    public void setCouleur(Couleur couleur) {
        if (couleur != null) {
            this.couleur = couleur;
        } else this.couleur = COULEUR_DEFAUT;
    }

    /**
     * Génére un String qui donne le nom, la couleur ainsi que les dimensions de ma forme.
     *
     * @return Un String qui décrit ma forme.
     */
    @Override
    public String toString() {
        return nom + " " + couleur.getNom() + " " + calculerSurface() + ", " + calculerSurface();
    }

    /**
     * Compare deux formes.
     *
     * @param o la forme qui est comparée.
     * @return un int qui me dit si ma forme comparée est inférieur, supérieur ou égale à ma forme d'instance.
     */
    @Override
    public int compareTo(Forme o) {
        int compare;
        String nomCouleur = o.nom + o.couleur;
        compare = (this.nom + this.couleur).compareTo(nomCouleur);
        return compare;
    }

    public String toStringCourt() {
        return getNom() + " " + couleur.getNom();
    }
}
