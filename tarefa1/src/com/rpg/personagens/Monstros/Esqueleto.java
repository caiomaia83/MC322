package com.rpg.personagens.Monstros;

import java.util.ArrayList;
import java.util.List;

import com.rpg.combate.*;
import com.rpg.itens.Armas.*;
import com.rpg.itens.Classificadores.*;
import com.rpg.itens.Loot.*;
import com.rpg.personagens.Monstro;

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
