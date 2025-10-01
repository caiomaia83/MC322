package com.rpg.cenario;

import com.rpg.personagens.*;

public interface InterfaceFase {
  
    void iniciar(Heroi heroi);

    boolean isConcluida();
    
    TipoCenario getTipoDeCenario();
}