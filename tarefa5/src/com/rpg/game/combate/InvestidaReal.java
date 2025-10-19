package com.rpg.game.combate; // SEU PACOTE (mantido)

import com.rpg.game.personagens.*; // SEU IMPORT (mantido)

/**
 * Representa a habilidade especial "Investida Real".
 * <p>
 * É uma manobra de alto risco e alta recompensa. A chance de sucesso e o
 * multiplicador de dano são baseados no método {@code getSorte()} do {@link Combatente}.
 * </p>
 *
 * @author Fernando e Caio
 * @version 1.1 // Versão atualizada
 * @since 2025-10-05
 */
public class InvestidaReal implements AcaoCombate {
    /**
     * {@inheritDoc}
     * <p>
     * Executa a Investida Real. O resultado é baseado no valor retornado por
     * {@code usuario.getSorte()}:
     * <ul>
     * <li>Sucesso (Sorte >= 0.20): O ataque acerta. O dano é {@code usuario.getDanoAtaque()}
     * multiplicado por {@code (1.5 + usuario.getSorte())}.</li>
     * <li>Falha (Sorte < 0.20): O ataque falha, causando 0 de dano.</li>
     * </ul>
     * </p>
     */
    @Override
    public void executar(Combatente usuario, Combatente alvo) {
        System.out.println("--> HABILIDADE ESPECIAL: " + usuario.getNome() + " usa INVESTIDA REAL! <--");

        float sorteAtual = usuario.getSorte(); // MUDANÇA 1: Usa método da interface

        if (sorteAtual >= 0.2f) { // Limite de 0.20f
            int danoBase = usuario.getDanoAtaque(); // MUDANÇA 2: Usa método da interface
            int danoFinal = (int) (danoBase * (1.5 + sorteAtual));
            System.out.println(usuario.getNome() + " acertou em cheio e causou dano crítico!");
            alvo.receberDano(danoFinal);
        } else {
            System.out.println(usuario.getNome() + " escorregou e não conseguiu atacar!");
            // Nenhum dano é aplicado
        }
    }
}