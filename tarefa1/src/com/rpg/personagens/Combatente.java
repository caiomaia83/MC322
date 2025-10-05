package com.rpg.personagens;

import com.rpg.combate.*;
/**
 * Define o contrato para qualquer entidade que vá participar de combate
 * 
 * @author Fernando e Caio
 * @version 1.0
 * @since 2025-05-10
 */
public interface Combatente {
    String getNome();
    boolean estaVivo();
    int getPontosDeVida(); 
    /**
     * Aplica uma quantidade de dano ao combatente, reduzindo seus pontos de vida.
     *
     * @param dano A quantidade de dano a ser subtraída dos pontos de vida.
     * Espera-se que este valor não seja negativo.
     */
    void receberDano(int dano);
    /**
     * Aplica uma quantidade de cura ao combatente, restaurando seus pontos de vida.
     * 
     * A implementação deve garantir que a vida do combatente não ultrapasse
     * seu valor máximo.
     * 
     * @param cura A quantidade de pontos de vida a serem restaurados.
     */
    void receberCura(int cura);
    /**
     * Determina e retorna a próxima ação que o combatente executará em seu turno.
     * <p>
     * Este método encapsula a lógica de decisão do combatente, seja ela controlada
     * por um jogador (Herói) ou por uma inteligência artificial (Monstro).
     * </p>
     *
     * @param alvo O {@link Combatente} que é o alvo principal da ação.
     * @return O objeto {@link AcaoCombate} que representa a ação a ser executada.
     */
    AcaoCombate escolherAcao(Combatente alvo);
}