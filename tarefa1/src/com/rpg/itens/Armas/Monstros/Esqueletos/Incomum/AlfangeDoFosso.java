package com.rpg.itens.Armas.Monstros.Esqueletos.Incomum;

import com.rpg.itens.Armas.ArmasBase.*;
import com.rpg.itens.Classificadores.*;

public class AlfangeDoFosso extends Espada{
    private boolean ferrugem; // Atributo único dessa lâmina

    public AlfangeDoFosso() {
        super("Alfange do Fosso", Raridade.INCOMUM, OrigemDoItem.ESQUELETO, 3, 7, 0.22f);

        String desc= """
                Esta espada passou décadas, talvez séculos, submersa na lama e na água parada de um fosso ou esgoto de masmorra. 
                A lâmina está coberta por uma camada espessa e escura de corrosão e lodo endurecido.
                Cheira a mofo e decomposição, e o cabo de couro está escorregadio e inchado pela umidade.
            """;
                    
        this.setDescricao(desc);
        this.ferrugem = true;
    }

    public boolean temFerrugem() { // TO DO: implementar lógica de efeitos no ataque
        return this.ferrugem;
    }
}
