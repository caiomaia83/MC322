package com.rpg.itens.Armas.ArmasBase.Gerais;

import com.rpg.itens.Classificadores.*;
import com.rpg.itens.Armas.Arma;

public class PeDeCadeira extends Arma{
    public PeDeCadeira() {
        super("Pé de Cadeira", Raridade.COMUM, OrigemDoItem.GERAL, 1, 2, 0.05f);
        this.setDescricao("""
                Em uma vida passada, este objeto servia ao nobre propósito de sustentar uma cadeira em uma taverna. 
                Após uma briga particularmente animada, ele encontrou uma nova e violenta vocação. Um dos lados ainda 
                tem um resto de verniz e cheira a cerveja barata
                """);
    }
}
