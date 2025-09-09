package Jogo.Loot;

import java.util.ArrayList;
import java.util.List;

import Jogo.Classificadores.OrigemDoItem;
import Jogo.Registro.RegistroDeItens;
import Itens.*;
import Itens.Armas.Arma;


// Constroi os itens de um persongem atraves do registro geral de itens 
public class ConstrutorDeTabelaDeLoot {
    
    // Constroi uma lista com todos itens desse monstro 
    public static List <Item> constroiPara(OrigemDoItem origem) {
        List<Item> tabelaDeLoot = new ArrayList<>();

        // Busca no registro geral por todos ites de mesma origem 
        for(Item itemModelo : RegistroDeItens.TODOS_OS_ITENS) {
            // Caso encontre um item dessa origem
            if(itemModelo.getOrigemDoItem() == origem) {
                tabelaDeLoot.add(itemModelo);
            }
        }
        return tabelaDeLoot;
    }

    // Constroi uma lista somente com as armas desse monstro
    // TO DO: otimizar esse método
    public static List <Arma> constroiListaDeArmas(OrigemDoItem origem) {
        List<Arma> tabelaDeArmas = new ArrayList<>();

        for(Item itemModelo: RegistroDeItens.TODOS_OS_ITENS) {
            if(itemModelo instanceof Arma) {
                Arma armaModelo = (Arma) itemModelo;
                if(armaModelo.getOrigemDoItem() == origem) {
                    tabelaDeArmas.add(armaModelo);
                }
            }
        }
        return tabelaDeArmas;
    }
}
