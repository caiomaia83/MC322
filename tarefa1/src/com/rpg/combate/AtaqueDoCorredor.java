package com.rpg.combate;


import java.util.Random;

import com.rpg.personagens.*;
import com.rpg.personagens.Monstros.*;

/**
 * Representa a ação de combate "Ataque do Corredor", uma habilidade especial.
 * <p>
 * Esta é a ação de assinatura do monstro {@link Corredor}. Consiste em um
 * ataque físico garantido, seguido por uma chance de realizar um segundo
- * ataque imediatamente. A probabilidade do segundo ataque é baseada no atributo
 * de velocidade do Corredor.
 * </p>
 *
 * @author Fernando e Caio
 * @version 1.0
 * @since 2025-10-05
 */
public class AtaqueDoCorredor implements AcaoCombate {
    /**
     * {@inheritDoc}
     * <p>
     * Executa o ataque especial do Corredor. O método aplica um primeiro golpe
     * com o dano total do usuário. Em seguida, realiza um teste de chance: se um
     * número aleatório de 0 a 99 for menor que o atributo 'velocidade' do Corredor,
     * um segundo golpe de mesmo dano é aplicado.
     * </p>
     */
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
