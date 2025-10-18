package com.rpg.game.combate;
import com.rpg.game.personagens.*; 


import com.rpg.exceptions.*;
import com.rpg.personagens.herois.*;

/**
 * Representa a habilidade especial dos bárbaros "Elixir de Fúria".
 * <p>
 * Esta ação consome um recurso (carga de elixir) e desfere um ataque
 * cujo poder depende do valor retornado por {@code getSorte()} do usuário.
 * </p>
 *
 * @author Fernando e Caio
 * @version 1.1 // Atualizada a versão
 * @since 2025-10-05
 */
public class ElixirDeFuria implements AcaoCombate {
    /**
     * {@inheritDoc}
     * <p>
     * Verifica se o usuário (que deve ser um {@link Barbaro}) possui cargas do elixir.
     * Se sim, consome uma carga e executa o ataque. O dano é multiplicado
     * com base no valor retornado por {@code usuario.getSorte()}:
     * <ul>
     * <li>Sorte >= 0.88 (Berserker): 3x o {@code usuario.getDanoAtaque()}</li>
     * <li>Sorte < 0.88 (Fúria): 1.5x o {@code usuario.getDanoAtaque()}</li>
     * </ul>
     * Se não houver cargas, lança {@link RecursoInsuficienteException}.
     * </p>
     * @throws RecursoInsuficienteException Se o Bárbaro não tiver cargas do elixir.
     */
    @Override
    public void executar(Combatente usuario, Combatente alvo) throws RecursoInsuficienteException {
        
        // --- Verificação de Recurso (Ainda precisa do casting para Barbaro aqui) ---
        // A lógica de RECURSO é específica do Bárbaro, então o casting aqui é justificável
        // ou precisaríamos de uma interface/método mais complexo para recursos genéricos.
        if (usuario instanceof Barbaro) {
             Barbaro barbaro = (Barbaro) usuario;
             if (barbaro.getCargasElixir() <= 0) {
                 throw new RecursoInsuficienteException(barbaro.getNome() + " tentou usar o elixir, mas não há mais cargas!");
             }
             barbaro.usarCargaElixir(); // Consome a carga
             System.out.println(barbaro.getNome() + " usou uma carga de Elixir! Restam: " + barbaro.getCargasElixir());
        } else {
            // Se não for um Bárbaro, não pode usar (ou não tem recurso)
             System.out.println("Apenas Bárbaros podem usar o Elixir!");
             return; // Sai do método
        }
        // ------------------------------------------------------------------------


        System.out.println("--> HABILIDADE ESPECIAL! <--");
        System.out.println(usuario.getNome() + " tomou um gole de elixir...");

        int danoBase = usuario.getDanoAtaque(); // MUDANÇA 1: Usa o método da interface
        float sorteAtual = usuario.getSorte(); // MUDANÇA 2: Usa o método da interface
        int danoFinal;

        if (sorteAtual >= 0.88f) {
            System.out.printf("O elixir desperta uma fúria primal em %s!!!\n", usuario.getNome());
            System.out.println(usuario.getNome() + " está imparável e ataca em estado BERSERKER!");
            danoFinal = danoBase * 3;
            alvo.receberDano(danoFinal);
        } else {
            System.out.println("Os pontos de força de " + usuario.getNome() + " aumentaram consideravelmente!");
            System.out.println(usuario.getNome() + " ataca com FÚRIA!");
            danoFinal = (int) (danoBase * 1.5f);
            alvo.receberDano(danoFinal);
        }
    }
}