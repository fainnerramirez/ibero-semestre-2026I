package exceptions;

public class EventoException extends Exception {
    public EventoException(String mensaje) {
        super(mensaje);
    }

    public EventoException(String mensaje, Throwable causa) {
        super(mensaje, causa);
    }
}
