package com.rpg.game;

import java.util.List;

import com.rpg.cenario.ConstrutorDeCenario;
import com.rpg.cenario.Fase;
import com.rpg.cenario.GeradorDeFases;
import com.rpg.cenario.IFase;
import com.rpg.combate.AcaoCombate;
import com.rpg.itens.IItem;
import com.rpg.itens.Loot.Lootavel;
import com.rpg.personagens.Heroi;
import com.rpg.personagens.Monstro;
import com.rpg.personagens.Herois.Barbaro;

public class Main {

    public static void main(String[] args) {

        // 1. CRIAÇÃO DO HERÓI
        Heroi heroi = new Barbaro("Conan, o Bárbaro", 150, 20);

        // 2. GERAÇÃO DO MUNDO
        GeradorDeFases gerador = new ConstrutorDeCenario(); 
        int numeroDeFases = 3;
        List<IFase> masmorra = gerador.gerar(numeroDeFases);

        // 3. APRESENTAÇÃO DA AVENTURA
        System.out.println("=====================================================");
        System.out.println("          O DESAFIO DAS ARENAS!!!");
        System.out.println("=====================================================");
        System.out.println(heroi.getNome() + ", um corajoso " + heroi.getClass().getSimpleName() + ", adentra a escuridão!");
        System.out.println("Ele deve sobreviver a " + numeroDeFases + " fase(s) para clamar a glória!");
        System.out.println("\n--- STATUS INICIAL DO HERÓI ---");
        heroi.exibirStatus();
        System.out.println("---------------------------------");

        // 4. LOOP PRINCIPAL DO JOGO
        for (IFase faseAtual : masmorra) {
            
            faseAtual.iniciar(heroi);

            if (!heroi.estaVivo()) {
                break;
            }
            
            List<Monstro> monstrosDaFase = ((Fase) faseAtual).getMonstros();

            for (Monstro monstroAtual : monstrosDaFase) {
                if (!monstroAtual.estaVivo()) continue;

                System.out.println("\n" + heroi.getNome() + " encara um " + monstroAtual.getNome() + "!");

                while (heroi.estaVivo() && monstroAtual.estaVivo()) {
                    // --- TURNO DO HERÓI ---
                    System.out.println("\n--- Turno do " + heroi.getNome() + " ---");
                    AcaoCombate acaoHeroi = heroi.escolherAcao(monstroAtual);
                    if (acaoHeroi != null) {
                        acaoHeroi.executar(heroi, monstroAtual);
                    } else {
                        System.out.println(heroi.getNome() + " não fez nada.");
                    }

                    // --- TURNO DO MONSTRO ---
                    if (monstroAtual.estaVivo()) {
                        System.out.println("\n--- Turno do " + monstroAtual.getNome() + " ---");
                        AcaoCombate acaoMonstro = monstroAtual.escolherAcao(heroi);
                        if (acaoMonstro != null) {
                            acaoMonstro.executar(monstroAtual, heroi);
                        } else {
                            System.out.println(monstroAtual.getNome() + " não fez nada.");
                        }
                    }
                } // FIM DO COMBATE

                // LÓGICA PÓS-COMBATE (VITÓRIA DO HERÓI)
                if (!monstroAtual.estaVivo() && heroi.estaVivo()) {
                    System.out.println("\nO " + monstroAtual.getNome() + " foi derrotado!");
                    heroi.ganharExperiencia(monstroAtual); 

                    // LÓGICA DE LOOT ADICIONADA
                    if (monstroAtual instanceof Lootavel) {
                        IItem itemDropado = ((Lootavel) monstroAtual).droparLoot();
                        if (itemDropado != null) {
                            System.out.println("Você obteve: " + itemDropado.getNome() + "!");
                        }
                    }
                }

                if (!heroi.estaVivo()) { break; }
            }

            if (!heroi.estaVivo()) { break; }

            if (faseAtual.isConcluida()) {
                System.out.println("\n--- FASE " + ((Fase) faseAtual).getNivel() + " CONCLUÍDA! ---");
                heroi.exibirStatus();
                System.out.println("---------------------------------");
            }
        }

        // 5. CONCLUSÃO DO JOGO
        System.out.println("\n=====================================================");
        if (heroi.estaVivo()) {
            System.out.println("  VITÓRIA! " + heroi.getNome() + " conquistou a masmorra!");
        } else {
            System.out.println("  GAME OVER! " + heroi.getNome() + " tombou bravamente na escuridão...");
        }
        System.out.println("=====================================================");
    }
}