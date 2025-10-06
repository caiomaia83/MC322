package com.rpg.game.personagens.Herois;

import java.util.ArrayList; // ADICIONADO

import com.rpg.game.combate.*;
import com.rpg.game.itens.Armas.ArmasHerois.Arqueira.*;
import com.rpg.game.personagens.Heroi;

public class Arqueira extends Heroi {
    public float precisao; // Deixei público para o ataque acessar, ou podemos criar um getPrecisao()
    float alcance;

    public Arqueira(String nome, int pontosDeVida, int forca) {
        super(nome, pontosDeVida, forca, new ArcoCurto());
        this.precisao = 0.1f;
        this.alcance = 0.1f;

        // ADICIONADO: Preenchendo a lista de ações
        this.acoes = new ArrayList<>();
        this.acoes.add(new FlechaPerfurante());
        this.acoes.add(new OlhosDeAguia());
    }
    
    // ADICIONADO: Setters para a habilidade poder modificar os atributos
    public void aumentarPrecisao(float valor) {
        this.precisao += valor;
    }

    public void aumentarAlcance(float valor) {
        this.alcance += valor;
    }

    // REMOVIDO: O método atacar() foi movido para a classe FlechaPerfurante

    // REMOVIDO: O método usarHabilidadeEspecial() foi movido para a classe OlhosDeAguia

    // INTACTO: Sua excelente habilidade de esquiva continua aqui!
    @Override
    public void receberDano(int dano) {
        if ((this.getSorte() + this.alcance) >= 0.85f) {
            System.out.println(this.getNome() + " conseguiu manter a distância e evadiu o ataque!");
        } else {
            super.receberDano(dano);
        }
    }

    // INTACTO: O método de aumentar atributos continua aqui
    @Override
    protected void aumentaAtributos() {
        this.setPontosDeVidaTotal(this.getPontosDeVidaTotal() + 10);
        this.setForca(this.getForca() + 10);
    }
}