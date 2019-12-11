package Excepciones;

public class FechaLimiteException extends Exception {
    public String mensaje() {
        return "La fecha limite para inscripcion caduco";
    }
}
