package com.rpg.combate;


import java.util.Random;

import com.rpg.personagens.*;
/**
 * Representa a ação de combate "Arranhão", um ataque físico básico.
 * 
 * Esta ação, tipicamente usada por monstros como Servos, causa dano direto
 * e possui uma chance de aplicar um efeito secundário de cegueira momentânea,
 * que é representado por uma mensagem ao jogador.
 * 
 *
 * @author Fernando e Caio
 * @version 1.0
 * @since 2025-10-05
 */
public class Arranhao implements AcaoCombate {
    /**
     * {@inheritDoc}
     * 
     * Executa o ataque "Arranhão". O dano base do usuário é aplicado ao alvo.
     * Além do dano, há uma chance de 40% de infligir uma cegueira temporária no alvo.
     * 
     */
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
