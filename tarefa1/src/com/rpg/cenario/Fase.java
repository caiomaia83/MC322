package com.rpg.cenario;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.rpg.personagens.*;


public class Fase implements InterfaceFase { 
    private int nivel;
    private TipoCenario tipoCenario; 
    private List<Monstro> monstros;

    
    public Fase(int nivel, TipoCenario tipoCenario, List<Monstro> monstrosBase) {
        this.nivel = nivel;
        this.tipoCenario = tipoCenario;
        this.monstros = new ArrayList<>();

        List<Monstro> listaSorteavel = new ArrayList<>(monstrosBase);
        Collections.shuffle(listaSorteavel);
        int quantidadeDeMonstros = Math.min(3, listaSorteavel.size());
        List<Monstro> monstrosSelecionados = listaSorteavel.subList(0, quantidadeDeMonstros);
        double fatorDificuldade = 1.0 + (0.15 * nivel);
        for (Monstro monstroBase : monstrosSelecionados) {
            Monstro monstroFortalecido = monstroBase.criarCopiaFortalecida(fatorDificuldade);
            this.monstros.add(monstroFortalecido);
        }
    }

    @Override
    public void iniciar(Heroi heroi) {
        System.out.println("\n--- FASE " + this.nivel + ": " + this.tipoCenario.name().replace("_", " ") + " ---");
        // Usando a descrição que colocamos no Enum
        System.out.println(this.tipoCenario.getDescricao());
        // Usando o efeito que colocamos no Enum
        this.tipoCenario.aplicarEfeitos(heroi);

        heroi.receberCura(heroi.getPontosDeVidaTotal());
        heroi.exibirStatus();

        System.out.println("\nMonstros a serem derrotados:");
        for (Monstro monstro : this.monstros) {
            monstro.exibirStatus();
        }
        System.out.println("------------------------------------");
    }

    @Override
    public boolean isConcluida() {
        for (Monstro monstro : this.monstros) {
            if (monstro.estaVivo()) {
                return false; // Encontrou um monstro vivo, fase não concluída
            }
        }
        return true; // Nenhum monstro vivo encontrado, fase concluída
    }

    @Override
    public TipoCenario getTipoDeCenario() {
        return this.tipoCenario;
    }

    public List<Monstro> getMonstros() {
        return this.monstros;
    }

    public int getNivel() {
        return this.nivel;
    }
}