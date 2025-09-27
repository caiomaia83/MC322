package com.rpg.personagens.Herois;

import java.util.ArrayList; // ADICIONADO
import Itens.Armas.Herois.Bárbaros.CuteloDeCaça;
import Personagens.Combatente; // ADICIONADO
import Personagens.Heroi;
import Personagens.Personagem;
import Jogo.ataques.*; // ADICIONADO: Importa todas as suas ações

public class Barbaro extends Heroi {
    // Boolean furia;     // REMOVIDO
    // Boolean berserker; // REMOVIDO

    public Barbaro(String nome, int pontosDeVida, int forca) {
        super(nome, pontosDeVida, forca, new CuteloDeCaça());
        // this.furia = false;     // REMOVIDO
        // this.berserker = false; // REMOVIDO

        // ADICIONADO: Preenchendo a lista de ações
        this.acoes = new ArrayList<>();
        this.acoes.add(new AtaqueDesvairado());
        this.acoes.add(new ElixirDeFuria());
    }

    // REMOVIDO: O método atacar() foi substituído pelas classes de Ação.

    // REMOVIDO: O método usarHabilidadeEspecial() foi substituído pela classe ElixirDeFuria.

    // INTACTO: O método de aumentar atributos continua aqui
    @Override
    protected void aumentaAtributos() {
        this.setPontosDeVidaTotal(this.getPontosDeVidaTotal() + 20);
        this.setForca(this.getForca() + 15);
    }
    
   
    public AcaoCombate escolherAcao(Combatente alvo) {
    // IA do Bárbaro: Fica mais agressivo com a vida baixa!

  
    if (this.getPontosDeVida() < this.getPontosDeVidaTotal() * 0.4) {
        System.out.println(this.getNome() + " está ferido e entra em fúria total!");
        return this.acoes.get(1); 
    } else {
        System.out.println(this.getNome() + " guarda sua fúria para o momento certo.");
        return this.acoes.get(0); 
        }
    }
}