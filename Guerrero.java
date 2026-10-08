public class Guerrero extends Personaje {
    private String arma;
    private int danioFisico;

    public Guerrero(String nombre, int nivel, int puntosVida, String arma, int danioFisico) {
        super(nombre, nivel, puntosVida);
        this.arma = arma;
        this.danioFisico = danioFisico;
    }

    @Override
    public void atacar() throws RpgException {
        if (!isEstaVivo()) throw new PersonajeDerrotadoException(getNombre());
        System.out.println("⚔️ [" + getNombre() + "] ataca con furia usando su " + arma);
    }

    @Override
    public int calcularDanio() { return danioFisico + (int)(Math.random() * 20); }
}