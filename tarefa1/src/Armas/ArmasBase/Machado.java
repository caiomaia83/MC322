package Armas.ArmasBase;

import Armas.Arma;

public class Machado extends Arma{
    boolean QuebraEscudo; // Atributo único de machado que aumenta dano contra oponentes em postura defensiva
    public Machado(String nome, int minNivel, int dano, int velocidadeDeAtaque) {
        super(nome, minNivel, dano, velocidadeDeAtaque);
        this.setAlcance(0.05f); // Alcance 0.05 por padrão ( um pouco maior que adaga)
        this.QuebraEscudo = true;
    }
}
