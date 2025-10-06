package com.rpg.game.itens.Armas.ArmasBase;

import com.rpg.game.itens.Armas.*;
import com.rpg.game.itens.Classificadores.*;

public class Arco extends Arma{
    public Arco(String nome, Raridade raridade, OrigemDoItem origem, int minNivel, int dano, float velocidadeDeAtaque) {
        super(nome, raridade, origem, minNivel, dano, velocidadeDeAtaque);
        this.setAlcance(0.25f);
    }
}
