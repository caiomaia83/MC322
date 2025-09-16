package Personagens.Monstros;

import java.util.List;
import java.util.ArrayList; // ADICIONADO
import java.util.Random;

import Itens.Armas.Arma;
import Jogo.Classificadores.OrigemDoItem;
import Jogo.Loot.ConstrutorDeTabelaDeLoot;
import Jogo.Loot.GerenciadorDeLoot;
import Personagens.Monstro;
import Personagens.Personagem;
import Jogo.ataques.*; // ADICIONADO

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