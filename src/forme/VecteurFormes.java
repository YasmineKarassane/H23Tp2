package forme;

import forme.IVecteurFormes;

import java.util.ArrayList;
import java.util.Random;

/**
 * Interface de manipulation d'un vecteur basé sur un ArrayList
 */
public class VecteurFormes implements IVecteurFormes {

    private ArrayList<Forme> vecteur;

<<<<<<< Updated upstream
    /**
     * Obtenir le vecteur de formes avec le nombre de forme
     *
     * @return le vecteur de formes
     */
=======
    public VecteurFormes() {
        this.vecteur = new ArrayList<>();
    }

>>>>>>> Stashed changes
    @Override
    public ArrayList<Forme> getVecteur() {
        return vecteur;
    }

    private void addForme(Forme forme, Couleur couleur) {
        forme.setCouleur(couleur);
        vecteur.add(forme);
    }

    /**
     * Mettre le nombre de formes voulues dans le vecteur. Les formes qui seront
     * placées dans le vecteur devront être générées de la façon suivante:
     * <p>
     * Tant que le nombre de formes souhaitées n'est pas atteint on crée une forme
     * à la fois, pour toutes les formes disponibles (Cercle, Rectangle et
     * Triangle) combiné à toutes les couleurs possibles (rouge, vert, bleu,
     * jaune, noir, orange). Quand toutes les combinaisons sont épuisées on
     * recommence.
     * <p>
     * Le but final étant d'obtenir le bon nombre de formes, les plus
     * diversifiées possibles.
     *
     * @param nbrElements le nombre de formes voulues
     */
    public void remplir(int nbrElements) throws ArrayIndexOutOfBoundsException {
        if (nbrElements > 0) {

            for (int j = 0; j < Couleur.values().length && validerNbrFormes(nbrElements); j++) {
                Forme cercle = new Cercle(5);
                addForme(cercle, Couleur.values()[j]);
                if (validerNbrFormes(nbrElements)) {
                    Forme rectangle = new Rectangle(5, 5);
                    addForme(rectangle, Couleur.values()[j]);
                }
                if (validerNbrFormes(nbrElements)) {
                    Forme triangle = new Triangle(5, 5, 5);
                    addForme(triangle, Couleur.values()[j]);
                }
            }
        } else {
            throw new ArrayIndexOutOfBoundsException();
        }
    }

    /**
     * Mélanger les éléments du vecteur.
     */
    public void melanger() {
        for (int i = 0; i < getVecteur().size(); i++) {
            Random chiffreRandom = new Random();
            int indexi = chiffreRandom.nextInt(getVecteur().size() - 1);
            int indexj = chiffreRandom.nextInt(getVecteur().size() - 1);
            permuter(indexi, indexj);
        }
    }

    /**
     * Trier en ordre croissant le vecteur de formes en utilisant le "compareTo"
     * disponible sur les objets.
     */
    public void trier() {
        int enOrdre;
        do {
            enOrdre = 0;
            for (int i = 0; i < getVecteur().size(); i++) {
                int valeur = getVecteur().get(i).compareTo(getVecteur().get(i + 1));
                if (valeur < 0) {
                    permuter(i, (i + 1));
                } else {
                    enOrdre++;
                }
            }
        } while (enOrdre < getVecteur().size());
    }

    private void permuter(int indicei, int indicej) {
        Forme temporairei = getVecteur().get(indicei);
        Forme temporairej = getVecteur().get(indicej);
        getVecteur().set(indicei, temporairej);
        getVecteur().set(indicej, temporairei);
    }

    @Override
    public String toString() {
        String stringARetourné = "";

        for (int i = 0; i < getVecteur().size(); i++) {
            stringARetourné += getVecteur().get(i).toStringCourt();
        }

        return stringARetourné;
    }

    private boolean validerNbrFormes(int nbFormes) {
        return vecteur.size() == nbFormes;
    }
}
