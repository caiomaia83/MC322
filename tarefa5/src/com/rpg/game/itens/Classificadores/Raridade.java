package com.rpg.game.itens.Classificadores;
 // Guarda a raridade de cada item para facilitar a manutencao

public enum Raridade {
    // Cada raridade tem um peso associado para sorteio
    COMUM(100),
    INCOMUM(50),
    RARO(15),
    EPICO(4),
    LENDARIO(1);

    private final int peso;

    Raridade(int peso) {
        this.peso = peso;
    }

    // Retorna o peso de uma raridade
    public int getPeso() {
        return this.peso;
    }

    

    
}
