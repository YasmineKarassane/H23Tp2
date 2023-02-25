package Exceptions;

public class TriangleInvalide extends RuntimeException{
    public TriangleInvalide(){
        super("Ce n'est pas un triangle");
    }
}
