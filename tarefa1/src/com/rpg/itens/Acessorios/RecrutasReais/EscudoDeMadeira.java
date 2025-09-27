package com.rpg.itens.Acessorios.RecrutasReais;

import Itens.Acessorios.Escudo;
import Jogo.Classificadores.OrigemDoItem;
import Jogo.Classificadores.Raridade;

public class EscudoDeMadeira extends Escudo{
    public EscudoDeMadeira() {
        super("Escudo de Madeira", Raridade.COMUM, OrigemDoItem.GERAL, 0.3f, 10, 8);
    }
}
