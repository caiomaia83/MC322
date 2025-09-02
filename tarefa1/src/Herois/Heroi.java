public abstract class Heroi extends Personagem {
    private int nivel;
    private int experiencia;

    public Heroi(String nome, int pontosDeVidaTotal, int forca, int nivel, int experiencia) {
        super(nome, pontosDeVidaTotal, forca);
        this.nivel = nivel;
        this.experiencia = experiencia;
    }

    public void ganharExperiencia(int xp) {
        this.experiencia += xp;
    }

    @Override
    public void exibirStatus() {
        super.exibirStatus();
        System.out.printf("Nivel: %d\n", this.nivel);
        System.out.printf("Xp: %d\n", this.experiencia);
    }

    public abstract void usarHabilidadeEspecial(Personagem alvo);

}
