package com.rpg.game.itens.Armas;

import com.rpg.game.itens.*;
import com.rpg.game.itens.Classificadores.*;

/**
 * Classe abstrata que serve como base para todas as armas do jogo.
 * <p>
 * Ela estende a classe {@link Item}, adicionando atributos específicos de
 * combate como dano, nível mínimo para uso, velocidade de ataque e alcance.
 * </p>
 *
 * @author Fernando e Caio
 * @version 1.0
 * @since 2025-10-05
 */
public abstract class Arma extends Item {
    // Atributos essenciais
    private int minNivel;
    
    // Atributos de combate
    private float alcance;
    private float velocidadeDeAtaque;
    // TO DO : implementar mecanica de golpe critico para arma e tipo de dano 
    /*private float chanceDeCritico;
    private float multiplicadorDeCritico;
    private TipoDeDano tipoDeDano; */
    private int dano;



    public Arma(String nome, Raridade raridade, OrigemDoItem origem, int minNivel, int dano, float velocidadeDeAtaque) {
        super(nome, raridade, origem, TipoDeItem.ARMA);
        this.dano = dano;
        this.minNivel = minNivel;
        this.velocidadeDeAtaque = velocidadeDeAtaque;
        this.alcance = 0f; // Alcance por padrão é zero (corpo a corpo)
        
    }

    public int getDano() {
        return this.dano;
    }

    public int getMinNivel() {
        return this.minNivel;
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

    public void exibirStatusArma() {
        System.out.printf(" ======== Status de Arma:  %s ========\n", this.getNome());
        System.out.printf("Descrição: " + this.getDescricao());
        System.out.printf("Dano: %s \n", this.getDano());
        System.out.printf("Raridade: %s\n", this.getRaridade());
        System.out.println("==========================================");
    }
}
