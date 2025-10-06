package com.rpg.game.itens.Armas.ArmasBase;

import com.rpg.game.itens.Armas.Arma;
import com.rpg.game.itens.Classificadores.OrigemDoItem;
import com.rpg.game.itens.Classificadores.Raridade;

public class Clava extends Arma{

    public Clava(String nome, Raridade raridade, OrigemDoItem origem, int minNivel, int dano, float velocidadeDeAtaque) {
        super(nome, raridade, origem, minNivel, dano, velocidadeDeAtaque);
        this.setAlcance(0.05f);
    }
}
