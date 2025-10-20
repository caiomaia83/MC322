package com.rpg.game.itens.Armas.ArmasMonstros.Esqueletos.Raro;

import com.rpg.game.itens.Armas.ArmasBase.Martelo;
import com.rpg.game.itens.Classificadores.OrigemDoItem;
import com.rpg.game.itens.Classificadores.Raridade;

public class EsmagadorDeVontades extends Martelo{
    public EsmagadorDeVontades() {
        super("Esmagador de Vontades", Raridade.RARO, OrigemDoItem.ESQUELETO, 10, 25, 0.05f);
        String desc = """
                Um malho de duas mãos cuja cabeça de metal parece absorver o som, tornando seus impactos estranhamente silenciosos e pesados. 
                A arma não esmaga apenas ossos; ela esmaga a moral. Aqueles atingidos por ela sentem sua determinação se esvair, ficando confusos 
                e hesitantes em batalha.
                """;
        this.setDescricao(desc);
    }
}
