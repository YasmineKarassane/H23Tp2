package forme;


import Exceptions.CoteInvalide;
import Exceptions.TriangleInvalide;

import java.util.Arrays;

public class Triangle extends Forme {

    private int coteA;
    private int coteB;
    private int coteC;

    public Triangle(int coteA, int coteB, int coteC) {
        if (coteEstValide(coteA) && coteEstValide(coteB) && coteEstValide(coteC) && estTriangle(coteA, coteB, coteC)) {
            this.coteA = coteA;
            this.coteB = coteB;
            this.coteC = coteC;
        }
    }

    public int calculerPerimetre() {
        return coteA + coteB + coteC;
    }

    public int calculerSurface() {
        double p = (coteA + coteB + coteC);
        p = p / 2;
        int surface = (int) Math.sqrt(p * (p - coteA) * (p - coteB) * (p - coteC));
        return surface;
    }

    public static boolean coteEstValide(int cote) {
        if (MAX_VAL >= cote && MIN_VAL <= cote) {
            return true;
        } else throw new CoteInvalide();
    }

    public boolean estRectangle() {
        return (getCotesTries()[2] == (int) Math.sqrt(Math.pow(getCotesTries()[1], 2) + Math.pow(getCotesTries()[0], 2)));
    }

    public static boolean estTriangle(int a, int b, int c) {
        int[] cotesTries = new int[]{a, b, c};
        Arrays.sort(cotesTries);
        if (cotesTries[2] < cotesTries[1] + cotesTries[0]) return true;
        else {
            throw new TriangleInvalide();
        }
    }

    public int getCoteA() {
        return coteA;
    }

    public int getCoteB() {
        return coteB;
    }

    public int getCoteC() {
        return coteC;
    }


    public TypeTriangle getType() {
        if (estRectangle()) return TypeTriangle.RECTANGLE;
        else if (getNbrCoteEgaux() == 1) return TypeTriangle.ISOCELE;
        else if (getNbrCoteEgaux() == 3) return TypeTriangle.EQUILATERAL;
        else return TypeTriangle.SCALENE;
    }

    private int[] getCotesTries() {
        int[] cotesTries = new int[]{coteA, coteB, coteC};
        Arrays.sort(cotesTries);
        return cotesTries;
    }

    private int getNbrCoteEgaux() {
        int nbrCoteEgaux = 0;

        if (coteA == coteB) nbrCoteEgaux++;
        if (coteA == coteC) nbrCoteEgaux++;
        if (coteB == coteC) nbrCoteEgaux++;
        return nbrCoteEgaux;
    }

    @Override
    public String toString() {
        return super.toString() + getType().toString() + " " + coteA + ", " + coteB + ", " + coteC + " (où " + coteA + " est coteA, " + coteB + " est coteB et " + coteC + " est coteC)";
    }
}
