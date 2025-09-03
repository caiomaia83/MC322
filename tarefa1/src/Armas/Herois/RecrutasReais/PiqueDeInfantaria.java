package Armas.Herois.RecrutasReais;
import Armas.ArmasBase.Lanca;
import Classificadores.Raridade;

public class PiqueDeInfantaria extends Lanca {
    public PiqueDeInfantaria(){
        super("Pique de Infantaria", 3, 12, 1);
        this.setRaridade(Raridade.COMUM);
        String desc = """
                Uma arma padronizada, forjada às centenas para armar as legiões do Rei. 
                O cabo é robusto e a ponta de ferro, em formato de folha, é projetada para ser eficaz tanto em estocadas quanto em pequenos cortes.
                Não é uma arma para heróis, mas uma ferramenta confiável para o soldado anônimo que forma a parede de escudos
                """;
        this.setDescricao(desc);
    
    }

}
