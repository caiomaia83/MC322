package com.rpg.game.combate; 

// SEUS IMPORTS ORIGINAIS (mantidos)
import com.rpg.personagens.*;
import com.rpg.personagens.Herois.*; // Mantido, embora Arqueira não seja mais usada diretamente

/**
 * Representa a ação de combate "Flecha Perfurante".
 * <p>
 * Esta ação tem a chance de causar dano aumentado. A probabilidade de um golpe
 * preciso é calculada somando {@code getSorte()} e {@code getPrecisaoAtaque()}
 * do {@link Combatente}.
 * </p>
 *
 * @author Fernando e Caio
 * @version 1.1 // Versão atualizada
 * @since 2025-10-05
 */
public class FlechaPerfurante implements AcaoCombate {
    /**
     * {@inheritDoc}
     * <p>
     * Executa o disparo de uma flecha. Se a soma de {@code usuario.getSorte()} e
     * {@code usuario.getPrecisaoAtaque()} for 0.7 ou maior, o ataque causa 130% (1.3x)
     * do {@code usuario.getDanoAtaque()}. Caso contrário, causa o dano padrão.
     * </p>
     */
    @Override
    public void executar(Combatente usuario, Combatente alvo) {
        System.out.println(usuario.getNome() + " atacou com: Flecha Perfurante!");

        int danoBase = usuario.getDanoAtaque(); // MUDANÇA 1: Usa método da interface
        float chanceCritico = usuario.getSorte() + usuario.getPrecisaoAtaque(); // MUDANÇA 2: Usa métodos da interface
        int danoFinal;

        if (chanceCritico >= 0.7f) {
            danoFinal = (int) (danoBase * 1.3f);
            System.out.println(usuario.getNome() + " acertou um golpe preciso e causou mais dano!");
        } else {
            danoFinal = danoBase;
        }
        alvo.receberDano(danoFinal);
    }
}