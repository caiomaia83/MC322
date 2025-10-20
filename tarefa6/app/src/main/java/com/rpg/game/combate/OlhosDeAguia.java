package com.rpg.game.combate;

import com.rpg.game.personagens.*;
import com.rpg.game.personagens.Herois.*;

/**
 * Representa a habilidade especial "Olhos de Águia", exclusiva da Arqueira.
 * <p>
 * Esta habilidade aplica um buff permanente nos atributos da {@link Arqueira}
 * e desfere um ataque com chance de dano crítico massivo ou bônus,
 * calculado com base nos métodos da interface {@link Combatente}.
 * </p>
 *
 * @author Fernando e Caio
 * @version 1.1 // Versão atualizada
 * @since 2025-10-05
 */
public class OlhosDeAguia implements AcaoCombate {

    @Override
    public void executar(Combatente usuario, Combatente alvo) {
        System.out.println("--> HABILIDADE ESPECIAL: " + usuario.getNome() + " usou Olhos de Águia! <--");

        // --- Parte 1: O Buff (Mantém o casting, pois é específico da Arqueira) ---
        if (usuario instanceof Arqueira) {
            Arqueira arqueira = (Arqueira) usuario;
            arqueira.aumentarPrecisao(0.1f);
            arqueira.aumentarAlcance(0.1f);
            System.out.println("A precisão e o alcance de " + arqueira.getNome() + " aumentaram!");
        } else {
             // Se não for Arqueira, o buff não se aplica, mas o ataque pode acontecer.
             System.out.println("Apenas Arqueiras recebem o bônus de Olhos de Águia!");
        }

        float sorteAtual = usuario.getSorte(); // Usa método da interface
        int danoBase = usuario.getDanoAtaque(); // Usa método da interface
        float precisaoAtual = usuario.getPrecisaoAtaque(); // Usa método da interface
        int danoFinal;

        if (sorteAtual >= 0.75f) {
            // Dano Crítico Massivo
            System.out.printf("%s acertou %s em seu ponto crítico e causou dano avassalador!\n", usuario.getNome(), alvo.getNome());
            danoFinal = danoBase * 3;
            alvo.receberDano(danoFinal);
        } else {
            // Ataque Normal (com chance de bônus)
            System.out.println("(Olhos de Águia) " + usuario.getNome() + " dispara uma flecha precisa!");
            if ((sorteAtual + precisaoAtual) >= 0.7f) {
                 danoFinal = (int) (danoBase * 1.3f);
            } else {
                 danoFinal = danoBase;
            }
            alvo.receberDano(danoFinal);
        }
    }
}