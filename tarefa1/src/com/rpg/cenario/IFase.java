package com.rpg.cenario;

import com.rpg.personagens.*;

public interface IFase {
  
    void iniciar(Heroi heroi);

  
    boolean isConcluida();

   
    TipoCenario getTipoDeCenario();
}