package Herois;

import Armas.Herois.Bárbaros.CuteloDeCaça;
import Personagens.Heroi;
import Personagens.Personagem;

public class Barbaro extends Heroi {
    Boolean furia;
    Boolean berserker; // Como que uma "super fúria"
    
    public Barbaro(String nome, int pontosDeVida, int forca, int nivel, int experiencia) {
        super(nome, pontosDeVida, forca,  new CuteloDeCaça()); // Cutelo de Caça é a espada inicial padrão dos bárbaros
        this.furia = false;
        this.berserker = false;
    }

    public void atacar(Personagem alvo) {
        
        int dano; 
        
        if(this.furia) {
            System.out.println(this.getNome() + " ataca com FÚRIA!");
            dano = (int)(this.getDano()*1.5f) ;
            alvo.receberDano(dano);
            this.furia = false;
        } else if (this.berserker) {
            System.out.println(this.getNome() + " ataca em estado BERSERKER!");
            dano = this.getDano()*3 ;
            alvo.receberDano(dano);
            this.furia = false;
        } else {
            System.out.println(this.getNome() + " ataca com: Ataque Desvairado!");
            dano = this.getDano();
            alvo.receberDano(getDano());
        }

        System.out.printf(alvo.getNome() + " recebeu %d de Dano! \n", dano);
    }

    public void usarHabilidadeEspecial(Personagem alvo) { // Aumenta a forca de ataque do Bárbaro
        System.out.println(this.getNome() + " tomou um gole de elixir...");
        // Em caso de sorte, a fúria da um aumento mais significativo ao bárbaro e o torna um berserker
        if(this.getSorte() >= 0.88f ) {
            System.out.printf("O elixir desperta uma fúria primal em %s!!!\n", this.getNome());
            System.out.println("----STATUS ATIVADO: Berserker----");
            System.out.println(this.getNome() + "está imparável!");
            this.berserker = true;
        } else { // Caso padrão 
            System.out.println("Os pontos de força de  "+this.getNome()+" aumentaram consideravelmente!");
            this.furia = true;
        }
        
        atacar(alvo);
    }

    protected void aumentaAtributos() {
        this.setPontosDeVidaTotal(this.getPontosDeVidaTotal() + 20);
        this.setForca(this.getForca() + 15);
    }

    
}
