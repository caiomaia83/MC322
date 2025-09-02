public class Esqueleto extends Monstro {
    
    public Esqueleto(String nome, int pontosDeVida, int forca, int xpconcedido) {
        super(nome,pontosDeVida, forca, xpconcedido);
    }

    public void atacar(Personagem alvo) {
        System.out.println("Esqueleto atacou com: Bate-Crânio!");
        System.out.println(alvo.nome +"Perdeu"+ this.forca+ "Pontos de vida!");
        alvo.receberDano(this.forca);
    }

}
