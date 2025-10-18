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
 * Cada subclasse concreta é responsável por definir sua própria tabela de loot
 * e implementar os métodos de drop.
 *
 * @author Fernando e Caio
 * @version 1.1 // Atualizada a versão
 * @since 2025-05-10
 */
public abstract class Monstro extends Personagem implements Lootavel {

    private int xpConcedido;
    // private List<Arma> listaDearmasParaLargar; // ATRIBUTO REMOVIDO
    private OrigemDoItem origem; // Guarda a origem de item do monstro
    protected List<AcaoCombate> acoes;

    public Monstro(String nome, OrigemDoItem origem, int pontosDeVidaTotal, int forca, int xpConcedido, Arma arma) {
        super(nome, pontosDeVidaTotal, forca, arma);
        this.xpConcedido = xpConcedido;
        this.origem = origem;
    }

    /**
     * Determina e retorna um item de loot quando o monstro é derrotado.
     *
     * Este método abstrato deve ser implementado por cada subclasse de monstro,
     * utilizando sua lista estática de possíveis drops e a lógica de sorteio desejada.
     *
     * @return Um {@link IItem} dropado pelo monstro, ou {@code null} se nada for dropado.
     */
    @Override
    public abstract IItem droparLoot(); // MÉTODO AGORA ABSTRATO

    /**
     * Cria uma cópia mais forte deste monstro, com atributos escalonados.
     *
     * @param fatorDificuldade O multiplicador a ser aplicado nos atributos.
     * @return Uma nova instância do monstro, fortalecida.
     */
    public abstract Monstro criarCopiaFortalecida(double fatorDificuldade);

    /**
     * Escolhe uma ação de combate aleatoriamente da lista de ações disponíveis.
     *
     * @param alvo O {@link Combatente} alvo da ação.
     * @return Uma {@link AcaoCombate} aleatória, ou {@code null}.
     */
    @Override
    public AcaoCombate escolherAcao(Combatente alvo) {
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

    public OrigemDoItem getOrigemDoItem() {
        return this.origem;
    }

    public void setAcoes(List<AcaoCombate> acoes) {
        this.acoes = acoes;
    }

    /**
     * Sorteia uma arma específica da tabela de loot do monstro com base na sorte.
     * <p>
     * Este método abstrato deve ser implementado por cada subclasse de monstro,
     * filtrando apenas as armas de sua lista estática de possíveis drops e
     * aplicando a lógica de sorteio.
     * </p>
     *
     * @param sorteDoJogador Um valor de ponto flutuante representando a sorte.
     * @return A {@link Arma} sorteada, ou {@code null}.
     */
    public abstract Arma largaArma(float sorteDoJogador); 
}