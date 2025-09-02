package Monstros;

import java.util.Random;

import Personagens.Monstro;
import Personagens.Personagem;

/* Monstro aéreo mais básico do jogo */
public class Servos extends Monstro {
    private Boolean arranhao;

    public Servos(String nome, int pontosDeVida, int forca, int xpConcedido) {
        super(nome, pontosDeVida, forca, xpConcedido);
        this.arranhao = false;
    }

    @Override
    public void atacar(Personagem alvo) {
        System.out.println(this.getNome() + " 3 servos raivosos avançam pelos ares!");
        alvo.receberDano(this.getForca());

        // esse monstro ṕode cegar o alvo temporariamente com suas garras afiadas
        Random random = new Random();
        if (random.nextInt(100) > 59) {
            this.arranhao = true;
        }

        if (this.arranhao == true) {
            System.out.println("As garras do servo acertaram o seu olho, voce fica cego ! ");
        }
    }
    public boolean isArranhao() {
    return this.arranhao;
    }
}
