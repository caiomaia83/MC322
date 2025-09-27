package com.rpg.personagens;

import java.util.List;
import java.util.Random;

import com.rpg.combate.AcaoCombate;
import com.rpg.itens.IItem;
import com.rpg.itens.Armas.Arma;
import com.rpg.itens.Classificadores.*;
import com.rpg.itens.Loot.*;

// MUDANÇA: Adicionado "implements Lootavel"
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
    
    // --- NOVO MÉTODO OBRIGATÓRIO DA INTERFACE Lootavel ---
    @Override
    public IItem droparLoot() {
        // Este método vai "adaptar" a chamada para o seu método já existente.
        
        // Como não temos a sorte do jogador aqui, vamos gerar uma sorte aleatória.
        Random random = new Random();
        float sorteGerada = random.nextFloat(); // Gera um número entre 0.0 e 1.0

        // Chama o seu método original 'largaArma' com a sorte gerada
        return this.largaArma(sorteGerada);
    }

    
    // --- SEUS MÉTODOS ORIGINAIS (INTACTOS) ---

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
        // Medida de segurança caso o herói não tenha nenhuma ação.
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

    // Seu método original foi mantido, como pedido.
    public Arma largaArma(float sorteDoJogador) {
        System.out.println(this.getNome() + " foi derrotado!");

        if(sorteDoJogador <= 0.15) { // Para sorte muito baixa o jogador não ganha nada 
            System.out.printf("Sorte baixa... %s não deixou cair nada.\n", this.getNome());
            return null; // Adicionado para não dar erro se não dropar nada
        }
        
        Arma armaSorteada = (Arma) GerenciadorDeLoot.sortearItemComSorte(this.listaDearmasParaLargar, sorteDoJogador);
        
        if (armaSorteada != null) {
            // PEQUENA CORREÇÃO: Troquei %d por %s para imprimir o nome da arma corretamente
            System.out.printf("%s deixou cair %s!\n", this.getNome(), armaSorteada.getNome());
        } else {
            System.out.printf("%s não deixou cair nada.\n", this.getNome());
        }

        return armaSorteada;
    }
}