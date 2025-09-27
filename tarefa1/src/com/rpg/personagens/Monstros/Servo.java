package com.rpg.personagens.Monstros;

import java.util.ArrayList; // ADICIONADO
import java.util.List;

import com.rpg.combate.Arranhao;
import com.rpg.itens.Armas.*;
import com.rpg.itens.Classificadores.*;
import com.rpg.itens.Loot.*;
import com.rpg.personagens.Monstro;

public class Servo extends Monstro {
    // private Boolean arranhao; // REMOVIDO
    
    static List<Arma> LISTA_DE_ARMAS = ConstrutorDeTabelaDeLoot.constroiListaDeArmas(OrigemDoItem.SERVOS);

    public Servo(int pontosDeVida, int forca, int xpConcedido) {
        super("Servo", OrigemDoItem.SERVOS, pontosDeVida, forca, xpConcedido, (Arma) GerenciadorDeLoot.sortearItem(LISTA_DE_ARMAS));
        // this.arranhao = false; // REMOVIDO

        // ADICIONADO: Preenchendo a lista de ações
        this.acoes = new ArrayList<>();
        this.acoes.add(new Arranhao());
    }

    // INTACTO: Sua função de criar cópias mais fortes continua aqui
    @Override
    public Monstro criarCopiaFortalecida(double fatorDificuldade) {
        int novaVida = (int) (this.getPontosDeVidaTotal() * fatorDificuldade);
        int novaForca = (int) (this.getForca() * fatorDificuldade);
        int novoXp = (int) (this.getXpConcedido() * fatorDificuldade);
        return new Servo(novaVida, novaForca, novoXp);
    }

}