package com.rpg.itens.Loot;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.rpg.itens.*;
import com.rpg.itens.Classificadores.*;

// Gerenciador geral de loot para itens
// A chance de itens raros aumenta com a sorte do jogador 
public class GerenciadorDeLoot {
    // Sorteia sem sorte 
    public static Item sortearItem(List<? extends Item> tabelaDeLoot) {
        Random random = new Random();
        
        if(tabelaDeLoot == null || tabelaDeLoot.isEmpty()) {
            return null;
        }

        int pesoTotal = 0;
        // Calcula o peso total dos itens na lista (como que se estivesse botando todos itens em uma rifa)
        for(Item item : tabelaDeLoot) {
            pesoTotal += item.getRaridade().getPeso();
        }

        // Sorteia um numero aleatorio no limite do peso total dos itens
        int numeroSorteado = random.nextInt(pesoTotal) + 1;

        
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

    public static Item sortearItemComSorte(List<? extends Item> tabelaDeLoot, float sorteDoJogador) {
        // A sorte aumenta a chance de "rolar de novo" em uma tabela melhor
        Random random = new Random();
        if (random.nextFloat() <= sorteDoJogador) {
            System.out.println("Sorte extra! Tentando um item de maior raridade...");
            // Tenta pegar um item raro ou melhor da lista
            List<Item> itensMelhores = filtrarPorRaridadeMinima(tabelaDeLoot, Raridade.RARO);
            if (!itensMelhores.isEmpty()) {
                return sortearItem(itensMelhores); // Sorteia apenas entre os melhores
            }
        }
        
        // Se a sorte falhar ou não houver itens melhores, faz o sorteio normal
        return sortearItem(tabelaDeLoot);
    }

    // Permite filtrar por uma raridade mínima 
    private static List<Item> filtrarPorRaridadeMinima(List<? extends Item> tabela, Raridade min) {
        List<Item> filtrada = new ArrayList<>();
        for (Item item : tabela) {
            // ordinal() compara a posicao do enum 
            if (item.getRaridade().ordinal() >= min.ordinal()) {
                filtrada.add(item);
            }
        }
        return filtrada;
    }
    
}
