package Armas.Herois.Bárbaros;

import Armas.ArmasBase.Espada;
import Classificadores.Raridade;

public class QuebraOssos extends Espada {
    public QuebraOssos() {
        super("Quebra-Ossos Grosseiro",1,14,1);
        this.setRaridade(Raridade.COMUM); 

        String desc = """
                Menos uma espada e mais uma barra de ferro brutalmente afiada. 
                O equilíbrio é terrível e o cabo é simplesmente couro enrolado, 
                mas o peso puro da lâmina é suficiente para quebrar ossos e escudos com a mesma facilidade. 
                Uma arma que não exige técnica, apenas fúria.
                """;
        this.setDescricao(desc);
    }
}