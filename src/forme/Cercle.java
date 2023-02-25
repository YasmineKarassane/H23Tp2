package forme;


import Exceptions.FormeException;

public class Cercle extends Forme {


    private int rayon;

    public Cercle(int rayon) {
        if (rayonEstValide(rayon)) {
            this.rayon = rayon;
        } else throw new FormeException();
    }

    public int calculerPerimetre() {
        return (int) (rayon * 2 * Math.PI);
    }

    public int calculerSurface() {
        return (int) (Math.PI * rayon * rayon);
    }

    public static boolean rayonEstValide(int rayon) {
        return MAX_VAL >= rayon && MIN_VAL <= rayon;
    }

    public int getRayon() {
        return rayon;
    }

    public void setRayon(int rayon) {
        if (rayonEstValide(rayon)) {
            this.rayon = rayon;
        }
    }

    @Override
    public String toString() {
        return super.toString() + rayon + "( " + rayon + " est le rayon )";
    }
}
