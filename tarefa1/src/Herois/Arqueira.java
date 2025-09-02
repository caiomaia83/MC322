import java.util.Random;

public  class Arqueira extends Heroi {
    int precisao;
    int alcance;

    public Arqueira(String nome, int pontosDeVida, int forca, int nivel, int experiencia, int precisao, int alcance) {
        super(nome,pontosDeVida, forca, nivel, experiencia);
        this.precisao = 50;
        this.alcance = 10;
    }



    public void atacar(Personagem alvo) {
        System.out.println(this.nome +"atacou com: Flecha Perfurante!");

        int dano; 
        
        Random random = new Random();
        if((random.nextInt(100) + this.precisao) >= 100) {
            dano = this.forca + 50;
            alvo.receberDano(dano);
            System.out.println(this.nome + "acertou um golpe preciso e causou dano crítico!");
        } else {
            dano = this.forca;
            alvo.receberDano(dano);
        }
    }

    public void usarHabilidadeEspecial(Personagem alvo) {
        System.out.println(this.nome+ "usou a habilidade: Olhos de àguia!");
        System.out.println("A precisao de "+this.nome+"aumentou consideravelmente.");
        this.alcance += 10;
        this.precisao += 30;
        atacar(alvo);
    }

    @Override
    public void receberDano(int dano) {
        Random random = new Random();
        if((random.nextInt(50) + this.alcance) >= 50) {
            System.out.println(this.nome + "conseguiu manter a distância e evadiu o ataque!");
        } else {
            this.pontosDeVida -= dano;
        }
    }
}
