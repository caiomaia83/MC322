package com.rpg.personagens;

import Jogo.ataques.AcaoCombate; 

public interface Combatente {
    String getNome();
    boolean estaVivo();
    int getPontosDeVida(); 
    void receberDano(int dano);
    void receberCura(int cura);
    AcaoCombate escolherAcao(Combatente alvo);
}