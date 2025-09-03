package Personagens;

import Armas.Arma;

public abstract class Personagem {
    private String nome;
    protected int pontosDeVida;
    private int pontosDeVidaTotal; // Guarda o hp total 
    private int forca;
    private int dano;
    protected Arma arma;
    

    public Personagem(String nome, int pontosDeVidaTotal, int forca, Arma arma) {
        this.forca = forca;
        this.nome = nome;
        this.pontosDeVida =  pontosDeVidaTotal;
        this.pontosDeVidaTotal = pontosDeVidaTotal;
        this.dano = calculaDano();
    }

    public boolean estaVivo() {
        return (this.pontosDeVida > 0);
    }

    public void receberDano(int dano) {
        this.pontosDeVida -= dano;

        if(this.pontosDeVida < 0) { // Garante que os pontos de vida nunca estejam negativos
            this.pontosDeVida = 0;
        }

        // Imprime uma mensagem indicando a ação 
        System.out.printf("%s recebeu %d de dano!", this.nome, dano);
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

    protected void setPontosDeVida(int hp) {
        this.pontosDeVida = hp;
    }

    public int getPontosDeVidaTotal() {
        return this.pontosDeVidaTotal;
    }

    protected void setPontosDeVidaTotal(int hpTotal) {
        this.pontosDeVidaTotal = hpTotal;
    }

    public int getDano() { // Retorna o dano do ataque do personagem
        return this.dano;
    }

    public int getForca() {
        return this.forca;
    }

    protected void setForca(int forca) {
        this.forca = forca;
    }

    public String getNomeArma() {
        return this.arma.getNome();
    }

    private String getDescricaoArma() {
        return this.arma.getDescricao();
    }

    public void exibirStatusArma() {
        System.out.printf(" -- Status de %s --\n", this.getNomeArma());
        System.out.printf("Descrição: " + this.getDescricaoArma());
        System.out.printf("Dano: %s \n", this.arma.getDano());
        System.out.printf("Forca: %d\n", this.forca);
    }


    // Calcula o dano de uma ataque considerando a força e o dano da arma 
    private int calculaDano() {
        return (this.getForca() + this.arma.getDano());
    }


    public abstract void atacar(Personagem alvo);
}