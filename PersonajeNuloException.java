public class PersonajeNuloException extends RuntimeException {
    public PersonajeNuloException(String metodo) {
        super("Se pasó un personaje nulo al método '" + metodo + "'. Error crítico.");
    }
}