package com.rpg.itens.Armas.ArmasBase;

import Itens.Armas.Arma;
import Jogo.Classificadores.OrigemDoItem;
import Jogo.Classificadores.Raridade;

public class Arco extends Arma{
    public Arco(String nome, Raridade raridade, OrigemDoItem origem, int minNivel, int dano, float velocidadeDeAtaque) {
        super(nome, raridade, origem, minNivel, dano, velocidadeDeAtaque);
        this.setAlcance(0.25f);
    }
}
