package forme;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class VecteurFormesTest {

    @Test
    void getVecteur() {
        VecteurFormes vecteur = new VecteurFormes();
        vecteur.remplir(2);
        assertEquals("r", vecteur.getVecteur());
    }

    @Test
    void remplir() {
        VecteurFormes vecteur = new VecteurFormes();
        vecteur.remplir(2);
        assertEquals(" Cercle rouge Rectangle rouge", vecteur.toString());
    }

    @Test
    void trier() {
        VecteurFormes vecteur = new VecteurFormes();
        vecteur.remplir(9);
        vecteur.trier();
        String doitEtreRetourné = " Cercle bleu Rectangle bleu Triangle bleu Cercle rouge Rectangle rouge Triangle rouge Cercle vert Rectangle vert Triangle vert";
        assertEquals(doitEtreRetourné, vecteur.toString());
    }
}