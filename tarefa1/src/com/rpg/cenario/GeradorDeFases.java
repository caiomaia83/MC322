package com.rpg.cenario;

import java.util.List;
import com.rpg.game.*;

public interface GeradorDeFases {
    
    List<IFase> gerar(int quantidadeDeFases, Dificuldade dificuldade);
}