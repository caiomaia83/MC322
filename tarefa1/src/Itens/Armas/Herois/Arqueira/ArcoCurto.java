package Itens.Armas.Herois.Arqueira;

import Itens.Armas.ArmasBase.Arco;
import Jogo.Classificadores.OrigemDoItem;
import Jogo.Classificadores.Raridade;

public class ArcoCurto extends Arco{
    public ArcoCurto() {
        super("Arco Curto de Patrulha", Raridade.COMUM, OrigemDoItem.ARQUEIRA, 0, 8, 0.3f);
        String desc = """
                Um arco padrão distribuído às sentinelas e batedores do reino. 
                É leve, fácil de carregar por longos períodos e rápido de sacar.
                 Não tem grande potência, mas é preciso o suficiente para acertar um alvo desatento a cinquenta passos.
                """;
        this.setDescricao(desc);
    }
}
