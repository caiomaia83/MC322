package com.rpg.game.personagens;
import java.util.List;
import java.util.Random;

import com.rpg.game.combate.*;
import com.rpg.game.exceptions.*;
import com.rpg.game.itens.Armas.*;
/**
 * Representa a base para todos heróis jogáveis do jogo
 * 
 * Esta classe abstrata estende {@link Personagem} e adiciona mecânicas
 * exclusivas aos heróis, como sistema de níveis, experiência e sorte.
 */
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

    /**
     * Adiciona experiência ao herói com base no XP concedido por um monstro derrotado.
     * Após ganhar experiência, verifica se o herói pode subir de nível.
     * 
     * @param alvo o {@link Monstro} derrotado que concede a experiência
     */
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
    /**
     * Verifica a experiência atual e sobe de nível se o necessário tiver sido atinjido
     * 
     * Este método pode ser chamado múltiplas vezes em sequêcia caso o herói ganhe
     * experiência suficiente para subir múltiplos níveis de uma vez.
     */
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


    /**
     * Equipa uma nova arma no herói, substituindo a atual.
     *
     * @param novaArma A {@link Arma} a ser equipada.
     * @throws NivelInsuficiente Se o nível do herói for menor que o nível mínimo
     * requerido pela arma.
     */
    public void equiparArma(Arma novaArma)throws NivelInsuficiente {
        // Verifica se o heroi possui nivel suficiente para a arma
        if(this.nivel >= novaArma.getMinNivel()) {
            System.out.println("Você equipou: " +  novaArma.getNome() + "!");
            this.arma = novaArma;
        } else {
            throw new NivelInsuficiente("Nível insuficiente! Você precisa do nível " +
            novaArma.getMinNivel() + " para equipar " + novaArma.getNome() + ".");
        }
    }

    // O getter da sorte é único na medida que ele muda toda vez que é chamado
    @Override
    public float getSorte() {
        Random random = new Random();
        this.sorte = random.nextFloat(1.0f);
        return this.sorte;
    }

    /**
     * Define como os atributos do herói (vida, força, etc.) aumentam ao subir de nível.
     * <p>
     * Este método é abstrato e deve ser implementado por cada subclasse de herói
     * para especificar seus ganhos de atributos únicos.
     * </p>
     */
    protected abstract void aumentaAtributos();

    /**
     * {@inheritDoc}
     * <p>
     * A implementação atual para o herói escolhe uma ação de combate de forma aleatória
     * a partir da sua lista de ações disponíveis.
     * </p>
     */
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
