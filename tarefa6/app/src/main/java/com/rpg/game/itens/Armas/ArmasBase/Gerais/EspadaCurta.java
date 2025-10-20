package com.rpg.game.itens.Armas.ArmasBase.Gerais;

import com.rpg.game.itens.Armas.ArmasBase.*;
import com.rpg.game.itens.Classificadores.*;

public class EspadaCurta extends Espada{
    public EspadaCurta() {
        super("Espada Curta Enferrujada", Raridade.COMUM, OrigemDoItem.GERAL, 0, 6, 0.1f);
        this.setDescricao("""
                Este é o primeiro pedaço de aço que você pode chamar de seu. 
                A lâmina curta está coberta de manchas de ferrugem e o fio de 
                corte tem vários dentes, testemunhas de donos anteriores menos cuidadosos. 
                O cabo de couro está gasto, mas ainda firme. Não é a arma de um herói, 
                mas é a arma que pode, com sorte e habilidade, forjar um.
                """);
    }
}
