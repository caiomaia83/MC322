package Personagens;
import Armas.Arma;

public abstract class Heroi extends Personagem {
    private int nivel;
    private int experiencia;
    private int expProximoNivel;
    private float sorte;

    public Heroi(String nome, int pontosDeVidaTotal, int forca, Arma arma, int nivel, int experiencia) {
        super(nome, pontosDeVidaTotal, forca, arma);
        this.nivel = nivel;
        this.experiencia = experiencia;
        this.expProximoNivel = 100;
        this.sorte = 0f;
    }

    public void ganharExperiencia(Monstro alvo) {
        this.experiencia += alvo.xpConcedido;
        this.subirDeNivel();
    }

    @Override
    public void exibirStatus() {
        super.exibirStatus();
        System.out.printf("Nivel: %d\n", this.nivel);
        System.out.printf("Xp: %d / %d\n", this.experiencia, this.expProximoNivel);
    }

    private void subirDeNivel() {
        while (this.experiencia >= this.expProximoNivel) {
            // Guarda o xp que sobrou apos subir de nivel
            this.experiencia -= this.expProximoNivel;

            // Sobe de nivel
            this.nivel += 1;
            // Imprime uma mensagem ao jogador 
            System.out.println("------------------------------------");
            System.out.println(this.getNome() + " subiu para o nível" + this.nivel + "!");
            System.out.println("------------------------------------");
            System.out.println("Os atributos de " + this.getNome() + " aumentaram consideravelmente!");
            
            // Aumenta os atributos e calcula o xp para o proximo nivel 
            this.aumentaAtributos();
            this.expProximoNivel = (int) (100* Math.pow(1.15, this.nivel));
        }
    }


    // Equipa uma nova arma
    protected void equiparArma(Arma novaArma) {
        // Verifica se o heroi possui nivel suficiente para a arma
        if(this.nivel >= novaArma.getMinNivel()) {
            System.out.println("Você equipou: " +  novaArma.getNome() + "!");
            this.arma = novaArma;
            System.out.println("Descricao:" + this.getDescricaoArma());
        } else {
            System.out.println("Você não tem nível suficiente para equipar essa arma...")
        }
    }


    protected abstract void aumentaAtributos();

    public abstract void usarHabilidadeEspecial(Personagem alvo);

}
