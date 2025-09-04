package Itens.Armas.Herois.RecrutasReais;
import Itens.Armas.ArmasBase.Lanca;
import Jogo.Classificadores.OrigemDoItem;
import Jogo.Classificadores.Raridade;

public class PiqueDeInfantaria extends Lanca {
    public PiqueDeInfantaria(){
        super("Pique de Infantaria",  Raridade.COMUM, OrigemDoItem.GERAL, 3, 10, 0.2f);
        String desc = """
                Uma arma padronizada, forjada às centenas para armar as legiões do Rei. 
                O cabo é robusto e a ponta de ferro, em formato de folha, é projetada para ser eficaz tanto em estocadas quanto em pequenos cortes.
                Não é uma arma para heróis, mas uma ferramenta confiável para o soldado anônimo que forma a parede de escudos
                """;
        this.setDescricao(desc);
    
    }

}
