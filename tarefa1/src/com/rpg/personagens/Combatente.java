package com.rpg.personagens;

import com.rpg.combate.*;
/**
 * Define o contrato para qualquer entidade que vá participar de combate
 * 
 * @author Fernando e Caio
 * @version 1.0
 * @since 2025-05-10
 */
public interface Combatente {
    String getNome();
    boolean estaVivo();
    int getPontosDeVida(); 
    void receberDano(int dano);
    void receberCura(int cura);
    AcaoCombate escolherAcao(Combatente alvo);
}