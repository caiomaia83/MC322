package Itens.Armas.ArmasBase.Gerais;

import Itens.Armas.ArmasBase.Clava;
import Jogo.Classificadores.OrigemDoItem;
import Jogo.Classificadores.Raridade;

public class PrimeiraClava  extends Clava{
    public PrimeiraClava() {
        super("Primeira Clava", Raridade.COMUM, OrigemDoItem.GERAL, 1, 3, 0.1f);
    
        String desc = """
                Toda jornada começa com um único passo e, aparentemente, toda lenda começa com um pedaço de madeira. 
                Esta clava improvisada é a prova de que a coragem não depende da qualidade do aço, mas da força do 
                braço que a empunha.
                """;
        this.setDescricao(desc);
    }
}
