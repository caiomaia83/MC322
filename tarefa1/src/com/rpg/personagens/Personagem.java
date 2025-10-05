package com.rpg.personagens;

import com.rpg.itens.Armas.Arma;
import com.rpg.combate.*;

/**
 * Representa a base para qualquer entidade viva do jogo
 * Esta classe abstrata define os atributos e comportamentos comuns
 * a todos os personagens, heróis ou monstros, que participam de combate
 * 
 * @author Fernando e Caio
 * @version 1.0
 * @since 2025-05-10
 */
public abstract class Personagem implements Combatente{
    private String nome;
    protected int pontosDeVida;
    private int pontosDeVidaTotal; // Guarda o hp total 
    private int forca;
    protected int dano;
    protected Arma arma;
    
    /**
     * Construtor para inicializar novo personagem
     * 
     * @param nome O nome do personagem
     * @param pontosDeVidaTotal A quantidade inicial de vida do personagem
     * @param forca O valor base da força do personagem
     * @param arma A arma utilizada pelo personagem
     */
    public Personagem(String nome, int pontosDeVidaTotal, int forca, Arma arma) {
        this.forca = forca;
        this.nome = nome;
        this.pontosDeVida =  pontosDeVidaTotal;
        this.pontosDeVidaTotal = pontosDeVidaTotal;
        this.arma = arma;
    }

    /**
     * Verifica se o personagem ainda esta vivo
     * 
     * @return true caso os pontos de vida sejam maiores que zero, 
     * false caso contrário
     */
    public boolean estaVivo() {
        return (this.pontosDeVida > 0);
    }
    /**
     * Aplica dano ao personagem, reduzindo seus pontos de vida de acordo com o dano
     * 
     * Garante que a vida seja maior que zero
     * 
     * @dano A quantidade de dano a ser recebida
     * @throw IllegalArgumentException se o valor do dano for negativo
     */
    public void receberDano(int dano) {
        if( dano < 0) {
            throw new IllegalArgumentException("Dano não pode ser negativo.");
        }
        this.pontosDeVida -= dano;

        if(this.pontosDeVida < 0) { 
            this.pontosDeVida = 0;
        }

        // Imprime uma mensagem indicando a ação 
        System.out.printf("%s recebeu %d de dano!\n", this.nome, dano);
    }
 
    public void exibirStatus() {
        System.out.printf(" -- Status de %s --\n", this.nome);
        System.out.printf("HP: %d / %d\n", this.pontosDeVida, this.pontosDeVidaTotal);
        if(this.arma == null) {
            System.out.println("Arma: Nenhuma Equipada");
        } else {
            System.out.printf("Arma: %s \n", this.arma.getNome());
        }
        System.out.printf("Forca: %d\n", this.forca);
    }

    public String getNome() {
        return this.nome;
    }

    public int getPontosDeVida() {
        return this.pontosDeVida;
    }

    protected void setPontosDeVida(int hp) {
        this.pontosDeVida = hp;
    }

    public int getPontosDeVidaTotal() {
        return this.pontosDeVidaTotal;
    }

    protected void setPontosDeVidaTotal(int hpTotal) {
        this.pontosDeVidaTotal = hpTotal;
    }
    /**
     * Calcula e retorna o dano total do ataque do personagem.
     * 
     * O cálculo é baseado na força do personagem somado ao dano da arma equipada.
     * Se nenhuma arma estiver equipada, o dano é igual à força.
     *
     * @return O dano total do ataque
     */
    public int getDano() { // Retorna o dano do ataque do personagem
        if(this.arma == null) {
            return this.forca;
        }

        return (this.forca + this.arma.getDano());
    }

    public int getForca() {
        return this.forca;
    }

    protected void setForca(int forca) {
        this.forca = forca;
    }

    public String getNomeArma() {
        return this.arma.getNome();
    }
    private String getDescricaoArma() {
        return this.arma.getDescricao();
    }

    public void exibirStatusArma() {
        System.out.printf(" ======== Status de Arma:  %s ========\n", this.getNomeArma());
        System.out.printf("Descrição: " + this.getDescricaoArma());
        System.out.printf("Dano: %s \n", this.arma.getDano());
        System.out.printf("Forca: %d\n", this.forca);
    }
    /**
     * Atribui cura ao personagem
     * Garante que a cura não ultrapasse os pontos de vida máximos
     * @param cura Quantidade de cura recebida 
     */
    public void receberCura(int cura) {
        this.pontosDeVida += cura;

        // Garante que a cura não ultrapasse a vida máxima
        if (this.pontosDeVida > this.pontosDeVidaTotal) {
            this.pontosDeVida = this.pontosDeVidaTotal;
        }

        System.out.printf("%s recebeu %d de cura!\n", this.nome, cura);
    }
    /**
     * Define a lógica para que o personagem escolha uma ação durante o combate.
     * 
     * Este método deve ser implementado pelas subclasses para determinar o
     * comportamento do personagem (ex: atacar, defender, usar item).
     * 
     * @param alvo O combatente que é o alvo da ação escolhida.
     * @return A {@link AcaoCombate} a ser executada pelo personagem.
     */
    public abstract AcaoCombate escolherAcao(Combatente alvo);
    
  
}