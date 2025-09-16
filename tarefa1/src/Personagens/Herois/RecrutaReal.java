package Personagens.Herois;

import java.util.Random;
import java.util.ArrayList; 

import Itens.Acessorios.Escudo;
import Itens.Acessorios.RecrutasReais.EscudoDeMadeira;
import Itens.Armas.Herois.RecrutasReais.LancaDeTreinamento;
import Personagens.Combatente;
import Personagens.Heroi;
import Personagens.Personagem;
import Jogo.ataques.*; 

public class RecrutaReal extends Heroi {

    private Escudo escudoEquipado;

    public RecrutaReal(String nome, int pontosDeVidaTotal, int forca) {
        super(nome, pontosDeVidaTotal, forca, new LancaDeTreinamento());
        this.escudoEquipado = new EscudoDeMadeira();
    
        //Preenchendo a lista de ações
        this.acoes = new ArrayList<>();
        this.acoes.add(new EstocadaSimples()); // Ataque Padrão
        this.acoes.add(new InvestidaReal());   // Habilidade Especial
    }

    
    public void equiparEscudo(Escudo escudo) {
        this.escudoEquipado = escudo;
    }
    
   
    @Override
    public void receberDano(int dano) {
        int danoFinal = dano;
        Random random = new Random();

        if (this.escudoEquipado != null && !this.escudoEquipado.estaQuebrado()) {
            float FATOR_SORTE = 0.10f;
            float bonusDeSorte = this.getSorte() * FATOR_SORTE;
            float chanceDeBloqueioFinal = this.escudoEquipado.getChanceDeBloqueio() + bonusDeSorte;
            chanceDeBloqueioFinal = Math.min(chanceDeBloqueioFinal, 0.6f);
            System.out.printf("Chance de bloqueio: %.0f %% \n", chanceDeBloqueioFinal * 100);

            if (random.nextFloat() <= chanceDeBloqueioFinal) {
                System.out.println(this.getNome() + " realizou um bloqueio perfeito com " + this.escudoEquipado.getNome() + "!");
                danoFinal = 0;
                this.escudoEquipado.consumirDurabilidade(2);
            } else {
                System.out.println(escudoEquipado.getNome() + " absorveu parte do dano.");
                danoFinal = Math.max(0, dano - escudoEquipado.getReducaoDeDano());
                this.escudoEquipado.consumirDurabilidade(1);
            }
        }
        this.pontosDeVida -= danoFinal;
        System.out.printf("%s recebeu %d de Dano!\n", this.getNome(), danoFinal);
    }

 
    @Override
    protected void aumentaAtributos() {
        this.setPontosDeVidaTotal(this.getPontosDeVidaTotal() + 20);
        this.setForca(this.getForca() + 10);
    }
    
    @Override
    public AcaoCombate escolherAcao(Combatente alvo) {
        // Se a vida do alvo for baixa, tente a investida para finalizar!
        if (alvo.getPontosDeVida() <= 50) {
            return this.acoes.get(1); // Retorna InvestidaReal
        }
        // Senão, usa o ataque básico
        return this.acoes.get(0); // Retorna EstocadaSimples
    }
}