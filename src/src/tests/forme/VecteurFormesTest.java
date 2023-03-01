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
        vecteur.remplir(6);
        //assertEquals(vecteur);
    }

    @Test
    void trier() {
    }
}