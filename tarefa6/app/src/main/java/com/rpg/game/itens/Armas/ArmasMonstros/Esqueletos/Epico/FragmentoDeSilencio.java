package com.rpg.game.itens.Armas.ArmasMonstros.Esqueletos.Epico;

import com.rpg.game.itens.Armas.ArmasBase.Adaga;
import com.rpg.game.itens.Classificadores.OrigemDoItem;
import com.rpg.game.itens.Classificadores.Raridade;

public class FragmentoDeSilencio extends Adaga{
    public FragmentoDeSilencio() {
        super("Fragmento de Silêncio", Raridade.EPICO, OrigemDoItem.ESQUELETO, 12, 24, 0.42f);
        String desc = """
                Um caco de obsidiana magicamente tratado para anular o som. Os ataques feitos com esta adaga 
                são assustadoramente silenciosos, sem o som do corte ou do impacto. O esqueleto que a empunha é 
                um assassino, e a primeira indicação de seu ataque é a dor.
                """;
        this.setDescricao(desc);
    }
}
