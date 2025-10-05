package com.rpg.combate;


import com.rpg.personagens.*;

/**
 * Representa a habilidade especial "Investida Real", habilidade especial do Recruta Real.
 * <p>
 * É uma manobra de alto risco e alta recompensa. Possui uma alta chance (80%)
 * de causar um dano crítico massivo, mas também uma pequena chance (20%) de falhar
 * completamente, não causando dano algum.
 * </p>
 *
 * @author Fernando e Caio
 * @version 1.0
 * @since 2025-10-05
 */
public class InvestidaReal implements AcaoCombate {
        /**
     * {@inheritDoc}
     * <p>
     * Executa a Investida Real. O resultado é baseado na sorte do {@link Heroi}:
     * 
     * -Sucesso (Sorte >= 0.20): O ataque acerta e causa dano crítico. O multiplicador de dano é dinâmico, sendo {@code (1.5 + sorte)}, resultando em um dano entre 165% e 250%.
     * -Falha (Sorte < 0.20): O herói escorrega, e o ataque falha, causando 0 de dano.
     * </p>
     */
    @Override
    public void executar(Combatente usuario, Combatente alvo) {
        System.out.println("--> HABILIDADE ESPECIAL! <--");
        
        // A lógica de sorte que estava em 'usarHabilidadeEspecial' vem para cá
        // Precisamos garantir que o 'usuario' é um Herói para usar o getSorte()
        if (usuario instanceof Heroi) {
            Heroi heroiUsuario = (Heroi) usuario;

            if (heroiUsuario.getSorte() >= 0.2) {
                // A lógica de dano bônus que estava no 'atacar' vem para cá
                int dano = (int) (heroiUsuario.getDano() * (1.5 + heroiUsuario.getSorte()));
                System.out.println(heroiUsuario.getNome() + " atacou com Investida Real e causou dano crítico!");
                alvo.receberDano(dano);

            } else {
                // A lógica do azar que estava em 'usarHabilidadeEspecial' vem para cá
                System.out.println(heroiUsuario.getNome() + " escorregou e não conseguiu atacar!");
            }
        } else {
            // Caso de segurança se um não-herói tentar usar isso
            System.out.println("Apenas heróis podem usar esta habilidade!");
        }
    }
}
