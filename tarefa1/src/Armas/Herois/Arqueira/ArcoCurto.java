package Armas.Herois.Arqueira;

import Armas.ArmasBase.Arco;
import Classificadores.Raridade;

public class ArcoCurto extends Arco{
    public ArcoCurto() {
        super("Arco Curto de Patrulha", 1, 8, 6);
        this.setRaridade(Raridade.COMUM);
        String desc = """
                Um arco padrão distribuído às sentinelas e batedores do reino. 
                É leve, fácil de carregar por longos períodos e rápido de sacar.
                 Não tem grande potência, mas é preciso o suficiente para acertar um alvo desatento a cinquenta passos.
                """;
        this.setDescricao(desc);
    }
}
