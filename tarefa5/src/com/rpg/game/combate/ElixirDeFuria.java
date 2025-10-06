package com.rpg.game.combate;
import com.rpg.game.personagens.*;

/**
 * Representa a habilidade especial dos bárbaros "Elixir de Fúria".
 * <p>
 * Esta ação de combate simula um herói consumindo um elixir para desferir
 * um ataque devastador. O poder do ataque é determinado pela sorte do herói,
 * resultando em um golpe fortalecido (Fúria) ou um golpe massivo (Berserker).
 * </p>
 *
 * @author Fernando e Caio
 * @version 1.0
 * @since 2025-10-05
 */
public class ElixirDeFuria implements AcaoCombate {
    /**
     * {@inheritDoc}
     * <p>
     * Executa a habilidade Elixir de Fúria. O resultado depende do valor retornado
     * pelo método {@code getSorte()} do {@link Heroi}:
     * 
     * -Estado Berserker (Sorte >= 0.88): O herói desfere um ataque com o triplo (3x) do seu dano normal.
     * Isso representa uma chance de 12%.
     * -Estado de Fúria (Sorte < 0.88): O herói ataca com 1.5x o seu dano normal.
     * 
     * O dano final é aplicado ao {@code alvo}.
     * </p>
     */
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