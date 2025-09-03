package Armas.ArmasBase;

import Armas.Arma;

public class Martelo extends Arma{

    boolean Impacto; // Atributo único do martelo que permite um impacto maior (atordoar)
    public Martelo(String nome, int minNivel, int dano, int velocidadeDeAtaque) {
        super(nome, minNivel, dano, velocidadeDeAtaque);
        this.setAlcance(0.05f);
        this.Impacto = true;
    }
}
