package com.rpg.cenario;

import com.rpg.personagens.*;

public interface Evento {
  
    boolean verificarGatilho(InterfaceFase faseAtual, Heroi heroi);

  
    void executar(InterfaceFase faseAtual, Heroi heroi);
}
