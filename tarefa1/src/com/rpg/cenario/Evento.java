package com.rpg.cenario;

import com.rpg.personagens.*;
/**
 * Define o contrato para um evento especial que pode ocorrer durante uma fase.
 * <p>
 * Um evento é uma ocorrência condicional que possui uma verificação (gatilho) e uma
 * ação a ser executada. Isso permite a criação de encontros surpresa, armadilhas,
 * ou a descoberta de tesouros baseados no estado do jogo.
 * </p>
 *
 * @author Fernando e Caio
 * @version 1.0
 * @since 2025-10-05
 */
public interface Evento {
    /**
     * Verifica se as condições para acionar (disparar) o evento foram atendidas.
     *
     * @param faseAtual A fase atual do jogo, para verificação de seu estado.
     * @param heroi O herói, para verificação de seu estado (ex: vida baixa, nível, etc.).
     * @return {@code true} se o evento deve ser executado, {@code false} caso contrário.
     */
    boolean verificarGatilho(InterfaceFase faseAtual, Heroi heroi);

    /**
     * Executa a lógica principal do evento.
     * <p>
     * Este método só deve ser chamado após {@link #verificarGatilho(InterfaceFase, Heroi)}
     * retornar {@code true}.
     * </p>
     * @param faseAtual A fase atual, que pode ser modificada pelo evento.
     * @param heroi O herói, que pode ser afetado pelo evento.
     */
    void executar(InterfaceFase faseAtual, Heroi heroi);
}
