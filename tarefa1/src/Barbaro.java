public class Barbaro extends Heroi {

    public Barbaro(String nome, int pontosDeVida, int pontosDeVidaTotal, int forca, int nivel, int experiencia) {
        super(nome, pontosDeVida, forca, nivel, experiencia);
    }

    public void atacar(Personagem alvo) {
        System.out.println(this.nome + "ataca com: Ataque Desvairado!");
        System.out.printf(alvo.nome + "Recebeu %d de Dano! \n", this.forca);
    
        alvo.receberDano(this.forca);
    }

    public void usarHabilidadeEspecial(Personagem alvo) { // Aumenta a forca de ataque do Bárbaro
        System.out.println(this.nome + "tomou um gole de elixir!");
        System.out.println("Os pontos de força de  "+this.nome+"aumentaram consideravelmente!");
        this.forca += 30;
        atacar(alvo);
    }
}
