public class AccionInvalidaException extends RpgException {
    public AccionInvalidaException(String accion, String razon) {
        super("Los dioses prohíben esta acción '" + accion + "': " + razon);
    }
}