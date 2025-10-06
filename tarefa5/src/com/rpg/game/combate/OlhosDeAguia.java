package com.rpg.game.combate;

import com.rpg.game.personagens.*;
import com.rpg.game.personagens.Herois.*;
/**
 * Representa a habilidade especial "Olhos de Águia", exclusiva da Arqueira.
 * <p>
 * Esta habilidade possui um efeito duplo: primeiro, ela concede um
 * <b>buff permanente</b> que aumenta a precisão e o alcance da {@link Arqueira}.
 * Em segundo lugar, ela desfere um ataque poderoso com alta chance de dano crítico.
 * </p>
 *
 * @author Fernando e Caio
 * @version 1.0
 * @since 2025-10-05
 */
public class OlhosDeAguia implements AcaoCombate {
    /**
     * {@inheritDoc}
     * <p>
     * Executa a habilidade em duas partes:
     * 
     * -<b>Buff:</b> Aumenta permanentemente a {@code precisao} e o {@code alcance} da Arqueira em 0.1.
     * -<b>Ataque:</b> Desfere um ataque com dois possíveis resultados baseados na sorte:
     * 
     * -<b>Dano Crítico (Sorte >= 0.75):</b> Chance de 25% de causar um dano massivo de 300% (3x).
     * -<b>Ataque Normal (Sorte < 0.75):</b> Caso o crítico falhe, executa um ataque com a mesma lógica da {@link FlechaPerfurante}, com chance de dano bônus de 130% (1.3x).
     * </p>
     */
    @Override
    public void executar(Combatente usuario, Combatente alvo) {
        System.out.println("--> HABILIDADE ESPECIAL: " + usuario.getNome() + " usou Olhos de Águia! <--");

        if (usuario instanceof Arqueira) {
            Arqueira arqueira = (Arqueira) usuario;

            // Parte 1: O Buff Permanente (usando os setters que criamos)
            arqueira.aumentarPrecisao(0.1f);
            arqueira.aumentarAlcance(0.1f);
            System.out.println("A precisão e o alcance de " + arqueira.getNome() + " aumentaram!");

            // Parte 2: O Ataque
            if (arqueira.getSorte() >= 0.75) {
                // O ataque crítico de 3x
                System.out.printf("%s acertou %s em seu ponto crítico, e causou dano avassalador!\n", arqueira.getNome(), alvo.getNome());
                int dano = arqueira.getDano() * 3;
                alvo.receberDano(dano);
            } else {
                // Se não deu o crítico, executa a mesma lógica do ataque básico "Flecha Perfurante"
                System.out.println("(Olhos de Águia) " + arqueira.getNome() + " dispara uma flecha precisa!");
                int dano;
                if ((arqueira.getSorte() + arqueira.precisao) >= 0.7f) {
                    dano = (int) (arqueira.getDano() * 1.3f);
                } else {
                    dano = arqueira.getDano();
                }
                alvo.receberDano(dano);
            }
        }
    }
}