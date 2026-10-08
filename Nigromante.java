public class Nigromante extends Personaje implements Hechicero {
    private int mana;
    private int danioBase;

    public Nigromante(String nombre, int nivel, int puntosVida, int mana, int danioBase) {
        super(nombre, nivel, puntosVida);
        this.mana = mana;
        this.danioBase = danioBase;
    }

    @Override
    public int getMana() { return mana; }

    @Override
    public void atacar() throws RpgException {
        if (!isEstaVivo()) throw new PersonajeDerrotadoException(getNombre());
        if (mana < 15) throw new RecursoInsuficienteException("maná oscuro", mana);
        mana -= 15;
        System.out.println("💀 [" + getNombre() + "] conjura Lanza de Hueso. Maná restante: " + mana);
    }

    @Override
    public int calcularDanio() { return danioBase + (int)(Math.random() * 20); }
}