package Armas;

public abstract class Arma {
    // Atributos essenciais
    private String nome;
    private String descricao;
    private int minNivel;
    
    // Atributos de combate
    private int alcance;
    private float velocidadeDeAtaque;
    private float chanceDeCritico;
    private float multiplicadorDeCritico;
    private TipoDeDano tipoDeDano;
    private int dano;


    public Arma(String nome, int minNivel, int dano, float velocidadeDeAtaque) {
        this.nome = nome;
        this.dano = dano;
        this.minNivel = minNivel;
        this.velocidadeDeAtaque = velocidadeDeAtaque;
        
        // Valores padroes
        this.descricao = "Uma arma básica para ser usada em combate corpo a corpo.";
        this.chanceDeCritico = 0.05f;
        this.multiplicadorDeCritico = 1.2f;
    }

    public int getDano() {
        return this.dano;
    }

    public int getMinNivel() {
        return this.minNivel;
    }

    public String getNome() {
        return this.nome;
    }

    public String getDescricao() {
        return this.descricao;
    }

    public int getAlcance() {
        return this.alcance;
    }

    public float getvelocidadeDeAtaque() {
        return this.velocidadeDeAtaque;
    }


    protected void setAlcance(int alcance) {
        this.alcance = alcance;
    }

    protected void setNome(String nome) {
        this.nome = nome;
    }

    // Parametro abstrato que modifica como os parametros da arma aumentam ao mudar de nivel
    protected abstract void aumentaAtributos();
}
