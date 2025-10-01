package com.rpg.itens.Armas.ArmasMonstros.Esqueletos.Incomum;

import com.rpg.itens.Armas.ArmasBase.Adaga;
import com.rpg.itens.Classificadores.OrigemDoItem;
import com.rpg.itens.Classificadores.Raridade;

public class AdagaCerimonial extends Adaga{
    public AdagaCerimonial() {
        super("Adaga Cerimonial de Bronze", Raridade.INCOMUM, OrigemDoItem.ESQUELETO, 4, 6, 0.37f);

        String desc= """
                Esta lâmina de bronze nunca foi feita para o combate, mas sim para rituais funerários. 
                O gume é cego, mas a adaga é coberta por símbolos e glifos que falam de passagens para o além. 
                Ela causa um dano profano que parece ferir mais a alma do que o corpo.
            """;
                    
        this.setDescricao(desc);
    }
}
