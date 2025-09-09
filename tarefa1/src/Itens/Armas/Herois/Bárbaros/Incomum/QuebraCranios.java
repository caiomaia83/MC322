package Itens.Armas.Herois.Bárbaros.Incomum;

import Itens.Armas.ArmasBase.Martelo;
import Jogo.Classificadores.OrigemDoItem;
import Jogo.Classificadores.Raridade;

public class QuebraCranios extends Martelo{
    public QuebraCranios() {
        super("Quebra-Crânios Tribal", Raridade.INCOMUM, OrigemDoItem.BARBARO, 4, 14, 0.09f);
        this.setDescricao("""
                A cabeça desta maça é uma união de três crânios de ursos das cavernas, 
                reforçados com piche e tiras de ferro. É tanto uma arma quanto um símbolo 
                de status dentro do clã. Cada crânio representa um rito de passagem, e o 
                bárbaro que a empunha carrega a força de seus testes consigo.
                """);
    }
}
