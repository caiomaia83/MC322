package com.rpg.combate;


import com.rpg.personagens.*;
/**
 * Representa a ação de combate "Estocada Simples".
 * <p>
 * Implementa um ataque físico básico e direto, causando dano ao alvo com base
 * nos atributos do usuário. É uma ação de ataque fundamental.
 * </p>
 *
 * @author Fernando e Caio
 * @version 1.0
 * @since 2025-10-05
 */
public class EstocadaSimples implements AcaoCombate {
    /**
     * {@inheritDoc}
     * <p>
     * Executa um ataque físico que causa dano ao alvo, calculado a partir
     * dos atributos do usuário.
     * </p>
     */
    @Override
    public void executar(Combatente usuario, Combatente alvo) {
        System.out.println(usuario.getNome() + " atacou com: Estocada Simples!");
        
        int dano = 0;
        if (usuario instanceof Personagem) {
            dano = ((Personagem) usuario).getDano();
        }

        alvo.receberDano(dano);
    }
}

