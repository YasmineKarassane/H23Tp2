package forme;

import forme.IVecteurFormes;

import java.util.ArrayList;
import java.util.Random;

public class VecteurFormes implements IVecteurFormes {

    private ArrayList<Forme> vecteur;

    @Override
    public ArrayList<Forme> getVecteur() {
        return null;
    }

    private void addForme(Forme forme, Couleur couleur) {
        forme.setCouleur(couleur);
        getVecteur().add(forme);
    }

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

    public void melanger() {
        for (int i = 0; i < getVecteur().size(); i++) {
            Random chiffreRandom = new Random();
            int indexi = chiffreRandom.nextInt(getVecteur().size() - 1);
            int indexj = chiffreRandom.nextInt(getVecteur().size() - 1);
            permuter(indexi, indexj);
        }
    }

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
