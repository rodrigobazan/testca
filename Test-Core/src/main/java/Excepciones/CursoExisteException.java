package Excepciones;

public class CursoExisteException extends Exception {
    public String mensaje() {
        return "Curso ya existe";
    }
}
