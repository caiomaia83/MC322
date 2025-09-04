package Personagens;

import java.util.List;

import Itens.Armas.Arma;
import Jogo.Classificadores.OrigemDoItem;
import Jogo.Loot.ConstrutorDeTabelaDeLoot;
import Jogo.Loot.GerenciadorDeLoot;

public abstract class Monstro extends Personagem {

    private int xpConcedido;
    private  List<Arma> listaDearmasParaLargar;
    private OrigemDoItem origem; // Guarda a origem de item do monstro

    public Monstro(String nome, OrigemDoItem origem, int pontosDeVidaTotal, int forca, int xpConcedido, Arma arma) {
        super(nome, pontosDeVidaTotal, forca, arma);
        this.xpConcedido = xpConcedido;
        this.origem = origem;
        this.listaDearmasParaLargar = ConstrutorDeTabelaDeLoot.constroiListaDeArmas(origem); // Constrói uma lista de armas 

    }

    // Cria uma instância mais forte do monstro ao subirmos de fase 
    public abstract Monstro criarCopiaFortalecida(double fatorDificuldade); // Como é um método abstrato, será único a cada monstro

    @Override
    public void exibirStatus() {
        super.exibirStatus();

        System.out.printf("XP concedido: %d\n", this.xpConcedido);
    }

    public int getXpConcedido() {
        return this.xpConcedido;
    }

    public List<Arma> getListaDeArmasParaLargar() {
        return this.listaDearmasParaLargar;
    }

    protected void setListaDeArmasParaLargar(List <Arma> lista) {
        this.listaDearmasParaLargar = lista;
    }

    public OrigemDoItem getOrigemDoItem() {
        return this.origem;
    }

    public Arma largaArma(float sorteDoJogador) {
        System.out.println(this.getNome() + " foi derrotado!");

        if(sorteDoJogador <= 0.15) { // Para sorte muito baixa o jogador não ganha nada 
            System.out.printf("Sorte baixa... %s não deixou cair nada.", this.getNome());
        }
        
        Arma armaSorteada = (Arma) GerenciadorDeLoot.sortearItem(this.listaDearmasParaLargar, sorteDoJogador);
        
        System.out.printf("%s deixou cair %d!\n", this.getNome(), armaSorteada.getNome());

        return armaSorteada;
    }
}