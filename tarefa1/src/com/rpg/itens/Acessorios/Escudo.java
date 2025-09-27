package com.rpg.itens.Acessorios;

import com.rpg.itens.*;
import com.rpg.itens.Classificadores.*;
public class Escudo extends Item{
    
    private String nome;
    private float chanceDeBloqueio; // Chance de bloquear totalmente o ataque 
    private int durabilidadeAtual;
    private int durabilidadeTotal;
    private int ReducaoDeDano; // O escudo sempre reduz em algum nível o dano 

    public Escudo(String nome, Raridade raridade, OrigemDoItem origem, float chanceDeBloqueio, int durabilidadeTotal, int ReducaoDeDano) {
        super(nome, raridade, origem, TipoDeItem.ESCUDO);
        this.nome = nome;
        this.chanceDeBloqueio = chanceDeBloqueio;
        this.durabilidadeAtual = durabilidadeTotal;
        this.durabilidadeTotal = durabilidadeTotal;
        this.ReducaoDeDano = ReducaoDeDano;
    }

    public boolean estaQuebrado() {
        return this.durabilidadeAtual <= 0;
    }

    public String getNome() {
        return this.nome;
    } 

    public int getDurabilidadeAtual() {
        return this.durabilidadeAtual;
    }

    public int getDurabilidadeTotal() {
        return this.durabilidadeTotal;
    }

    public float getChanceDeBloqueio() {
        return this.chanceDeBloqueio;
    }

    public int getReducaoDeDano() {
        return this.ReducaoDeDano;
    }

    // Função para quando o escudo absorve dano 
    public void consumirDurabilidade(int quantidade) {
        this.durabilidadeAtual -= quantidade;

        if(this.durabilidadeAtual <= 0) {
            System.out.println("O " + this.nome + "quebrou!");
        }
    }


}
