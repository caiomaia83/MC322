package com.rpg.game.itens;
/**
 * Define o contrato fundamental para todos os itens do jogo.
 * <p>
 * Qualquer objeto que possa ser considerado um item, seja ele uma arma,
 * armadura ou consumível, deve implementar esta interface.
 * </p>
 *
 * @author Fernando e Caio
 * @version 1.0
 * @since 2025-10-05
 */
public interface InterfaceItem {
    String getNome();
}