package Armas;

import Classificadores.Raridade;

public abstract class Arma {
    // Atributos essenciais
    private String nome;
    private String descricao;
    private int minNivel;
    
    // Atributos de combate
    private float alcance;
    private float velocidadeDeAtaque;
    // TO DO : implementar mecanica de golpe critico para arma e tipo de dano 
    /*private float chanceDeCritico;
    private float multiplicadorDeCritico;
    private TipoDeDano tipoDeDano; */
    private Raridade raridade;
    private int dano;



    public Arma(String nome, int minNivel, int dano, float velocidadeDeAtaque) {
        this.nome = nome;
        this.dano = dano;
        this.minNivel = minNivel;
        this.velocidadeDeAtaque = velocidadeDeAtaque;
        this.alcance = 0f; // Alcance por padrão é zero (corpo a corpo)
        
        // Valores padroes
        this.descricao = "Uma arma básica para ser usada em combate corpo a corpo.";
    }

    public int getDano() {
        return this.dano;
    }

    public int getMinNivel() {
        return this.minNivel;
    }

    public String getNome() {
        return this.nome;
    }

    public String getDescricao() {
        return this.descricao;
    }

    protected void setDescricao(String descricao) {
        this.descricao = descricao; 
    }

    public float getAlcance() {
        return this.alcance;
    }

    public float getvelocidadeDeAtaque() {
        return this.velocidadeDeAtaque;
    }


    protected void setAlcance(float alcance) {
        this.alcance = alcance;
    }

    public Raridade getRaridade() {
        return this.raridade;
    }

    protected void setRaridade(Raridade raridade) {
        this.raridade = raridade;
    }

    protected void setNome(String nome) {
        this.nome = nome;
    }
}
