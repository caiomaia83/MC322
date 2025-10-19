package com.rpg.game.personagens.Monstros; // Seu pacote original (mantido)

import java.util.ArrayList; // Adicionado para filtrarArmas (se necessário)
import java.util.List;

// --- Imports Corrigidos para usar com.rpg.game ---
import com.rpg.game.itens.Armas.*;
import com.rpg.game.itens.Classificadores.*; 
import com.rpg.game.itens.Loot.*; 
import com.rpg.game.personagens.Monstro;
import com.rpg.game.itens.*; 

public class Servo extends Monstro {

    private static final List<Item> LISTA_POSSIVEIS_DROPS =
            ConstrutorDeTabelaDeLoot.constroiPara(OrigemDoItem.SERVOS);


    public Servo(int pontosDeVida, int forca, int xpConcedido) {
        super("Servo", OrigemDoItem.SERVOS, pontosDeVida, forca, xpConcedido, sortearArmaInicial());
    }

    // Método auxiliar para sortear a arma inicial da lista estática
    private static Arma sortearArmaInicial() {
        List<Arma> armasPossiveis = filtrarArmas(LISTA_POSSIVEIS_DROPS);
        if (armasPossiveis.isEmpty()) return null;
        return (Arma) GerenciadorDeLoot.sortearItem(armasPossiveis);
    }

    // Método auxiliar para filtrar apenas armas da lista de drops
    private static List<Arma> filtrarArmas(List<Item> listaCompleta) {
        List<Arma> armas = new ArrayList<>();
        for(Item i : listaCompleta) {
            if (i instanceof Arma) armas.add((Arma)i);
        }
        return armas;
    }

    // Cria uma versao mais forte do monstro
    @Override
    public Monstro criarCopiaFortalecida(double fatorDificuldade) {
        int novaVida = (int) (this.getPontosDeVidaTotal() * fatorDificuldade);
        int novaForca = (int) (this.getForca() * fatorDificuldade);
        int novoXp = (int) (this.getXpConcedido() * fatorDificuldade);
        Servo copia = new Servo(novaVida, novaForca, novoXp);
        copia.setAcoes(this.acoes); // Copia ações compartilhadas
        return copia;
    }

    @Override
    public InterfaceItem droparLoot() {
        System.out.println("Verificando os despojos de " + getNome() + "...");
        if (LISTA_POSSIVEIS_DROPS.isEmpty()) {
            System.out.println(getNome() + " não tinha nada de valor.");
            return null;
        }
        // Usa a lista estática para o sorteio
        InterfaceItem itemSorteado = GerenciadorDeLoot.sortearItem(LISTA_POSSIVEIS_DROPS);

        if (itemSorteado != null) {
            System.out.printf("%s deixou cair %s!\n", this.getNome(), itemSorteado.getNome());
        } else {
            System.out.println("Nenhum item foi encontrado.");
        }
        return itemSorteado;
    }

    @Override
    public Arma largaArma(float sorteDoJogador) {
         System.out.println(this.getNome() + " foi derrotado!");
         List<Arma> armasPossiveis = filtrarArmas(LISTA_POSSIVEIS_DROPS); // Filtra da lista estática

         if (armasPossiveis.isEmpty()) {
             System.out.printf("%s não tinha armas para deixar cair.\n", this.getNome());
             return null;
         }
         if(sorteDoJogador <= 0.15) {
            System.out.printf("Sorte baixa... %s não deixou cair nada.\n", this.getNome());
            return null;
         }
         // Usa a lista filtrada para sortear com sorte
         Arma armaSorteada = (Arma) GerenciadorDeLoot.sortearItemComSorte(armasPossiveis, sorteDoJogador);

         if (armaSorteada != null) {
            System.out.printf("%s deixou cair %s!\n", this.getNome(), armaSorteada.getNome());
         } else {
            System.out.printf("%s não deixou cair nada.\n", this.getNome());
         }
         return armaSorteada;
    }
}