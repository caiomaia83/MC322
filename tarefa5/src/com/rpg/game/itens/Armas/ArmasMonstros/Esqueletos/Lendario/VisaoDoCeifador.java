package com.rpg.game.itens.Armas.ArmasMonstros.Esqueletos.Lendario;

import com.rpg.game.itens.Armas.ArmasBase.Arco;
import com.rpg.game.itens.Classificadores.OrigemDoItem;
import com.rpg.game.itens.Classificadores.Raridade;

public class VisaoDoCeifador extends Arco{
    public VisaoDoCeifador() {
        super("Visao do Ceifador", Raridade.LENDARIO, OrigemDoItem.ESQUELETO, 30, 50, 0.55f);
        String desc = """
                Forjado com o osso de um titã e o olho da Morte. Não mire no corpo; mire no destino. 
                A flecha não voa, ela cumpre
                """;
        this.setDescricao(desc);

    }
}
