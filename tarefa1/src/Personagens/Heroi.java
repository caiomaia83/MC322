package Personagens;
import java.util.Random;

import Itens.Armas.Arma;

public abstract class Heroi extends Personagem {
    private int nivel;
    private int experiencia;
    private int expProximoNivel;
    private float sorte;

    public Heroi(String nome, int pontosDeVidaTotal, int forca, Arma arma) {
        super(nome, pontosDeVidaTotal, forca, arma);
        this.nivel = 0;
        this.experiencia = 0;
        this.expProximoNivel = 100;
        this.sorte = 0.0f;
    }

    public void ganharExperiencia(Monstro alvo) {
        this.experiencia += alvo.getXpConcedido();
        System.out.printf("%s ganhou %d de Experiência!\n", this.getNome(), alvo.getXpConcedido());
        this.subirDeNivel();
    }

    @Override
    public void exibirStatus() {
        super.exibirStatus();
        // Barra de Xp
        double porcentagemXp = (double) this.experiencia / this.expProximoNivel;
        int tamanhoBarra = 20; // Tamanho da barra em caracteres 
        int blocosPreenchidos = (int) (tamanhoBarra * porcentagemXp);
        
        // Constrói a barra
        StringBuilder barraXp = new StringBuilder("[");
        barraXp.append("#".repeat(blocosPreenchidos)); 
        barraXp.append("-".repeat(tamanhoBarra - blocosPreenchidos)); 
        barraXp.append("]");
        // ----------------------------

        System.out.printf("Nível:       %d\n", this.nivel);
        System.out.printf("XP:          %s %d / %d \n", 
                        barraXp.toString(), 
                        this.experiencia, 
                        this.expProximoNivel,
                        porcentagemXp * 100);
        System.out.printf("\n");
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
    public void equiparArma(Arma novaArma) {
        // Verifica se o heroi possui nivel suficiente para a arma
        if(this.nivel >= novaArma.getMinNivel()) {
            System.out.println("Você equipou: " +  novaArma.getNome() + "!");
            this.arma = novaArma;
        } else {
            System.out.println("Você não tem nível suficiente para equipar essa arma...");
        }
    }

    // O getter da sorte é único na medida que ele muda toda vez que é chamado
    public float getSorte() {
        Random random = new Random();
        this.sorte = random.nextFloat(1.0f);
        return this.sorte;
    }

    public void inspecionarArma(Arma arma) {
        arma.exibirStatus();
        if(arma.getMinNivel() >= this.getMinNivelArma()) {
            this.equiparArma(arma);
        }
    }

    // optei por fazer o aumento de nível individual á cada tipo de herói
    protected abstract void aumentaAtributos();

    public abstract void usarHabilidadeEspecial(Personagem alvo);

}
