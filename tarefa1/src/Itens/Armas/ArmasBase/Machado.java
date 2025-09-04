package Itens.Armas.ArmasBase;

import Itens.Armas.Arma;
import Jogo.Classificadores.OrigemDoItem;
import Jogo.Classificadores.Raridade;

public class Machado extends Arma{
    boolean QuebraEscudo; // Atributo único de machado que aumenta dano contra oponentes em postura defensiva
    public Machado(String nome, Raridade raridade, OrigemDoItem origem, int minNivel, int dano, float velocidadeDeAtaque) {
        super(nome, raridade, origem, minNivel, dano, velocidadeDeAtaque);
        this.setAlcance(0.05f); // Alcance 0.05 por padrão ( um pouco maior que adaga)
        this.QuebraEscudo = true;
    }
}
