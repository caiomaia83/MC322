package Armas.ArmasBase;

import Armas.Arma;

public class Adaga extends Arma {

    boolean AtaqueFurtivo; // Atributo único das adagas que permite um aumento no dano se o golpe for furtivo

    public Adaga( String nome, int minNivel, int dano, int velocidadeDeAtaque) { 
        super(nome, minNivel, dano, velocidadeDeAtaque);
        this.setAlcance(0f); // Alcance 0 por padrão
        this.AtaqueFurtivo = true;
    }
}
