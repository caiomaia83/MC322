package com.rpg.game;

public enum Dificuldade {
    FACIL(0.8),
    MEDIO(1.0),
    DIFICIL(1.3);


private final double multiplicador;

    Dificuldade(double multiplicador) {
        this.multiplicador = multiplicador;
    }

    public double getMultiplicador() {
        return multiplicador;
    }
}


