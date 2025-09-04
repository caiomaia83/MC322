package Personagens.Monstros;

import java.util.List;
import java.util.Random;

import Itens.Armas.Arma;
import Jogo.Classificadores.OrigemDoItem;
import Jogo.Loot.ConstrutorDeTabelaDeLoot;
import Jogo.Loot.GerenciadorDeLoot;
import Personagens.Monstro;
import Personagens.Personagem;

/* Monstro aéreo mais básico do jogo */
public class Servo extends Monstro {
    private Boolean arranhao;
    
    // Constroi a lista de todas armas que um servo pode dropar
    static List<Arma> LISTA_DE_ARMAS = ConstrutorDeTabelaDeLoot.constroiListaDeArmas(OrigemDoItem.SERVOS);

    public Servo( int pontosDeVida, int forca, int xpConcedido) {
        super("Servo", OrigemDoItem.SERVOS, pontosDeVida , forca, xpConcedido, (Arma) GerenciadorDeLoot.sortearItem(LISTA_DE_ARMAS));
        this.arranhao = false;
    }

    public Monstro criarCopiaFortalecida(double fatorDificuldade) {
        // Calcula os novos atributos
        int novaVida = (int) (this.getPontosDeVidaTotal() * fatorDificuldade);
        int novaForca = (int) (this.getForca() * fatorDificuldade);
        int novoXp = (int) (this.getXpConcedido() * fatorDificuldade);

        // Retorna uma instancia mais forte
        return new Servo( novaVida, novaForca, novoXp);
    }

    @Override
    public void atacar(Personagem alvo) {
        System.out.println(this.getNome() + " um servo raivoso ataca pelos ares!");
        alvo.receberDano(this.getDano());

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
