package com.rpg.combate;


import com.rpg.personagens.*;
import com.rpg.personagens.Heroi;

public class InvestidaReal implements AcaoCombate {

    @Override
    public void executar(Combatente usuario, Combatente alvo) {
        System.out.println("--> HABILIDADE ESPECIAL! <--");
        
        // A lógica de sorte que estava em 'usarHabilidadeEspecial' vem para cá
        // Precisamos garantir que o 'usuario' é um Herói para usar o getSorte()
        if (usuario instanceof Heroi) {
            Heroi heroiUsuario = (Heroi) usuario;

            if (heroiUsuario.getSorte() >= 0.15) {
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
