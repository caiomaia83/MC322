package com.rpg.game.personagens.Monstros; // Seu pacote

import com.rpg.itens.Arma; // Supondo que DemolidorDeTorres herde de Arma
import com.rpg.itens.classificadores.OrigemDoItem;
import com.rpg.personagens.Monstro;
// Corrigindo o import da arma específica se necessário
import com.rpg.itens.armas.monstros.Corredor.DemolidorDeTorres;


public class Corredor extends Monstro {

    private int velocidade;

    public Corredor(int pontosDeVida, int forca, int xpConcedido, int velocidade) {
        super("Hog Rider", OrigemDoItem.CORREDOR, pontosDeVida, forca, xpConcedido, new DemolidorDeTorres());
        this.velocidade = velocidade;

    }

    // O getter da velocidade continua correto
    public int getVelocidade() {
        return this.velocidade;
    }

    // A implementação da chance de ataque extra continua correta
    @Override
    public int getChanceAtaqueExtra() {
        return this.velocidade;
    }

    @Override
    public Monstro criarCopiaFortalecida(double fatorDificuldade) {
        // Calcula os novos atributos (sua lógica original está correta)
        int novaVida = (int) (this.getPontosDeVidaTotal() * fatorDificuldade);
        int novaForca = (int) (this.getForca() * fatorDificuldade);
        int novoXp = (int) (this.getXpConcedido() * fatorDificuldade);

        // Cria a nova instância fortalecida
        Corredor copia = new Corredor(novaVida, novaForca, novoXp, this.velocidade);
   
        copia.setAcoes(this.acoes);
        // ----------------------
        
        return copia; // Retorna a cópia fortalecida e com as ações corretas
    }
}