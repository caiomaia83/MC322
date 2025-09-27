package com.rpg.combate;

import Personagens.Combatente;
import Personagens.Herois.Arqueira;

public class OlhosDeAguia implements AcaoCombate {

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