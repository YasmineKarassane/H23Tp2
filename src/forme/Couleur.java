package forme;

public enum Couleur {
    ROUGE, VERT, BLEU, JAUNE, NOIR, ORANGE;

    public String getNom() {
        return this.toString().toLowerCase();
    }
}