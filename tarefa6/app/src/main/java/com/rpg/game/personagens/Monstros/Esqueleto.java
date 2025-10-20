package com.rpg.game.personagens.Monstros;

import java.util.List;

import com.rpg.game.itens.Armas.*;
import com.rpg.game.itens.Classificadores.*;
import com.rpg.game.itens.Loot.*;
import com.rpg.game.personagens.Monstro;
import com.rpg.game.itens.*;

public class Esqueleto extends Monstro {

    private static final List<Class <? extends Item>> LISTA_POSSIVEIS_DROPS =
            ConstrutorDeTabelaDeLoot.constroiPara(OrigemDoItem.ESQUELETO);

    private static final List<Class <? extends Arma>> LISTA_POSSIVEIS_ARMAS = 
            ConstrutorDeTabelaDeLoot.constroiListaDeArmas(OrigemDoItem.ESQUELETO);

    public Esqueleto(int pontosDeVida, int forca, int xpconcedido) {
        // Sorteia a arma inicial a partir da nova lista estática
        super("Esqueleto", OrigemDoItem.ESQUELETO, pontosDeVida, forca, xpconcedido, sortearArmaInicial());
    }


    @Override
    public Monstro criarCopiaFortalecida(double fatorDificuldade) {
        int novaVida = (int) (this.getPontosDeVidaTotal() * fatorDificuldade);
        int novaForca = (int) (this.getForca() * fatorDificuldade);
        int novoXp = (int) (this.getXpConcedido() * fatorDificuldade);
        Esqueleto copia = new Esqueleto(novaVida, novaForca, novoXp);
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
        Class <? extends Item> classeSorteada = GerenciadorDeLoot.sortearItem(LISTA_POSSIVEIS_DROPS);

        if (classeSorteada != null) {
            try{ // Declara uma nova instância da classe 
                InterfaceItem itemInstanciado = classeSorteada.getDeclaredConstructor().newInstance();
                System.out.printf("%s deixou cair %s!\n", this.getNome(), itemInstanciado.getNome());
                return itemInstanciado;
            } catch (Exception e) {
                System.err.println("Erro crítico: Falha ao instanciar loot " + classeSorteada.getName());
                e.printStackTrace();
                return null;
            }
        } else {
            System.out.println("Nenhum item foi encontrado.");
            return null;
        }
    }

    @Override
    public Arma largaArma(float sorteDoJogador) {
         System.out.println(this.getNome() + " foi derrotado!");

        if (LISTA_POSSIVEIS_ARMAS.isEmpty()) {
             System.out.printf("%s não tinha armas para deixar cair.\n", this.getNome());
             return null;
         }
         if(sorteDoJogador <= 0.15) {
            System.out.printf("Sorte baixa... %s não deixou cair nada.\n", this.getNome());
            return null;
         }
         // Usa a lista filtrada para sortear com sorte
         Class<? extends Arma> classeDaArma = GerenciadorDeLoot.sortearArmaComSorte(LISTA_POSSIVEIS_ARMAS, sorteDoJogador);

         if (classeDaArma != null) {
            try{ // Instancia uma nova versão da arma 
                Arma armaInstanciada = classeDaArma.getDeclaredConstructor().newInstance();
                System.out.printf("%s deixou cair %s!\n", this.getNome(), armaInstanciada.getNome());
                return armaInstanciada;
            } catch (Exception e) {
                System.err.println("Erro crítico: Falha ao instanciar arma " + classeDaArma.getName());
                e.printStackTrace();
                return null;
            }
         } else {
            System.out.printf("%s não deixou cair nada.\n", this.getNome());
        }
        return null;

    }

    private static Arma sortearArmaInicial() {
        Class <? extends Arma> classeDaArma = GerenciadorDeLoot.sortearArma(LISTA_POSSIVEIS_ARMAS);
        try{ // Instancia uma nova versão da arma 
                Arma armaInstanciada = classeDaArma.getDeclaredConstructor().newInstance();
                return armaInstanciada;
            } catch (Exception e) {
                System.err.println("Erro crítico: Falha ao instanciar arma " + classeDaArma.getName());
                e.printStackTrace();
                return null;
            }
    }
}