package com.rpg.combate;


import java.util.Random;
import Personagens.Combatente;
import Personagens.Monstros.Corredor; // Importamos a classe Corredor
import Personagens.Personagem;

public class AtaqueDoCorredor implements AcaoCombate {

    @Override
    public void executar(Combatente usuario, Combatente alvo) {
        System.out.println(usuario.getNome() + " avança rapidamente montado em seu porco e golpeia com seu poderoso martelo!");
        
        if (usuario instanceof Corredor) {
            Corredor corredor = (Corredor) usuario;

            // O primeiro ataque sempre acontece
            alvo.receberDano(corredor.getDano());

            // Verifica a chance de atacar uma segunda vez
            Random random = new Random();
            if (random.nextInt(100) < corredor.getVelocidade()) {
                System.out.println("A velocidade de " + corredor.getNome() + " permite um segundo ataque!");
                alvo.receberDano(corredor.getDano());
            }
        }
    }
}
