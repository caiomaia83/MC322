package com.rpg.game.combate; // Pacote correto

import java.util.Random;
import com.rpg.game.personagens.*; // Apenas a interface é necessária
// O import de 'Corredor' não é mais necessário aqui!

/**
 * Representa a ação de combate "Ataque do Corredor", com chance de golpe duplo.
 * <p>
 * Esta ação aplica um golpe inicial e, em seguida, usa o método
 * {@code getChanceAtaqueExtra()} da interface {@link Combatente} para
 * determinar a probabilidade de um segundo golpe.
 * </p>
 *
 * @author Fernando e Caio
 * @version 1.1 // Atualizei a versão
 * @since 2025-10-05
 */
public class AtaqueDoCorredor implements AcaoCombate {
    /**
     * {@inheritDoc}
     * <p>
     * Executa o ataque especial do Corredor. O método aplica um primeiro golpe
     * com o dano {@code usuario.getDanoAtaque()}. Em seguida, realiza um teste de chance: se um
     * número aleatório de 0 a 99 for menor que o valor retornado por {@code usuario.getChanceAtaqueExtra()},
     * um segundo golpe de mesmo dano é aplicado.
     * </p>
     */
    @Override
    public void executar(Combatente usuario, Combatente alvo) {
        System.out.println(usuario.getNome() + " avança rapidamente e golpeia com força!");

        // MUDANÇA 1: Usamos o método da interface para o dano
        int danoDoGolpe = usuario.getDanoAtaque();
        alvo.receberDano(danoDoGolpe);

        // MUDANÇA 2: Usamos o método da interface para a chance
        int chanceExtra = usuario.getChanceAtaqueExtra();

        // Verifica a chance de atacar uma segunda vez
        Random random = new Random();
        if (random.nextInt(100) < chanceExtra) {
            System.out.println("A agilidade de " + usuario.getNome() + " permite um segundo ataque!");
            alvo.receberDano(danoDoGolpe); // Aplica o mesmo dano novamente
        }
    }
}