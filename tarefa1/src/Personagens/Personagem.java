package Personagens;

import Itens.Armas.Arma;

public abstract class Personagem {
    private String nome;
    protected int pontosDeVida;
    private int pontosDeVidaTotal; // Guarda o hp total 
    private int forca;
    protected int dano;
    protected Arma arma;
    

    public Personagem(String nome, int pontosDeVidaTotal, int forca, Arma arma) {
        this.forca = forca;
        this.nome = nome;
        this.pontosDeVida =  pontosDeVidaTotal;
        this.pontosDeVidaTotal = pontosDeVidaTotal;
        this.arma = arma;
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
        System.out.printf("%s recebeu %d de dano!\n", this.nome, dano);
    }

    public void exibirStatus() {
        System.out.printf(" -- Status de %s --\n", this.nome);
        System.out.printf("HP: %d / %d\n", this.pontosDeVida, this.pontosDeVidaTotal);
        if(this.arma == null) {
            System.out.println("Arma: Nenhuma Equipada");
        } else {
            System.out.printf("Arma: %s \n", this.arma.getNome());
        }
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
        if(this.arma == null) {
            return this.forca;
        }

        return (this.forca + this.arma.getDano());
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
        System.out.printf(" ======== Status de Arma:  %s ========\n", this.getNomeArma());
        System.out.printf("Descrição: " + this.getDescricaoArma());
        System.out.printf("Dano: %s \n", this.arma.getDano());
        System.out.printf("Forca: %d\n", this.forca);
    }


    public abstract void atacar(Personagem alvo);
}