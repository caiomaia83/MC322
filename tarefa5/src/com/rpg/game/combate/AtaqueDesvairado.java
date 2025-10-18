package com.rpg.game.combate; 

import com.rpg.personagens.Combatente; // Import da interface
// O import de 'Personagem' não é mais necessário aqui!

/**
 * Representa a ação de combate "Ataque Desvairado".
 * <p>
 * Esta classe implementa um ataque físico direto, utilizando o método
 * {@code getDanoAtaque()} da interface {@link Combatente}.
 * É um ataque característico dos bárbaros, mas pode ser usado por outros.
 * </p>
 *
 * @author Fernando e Caio
 * @version 1.1 // Atualizei a versão
 * @since 2025-10-05 // Corrigi a data
 */
public class AtaqueDesvairado implements AcaoCombate {
    /**
     * {@inheritDoc}
     * <p>
     * Executa um ataque físico direto que causa dano ao alvo com base no
     * retorno do método {@code getDanoAtaque()} do usuário.
     * </p>
     */
    @Override
    public void executar(Combatente usuario, Combatente alvo) {
        System.out.println(usuario.getNome() + " ataca com: Ataque Desvairado!");
        
        // MUDANÇA PRINCIPAL: Usamos o método da interface, sem casting!
        int dano = usuario.getDanoAtaque();

        alvo.receberDano(dano);
    }
}