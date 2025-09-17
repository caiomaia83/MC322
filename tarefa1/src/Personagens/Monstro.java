package Personagens;

import java.util.List;
import java.util.Random;

import Itens.Armas.Arma;
import Jogo.Classificadores.OrigemDoItem;
import Jogo.Loot.ConstrutorDeTabelaDeLoot;
import Jogo.Loot.GerenciadorDeLoot;
import Jogo.ataques.AcaoCombate;


import Jogo.Loot.Lootavel;
import Itens.IItem;


public abstract class Monstro extends Personagem implements Lootavel {

    private int xpConcedido;
    private  List<Arma> listaDearmasParaLargar;
    private OrigemDoItem origem; // Guarda a origem de item do monstro
    protected List<AcaoCombate> acoes;

    public Monstro(String nome, OrigemDoItem origem, int pontosDeVidaTotal, int forca, int xpConcedido, Arma arma) {
        super(nome, pontosDeVidaTotal, forca, arma);
        this.xpConcedido = xpConcedido;
        this.origem = origem;
        this.listaDearmasParaLargar = ConstrutorDeTabelaDeLoot.constroiListaDeArmas(origem); // Constrói uma lista de armas 
    }
    
   
    @Override
    public IItem droparLoot() {
        
        // tem que mudar para pegar a sorte do heroi
        Random random = new Random();
        float sorteGerada = random.nextFloat(); 

        return this.largaArma(sorteGerada);
    }
        @Override
        public void restaurarVida(){
        this.pontosDeVida = pontosDeVidaTotal;
    }


    // Cria uma instância mais forte do monstro ao subirmos de fase 
    public abstract Monstro criarCopiaFortalecida(double fatorDificuldade); // Como é um método abstrato, será único a cada monstro

    @Override
    public AcaoCombate escolherAcao(Combatente alvo) {
        // escolhe uma acao/ataque aleatoriamente
        if (this.acoes != null && !this.acoes.isEmpty()) {
            Random random = new Random();
            int indiceAleatorio = random.nextInt(this.acoes.size());
            return this.acoes.get(indiceAleatorio);
        }
        return null;
    }
    
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

        if(sorteDoJogador <= 0.15) { 
            System.out.printf("Sorte baixa... %s não deixou cair nada.\n", this.getNome());
            return null; 
        }
        
        Arma armaSorteada = (Arma) GerenciadorDeLoot.sortearItemComSorte(this.listaDearmasParaLargar, sorteDoJogador);
        
        if (armaSorteada != null) {
            System.out.printf("%s deixou cair %s!\n", this.getNome(), armaSorteada.getNome());
        } else {
            System.out.printf("%s não deixou cair nada.\n", this.getNome());
        }

        return armaSorteada;
    }
}