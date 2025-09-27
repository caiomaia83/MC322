package com.rpg.combate;
import com.rpg.combate.*;
import com.rpg.personagens.*;

public class ElixirDeFuria implements AcaoCombate {

    @Override
    public void executar(Combatente usuario, Combatente alvo) {
        System.out.println("--> HABILIDADE ESPECIAL! <--");
        System.out.println(usuario.getNome() + " tomou um gole de elixir...");

        if (usuario instanceof Heroi) {
            Heroi heroiUsuario = (Heroi) usuario;
            int dano;

            // Em caso de sorte, a fúria se torna um estado Berserker
            if (heroiUsuario.getSorte() >= 0.88f) {
                System.out.printf("O elixir desperta uma fúria primal em %s!!!\n", heroiUsuario.getNome());
                System.out.println(heroiUsuario.getNome() + " está imparável e ataca em estado BERSERKER!");
                dano = heroiUsuario.getDano() * 3;
                alvo.receberDano(dano);
            } else { // Caso padrão, ativa a Fúria normal
                System.out.println("Os pontos de força de " + heroiUsuario.getNome() + " aumentaram consideravelmente!");
                System.out.println(heroiUsuario.getNome() + " ataca com FÚRIA!");
                dano = (int) (heroiUsuario.getDano() * 1.5f);
                alvo.receberDano(dano);
            }
        }
    }
}