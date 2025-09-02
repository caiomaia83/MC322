

import java.util.Random;

public class Servos extends Monstro {
    private Boolean arranhao;

    public Servos(String nome, int pontosDeVida, int forca, int xpConcedido) {
        super(nome, pontosDeVida, forca, xpConcedido);
        this.arranhao = false;
    }

    @Override
    public void atacar(Personagem alvo) {
        System.out.println(this.nome + " 3 servos raivosos avançam pelos ares!");
        alvo.receberDano(this.forca);

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
