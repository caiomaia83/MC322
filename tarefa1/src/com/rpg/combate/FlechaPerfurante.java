package com.rpg.combate;


import com.rpg.personagens.*;
import com.rpg.personagens.Herois.*;

/**
 * Representa a ação de combate "Flecha Perfurante", o ataque básico da Arqueira.
 * <p>
 * Esta ação tem a chance de causar dano aumentado. A probabilidade de um golpe
 * preciso é calculada somando a sorte e a precisão da {@link Arqueira}.
 * </p>
 *
 * @author Fernando e Caio
 * @version 1.0
 * @since 2025-10-05
 */
public class FlechaPerfurante implements AcaoCombate {
    /**
     * {@inheritDoc}
     * <p>
     * Executa o disparo de uma flecha. Se a soma da {@code sorte} e {@code precisao}
     * da Arqueira for 0.7 ou maior, o ataque causa 130% (1.3x) do dano normal.
     * Caso contrário, causa dano padrão.
     * </p>
     */
    @Override
    public void executar(Combatente usuario, Combatente alvo) {
        System.out.println(usuario.getNome() + " atacou com: Flecha Perfurante!");

        int dano;
        // Precisamos que o usuario seja uma Arqueira para usar a 'precisao'
        if (usuario instanceof Arqueira) {
            Arqueira arqueira = (Arqueira) usuario;

            if ((arqueira.getSorte() + arqueira.precisao) >= 0.7f) {
                dano = (int) (arqueira.getDano() * 1.3f);
                System.out.println(arqueira.getNome() + " acertou um golpe preciso e causou mais dano!");
            } else {
                dano = arqueira.getDano(); // Usamos getDano() para incluir a arma
            }
            alvo.receberDano(dano);
        }
    }
}