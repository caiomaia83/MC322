package com.rpg.itens.Armas.ArmasBase;

import com.rpg.itens.Armas.*;
import com.rpg.itens.Classificadores.*;

public class Machado extends Arma{
    boolean QuebraEscudo; // Atributo único de machado que aumenta dano contra oponentes em postura defensiva
    public Machado(String nome, Raridade raridade, OrigemDoItem origem, int minNivel, int dano, float velocidadeDeAtaque) {
        super(nome, raridade, origem, minNivel, dano, velocidadeDeAtaque);
        this.setAlcance(0.05f); // Alcance 0.05 por padrão ( um pouco maior que adaga)
        this.QuebraEscudo = true;
    }
}
