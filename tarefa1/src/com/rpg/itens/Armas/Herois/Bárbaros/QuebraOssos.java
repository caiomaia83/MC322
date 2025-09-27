package com.rpg.itens.Armas.Herois.Bárbaros;

import com.rpg.itens.Armas.ArmasBase.*;
import com.rpg.itens.Classificadores.*;

public class QuebraOssos extends Espada {
    public QuebraOssos() {
        super("Quebra-Ossos Grosseiro", Raridade.COMUM, OrigemDoItem.GERAL, 2, 11, 0.25f);

        String desc = """
                Menos uma espada e mais uma barra de ferro brutalmente afiada. 
                O equilíbrio é terrível e o cabo é simplesmente couro enrolado, 
                mas o peso puro da lâmina é suficiente para quebrar ossos e escudos com a mesma facilidade. 
                Uma arma que não exige técnica, apenas fúria.
                """;
        this.setDescricao(desc);
    }
}