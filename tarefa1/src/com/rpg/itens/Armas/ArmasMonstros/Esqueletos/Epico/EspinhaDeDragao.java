package com.rpg.itens.Armas.ArmasMonstros.Esqueletos.Epico;

import com.rpg.itens.Armas.ArmasBase.Lanca;
import com.rpg.itens.Classificadores.OrigemDoItem;
import com.rpg.itens.Classificadores.Raridade;

public class EspinhaDeDragao extends Lanca{
    public EspinhaDeDragao() {
        super("Espinha de Dragão de Esqueletos", Raridade.EPICO, OrigemDoItem.ESQUELETO, 15, 38 , 0.12f);
        String desc = """
                Uma lança formidável criada a partir de uma única vértebra fossilizada da espinha de um dragão de ossos. 
                A arma é incrivelmente densa e crepita com energia necrótica. A ponta, naturalmente afiada, parece guiar-se 
                em direção ao coração de suas vítimas.
                """;
        this.setDescricao(desc);
    }

}
