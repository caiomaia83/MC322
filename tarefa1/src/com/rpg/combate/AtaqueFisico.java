package com.rpg.combate;

import com.rpg.personagens.*;
/**
 * Representa uma ação de Ataque Físico genérico.
 * <p>
 * Esta classe implementa a forma mais básica de ataque no jogo. Ela serve como
 * uma ação padrão para qualquer {@link Combatente}, causando dano direto com base
 * nos atributos do usuário.
 * </p>
 *
 * @author Fernando e Caio
 * @version 1.0
 * @since 2025-10-05
 */
public class AtaqueFisico implements AcaoCombate{
    /**
     * {@inheritDoc}
     * <p>
     * Executa um ataque físico padrão. O dano é calculado com base nos atributos
     * do {@code usuario}. Uma regra especial garante que o ataque sempre cause
     * no mínimo 1 ponto de dano, mesmo que o cálculo inicial resulte em zero ou menos.
     * </p>
     */
    @Override
    public void executar(Combatente usuario, Combatente alvo) {
      
        System.out.println(usuario.getNome() + " usa um Ataque Físico!");

        int danoTotal = 0;
        
 
        if (usuario instanceof Personagem) {
            Personagem personagemUsuario = (Personagem) usuario;
            danoTotal = personagemUsuario.getDano();
        }

        if (danoTotal <= 0) {
            // Garante que o ataque sempre cause pelo menos 1 de dano para dar feedback
            danoTotal = 1;
        }

        // Finalmente, a ação diz para o alvo receber o dano calculado
        alvo.receberDano(danoTotal);
    }
}