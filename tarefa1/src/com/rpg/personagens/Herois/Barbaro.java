package com.rpg.personagens.Herois;

import java.util.ArrayList; // ADICIONADO

import com.rpg.combate.*;
import com.rpg.itens.Armas.Herois.Bárbaros.CuteloDeCaça;
import com.rpg.personagens.*;

// ADICIONADO: Importa todas as suas ações

public class Barbaro extends Heroi {

    private int cargasElixir;

    public Barbaro(String nome, int pontosDeVida, int forca) {
        super(nome, pontosDeVida, forca, new CuteloDeCaça());


        this.acoes = new ArrayList<>();
        this.acoes.add(new AtaqueDesvairado());
        this.acoes.add(new ElixirDeFuria());
        this.cargasElixir = 2; 
    }

    public int getCargasElixir() {
        return this.cargasElixir;
    }

    public void usarCargaElixir() {
        this.cargasElixir--;
    }

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