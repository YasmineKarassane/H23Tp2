package forme;

import forme.IVecteurFormes;

import java.util.ArrayList;
import java.util.Random;

public abstract class VecteurFormes implements IVecteurFormes {

    private ArrayList<Forme> vecteur;

    public void remplir(int nbrElements) throws ArrayIndexOutOfBoundsException {
        if (nbrElements > 0) {
            for (int i = 0; i < nbrElements; i++) {

                for (int j = 0; j < Couleur.values().length; j++) {
                    Forme cercle = new Cercle(5);
                    getVecteur().set(i, cercle);
                    cercle.setCouleur(Couleur.values()[j]);
                    i++;
                    if (nbrElements < i) {
                        Forme rectangle = new Rectangle(5, 5);
                        getVecteur().set(i, rectangle);
                        i++;
                        rectangle.setCouleur(Couleur.values()[j]);
                    }
                    if (nbrElements < i) {
                        Forme triangle = new Triangle(5, 5, 5);
                        getVecteur().set(i, triangle);
                        i++;
                        triangle.setCouleur(Couleur.values()[j]);
                    }
                }

            }
        } else {
            throw new ArrayIndexOutOfBoundsException();
        }
    }

    public void melanger() {

    }

//    public void shuffle() {
//        Object[] tabTemporaire = new Object[size()];
//
//        for (int i = 0; i < size(); i++) {
//            int indexi = Utile.getNombreAleatoireEntreBorne(0, size() - 1);
//            int indexj = Utile.getNombreAleatoireEntreBorne(0, size() - 1);
//            permuter(indexi, indexj);
//
//            for (int j = 0; j < size(); j++) {
//                tabTemporaire[j] = getTab()[j];
//            }
//        }
//        setTab(tabTemporaire);
//    }

    public void shuffle() {

        for (int i = 0; i < getVecteur().size(); i++) {
            Random chiffreRandom = new Random();
            int indexi = chiffreRandom.nextInt(getVecteur().size() - 1);
            int indexj = chiffreRandom.nextInt(getVecteur().size() - 1);
            permuter(indexi,indexj);
        }
    }

    public void permuter(int indicei, int indicej) {
        Forme temporairei = getVecteur().get(indicei);
        Forme temporairej = getVecteur().get(indicej);
        getVecteur().set(indicei, temporairej);
        getVecteur().set(indicej, temporairei);
    }
}
