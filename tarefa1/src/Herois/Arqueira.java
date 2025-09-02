package Herois;

import java.util.Random;

import Personagens.Heroi;
import Personagens.Personagem;

/* A arqueira é o personagem inicial de longo alcance */
public  class Arqueira extends Heroi {
    int precisao; // A precisão pode aumentar o dano dos ataques
    int alcance; // Permite que a arqueira fique fora do alcance dos inimigos

    public Arqueira(String nome, int pontosDeVida, int forca, int nivel, int experiencia, int precisao, int alcance) {
        super(nome,pontosDeVida, forca, nivel, experiencia);
        this.precisao = 50;
        this.alcance = 10;
    }



    public void atacar(Personagem alvo) {
        System.out.println(this.getNome() +" atacou com: Flecha Perfurante!");

        int dano; 
        
        Random random = new Random();
        
        // A arqueira tem uma chance aleatória de acertar um golpe crítico, proporcional a precisao
        if((random.nextInt(100) + this.precisao) >= 100) { 
            dano = this.getForca() + 50;
            alvo.receberDano(dano);
            System.out.println(this.getNome() + " acertou um golpe preciso e causou dano crítico!");
        } else {
            dano = this.getForca();
            alvo.receberDano(dano);
        }
    }

    // A habilidade especial da arqueira aumenta sua precisao e alcance 
    public void usarHabilidadeEspecial(Personagem alvo) {
        System.out.println(this.getNome()+ "usou a habilidade: Olhos de àguia!");
        System.out.println("A precisao de "+this.getNome()+"aumentou consideravelmente.");
        this.alcance += 10;
        this.precisao += 30;
        atacar(alvo);
    }

    @Override
    public void receberDano(int dano) {
        Random random = new Random();
        if((random.nextInt(50) + this.alcance) >= 50) { // QUanto maior o alcance, maior a chance da arqueira evadir um ataque
            System.out.println(this.getNome() + "conseguiu manter a distância e evadiu o ataque!");
        } else {
            super.receberDano(dano);
        }
    }
}
