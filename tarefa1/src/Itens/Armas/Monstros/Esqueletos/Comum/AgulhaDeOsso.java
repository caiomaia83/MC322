package Itens.Armas.Monstros.Esqueletos.Comum;

import Itens.Armas.ArmasBase.Lanca;
import Jogo.Classificadores.OrigemDoItem;
import Jogo.Classificadores.Raridade;

public class AgulhaDeOsso extends Lanca{
    public AgulhaDeOsso() {
        super("Agulha de Osso", Raridade.COMUM, OrigemDoItem.ESQUELETO, 1, 6, 0.04f);

        String desc= """
                Uma lança improvisada, feita a partir da costela afiada de alguma criatura 
                enorme ou de um fêmur humano especialmente longo. É surpreendentemente leve 
                e sua ponta se quebra com facilidade, mas até lá, é um instrumento de perfuração 
                eficaz nas mãos de um ser que não tem nada a perder.
            """;
        this.setDescricao(desc);
    }
}
