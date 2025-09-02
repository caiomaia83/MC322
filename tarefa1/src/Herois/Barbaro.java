package Herois;

import Personagens.Heroi;
import Personagens.Personagem;

/* O barbaro é o personagem inicial de combate corpo a corpo */
public class Barbaro extends Heroi {
    Boolean furia; // Atributo especial do bárbaro, que aumenta sua forca consideravelmente
    
    public Barbaro(String nome, int pontosDeVida, int forca, int nivel, int experiencia) {
        super(nome, pontosDeVida, forca, nivel, experiencia);
        this.furia = false; // A furia comeca desativada 
    }

    public void atacar(Personagem alvo) {
        System.out.println(this.getNome() + "ataca com: Ataque Desvairado!");
        
        int dano; 
        
        if(this.furia) { // Caso esteja furioso, o barbaro causa mais dano 
            dano = this.getForca() + 35;
            alvo.receberDano(dano);
        } else {
            dano = this.getForca();
            alvo.receberDano(getForca());
        }

        System.out.printf(alvo.getNome() + "Recebeu %d de Dano! \n", this.getForca());
    }

    public void usarHabilidadeEspecial(Personagem alvo) { // Aumenta a forca de ataque do Bárbaro
        System.out.println(this.getNome() + "tomou um gole de elixir e ficou furioso!");
        System.out.println("Os pontos de força de  "+this.getNome()+"aumentaram consideravelmente!");
        this.furia = true;
        atacar(alvo);
    }
}
