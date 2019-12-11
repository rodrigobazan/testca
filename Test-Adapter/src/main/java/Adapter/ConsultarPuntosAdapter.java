package Adapter;

import Input.ConsultarPuntosInput;

public class ConsultarPuntosAdapter {
    private ConsultarPuntosInput consultarPuntosInput;

    public ConsultarPuntosAdapter(ConsultarPuntosInput consultarPuntosInput) {
        this.consultarPuntosInput = consultarPuntosInput;
    }

    public int consultarPuntosUsuario(String usuario) {
        return this.consultarPuntosInput.consultarPuntosCuenta(usuario);
    }
}
