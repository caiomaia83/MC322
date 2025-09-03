package Monstros;

import java.util.Random;

import Armas.Monstros.Corredor.DemolidorDeTorres;
import Personagens.Monstro;
import Personagens.Personagem;

// Corredor é uma classe concreta que herda da classe abstrata Monstro
public class Corredor extends Monstro {

    // atributo unico da classe
    private int velocidade;

    // Construtor do Corredor
    public Corredor(String nome, int pontosDeVida, int forca, int xpConcedido, int velocidade) {
        // constroi a classe pai
        super(nome, pontosDeVida, forca, xpConcedido, new DemolidorDeTorres());
        //inicializa att proprio
        this.velocidade = velocidade;
    }

    
    @Override
    public void atacar(Personagem alvo) {
        System.out.println(this.getNome() + " avança rapidamente montado em seu porco e golpeia com seu poderoso martelo!");
        alvo.receberDano(this.getDano());

        // esse monstro pode atacar duas vezes devido a sua imensa agilidade
        Random random = new Random();
        // Gera um número aleatório de 0 a 99. Se for menor que a velocidade, ataca de novo.
        // Ou seja, um Corredor com velocidade 30 tem 30% de chance de atacar duas vezes.
        if (random.nextInt(100) < this.velocidade) {
            System.out.println("A velocidade de " + this.getNome() + " permite um segundo ataque!");
           alvo.receberDano( this.getDano());
        }
    }
}
