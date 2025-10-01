package com.rpg.itens.Armas.ArmasMonstros.Servos.Comum;

import com.rpg.itens.Armas.ArmasBase.*;
import com.rpg.itens.Classificadores.*;

public class GarraDeServo extends Adaga{
    public GarraDeServo() {
        super("Garra de Servo", Raridade.COMUM, OrigemDoItem.SERVOS, 1, 6, 0.35f);

        String desc = """
                A garra afiada de um servo menor, arrancada após sua destruição. 
                É leve, serrilhada e surpreendentemente dura, mas o cabo improvisado com tiras de couro dificulta o manuseio. 
                Mantém um leve cheiro de elixir negro.
                """;
        this.setDescricao(desc);
    }
}
