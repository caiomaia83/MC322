package com.rpg.itens.Armas.Monstros.Esqueletos.Comum;

import com.rpg.itens.Armas.ArmasBase.*;
import com.rpg.itens.Classificadores.*;

public class EspadaoLascado extends Espada{
    public EspadaoLascado() {
        super("Espadão Lascado", Raridade.COMUM, OrigemDoItem.ESQUELETO, 1, 4, 0.05f);

        String desc= """
                Uma espada de duas mãos que um dia foi imponente. Agora, grandes lascas de metal estão faltando em sua lâmina,
                resultado de batalhas antigas ou simplesmente da corrosão do tempo. É pesada e desajeitada, e o esqueleto que a levanta o faz com uma lentidão rangente, 
                dependendo mais do peso da arma do que de qualquer técnica
                """;
        this.setDescricao(desc);
    }
}
