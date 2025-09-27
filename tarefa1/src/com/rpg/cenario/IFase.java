package com.rpg.cenario;

import Personagens.Heroi;
import Fases.TipoCenario; // Usando o Enum que você colocou aqui

public interface IFase {
  
    void iniciar(Heroi heroi);

  
    boolean isConcluida();

   
    TipoCenario getTipoDeCenario();
}