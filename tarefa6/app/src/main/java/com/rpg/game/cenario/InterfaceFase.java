package com.rpg.game.cenario;

import com.rpg.game.personagens.*;
/**
 * Define o contrato essencial para qualquer fase ou nível do jogo.
 * <p>
 * Qualquer classe que represente um estágio jogável, com inícios,
 * condições de conclusão e um ambiente, deve implementar esta interface.
 * </p>
 *
 * @author Fernando e Caio
 * @version 1.0
 * @since 2025-10-05
 */
public interface InterfaceFase {
    /**
     * Inicia a fase, preparando o ambiente e os inimigos para o herói.
     *
     * @param heroi O {@link Heroi} que está entrando na fase.
     */
    void iniciar(Heroi heroi);
    /**
     * Verifica se a fase foi concluída.
     *
     * @return {@code true} se os objetivos da fase (ex: derrotar todos os monstros)
     * foram alcançados, {@code false} caso contrário.
     */
    boolean isConcluida();
    /**
     * Retorna o tipo de cenário em que a fase ocorre
     * 
     * @return o {@link TipoCenario} associado a esta fase.
     */
    TipoCenario getTipoDeCenario();
}