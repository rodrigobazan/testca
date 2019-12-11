package Excepciones;

public class EstaInscriptoException extends Exception {
    public String mensaje() {
        return "Ya esta inscripto en estes curso";
    }
}
