package com.rpg.itens.Armas.ArmasMonstros.Esqueletos.Incomum;

import com.rpg.itens.Armas.ArmasBase.Arco;
import com.rpg.itens.Classificadores.OrigemDoItem;
import com.rpg.itens.Classificadores.Raridade;

public class ArcoDeOsso extends Arco{
     public ArcoDeOsso() {
        super("Arco de Osso Frágil", Raridade.INCOMUM, OrigemDoItem.ESQUELETO, 3, 10, 0.15f);
        String desc = """
                Um arco rudimentar montado a partir das costelas de uma grande criatura e amarrado com tendões ressecados. 
                Ele range e estala a cada puxada, parecendo que vai se despedaçar a qualquer momento. Suas flechas são lascas 
                de osso, que voam de forma instável e raramente atingem o alvo com força.
                """;
        this.setDescricao(desc);
    }
}
