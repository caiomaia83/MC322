package com.rpg.cenario;

import java.util.List;
import com.rpg.game.*;
/**
 * Define o contrato para uma classe que gera uma sequência de fases para o jogo.
 *
 * @author Fernando e Caio
 * @version 1.0
 * @since 2025-10-05
 */
public interface GeradorDeFases {
    /**
     * Gera uma lista de fases para uma nova partida do jogo
     * 
     * @param quantidadeDeFases O numero de fases no jogo
     * @param dificuldade A dificuldade do jogo, que influenciará a geração das fases
     * @return uma {@link List} de {@link interface Fase} prontas para serem jogadas em seguida 
     */
    List<InterfaceFase> gerar(int quantidadeDeFases, Dificuldade dificuldade);
}