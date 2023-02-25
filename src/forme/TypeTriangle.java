package forme;

public enum TypeTriangle {
    EQUILATERAL("équilatéral"), ISOCELE("isocèle"), RECTANGLE("rectangle"), SCALENE("scalène");

    private String type;

    private TypeTriangle(String type) {
        setType(type);
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        String aAfficher = getType().replaceAll("Triangle", "");
        return aAfficher;
    }
}
