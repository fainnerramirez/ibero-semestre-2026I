package exceptions;

public class PersonaException extends Exception {
    public PersonaException(String mensaje) {
        super(mensaje);
    }

    public PersonaException(String mensaje, Throwable causa) {
        super(mensaje, causa);
    }
}
