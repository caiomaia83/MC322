public class Barbaro extends Heroi {
    Boolean furia;
    
    public Barbaro(String nome, int pontosDeVida, int pontosDeVidaTotal, int forca, int nivel, int experiencia, Boolean furia) {
        super(nome, pontosDeVida, forca, nivel, experiencia);
    }

    public void atacar(Personagem alvo) {
        System.out.println(this.nome + "ataca com: Ataque Desvairado!");
        
        int dano; 
        
        if(this.furia) {
            dano = this.forca + 30;
            alvo.receberDano(dano);
        } else {
            dano = this.forca;
            alvo.receberDano(forca);
        }

        System.out.printf(alvo.nome + "Recebeu %d de Dano! \n", this.forca);
    }

    public void usarHabilidadeEspecial(Personagem alvo) { // Aumenta a forca de ataque do Bárbaro
        System.out.println(this.nome + "tomou um gole de elixir e se tornou furioso!");
        System.out.println("Os pontos de força de  "+this.nome+"aumentaram consideravelmente!");
        this.furia = true;
        atacar(alvo);
    }
}
