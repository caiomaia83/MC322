package com.rpg.itens.Armas.ArmasMonstros.Esqueletos.Raro;

import com.rpg.itens.Armas.ArmasBase.Machado;
import com.rpg.itens.Classificadores.OrigemDoItem;
import com.rpg.itens.Classificadores.Raridade;

public class DesmembradorDeCripta extends Machado{
     public DesmembradorDeCripta() {
        super("Desmembrador de Criptas", Raridade.RARO, OrigemDoItem.ESQUELETO, 8, 20, 0.1f);
        
        String desc = """
                Este machado pesado de duas mãos parece ter sido reaproveitado de uma antiga armadilha de lâminas. 
                É desbalanceado e exige uma força desumana para ser manejado, algo que um esqueleto, livre das limitações 
                dos músculos, não se importa. É projetado para amputar, não para lutar com delicadeza
                """;
        this.setDescricao(desc);
    }
}
