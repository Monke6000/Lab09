public class Druida extends Personaje implements Sanador, Hechicero {
    private int mana;

    public Druida(String nombre, int nivel, int puntosVida, int mana) {
        super(nombre, nivel, puntosVida);
        this.mana = mana;
    }

    @Override
    public int getMana() { return mana; }

    @Override
    public void atacar() throws RpgException {
        if (!isEstaVivo()) throw new PersonajeDerrotadoException(getNombre());
        if (mana < 10) throw new RecursoInsuficienteException("maná", mana);
        mana -= 10;
        System.out.println("🌿 [" + getNombre() + "] lanza Enjambre de Insectos. Maná: " + mana);
    }

    @Override
    public int calcularDanio() { return 15 + (int)(Math.random() * 15); }

    @Override
    public void curarAliado(Personaje aliado) throws RpgException {
        if (aliado == null) throw new PersonajeNuloException("curarAliado");
        if (!aliado.isEstaVivo()) throw new AccionInvalidaException("curar", "No puedes curar a caídos.");
        System.out.println("✨ [" + getNombre() + "] cura a " + aliado.getNombre());
    }
}