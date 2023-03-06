package forme;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class VecteurFormesTest {

    @Test
    void getVecteur() {
        VecteurFormes vecteur = new VecteurFormes();
        vecteur.remplir(2);
        assertEquals("[Cercle rouge 28, 283(3 est le rayon), Rectangle rouge 9, 93, 3 (où 3 est la hauteur et 3 est la largeur)]", vecteur.getVecteur().toString());
    }

    @Test
    void remplir() {
        VecteurFormes vecteur = new VecteurFormes();
        vecteur.remplir(2);
        assertEquals(" Cercle rouge Rectangle rouge", vecteur.toString());

        VecteurFormes vecteur1 = new VecteurFormes();
        vecteur1.remplir(12);
        assertEquals(" Cercle rouge Rectangle rouge Triangle rouge Cercle vert Rectangle vert Triangle vert Cercle bleu Rectangle bleu Triangle bleu Cercle jaune Rectangle jaune Triangle jaune", vecteur1.toString());
    }

    @Test
    void trier() {
        VecteurFormes vecteur = new VecteurFormes();
        vecteur.remplir(9);
        vecteur.trier();
        String doitEtreRetourné = " Cercle bleu Cercle rouge Cercle vert Rectangle bleu Rectangle rouge Rectangle vert Triangle bleu Triangle rouge Triangle vert";
        assertEquals(doitEtreRetourné, vecteur.toString());

        VecteurFormes vecteur1 = new VecteurFormes();
        vecteur1.remplir(2);
        vecteur1.trier();
        String doitEtreRetourné1 = " Cercle rouge Rectangle rouge";
        assertEquals(doitEtreRetourné1, vecteur1.toString());
    }

    @Test
    void mélanger() {
        VecteurFormes vecteur = new VecteurFormes();
        vecteur.remplir(2);
        vecteur.melanger();
        assertNotEquals(" Cercle rouge Rectangle rouge", vecteur);

        VecteurFormes vecteur1 = new VecteurFormes();
        vecteur1.remplir(2);
        vecteur1.melanger();
        assertNotEquals(" Cercle bleu Rectangle bleu Triangle bleu Cercle rouge Rectangle rouge" +
                " Triangle rouge Cercle vert Rectangle vert Triangle vert", vecteur1);
    }
}