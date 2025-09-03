package Armas.ArmasBase;

import Armas.Arma;

public class Lanca extends Arma {
    
    Boolean golpePerfurante; // Atributo único das lanças, permite um ataque crítico que ignora defesa 

    public Lanca( String nome, int minNivel, int dano, int velocidadeDeAtaque) { 
        super(nome, minNivel, dano, velocidadeDeAtaque);
        this.setAlcance(0.15f); // Lança tem um alcance um pouco maior 
        this.golpePerfurante = false;
    }
}
