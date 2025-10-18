package com.rpg.game.personagens;

import java.util.List;
import java.util.Random;

import com.rpg.game.combate.AcaoCombate;
import com.rpg.game.itens.InterfaceItem;
import com.rpg.game.itens.Armas.Arma;
import com.rpg.game.itens.Classificadores.*;
import com.rpg.game.itens.Loot.*;

/**
 * Representa um adversário genérico (monstro) no jogo
 * 
 * Essa classe extende {@link Personagem}, e implementa os comportamentos
 * específicos para monstros, como conceder experiência (XP) e a capacidade de dropar
 * itens ao ser derrotado, através da interface {@link Lootavel}.
 * 
 * @author Fernando e Caio
 * @ 1.0
 * @since 2025-05-10
 */
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
    
    /**
     * Determina e retorna um item de loot quando o monstro é derrotado.
     * 
     * Este método implementa a interface {@link Lootavel}, utilizando um fator de
     * sorte aleatório para decidir qual item, se houver, será dropado.
     * 
     * @return Um {@link InterfaceItem} dropado pelo monstro, ou {@code null} se nada for dropado.
     */
    @Override
    public InterfaceItem droparLoot() {
        // Este método vai "adaptar" a chamada para o seu método já existente.
        
        Random random = new Random();
        float sorteGerada = random.nextFloat(); // Gera um número entre 0.0 e 1.0

        
        return this.largaArma(sorteGerada);
    }

    
    /**
     * Cria uma cópia mais forte deste monstro, com atributos escalonados.
     * 
     * Este método abstrato deve ser implementado por cada subclasse de monstro
     * para definir como seus atributos (vida, força, etc.) são fortalecidos
     * com base em um fator de dificuldade.
     * 
     *
     * @param fatorDificuldade O multiplicador a ser aplicado nos atributos do novo monstro (ex: 1.5 para 50% mais forte).
     * @return Uma nova instância do monstro, fortalecida.
     */
    public abstract Monstro criarCopiaFortalecida(double fatorDificuldade); // Como é um método abstrato, será único a cada monstro
    /**
     * Escolhe uma ação de combate aleatoriamente da lista de ações disponíveis.
     *
     * @param alvo O {@link Combatente} alvo da ação.
     * @return Uma {@link AcaoCombate} aleatória para ser executada, ou {@code null} se o monstro não tiver ações.
     */
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

    public void setAcoes(List<AcaoCombate> acoes) {
    // Simplesmente atribui a lista recebida ao atributo 'acoes' do monstro
        this.acoes = acoes;
}

    /**
     * Sorteia uma arma da tabela de loot do monstro com base na sorte do jogador.
     * <p>
     * Imprime mensagens no console indicando o resultado do drop.
     * Se a sorte do jogador for muito baixa (<= 0.15), ou o monstro não
     * tiver nenhuma arma na sua lista de armas, nenhum item é dropado.
     * </p>
     *
     * @param sorteDoJogador Um valor de ponto flutuante (tipicamente entre 0.0 e 1.0) que representa a sorte.
     * @return A {@link Arma} sorteada, ou {@code null} se nenhum item for dropado
     */
    public Arma largaArma(float sorteDoJogador) {
        System.out.println(this.getNome() + " foi derrotado!");
        
        Arma armaSorteada = (Arma) GerenciadorDeLoot.sortearItemComSorte(this.listaDearmasParaLargar, sorteDoJogador);
        
        if (armaSorteada != null) {
            if(sorteDoJogador <= 0.15) { // Para sorte muito baixa o jogador não ganha nada 
            System.out.printf("Sorte baixa... %s não deixou cair nada.\n", this.getNome());
            return null; 
            } else {
                System.out.printf("%s deixou cair %s!\n", this.getNome(), armaSorteada.getNome());
            }
        } else {
            System.out.printf("%s não deixou cair nada.\n", this.getNome());
        }

        return armaSorteada;
    }
}