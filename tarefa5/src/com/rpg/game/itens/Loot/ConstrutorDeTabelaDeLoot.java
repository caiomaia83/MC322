package com.rpg.game.itens.Loot;

import java.util.ArrayList;
import java.util.List;

import com.rpg.game.itens.*;
import com.rpg.game.itens.Armas.*;
import com.rpg.game.itens.Classificadores.*;
import com.rpg.game.itens.Registro.*;


// Constroi os itens de um persongem atraves do registro geral de itens 
public class ConstrutorDeTabelaDeLoot {
    
    // Constroi uma lista com as classes do item de cada monstro  
    public static List <Class <? extends Item>> constroiPara(OrigemDoItem origem) {
        List<Class <? extends Item>> tabelaDeLoot = new ArrayList<>();

        // Busca no registro geral por todos ites de mesma origem 
        for(Item itemModelo : RegistroDeItens.TODOS_OS_ITENS) {
            // Caso encontre um item dessa origem
            if(itemModelo.getOrigemDoItem() == origem) {
                tabelaDeLoot.add(itemModelo.getClass());
            }
        }
        return tabelaDeLoot;
    }

    // Constroi uma lista somente com as classes das armas desse monstro
    public static List <Class <? extends Arma>> constroiListaDeArmas(OrigemDoItem origem) {
        List<Class <? extends Arma>> tabelaDeArmas = new ArrayList<>();

        for(Item itemModelo: RegistroDeItens.TODOS_OS_ITENS) {
            if(itemModelo instanceof Arma && itemModelo.getOrigemDoItem() == origem) {
                Arma armaModelo = (Arma) itemModelo;
                if(armaModelo.getOrigemDoItem() == origem) {
                    tabelaDeArmas.add(armaModelo.getClass());
                }
            }
        }
        return tabelaDeArmas;
    }
}
