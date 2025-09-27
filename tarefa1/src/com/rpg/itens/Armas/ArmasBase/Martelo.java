package com.rpg.itens.Armas.ArmasBase;
import com.rpg.itens.Armas.*;
import com.rpg.itens.Classificadores.*;

public class Martelo extends Arma{

    boolean Impacto; // Atributo único do martelo que permite um impacto maior (atordoar)
    public Martelo(String nome, Raridade raridade, OrigemDoItem origem, int minNivel, int dano, float velocidadeDeAtaque) {
        super(nome, raridade, origem, minNivel, dano, velocidadeDeAtaque);
        this.setAlcance(0.05f);
        this.Impacto = true;
    }
}
