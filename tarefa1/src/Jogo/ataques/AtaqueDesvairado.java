package Jogo.ataques; // Use o nome do seu pacote

import Personagens.Combatente;
import Personagens.Personagem;
import Jogo.ataques.*;

public class AtaqueDesvairado implements AcaoCombate {

    @Override
    public void executar(Combatente usuario, Combatente alvo) {
        System.out.println(usuario.getNome() + " ataca com: Ataque Desvairado!");
        
        int dano = 0;
        if (usuario instanceof Personagem) {
            dano = ((Personagem) usuario).getDano();
        }

        alvo.receberDano(dano);
    }
}
