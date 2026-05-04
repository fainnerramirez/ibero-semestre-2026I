package exceptions;

public class InscripcionException extends Exception {
    public InscripcionException(String mensaje) {
        super(mensaje);
    }

    public InscripcionException(String mensaje, Throwable causa) {
        super(mensaje, causa);
    }
}
