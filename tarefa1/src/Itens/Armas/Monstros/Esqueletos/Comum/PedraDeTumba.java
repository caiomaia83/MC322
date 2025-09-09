package Itens.Armas.Monstros.Esqueletos.Comum;

import Itens.Armas.ArmasBase.Martelo;
import Jogo.Classificadores.OrigemDoItem;
import Jogo.Classificadores.Raridade;

public class PedraDeTumba extends Martelo{
    public PedraDeTumba() {
        super("Pedra de Tumba Amarrada", Raridade.COMUM, OrigemDoItem.ESQUELETO, 1, 9, 0.08f);
        String desc = """
                Um pedaço quebrado de uma lápide ou sarcófago, amarrado a um cabo de madeira com 
                cordas apodrecidas. É uma arma improvisada, pesada e desequilibrada. O impacto é mais 
                um esmagamento surdo do que uma pancada limpa, e deixa um pó de granito na ferida.
                """;
        this.setDescricao(desc);
    }
}
