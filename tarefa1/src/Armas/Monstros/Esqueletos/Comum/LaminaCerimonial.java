package Armas.Monstros.Esqueletos.Comum;

import Armas.ArmasBase.Espada;
import Classificadores.Raridade;

public class LaminaCerimonial extends Espada{
    public LaminaCerimonial() {
        super("Lâmina Cerimonial de Tumba", 1,5, 1);
        this.setRaridade(Raridade.COMUM);
        String desc= """
                Esta espada fina e outrora ornamentada foi colocada em uma tumba como uma oferenda, não como uma arma. 
                Nunca teve um fio verdadeiro e foi feita mais para impressionar do que para cortar.
                Anos de negligência a deixaram frágil e manchada, mas um esqueleto reanimado não se importa com a linhagem de sua arma, apenas com sua ponta
                """;
        this.setDescricao(desc);
    }
}
