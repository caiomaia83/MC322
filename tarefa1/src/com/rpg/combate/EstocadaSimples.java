package com.rpg.combate;


import com.rpg.personagens.*;

public class EstocadaSimples implements AcaoCombate {

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

