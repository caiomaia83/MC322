package com.rpg.game;

import java.util.List;

import com.rpg.game.cenario.*;
import com.rpg.game.combate.*;
import com.rpg.game.itens.*;
import com.rpg.game.itens.Loot.*;
import com.rpg.game.personagens.*;
import com.rpg.game.personagens.Herois.*;
import com.rpg.game.util.*;

public class Main {

    public static void main(String[] args) {

        System.out.println("=====================================================");
        System.out.println("          BEM-VINDO ÀS ARENAS!!!");
        System.out.println("=====================================================");

        // 1. CRIAÇÃO DO HERÓI
        Heroi heroi = new Barbaro("Conan, o Bárbaro", 150, 30);
        
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
                case 0:
                    sair = true;
                    break;
                default:
                    if (opcao != -1) {
                        System.out.println("Opção inválida! Por favor, tente novamente.");
                    }
                    break;
            }
        }
        InputManager.fecharScanner();
        System.out.println("=====================================================");
        System.out.println("                  FIM DE JOGO");
        System.out.println("=====================================================");
    }

    private static Dificuldade selecionarDificuldade() {
    System.out.println("\nSELECIONE A DIFICULDADE DA AVENTURA:");
    System.out.println("[1] Fácil");
    System.out.println("[2] Normal");
    System.out.println("[3] Difícil");

    // Usamos a nossa ferramenta para garantir que o jogador digite um número entre 1 e 3.
    // O InputManager lida com todos os possíveis erros (digitar texto, número fora do intervalo, etc).
    int escolha = InputManager.lerInteiro("> ", 1, 3);

    // Convertemos a resposta numérica no Enum correspondente
    switch (escolha) {
        case 1:
            return Dificuldade.FACIL;
        case 3:
            return Dificuldade.DIFICIL;
        default: // case 2
            return Dificuldade.MEDIO;
    }
}

    public static void iniciarAventura(Heroi heroi) {
        if (!heroi.estaVivo()) {
            System.out.println(heroi.getNome() + " está incapacitado e não pode lutar.");
            return;
        }

        // 2. GERAÇÃO DO MUNDO
        GeradorDeFases gerador = new ConstrutorDeCenario(); 
        int numeroDeFases = 3;
        Dificuldade dificuldadeEscolhida = selecionarDificuldade();
        List<InterfaceFase> masmorra = gerador.gerar(numeroDeFases, dificuldadeEscolhida);

        // 3. APRESENTAÇÃO DA AVENTURA
        System.out.println("\n" + heroi.getNome() + ", um corajoso " + heroi.getClass().getSimpleName() + ", adentra a escuridão!");
        System.out.println("Ele deve sobreviver a " + numeroDeFases + " fase(s) para clamar a glória!");
        
        // 4. LOOP PRINCIPAL DO JOGO
        for (InterfaceFase faseAtual : masmorra) {
            faseAtual.iniciar(heroi);
            if (!heroi.estaVivo()) break;
            
            List<Monstro> monstrosDaFase = ((Fase) faseAtual).getMonstros();
            for (Monstro monstroAtual : monstrosDaFase) {
                if (!monstroAtual.estaVivo()) continue;

                System.out.println("\n" + heroi.getNome() + " encara um " + monstroAtual.getNome() + "!");

                while (heroi.estaVivo() && monstroAtual.estaVivo()) {

                    heroi.exibirStatus();
                    monstroAtual.exibirStatus();
                    // --- TURNO DO HERÓI ---
                    System.out.println("\n--- Turno do " + heroi.getNome() + " ---");
                    AcaoCombate acaoHeroi = heroi.escolherAcao(monstroAtual);
                    if (acaoHeroi != null) acaoHeroi.executar(heroi, monstroAtual);
                    else System.out.println(heroi.getNome() + " não fez nada.");

                    // --- TURNO DO MONSTRO ---
                    if (monstroAtual.estaVivo()) {
                        heroi.exibirStatus();
                        monstroAtual.exibirStatus();
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
                        InterfaceItem itemDropado = ((Lootavel) monstroAtual).droparLoot();
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
        return;
    }

    public static void exibirStatusHeroi(Heroi heroi) {
        System.out.println("\n--- STATUS ATUAL DO HERÓI ---");
        heroi.exibirStatus();
        System.out.println("---------------------------------");
    }
}