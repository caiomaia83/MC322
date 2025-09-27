package com.rpg.itens.Armas.Monstros.Esqueletos.Comum;

import com.rpg.itens.Armas.ArmasBase.*;
import com.rpg.itens.Classificadores.*;

public class LaminaCerimonial extends Espada{
    public LaminaCerimonial() {
        super("Lâmina Cerimonial de Tumba", Raridade.COMUM, OrigemDoItem.ESQUELETO, 1, 5, 0.08f);

        String desc= """
                Esta espada fina e outrora ornamentada foi colocada em uma tumba como uma oferenda, não como uma arma. 
                Nunca teve um fio verdadeiro e foi feita mais para impressionar do que para cortar.
                Anos de negligência a deixaram frágil e manchada, mas um esqueleto reanimado não se importa com a linhagem de sua arma, apenas com sua ponta
                """;
        this.setDescricao(desc);
    }
}
