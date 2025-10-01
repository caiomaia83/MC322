package com.rpg.itens.Armas.ArmasHerois.Bárbaros.Raro;

import com.rpg.itens.Armas.ArmasBase.Espada;
import com.rpg.itens.Classificadores.OrigemDoItem;
import com.rpg.itens.Classificadores.Raridade;

public class Devoradora extends Espada{
    public Devoradora() {
        super("Devoradora", Raridade.RARO, OrigemDoItem.BARBARO, 10, 30, 0.2f);
        
        this.setDescricao("""
                Uma chapa de metal impossivelmente grande e pesada, que mal se assemelha a uma espada. 
                As lendas dizem que não foi feita para matar homens, mas para derrubar muralhas e deuses. 
                Ela não tem um fio afiado, dependendo apenas de seu peso absurdo. A espada se alimenta da força 
                do portador; quanto mais forte o bárbaro, mais pesada e devastadora ela se torna
                """);
    }
}
