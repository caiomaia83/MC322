package com.rpg.personagens.Monstros;

import java.util.ArrayList; // ADICIONADO

import com.rpg.combate.*;
import com.rpg.itens.Armas.ArmasMonstros.Corredor.*;
import com.rpg.itens.Classificadores.*;
import com.rpg.personagens.Monstro;

public class Corredor extends Monstro {

    private int velocidade;

    public Corredor(int pontosDeVida, int forca, int xpConcedido, int velocidade) {
        super("Hog Rider", OrigemDoItem.CORREDOR, pontosDeVida, forca, xpConcedido, new DemolidorDeTorres());
        this.velocidade = velocidade;

      
        this.acoes = new ArrayList<>();
        this.acoes.add(new AtaqueDoCorredor()); 
    }

 
    public int getVelocidade() {
        return this.velocidade;
    }

    @Override
    public Monstro criarCopiaFortalecida(double fatorDificuldade) {
        int novaVida = (int) (this.getPontosDeVidaTotal() * fatorDificuldade);
        int novaForca = (int) (this.getForca() * fatorDificuldade);
        int novoXp = (int) (this.getXpConcedido() * fatorDificuldade);
        return new Corredor(novaVida, novaForca, novoXp, this.velocidade);
    }


}
