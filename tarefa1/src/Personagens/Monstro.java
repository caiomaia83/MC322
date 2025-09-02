package Personagens;
public abstract class Monstro extends Personagem {

    int xpConcedido;

    public Monstro(String nome, int pontosDeVidaTotal, int forca, int xpConcedido) {
        super(nome, pontosDeVidaTotal, forca);
        this.xpConcedido = xpConcedido;

    }

    @Override
    public void exibirStatus() {
        super.exibirStatus();

        System.out.printf("XP concedido: %d\n", this.xpConcedido);
    }
}