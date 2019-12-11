package Adapter;

import Input.ObtenerPromedioInscriptosInput;

public class ObtenerPromedioInscriptosAdapter {
    private ObtenerPromedioInscriptosInput obtenerPromedioInscriptosInput;

    public ObtenerPromedioInscriptosAdapter(ObtenerPromedioInscriptosInput obtenerPromedioInscriptosInput) {
        this.obtenerPromedioInscriptosInput = obtenerPromedioInscriptosInput;
    }

    public double obtenerPromedio() {
        return this.obtenerPromedioInscriptosInput.obtenerPromedio();
    }
}
