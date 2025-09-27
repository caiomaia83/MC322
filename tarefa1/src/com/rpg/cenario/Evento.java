package com.rpg.cenario;

import Personagens.Herois.Heroi;

public interface Evento {
  
    boolean verificarGatilho(IFase faseAtual, Heroi heroi);

  
    void executar(IFase faseAtual, Heroi heroi);
}
