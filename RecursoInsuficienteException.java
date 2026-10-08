public class RecursoInsuficienteException extends RpgException {
    public RecursoInsuficienteException(String recurso, int cantidadActual) {
        super("Falta " + recurso + " para realizar la acción (Actual: " + cantidadActual + ").");
    }
}