package com.rpg.itens.Armas.ArmasBase;

import com.rpg.itens.Armas.*;
import com.rpg.itens.Classificadores.*;
// A espada é uma das armas mais básicas, e não possui um atributo próprio  universal
public class Espada extends Arma {
    
    public Espada( String nome, Raridade raridade, OrigemDoItem origem, int minNivel, int dano, float velocidadeDeAtaque) { 
        super(nome, raridade, origem, minNivel, dano, velocidadeDeAtaque);
        this.setAlcance(0.05f); // Alcance 0.05 por padrão (maior que adaga e corpo a corpo)
    }
}


