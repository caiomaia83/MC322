package Armas.Herois.Bárbaros;

import Armas.ArmasBase.Espada;
import Classificadores.Raridade;

public class CuteloDeCaça extends Espada {
    public CuteloDeCaça() {
        super("Cutelo de Caça",1,10,2);
        this.setRaridade(Raridade.COMUM); 

        String desc = """
                Uma lâmina larga e pesada, projetada para esquartejar grandes feras da floresta. 
                O fio é espesso para cortar couro e tendões, e o peso ajuda a romper a resistência de presas teimosas. 
                Não é uma arma de duelo, mas sim uma ferramenta de carnificina
                """;
        this.setDescricao(desc);
    }
}
