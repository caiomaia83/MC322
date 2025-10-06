package com.rpg.game.personagens.Monstros;

import java.util.ArrayList;
import java.util.List;

import com.rpg.game.combate.*;
import com.rpg.game.itens.Armas.*;
import com.rpg.game.itens.Classificadores.*;
import com.rpg.game.itens.Loot.*;
import com.rpg.game.personagens.Monstro;

public class Esqueleto extends Monstro {
    // Constroi a lista de todas armas que um esqueleto pode dropar
    static List<Arma> LISTA_DE_ARMAS = ConstrutorDeTabelaDeLoot.constroiListaDeArmas(OrigemDoItem.ESQUELETO);

    public Esqueleto(int pontosDeVida, int forca, int xpconcedido) {
        super("Esqueleto", OrigemDoItem.ESQUELETO, pontosDeVida, forca, xpconcedido, (Arma) GerenciadorDeLoot.sortearItem(LISTA_DE_ARMAS)); // Equipa uma arma aleatória
    }

    public Monstro criarCopiaFortalecida(double fatorDificuldade) {
        // Calcula os novos atributos
        int novaVida = (int) (this.getPontosDeVidaTotal() * fatorDificuldade);
        int novaForca = (int) (this.getForca() * fatorDificuldade);
        int novoXp = (int) (this.getXpConcedido() * fatorDificuldade);
        this.acoes = new ArrayList<>();
        this.acoes.add(new AtaqueFisico());

        // Retorna uma instancia mais forte
        return new Esqueleto( novaVida, novaForca, novoXp);
    }
}
