package forme;

public enum Couleur {
    BLEU, JAUNE, NOIR, ORANGE, ROUGE, VERT;

    public String getNom() {
        return this.toString().toLowerCase();
    }
}