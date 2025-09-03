package Herois;

import java.util.Random;

import Personagens.Heroi;
import Personagens.Personagem;
import Armas.Escudo;
import Armas.Herois.RecrutasReais.LancaDeTreinamento;



// O recruta real é um combatente corpo a corpo que já vem com um escudo
// Ele possui o atributo único investida  
public class RecrutaReal extends Heroi {

    private Escudo escudoEquipado;
    private boolean investida; // Atributo único do recruta real, aumenta consideravelmente seu dano 
    
    public RecrutaReal(String nome, int pontosDeVidaTotal, int forca) {
        super(nome, pontosDeVidaTotal, forca, new LancaDeTreinamento()) ;
        this.investida = false;

    }

    public void equiparEscudo(Escudo escudo) {
        this.escudoEquipado = escudo;
    }
    
    @Override
    public void receberDano(int dano) {
        int danoFinal = dano;
        Random random = new Random();

        // Verifica se o escudo não está quebrado 
        if(this.escudoEquipado != null && !this.escudoEquipado.estaQuebrado()) {

            // Lógica da sorte
            float chanceDeBloqueioFinal = escudoEquipado.calculaSorteEscudo(0.20f, this.getSorte(), 0.6f);

            // Verifica se o conseguiu realizar um bloqueio perfeito  
            if(random.nextFloat() <= chanceDeBloqueioFinal) {
                System.out.println(this.getNome() + " realizou um bloqueio perfeito com" + this.escudoEquipado + "!");
                danoFinal = 0;
                // Bloqueio perfeito consome mais durabilidade 
                escudoEquipado.consumirDurabilidade(2);

            } else {
                System.out.println(escudoEquipado.getNome() + " absorveu parte do dano.");
                danoFinal = Math.max(0, dano - escudoEquipado.getReducaoDeDano());
                escudoEquipado.consumirDurabilidade(1);
            }
        } 

        this.pontosDeVida -= danoFinal;
        System.out.printf("%s recebeu %d de Dano!\n", this.getNome(), danoFinal );

    }

    public void atacar(Personagem alvo) {
        int dano; 
        
        // Caso ele esteja com a investida ativada 
        if(this.investida) {
            dano = (int) (this.getDano()*(1 + this.getSorte()) );
            System.out.println(this.getNome() + " atacou com Investida Real e causou dano crítico!");
            alvo.receberDano(dano);

            // A investida só dura por um ataque 
            this.investida = false;
        } else {
            dano = this.getDano();
            System.out.println(this.getNome() + " atacou com: Estocada Simples!");
            alvo.receberDano(dano);
        }
    }

    // A habilidade especial do recruta real ativa sua investida 
    // Como a chance de conseguir é alta, caso dê errado o negativo é maior
    public void usarHabilidadeEspecial(Personagem alvo) {
        if(this.getSorte() >= 0.25) {
            System.out.println(this.getNome() + " entrou em investida!");
            this.investida = true;
            this.atacar(alvo);
        } else { 
            System.out.println(this.getNome() + " escorregou e não conseguiu atacar!");
        }
    }

    protected void aumentaAtributos() {
        this.setPontosDeVidaTotal(this.getPontosDeVidaTotal() + 20);
        this.setForca(this.getForca() + 10);
    }
}
