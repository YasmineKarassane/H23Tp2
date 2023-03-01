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
        assertEquals("Cercle rougeRectangle rouge", vecteur.toString());
    }

    @Test
    void trier() {
        VecteurFormes vecteur = new VecteurFormes();
        vecteur.remplir(3);
        String doitEtreRetourné = "Cercle rouge Rectangle rouge Triangle rouge";

    }
}