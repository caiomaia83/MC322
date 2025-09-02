package Personagens;

import Armas.Arma;

public abstract class Personagem {
    private String nome;
    protected int pontosDeVida;
    protected int pontosDeVidaTotal; // Guarda o hp total 
    private int forca;
    protected Arma arma;
    

    public Personagem(String nome, int pontosDeVidaTotal, int forca, Arma arma) {
        this.forca = forca;
        this.nome = nome;
        this.pontosDeVida =  pontosDeVidaTotal;
        this.pontosDeVidaTotal = pontosDeVidaTotal;
    }

    public boolean estaVivo() {
        return (this.pontosDeVida > 0);
    }

    public void receberDano(int dano) {
        this.pontosDeVida -= dano;

        if(this.pontosDeVida < 0) { // Garante que os pontos de vida nunca estejam negativos
            this.pontosDeVida = 0;
        }
    }

    public void exibirStatus() {
        System.out.printf(" -- Status de %s --\n", this.nome);
        System.out.printf("HP: %d / %d\n", this.pontosDeVida, this.pontosDeVidaTotal);
        System.out.printf("Arma: %s \n", this.arma.getNome());
        System.out.printf("Forca: %d\n", this.forca);
    }

    public String getNome() {
        return this.nome;
    }

    public int getPontosDeVida() {
        return this.pontosDeVida;
    }

    public int getPontosDeVidaTotal() {
        return this.pontosDeVidaTotal;
    }

    public int getForca() {
        return this.forca;
    }

    public String getArma() {
        return this.arma.getNome();
    }

    protected void MudarArma(Arma novaArma) {

    }

    public abstract void atacar(Personagem alvo);
}