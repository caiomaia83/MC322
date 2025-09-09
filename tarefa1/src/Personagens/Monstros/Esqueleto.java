package Personagens.Monstros;

import java.util.List;

import Itens.Armas.*;
import Jogo.Classificadores.OrigemDoItem;
import Jogo.Loot.ConstrutorDeTabelaDeLoot;
import Jogo.Loot.GerenciadorDeLoot;
import Personagens.Monstro;
import Personagens.Personagem;

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

        // Retorna uma instancia mais forte
        return new Esqueleto( novaVida, novaForca, novoXp);
    }

    public void atacar(Personagem alvo) {
        System.out.println(this.getNome() + " atacou com: Bate-Crânio!");
        alvo.receberDano(this.getDano());
    }

}
