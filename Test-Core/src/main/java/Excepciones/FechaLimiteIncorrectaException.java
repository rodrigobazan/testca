package Excepciones;

public class FechaLimiteIncorrectaException extends Exception {
    public String mensaje() {
        return "Fecha limite incorrecta";
    }
}
