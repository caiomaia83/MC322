package Armas;


public class Escudo {
    
    private String nome;
    private float chanceDeBloqueio; // Chance de bloquear totalmente o ataque 
    private int DurabilidadeAtual;
    private int DurabilidadeTotal;
    private int ReducaoDeDano; // O escudo sempre reduz em algum nível o dano 

    public Escudo(float chanceDeBloqueio, int DurabilidadeTotal) {
        this.chanceDeBloqueio = chanceDeBloqueio;
        this.DurabilidadeAtual = DurabilidadeTotal;
        this.DurabilidadeTotal = DurabilidadeTotal;
    }

    public boolean estaQuebrado() {
        return this.DurabilidadeAtual <= 0;
    }

    public String getNome() {
        return this.nome;
    } 

    public int getDurabilidadeAtual() {
        return this.DurabilidadeAtual;
    }

    public int getDurabilidadeTotal() {
        return this.DurabilidadeTotal;
    }

    public float getChanceDeBloqueio() {
        return this.chanceDeBloqueio;
    }

    public int getReducaoDeDano() {
        return this.ReducaoDeDano;
    }

    // Função para quando o escudo absorve dano 
    public void consumirDurabilidade(int quantidade) {
        this.DurabilidadeAtual -= quantidade;

        if(this.DurabilidadeAtual <= 0) {
            System.out.println("O escudo" + this.nome + "quebrou!");
        }
    }

    public float calculaSorteEscudo(float FATOR_SORTE, float sorte, float CHANCE_LIMITE) {
        float bonusDeSorte = sorte*FATOR_SORTE;
        float chanceDeBloqueioFinal = this.getChanceDeBloqueio() + bonusDeSorte;

        chanceDeBloqueioFinal = Math.min(chanceDeBloqueioFinal, CHANCE_LIMITE); // A chance nunca ultrapassa 85%

        // Imprime uma mensagem 
        System.out.printf("Chance de bloqueio: %d % ...", chanceDeBloqueioFinal*100);
        return chanceDeBloqueioFinal;
    }

}
