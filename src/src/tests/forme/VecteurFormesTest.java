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
    }

    @Test
    void trier() {
    }
}