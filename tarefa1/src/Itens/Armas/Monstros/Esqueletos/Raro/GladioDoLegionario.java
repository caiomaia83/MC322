package Itens.Armas.Monstros.Esqueletos.Raro;

import Itens.Armas.ArmasBase.Espada;
import Jogo.Classificadores.OrigemDoItem;
import Jogo.Classificadores.Raridade;

public class GladioDoLegionario extends Espada{
    public GladioDoLegionario() {
        super("Gládio do Legionário Leal", Raridade.RARO, OrigemDoItem.ESQUELETO, 6, 18, 0.18f);
        String desc = """
                Mesmo após a morte, este legionário permaneceu em seu posto. Sua espada curta,
                o gládio, está surpreendentemente bem preservada, como se a lealdade de seu dono 
                a protegesse da decadência. A lâmina ainda é afiada, e a imagem de uma águia no 
                pomo permanece visível, embora desgastada.
                """;
        this.setDescricao(desc);
    }
}
