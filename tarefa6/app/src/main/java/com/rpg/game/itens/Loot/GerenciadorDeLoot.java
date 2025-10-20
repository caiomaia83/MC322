package com.rpg.game.itens.Loot;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.rpg.game.itens.*;
import com.rpg.game.itens.Armas.Arma;
import com.rpg.game.itens.Classificadores.*;
import com.rpg.game.itens.Registro.RegistroDeItens;

// Gerenciador geral de loot para itens
// A chance de itens raros aumenta com a sorte do jogador 
public class GerenciadorDeLoot {
    // Sorteia sem sorte 
    public static Class<? extends Item> sortearItem(List<Class<? extends Item>> tabelaDeLoot) {
        Random random = new Random();
        
        if(tabelaDeLoot == null || tabelaDeLoot.isEmpty()) {
            return null;
        }

        int pesoTotal = 0;
        // Calcula o peso total dos itens na lista (como que se estivesse botando todos itens em uma rifa)
        for(Class<? extends Item> item : tabelaDeLoot) {
            // Usa os itens do registro do geral como referência, p/ n gerar novas instancias
            Item prototipo = RegistroDeItens.getPrototipo(item);

            if(prototipo != null) { // Pega o peso do item 
                pesoTotal += prototipo.getRaridade().getPeso();
            } else { // Avisa que o item não está no regsitro
                System.err.println("Alerta: Item " + item.getName() + " não encontrado no RegistroDeItens.");
            }
        }

        // Sorteia um numero aleatorio no limite do peso total dos itens
        int numeroSorteado = random.nextInt(pesoTotal) + 1;

        
        int pesoAcumulado = 0;
        // Encontra o item com correspondente ao numero sorteado
        for(Class<? extends Item>item : tabelaDeLoot) {
            Item prototipo = RegistroDeItens.getPrototipo(item);

            // Caso encontre, retorna a classe do item
            if (prototipo != null) {
                pesoAcumulado += prototipo.getRaridade().getPeso();

                if(numeroSorteado <= pesoAcumulado) {
                    return item;
                }
            }
        }
        return null; // Nao era pra acontecer 
    }

    public static Class<? extends Item> sortearItemComSorte(List<Class <? extends Item>> tabelaDeLoot, float sorteDoJogador) {
        // A sorte aumenta a chance de "rolar de novo" em uma tabela melhor
        Random random = new Random();
        List<Class<? extends Item>> tabelaDeItens = new ArrayList<>(tabelaDeLoot);

        if (random.nextFloat() <= sorteDoJogador) {
            System.out.println("Sorte extra! Tentando um item de maior raridade...");
            // Tenta pegar um item raro ou melhor da lista
            List<Class<? extends Item>> itensMelhores = filtrarPorRaridadeMinima(tabelaDeItens, Raridade.RARO);
            if (!itensMelhores.isEmpty()) {
                Class<? extends Item> classeSorteada = sortearItem(itensMelhores);
                return classeSorteada.asSubclass(Arma.class);
            }
        }
        
        // Se a sorte falhar ou não houver itens melhores, faz o sorteio normal
        Class<? extends Item> classeSorteada = sortearItem(tabelaDeItens);
        return classeSorteada;
    }

    // MÉTODOS PARA ARMAS

    public static Class <? extends Arma> sortearArma(List <Class<? extends Arma>> tabela) {
        // Converte a lista de Armas para uma lista de Itens p/ usar os helpers
        List<Class<? extends Item>> tabelaDeItens = new ArrayList<>(tabela);

        // Sorteia uma arma aleatória
        Class<? extends Item> classeSorteada = sortearItem(tabelaDeItens);
        
        // Converte de volta para Arma 
        return classeSorteada.asSubclass(Arma.class);
    }

    /**
     * Sorteia uma ARMA específica aplicando a lógica de "sorte".
     * Retorna Class<? extends Arma>.
     */
    public static Class<? extends Arma> sortearArmaComSorte(List<Class <? extends Arma>> tabelaDeArmas, float sorteDoJogador) {
        Random random = new Random();
        
        // Converte a lista de Armas para uma lista de Itens p/ usar os helpers
        List<Class<? extends Item>> tabelaDeItens = new ArrayList<>(tabelaDeArmas);

        if (random.nextFloat() <= sorteDoJogador) {
            System.out.println("Sorte extra! Tentando uma arma de maior raridade...");
            
            //  Filtra 
            List<Class<? extends Item>> itensMelhores = filtrarPorRaridadeMinima(tabelaDeItens, Raridade.RARO);
            
            if (!itensMelhores.isEmpty()) {
                // 2. Sorteia 
                Class<? extends Item> classeSorteada = sortearItem(itensMelhores);
                
                // 3. Converte de volta para Arma (agora é seguro)
                return classeSorteada.asSubclass(Arma.class); 
            }
        }
        
        // Se a sorte falhar, sorteio normal
        Class<? extends Item> classeSorteada = sortearItem(tabelaDeItens);
        
        // Converte de volta para Arma 
        return classeSorteada.asSubclass(Arma.class);
    }

    // Permite filtrar por uma raridade mínima 
    private static List<Class<? extends Item>> filtrarPorRaridadeMinima(List<Class<? extends Item>> tabela, Raridade min) {
        List<Class <? extends Item>> filtrada = new ArrayList<>();
        for (Class<? extends Item> item : tabela) {
            Item prototipo = RegistroDeItens.getPrototipo(item);
            // ordinal() compara a posicao do enum 
            if (prototipo.getRaridade().ordinal() >= min.ordinal()) {
                filtrada.add(item);
            }
        }
        return filtrada;
    }
    
}
