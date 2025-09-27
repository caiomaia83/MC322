package com.rpg.personagens;
import java.util.List;
import java.util.Random;

import com.rpg.combate.*;
import com.rpg.itens.Armas.*;

public abstract class Heroi extends Personagem {
    private int nivel;
    private int experiencia;
    private int expProximoNivel;
    private float sorte;

    protected List<AcaoCombate> acoes;

    public Heroi(String nome, int pontosDeVidaTotal, int forca, Arma arma) {
        super(nome, pontosDeVidaTotal, forca, arma);
        this.nivel = 1;
        this.experiencia = 0;
        this.expProximoNivel = 100;
        this.sorte = 0.0f;
    }

    public void ganharExperiencia(Monstro alvo) {
        this.experiencia += alvo.getXpConcedido();
        this.subirDeNivel();
    }

    @Override
    public void exibirStatus() {
        super.exibirStatus();
        System.out.printf("Nivel: %d\n", this.nivel);
        System.out.printf("Xp: %d / %d\n", this.experiencia, this.expProximoNivel);
    }

    private void subirDeNivel() {
        while (this.experiencia >= this.expProximoNivel) {
            // Guarda o xp que sobrou apos subir de nivel
            this.experiencia -= this.expProximoNivel;

            // Sobe de nivel
            this.nivel += 1;
            // Imprime uma mensagem ao jogador 
            System.out.println("------------------------------------");
            System.out.println(this.getNome() + " subiu para o nível" + this.nivel + "!");
            System.out.println("------------------------------------");
            System.out.println("Os atributos de " + this.getNome() + " aumentaram consideravelmente!");
            
            // Aumenta os atributos e calcula o xp para o proximo nivel 
            this.aumentaAtributos();
            this.expProximoNivel = (int) (100* Math.pow(1.15, this.nivel));
        }
    }


    // Equipa uma nova arma
    public void equiparArma(Arma novaArma) {
        // Verifica se o heroi possui nivel suficiente para a arma
        if(this.nivel >= novaArma.getMinNivel()) {
            System.out.println("Você equipou: " +  novaArma.getNome() + "!");
            this.arma = novaArma;
        } else {
            System.out.println("Você não tem nível suficiente para equipar essa arma...");
        }
    }

    // O getter da sorte é único na medida que ele muda toda vez que é chamado
    public float getSorte() {
        Random random = new Random();
        this.sorte = random.nextFloat(1.0f);
        return this.sorte;
    }

    // optei por fazer o aumento de nível individual á cada tipo de herói
    protected abstract void aumentaAtributos();

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

}
