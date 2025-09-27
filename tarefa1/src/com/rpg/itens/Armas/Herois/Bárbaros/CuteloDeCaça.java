package com.rpg.itens.Armas.Herois.Bárbaros;

import Itens.Armas.ArmasBase.Espada;
import Jogo.Classificadores.OrigemDoItem;
import Jogo.Classificadores.Raridade;

public class CuteloDeCaça extends Espada {
    public CuteloDeCaça() {
        super("Cutelo de Caça", Raridade.COMUM, OrigemDoItem.GERAL, 1, 10, 0.2f); 

        String desc = """
                Uma lâmina larga e pesada, projetada para esquartejar grandes feras da floresta. 
                O fio é espesso para cortar couro e tendões, e o peso ajuda a romper a resistência de presas teimosas. 
                Não é uma arma de duelo, mas sim uma ferramenta de carnificina
                """;
        this.setDescricao(desc);
    }
}
