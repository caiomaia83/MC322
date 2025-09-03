package Herois;

import Personagens.Heroi;
import Personagens.Personagem;
import Armas.Arma;

public  class Arqueira extends Heroi {
    float precisao;
    float alcance;

    public Arqueira(String nome, int pontosDeVida, int forca, int precisao, Arma arma,  int alcance) {
        super(nome,pontosDeVida, forca , arma);
        this.precisao = 0.1f;
        this.alcance = 0.1f;
    }



    public void atacar(Personagem alvo) {
        System.out.println(this.getNome() +"atacou com: Flecha Perfurante!");

        int dano; 
        
        // A arqueira tem o traço passivo de conseguir acertar um tiro certeiro 
        if((this.getSorte() + this.precisao) >= 0.8) {
            dano = (int)(this.getDano()*1.3f);
            alvo.receberDano(dano);
            System.out.println(this.getNome() + "acertou um golpe preciso e causou mais dano!");
        } else {
            dano = this.getForca();
            alvo.receberDano(dano);
        }
    }

    public void usarHabilidadeEspecial(Personagem alvo) {
        // A habilidade sempre aumenta um pouco os atributos únicos da arqueira 
        System.out.println(this.getNome()+ "usou a habilidade: Olhos de àguia!");
        System.out.println("A precisao de "+this.getNome()+"aumentou!");
        this.alcance += 0.1f;
        this.precisao += 0.1f;

        if(this.getSorte() >= 0.9) { // A arqueira tem um pequena chance de acertar um ataque crítico
            System.out.println("%s acertou %s em seu ponto crítico, e causou dano avassalador!");
            int dano = this.getDano()*4;
            alvo.receberDano(dano);
        } else {
            atacar(alvo);
        }

    }

    @Override
    public void receberDano(int dano) {
        if((this.getSorte()*0.8f + this.alcance) >= 0.85f) {
            System.out.println(this.getNome() + "conseguiu manter a distância e evadiu o ataque!");
        } else {
            super.receberDano(dano);
        }
    }

    protected void aumentaAtributos() {
        this.setPontosDeVidaTotal(this.getPontosDeVidaTotal() + 10);
        this.setForca(this.getForca() + 10);
    }
}
