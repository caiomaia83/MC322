package com.rpg.game.itens.Armas.ArmasHerois.Arqueira;

import com.rpg.game.itens.Armas.ArmasBase.*;
import com.rpg.game.itens.Classificadores.*;

public class ArcoCurto extends Arco{
    public ArcoCurto() {
        super("Arco Curto de Patrulha", Raridade.COMUM, OrigemDoItem.GERAL, 1, 8, 0.3f);
        String desc = """
                Um arco padrão distribuído às sentinelas e batedores do reino. 
                É leve, fácil de carregar por longos períodos e rápido de sacar.
                 Não tem grande potência, mas é preciso o suficiente para acertar um alvo desatento a cinquenta passos.
                """;
        this.setDescricao(desc);
    }
}
