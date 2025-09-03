package Armas.ArmasBase;

import Armas.Arma;

public class Arco extends Arma{
    public Arco(String nome, int minNivel, int dano, int velocidadeDeAtaque) {
        super(nome, minNivel, dano, velocidadeDeAtaque);
        this.setAlcance(0.25f);
    }
}
