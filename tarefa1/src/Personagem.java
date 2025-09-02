public abstract class Personagem {
    String nome;
    int pontosDeVida;
    int pontosDeVidaTotal;
    int forca;

    public Personagem(String nome, int pontosDeVidaTotal, int forca) {
        this.forca = forca;
        this.nome = nome;
        this.pontosDeVida =  pontosDeVidaTotal;
        this.pontosDeVidaTotal = pontosDeVidaTotal;
    }

    public void receberDano(int dano) {
        this.pontosDeVida -= dano;
    }

    public void exibirStatus() {
        System.out.printf(" -- Status de %d --\n", this.nome);
        System.out.printf("HP: %d / %d\n", this.pontosDeVida, this.pontosDeVidaTotal);
        System.out.printf("Forca: %d\n", this.forca);
    }

    public abstract void atacar(Personagem alvo);
}