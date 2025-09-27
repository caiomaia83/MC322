package com.rpg.itens.Armas.Monstros.Corredor;

import com.rpg.itens.Armas.ArmasBase.*;
import com.rpg.itens.Classificadores.*;

public class DemolidorDeTorres extends Martelo{
    public DemolidorDeTorres() {
        super("Demolidor de Torres", Raridade.EPICO, OrigemDoItem.CORREDOR, 10, 30, 0.45f);
        
        String desc = """
                Um martelo pesado e funcional, com a cabeça quadrada e maciça. 
                Foi projetado com um único propósito: quebrar o que não deveria ser quebrado. 
                É especialmente eficaz contra escudos, portões e construções. O cabo de madeira é reforçado com anéis de ferro, 
                garantindo que a arma não se despedace antes de seu alvo.
                """;
        this.setDescricao(desc);
    }
}
