package com.rpg.game.itens.Armas.ArmasMonstros.Servos.Incomum;

import com.rpg.game.itens.Armas.ArmasBase.*;
import com.rpg.game.itens.Classificadores.*;

public class FerraoDeServo extends Adaga{
    public FerraoDeServo() {
        super("Ferrão de Servo Maior", Raridade.INCOMUM, OrigemDoItem.SERVOS, 3, 8, 0.4f );

        String desc = """
                O ferrão de um Servo Maior, notavelmente mais denso e afiado que uma garra comum. 
                Sua ponta é perfeita para encontrar e penetrar as junções de armaduras. 
                A arma parece ter uma predileção por alvos bem protegidos.
                """;
        this.setDescricao(desc);
    }
}
