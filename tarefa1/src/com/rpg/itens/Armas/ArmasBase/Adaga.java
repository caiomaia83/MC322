package com.rpg.itens.Armas.ArmasBase;

import Itens.Armas.Arma;
import Jogo.Classificadores.OrigemDoItem;
import Jogo.Classificadores.Raridade;

public class Adaga extends Arma {

    boolean AtaqueFurtivo; // Atributo único das adagas que permite um aumento no dano se o golpe for furtivo

    public Adaga( String nome, Raridade raridade, OrigemDoItem origem, int minNivel, int dano, float velocidadeDeAtaque) { 
        super(nome, raridade, origem, minNivel, dano, velocidadeDeAtaque);
        this.setAlcance(0f); // Alcance 0 por padrão
        this.AtaqueFurtivo = true;
    }
}
