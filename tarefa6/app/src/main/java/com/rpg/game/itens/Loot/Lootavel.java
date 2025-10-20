package com.rpg.game.itens.Loot;


import com.rpg.game.itens.*;
import com.rpg.game.itens.Armas.Arma;

public interface Lootavel {

    InterfaceItem droparLoot();
    Arma largaArma(float sorteDoJogador);
}