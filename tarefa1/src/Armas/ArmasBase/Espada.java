package Armas.ArmasBase;

import Armas.Arma;

// A espada é uma das armas mais básicas, e não possui um atributo próprio  universal
public class Espada extends Arma {
    
    public Espada( String nome, int minNivel, int dano, int velocidadeDeAtaque) { 
        super(nome, minNivel, dano, velocidadeDeAtaque);
        this.setAlcance(0.05f); // Alcance 0.05 por padrão (maior que adaga e corpo a corpo)
    }
}


