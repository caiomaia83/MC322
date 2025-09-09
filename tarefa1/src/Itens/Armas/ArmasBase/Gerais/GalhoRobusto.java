package Itens.Armas.ArmasBase.Gerais;


import Itens.Armas.Arma;
import Jogo.Classificadores.OrigemDoItem;
import Jogo.Classificadores.Raridade;

// Arma geral que pode ser utilizada por qualquer personagem
public class GalhoRobusto extends Arma{
    public GalhoRobusto() {
        super("Galho Robusto", Raridade.COMUM, OrigemDoItem.GERAL, 1, 1, 0.1f);
        String desc = """
                Não é uma arma. É um galho de carvalho que estava no chão há cinco minutos. 
                É pesado, desequilibrado, e o cabo improvisado deixa farpas na mão. Ainda assim, 
                dói mais do que um soco. Provavelmente.
                """;
        this.setDescricao(desc);
    }
}
