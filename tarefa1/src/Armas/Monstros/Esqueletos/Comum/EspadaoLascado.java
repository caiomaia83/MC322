package Armas.Monstros.Esqueletos.Comum;

import Armas.ArmasBase.Espada;
import Classificadores.Raridade;

public class EspadaoLascado extends Espada{
    public EspadaoLascado() {
        super("Espadão Lascado", 1,6, 1);
        this.setRaridade(Raridade.COMUM);
        String desc= """
                Uma espada de duas mãos que um dia foi imponente. Agora, grandes lascas de metal estão faltando em sua lâmina,
                resultado de batalhas antigas ou simplesmente da corrosão do tempo. É pesada e desajeitada, e o esqueleto que a levanta o faz com uma lentidão rangente, 
                dependendo mais do peso da arma do que de qualquer técnica
                """;
        this.setDescricao(desc);
    }
}
