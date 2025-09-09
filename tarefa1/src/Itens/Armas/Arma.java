package Itens.Armas;
import Itens.Item;
import Jogo.Classificadores.OrigemDoItem;
import Jogo.Classificadores.Raridade;
import Jogo.Classificadores.TipoDeItem;

public abstract class Arma extends Item {
    // Atributos essenciais
    private int minNivel;
    
    // Atributos de combate
    private float alcance;
    private float velocidadeDeAtaque;
    // TO DO : implementar mecanica de golpe critico para arma e tipo de dano 
    /*private float chanceDeCritico;
    private float multiplicadorDeCritico;
    private TipoDeDano tipoDeDano; */
    private int dano;



    public Arma(String nome, Raridade raridade, OrigemDoItem origem, int minNivel, int dano, float velocidadeDeAtaque) {
        super(nome, raridade, origem, TipoDeItem.ARMA);
        this.dano = dano;
        this.minNivel = minNivel;
        this.velocidadeDeAtaque = velocidadeDeAtaque;
        this.alcance = 0f; // Alcance por padrão é zero (corpo a corpo)
        
    }

    public int getDano() {
        return this.dano;
    }

    public int getMinNivel() {
        return this.minNivel;
    }

    public float getAlcance() {
        return this.alcance;
    }

    public float getvelocidadeDeAtaque() {
        return this.velocidadeDeAtaque;
    }


    protected void setAlcance(float alcance) {
        this.alcance = alcance;
    }
}
