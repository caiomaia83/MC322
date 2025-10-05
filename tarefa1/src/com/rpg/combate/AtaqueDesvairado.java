package com.rpg.combate;


import com.rpg.personagens.*;
/**
 * Representa a ação de combate "Ataque Desvairado".
 * <p>
 * Esta classe implemente um ataque físico direto. Sua única
 * função é aplicar o dano total do usuário em um único alvo.
 * É um ataque característico dos bárbaros.
 * </p>
 * 
 * @author Fernando e Caio
 * @version 1.0
 * @since 05-10-05
 */
public class AtaqueDesvairado implements AcaoCombate {
    /**
     * {@inheritDoc}
     * <p>
     * Executa um ataque físico direto que causa dano ao alvo com base nos
     * atributos do usuário.
     * </p>
     */
    @Override
    public void executar(Combatente usuario, Combatente alvo) {
        System.out.println(usuario.getNome() + " ataca com: Ataque Desvairado!");
        
        int dano = 0;
        if (usuario instanceof Personagem) {
            dano = ((Personagem) usuario).getDano();
        }

        alvo.receberDano(dano);
    }
}
