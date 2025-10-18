package com.rpg.game.personagens.Monstros; // Seu pacote

import java.util.List;
// O import do ArrayList e Arranhao não são mais necessários aqui no topo para o construtor
// import java.util.ArrayList;
// import com.rpg.combate.Arranhao;

// Seus imports originais (mantidos)
import com.rpg.itens.Armas.*;
import com.rpg.itens.classificadores.*;
import com.rpg.itens.loot.*;
import com.rpg.personagens.Monstro;

public class Servo extends Monstro {

    static List<Arma> LISTA_DE_ARMAS = ConstrutorDeTabelaDeLoot.constroiListaDeArmas(OrigemDoItem.SERVOS);

    public Servo(int pontosDeVida, int forca, int xpConcedido) {
        super("Servo", OrigemDoItem.SERVOS, pontosDeVida, forca, xpConcedido, (Arma) GerenciadorDeLoot.sortearItem(LISTA_DE_ARMAS));

    }

    // Cria uma versao mais forte do monstro
    @Override
    public Monstro criarCopiaFortalecida(double fatorDificuldade) {
        // Calcula os novos atributos (sua lógica original está correta)
        int novaVida = (int) (this.getPontosDeVidaTotal() * fatorDificuldade);
        int novaForca = (int) (this.getForca() * fatorDificuldade);
        int novoXp = (int) (this.getXpConcedido() * fatorDificuldade);

        // Cria a nova instância fortalecida
        Servo copia = new Servo(novaVida, novaForca, novoXp);

        copia.setAcoes(this.acoes);
        // ----------------------

        return copia; // Retorna a cópia fortalecida e com as ações corretas
    }
}