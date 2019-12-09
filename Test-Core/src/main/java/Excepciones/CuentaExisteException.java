package Excepciones;

public class CuentaExisteException extends Exception {
    public String mensaje() {
        return "Cuenta ya existe";
    }
}
