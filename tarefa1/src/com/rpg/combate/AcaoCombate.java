package com.rpg.combate;


import com.rpg.personagens.*;
/**
 * Define o contrato para qualquer ação que possa ser executada durante o combate.
 * <p>
 * Esta interface é a base para a implementação de ataques, habilidades, magias ou
 * qualquer outra ação que um {@link Combatente} possa realizar em seu turno.
 * Ela padroniza como as ações são executadas, recebendo quem a utiliza e quem é o alvo.
 * </p>
 *
 * @author Fernando e Caio
 * @version 1.0
 * @since 2025-10-05
 */
public interface AcaoCombate {
    /**
     * Executa a lógica da ação de combate.
     * <p>
     * Este método aplica o efeito da ação (como causar dano, curar ou aplicar
     * um status) do usuário para o alvo.
     * </p>
     *
     * @param usuario O {@link Combatente} que está realizando a ação.
     * @param alvo O {@link Combatente} que está recebendo o efeito da ação.
     */
    void executar(Combatente usuario, Combatente alvo);
    
}
