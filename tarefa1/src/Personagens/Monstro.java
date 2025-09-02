package Personagens;

import Armas.Arma;

public abstract class Monstro extends Personagem {

    int xpConcedido;

    public Monstro(String nome, int pontosDeVidaTotal, int forca, int xpConcedido, Arma arma) {
        super(nome, pontosDeVidaTotal, forca, arma);
        this.xpConcedido = xpConcedido;

    }

    @Override
    public void exibirStatus() {
        super.exibirStatus();

        System.out.printf("XP concedido: %d\n", this.xpConcedido);
    }
}