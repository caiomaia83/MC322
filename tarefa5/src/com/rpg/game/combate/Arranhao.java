package com.rpg.game.combate; 

import java.util.Random;
import com.rpg.game.personagens.Combatente; // Import da interface
// O import de 'Personagem' não é mais necessário aqui!

/**
 * Representa a ação de combate "Arranhão", um ataque físico básico com chance de efeito.
 * * Esta ação, tipicamente usada por monstros como Servos, causa dano direto
 * baseado no {@code getDanoAtaque()} do usuário e possui uma chance de aplicar
 * um efeito secundário de cegueira momentânea.
 * * @author Fernando e Caio
 * @version 1.1 // Atualizei a versão
 * @since 2025-10-05
 */
public class Arranhao implements AcaoCombate {
    /**
     * {@inheritDoc}
     * * Executa o ataque "Arranhão". O dano base, obtido via {@code usuario.getDanoAtaque()},
     * é aplicado ao alvo. Além do dano, há uma chance de 40% de infligir cegueira temporária.
     * */
    @Override
    public void executar(Combatente usuario, Combatente alvo) {
        System.out.println(usuario.getNome() + ", um servo raivoso, ataca com suas garras!");
        
        // MUDANÇA PRINCIPAL: Usamos o método da interface, sem casting!
        int danoAplicado = usuario.getDanoAtaque();
        alvo.receberDano(danoAplicado);

        // A lógica da chance de cegar continua a mesma
        Random random = new Random();
        if (random.nextInt(100) > 59) { // Chance de 40% (60 a 99)
            System.out.println(">> As garras do servo acertaram o seu olho, você fica cego por um instante! <<");
            // No futuro, aqui poderia ser: alvo.aplicarStatus(Status.CEGO, 1);
        }
    }
}