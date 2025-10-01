package com.rpg.combate;

import com.rpg.personagens.*;

public class AtaqueFisico implements AcaoCombate{
    
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