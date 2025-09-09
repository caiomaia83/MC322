package Itens.Armas.Monstros.Esqueletos.Epico;

import Itens.Armas.ArmasBase.Lanca;
import Jogo.Classificadores.OrigemDoItem;
import Jogo.Classificadores.Raridade;

// TO DO: Adicionar atributo especial
public class EspinhaDeDragao extends Lanca{
    public EspinhaDeDragao() {
        super("Espinha de Dragão de Esqueletos", Raridade.EPICO, OrigemDoItem.ESQUELETO, 15, 38 , 0.12f);
        String desc = """
                Uma lança formidável criada a partir de uma única vértebra fossilizada da espinha de um dragão de ossos. 
                A arma é incrivelmente densa e crepita com energia necrótica. A ponta, naturalmente afiada, parece guiar-se 
                em direção ao coração de suas vítimas.
                """;
        this.setDescricao(desc);
    }
}
