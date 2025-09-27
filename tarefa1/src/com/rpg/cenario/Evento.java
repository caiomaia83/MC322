package com.rpg.cenario;

import com.rpg.personagens.*;

public interface Evento {
  
    boolean verificarGatilho(IFase faseAtual, Heroi heroi);

  
    void executar(IFase faseAtual, Heroi heroi);
}
