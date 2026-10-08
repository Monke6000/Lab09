public class PersonajeDerrotadoException extends RpgException {
    private String nombrePersonaje;

    public PersonajeDerrotadoException(String nombre) {
        super("El personaje " + nombre + " está inconsciente y no puede actuar.");
        this.nombrePersonaje = nombre;
    }

    public String getNombrePersonaje() {
        return nombrePersonaje;
    }
}