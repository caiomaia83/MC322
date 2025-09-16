package Personagens.Monstros;

import java.util.ArrayList; // ADICIONADO
import java.util.Random;

import Itens.Armas.Monstros.Corredor.DemolidorDeTorres;
import Jogo.Classificadores.OrigemDoItem;
import Personagens.Monstro;
import Personagens.Personagem;
import Jogo.ataques.*; // ADICIONADO: Importa as ações

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
