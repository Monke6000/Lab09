public class Arquero extends Personaje {
    private String tipoArco;
    private int flechasDisponibles;
    private int danioBase;

    public Arquero(String nombre, int nivel, int puntosVida, String tipoArco, int flechasDisponibles, int danioBase) {
        super(nombre, nivel, puntosVida);
        this.tipoArco = tipoArco;
        this.flechasDisponibles = flechasDisponibles;
        this.danioBase = danioBase;
    }

    @Override
    public void atacar() throws RpgException {
        if (!isEstaVivo()) throw new PersonajeDerrotadoException(getNombre());
        if (flechasDisponibles <= 0) throw new RecursoInsuficienteException("flechas", flechasDisponibles);
        flechasDisponibles--;
        System.out.println("🏹 [" + getNombre() + "] dispara su " + tipoArco + ". Flechas restantes: " + flechasDisponibles);
    }

    @Override
    public int calcularDanio() { return danioBase + (int)(Math.random() * 10); }
}