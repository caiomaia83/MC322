package com.rpg.game.combate; // O pacote correto

import com.rpg.game.personagens.Combatente; // Import da interface
// O import de 'Personagem' não é mais necessário aqui!

/**
 * Representa uma ação de Ataque Físico genérico.
 * <p>
 * Esta classe implementa a forma mais básica de ataque no jogo. Ela serve como
 * uma ação padrão para qualquer {@link Combatente}, causando dano direto com base
 * nos atributos do usuário definidos na interface {@code Combatente}.
 * </p>
 *
 * @author Fernando e Caio
 * @version 1.1 // Atualizei a versão para indicar a mudança
 * @since 2025-10-05
 */
public class AtaqueFisico implements AcaoCombate{
    /**
     * {@inheritDoc}
     * <p>
     * Executa um ataque físico padrão. O dano é calculado chamando o método
     * {@code getDanoAtaque()} do {@code usuario}. Uma regra especial garante que
     * o ataque sempre cause no mínimo 1 ponto de dano.
     * </p>
     */
    @Override
    public void executar(Combatente usuario, Combatente alvo) {
      
        System.out.println(usuario.getNome() + " usa um Ataque Físico!");

        // MUDANÇA PRINCIPAL: Usamos o método da interface, sem casting!
        int danoTotal = usuario.getDanoAtaque();

        // A lógica de dano mínimo continua igual
        if (danoTotal <= 0) {
            danoTotal = 1;
        }

        // A chamada para receber dano continua igual
        alvo.receberDano(danoTotal);
    }
}