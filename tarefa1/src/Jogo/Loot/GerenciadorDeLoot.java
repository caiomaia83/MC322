package Jogo.Loot;

import java.util.Random;

import Itens.Item;

import java.util.List;

// Gerenciador geral de loot para itens
public class GerenciadorDeLoot {
    public static Item sortearItem(List<? extends Item> tabelaDeLoot) {
        if(tabelaDeLoot == null || tabelaDeLoot.isEmpty()) {
            return null;
        }

        int pesoTotal = 0;
        // Calcula o peso total dos itens na lista (como que se estivesse botando todos itens em uma rifa)
        for(Item item : tabelaDeLoot) {
            pesoTotal += item.getRaridade().getPeso();
        }

        // Sorteia um numero aleatorio no limite do peso total dos itens
        int numeroSorteado = new Random().nextInt(pesoTotal) + 1;

        
        int pesoAcumulado = 0;
        // Encontra o item com correspondente ao numero sorteado
        for(Item item : tabelaDeLoot) {
            pesoAcumulado += item.getRaridade().getPeso();

            // Caso encontre, retorna uma instancia nova do item
            if(numeroSorteado <= pesoAcumulado) {
                try{
                    return  item.getClass().getDeclaredConstructor().newInstance();
                } catch (Exception e) { // Caso tenha erro
                    e.printStackTrace();
                    return null;
                }
            }
        

        }
        return null; // Nao era pra acontecer 
    }
    
}
