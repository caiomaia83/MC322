package com.rpg.combate;


import java.util.Random;
import Personagens.Combatente;
import Personagens.Personagem;

// O nome da classe agora é Arranhao
public class Arranhao implements AcaoCombate {

    @Override
    public void executar(Combatente usuario, Combatente alvo) {
        System.out.println(usuario.getNome() + ", um servo raivoso, ataca com suas garras!");
        
        if (usuario instanceof Personagem) {
            Personagem servo = (Personagem) usuario;

            // O dano sempre é aplicado
            alvo.receberDano(servo.getDano());

            // Verifica a chance de aplicar o efeito "arranhao" (cegueira)
            Random random = new Random();
            if (random.nextInt(100) > 59) {
                System.out.println(">> As garras do servo acertaram o seu olho, você fica cego por um instante! <<");
            }
        }
    }
}
