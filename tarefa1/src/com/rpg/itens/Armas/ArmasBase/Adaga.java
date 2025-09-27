package com.rpg.itens.Armas.ArmasBase;

import com.rpg.itens.Armas.*;
import com.rpg.itens.Classificadores.*;

public class Adaga extends Arma {

    boolean AtaqueFurtivo; // Atributo único das adagas que permite um aumento no dano se o golpe for furtivo

    public Adaga( String nome, Raridade raridade, OrigemDoItem origem, int minNivel, int dano, float velocidadeDeAtaque) { 
        super(nome, raridade, origem, minNivel, dano, velocidadeDeAtaque);
        this.setAlcance(0f); // Alcance 0 por padrão
        this.AtaqueFurtivo = true;
    }
}
