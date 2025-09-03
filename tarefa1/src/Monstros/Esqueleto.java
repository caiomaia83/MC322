package Monstros;

import Armas.Monstros.Esqueletos.Comum.LaminaCerimonial;
import Personagens.Monstro;
import Personagens.Personagem;

public class Esqueleto extends Monstro {
    
    public Esqueleto(String nome, int pontosDeVida, int forca, int xpconcedido) {
        super(nome,pontosDeVida, forca, xpconcedido, new LaminaCerimonial());
    }

    public void atacar(Personagem alvo) {
        System.out.println("Esqueleto atacou com: Bate-Crânio!");
        System.out.println(alvo.getNome() +"Perdeu"+ this.getForca()+ "Pontos de vida!");
        alvo.receberDano(this.getForca());
    }

}
