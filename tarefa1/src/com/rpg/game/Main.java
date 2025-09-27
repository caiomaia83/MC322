package com.rpg.game;

import java.util.List;
import com.rpg.cenario.*;
import com.rpg.combate.*;
import com.rpg.itens.*;
import com.rpg.itens.Loot.*;
import com.rpg.personagens.*;
import com.rpg.personagens.Herois.*;
import com.rpg.util.*;
import java.util.InputMismatchException;

public class Main {

    public static void main(String[] args) {

        System.out.println("=====================================================");
        System.out.println("          BEM-VINDO ÀS ARENAS!!!");
        System.out.println("=====================================================");

        // 1. CRIAÇÃO DO HERÓI
        Heroi heroi = new Barbaro("Conan, o Bárbaro", 150, 20);
        
        Menu menuPrincipal = new Menu();
        boolean sair = false;

        while (!sair) {
            int opcao = menuPrincipal.exibir();

            switch (opcao) {
                case 1:
                    iniciarAventura(heroi);
                    if (!heroi.estaVivo()) {
                        sair = true;
                    }
                    break;
                case 2:
                    exibirStatusHeroi(heroi);
                    break;
                case 3:
                    System.out.println("Loja de Itens (não implementado).");
                    break;
                case 4:
                    System.out.println("Salvar Jogo (não implementado).");
                    break;
                case 0:
                    System.out.println("Saindo do jogo. Até mais!");
                    sair = true;
                    break;
                default:
                    if (opcao != -1) {
                        System.out.println("Opção inválida! Por favor, tente novamente.");
                    }
                    break;
            }
        }
        
        menuPrincipal.fechar();
        System.out.println("=====================================================");
        System.out.println("                  FIM DE JOGO");
        System.out.println("=====================================================");
    }

    public static void iniciarAventura(Heroi heroi) {
        if (!heroi.estaVivo()) {
            System.out.println(heroi.getNome() + " está incapacitado e não pode lutar.");
            return;
        }

        // 2. GERAÇÃO DO MUNDO
        GeradorDeFases gerador = new ConstrutorDeCenario(); 
        int numeroDeFases = 3;
        List<IFase> masmorra = gerador.gerar(numeroDeFases, Dificuldade.MEDIO);

        // 3. APRESENTAÇÃO DA AVENTURA
        System.out.println("\n" + heroi.getNome() + ", um corajoso " + heroi.getClass().getSimpleName() + ", adentra a escuridão!");
        System.out.println("Ele deve sobreviver a " + numeroDeFases + " fase(s) para clamar a glória!");
        
        // 4. LOOP PRINCIPAL DO JOGO
        for (IFase faseAtual : masmorra) {
            faseAtual.iniciar(heroi);
            if (!heroi.estaVivo()) break;
            
            List<Monstro> monstrosDaFase = ((Fase) faseAtual).getMonstros();
            for (Monstro monstroAtual : monstrosDaFase) {
                if (!monstroAtual.estaVivo()) continue;

                System.out.println("\n" + heroi.getNome() + " encara um " + monstroAtual.getNome() + "!");

                while (heroi.estaVivo() && monstroAtual.estaVivo()) {
                    // --- TURNO DO HERÓI ---
                    System.out.println("\n--- Turno do " + heroi.getNome() + " ---");
                    AcaoCombate acaoHeroi = heroi.escolherAcao(monstroAtual);
                    if (acaoHeroi != null) acaoHeroi.executar(heroi, monstroAtual);
                    else System.out.println(heroi.getNome() + " não fez nada.");

                    // --- TURNO DO MONSTRO ---
                    if (monstroAtual.estaVivo()) {
                        System.out.println("\n--- Turno do " + monstroAtual.getNome() + " ---");
                        AcaoCombate acaoMonstro = monstroAtual.escolherAcao(heroi);
                        if (acaoMonstro != null) acaoMonstro.executar(monstroAtual, heroi);
                        else System.out.println(monstroAtual.getNome() + " não fez nada.");
                    }
                } // FIM DO COMBATE

                // LÓGICA PÓS-COMBATE (VITÓRIA DO HERÓI)
                if (!monstroAtual.estaVivo() && heroi.estaVivo()) {
                    System.out.println("\nO " + monstroAtual.getNome() + " foi derrotado!");
                    heroi.ganharExperiencia(monstroAtual); 
                    // LÓGICA DE LOOT ADICIONADA
                    if (monstroAtual instanceof Lootavel) {
                        IItem itemDropado = ((Lootavel) monstroAtual).droparLoot();
                        if (itemDropado != null) System.out.println("Você obteve: " + itemDropado.getNome() + "!");
                    }
                }
                if (!heroi.estaVivo()) break;
            }
            if (!heroi.estaVivo()) break;

            if (faseAtual.isConcluida()) {
                System.out.println("\n--- FASE " + ((Fase) faseAtual).getNivel() + " CONCLUÍDA! ---");
            }
        }

        // 5. CONCLUSÃO DO JOGO
        System.out.println("\n-----------------------------------------------------");
        if (heroi.estaVivo()) {
            System.out.println("  VITÓRIA! " + heroi.getNome() + " conquistou a masmorra!");
        } else {
            System.out.println("  GAME OVER! " + heroi.getNome() + " tombou bravamente...");
        }
        System.out.println("-----------------------------------------------------");
    }

    public static void exibirStatusHeroi(Heroi heroi) {
        System.out.println("\n--- STATUS ATUAL DO HERÓI ---");
        heroi.exibirStatus();
        System.out.println("---------------------------------");
    }
}