package com.rpg.game.personagens.Monstros; // Seu pacote

import com.rpg.itens.Arma; // Supondo que DemolidorDeTorres herde de Arma
import com.rpg.itens.classificadores.OrigemDoItem;
import com.rpg.personagens.Monstro;
// Corrigindo o import da arma específica se necessário
import com.rpg.itens.armas.monstros.Corredor.DemolidorDeTorres;

import com.rpg.itens.loot.ConstrutorDeTabelaDeLoot;
import com.rpg.itens.loot.GerenciadorDeLoot;
import com.rpg.itens.Item;
import com.rpg.itens.IItem;
import java.util.ArrayList;


public class Corredor extends Monstro {

    private static final List<Item> LISTA_POSSIVEIS_DROPS =
            ConstrutorDeTabelaDeLoot.constroiPara(OrigemDoItem.CORREDOR);

    private int velocidade;

    public Corredor(int pontosDeVida, int forca, int xpConcedido, int velocidade) {
        super("Hog Rider", OrigemDoItem.CORREDOR, pontosDeVida, forca, xpConcedido, new DemolidorDeTorres());
        this.velocidade = velocidade;
    }

    // Método auxiliar para filtrar apenas armas da lista de drops
    private static List<Arma> filtrarArmas(List<Item> listaCompleta) {
        List<Arma> armas = new ArrayList<>();
        for(Item i : listaCompleta) {
            if (i instanceof Arma) armas.add((Arma)i);
        }
        return armas;
    }
    public int getVelocidade() {
        return this.velocidade;
    }

    @Override
    public int getChanceAtaqueExtra() {
        return this.velocidade;
    }

    @Override
    public Monstro criarCopiaFortalecida(double fatorDificuldade) {
        int novaVida = (int) (this.getPontosDeVidaTotal() * fatorDificuldade);
        int novaForca = (int) (this.getForca() * fatorDificuldade);
        int novoXp = (int) (this.getXpConcedido() * fatorDificuldade);
        Corredor copia = new Corredor(novaVida, novaForca, novoXp, this.velocidade);
        copia.setAcoes(this.acoes); 
        return copia;
    }

    @Override
    public IItem droparLoot() {
        System.out.println("Verificando os despojos de " + getNome() + "...");
        if (LISTA_POSSIVEIS_DROPS.isEmpty()) {
            System.out.println(getNome() + " não tinha nada de valor.");
            return null;
        }
        // Usa a lista estática para o sorteio
        IItem itemSorteado = GerenciadorDeLoot.sortearItem(LISTA_POSSIVEIS_DROPS);

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