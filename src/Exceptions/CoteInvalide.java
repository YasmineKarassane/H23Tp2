package Exceptions;

public class CoteInvalide extends RuntimeException{
    public CoteInvalide(){
        super("Le côté est invalide");
    }

}
