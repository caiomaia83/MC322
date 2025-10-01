package com.rpg.itens.Armas.ArmasHerois.Bárbaros.Epico;

import com.rpg.itens.Armas.ArmasBase.Machado;
import com.rpg.itens.Classificadores.OrigemDoItem;
import com.rpg.itens.Classificadores.Raridade;

public class RugidoDoBerserker extends Machado{
    public RugidoDoBerserker() {
        super("Rugido do Berserker", Raridade.EPICO, OrigemDoItem.BARBARO, 25, 45, 0.18f);

        this.setDescricao("""
                Uma arma viva, forjada da própria Fúria. Ela transforma a dor de seu portador em poder,
                e o desespero em devastação. Seu corte não é metal, mas um rugido que estilhaça a coragem 
                antes de esmagar o osso
                """);        
    }
}
