package com.rpg.itens.Armas.ArmasBase;

import Itens.Armas.Arma;
import Jogo.Classificadores.OrigemDoItem;
import Jogo.Classificadores.Raridade;

public class Lanca extends Arma {
    
    Boolean golpePerfurante; // Atributo único das lanças, permite um ataque crítico que ignora defesa 

    public Lanca( String nome, Raridade raridade, OrigemDoItem origem, int minNivel, int dano, float velocidadeDeAtaque) { 
        super(nome, raridade, origem, minNivel, dano, velocidadeDeAtaque );
        this.setAlcance(0.15f); // Lança tem um alcance um pouco maior 
        this.golpePerfurante = false;
    }
}
