package com.rpg.game.combate; // SEU PACOTE ORIGINAL (mantido)

import com.rpg.game.personagens.*; // SEU IMPORT ORIGINAL (mantido)

/**
 * Representa a ação de combate "Estocada Simples".
 * <p>
 * Implementa um ataque físico básico e direto, causando dano ao alvo com base
 * no método {@code getDanoAtaque()} da interface {@link Combatente}.
 * É uma ação de ataque fundamental.
 * </p>
 *
 * @author Fernando e Caio
 * @version 1.1 // Versão atualizada
 * @since 2025-10-05
 */
public class EstocadaSimples implements AcaoCombate {
    /**
     * {@inheritDoc}
     * <p>
     * Executa um ataque físico que causa dano ao alvo, calculado chamando
     * {@code usuario.getDanoAtaque()}.
     * </p>
     */
    @Override
    public void executar(Combatente usuario, Combatente alvo) {
        System.out.println(usuario.getNome() + " atacou com: Estocada Simples!");
        
        // MUDANÇA PRINCIPAL: Usamos o método da interface, sem casting!
        int dano = usuario.getDanoAtaque();

        alvo.receberDano(dano);
    }
}