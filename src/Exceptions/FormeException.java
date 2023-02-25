package Exceptions;

public class FormeException extends RuntimeException {
    public FormeException() {
        super("Dimensions invalide"); //appel du contructeur de RuntimeException
    }

    public  FormeException(String message) {
        super(message);
    }
}

