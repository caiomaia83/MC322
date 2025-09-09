import Personagens.*;
import Personagens.Herois.*;
import Personagens.Monstros.*;

import java.util.Random;
import java.util.List;
import Fases.ConstrutorDeCenario;
import Fases.Fase;


public class Main {

    public static void main(String[] args) {

        // 1. CRIAÇÃO DO HERÓI
        RecrutaReal heroi = new RecrutaReal("joao", 100, 15);

        // 2. GERAÇÃO DINÂMICA DO MUNDO
        // Em vez de uma lista fixa, usamos o ConstrutorDeCenario
        int numeroDeFases = 1; // Você pode facilmente mudar para 5, 10, etc.
        List<Fase> masmorra = ConstrutorDeCenario.gerarFases(numeroDeFases);

        // 3. APRESENTAÇÃO DO DESAFIO
        System.out.println("=====================================================");
        System.out.println("  O DESAFIO DA MASMORRA GERADA DINAMICAMENTE");
        System.out.println("=====================================================");
        System.out.println(heroi.getNome() + ", um corajoso aventureiro, adentra a escuridão!");
        System.out.println("Ele deve sobreviver a " + numeroDeFases + " fases para clamar a glória!");
        System.out.println("\n--- STATUS INICIAL DO HERÓI ---");
        heroi.exibirStatus();
        heroi.exibirStatusArma(); // Se este método ainda for relevante
        System.out.println("---------------------------------");

        // 4. LOOP PRINCIPAL PELAS FASES DA MASMORRA
        for (Fase faseAtual : masmorra) {
            
            faseAtual.iniciar(); // Apresenta a fase, o ambiente e os monstros
            
            // LOOP DE COMBATE PARA CADA MONSTRO NA FASE ATUAL
            for (Monstro monstroAtual : faseAtual.getMonstros()) {
                System.out.println("\n" + heroi.getNome() + " encara um " + monstroAtual.getNome() + " fortalecido!");

                // A sua lógica de combate original, agora aplicada a cada monstro da fase
                while (heroi.estaVivo() && monstroAtual.estaVivo()) {
                    System.out.println("\n--- Ação do Herói ---");
                    Random random = new Random();
                    if (random.nextInt(100) > 80) { // 20% de chance de especial
                        heroi.usarHabilidadeEspecial(monstroAtual);
                    } else {
                        heroi.atacar(monstroAtual);
                    }

                    if (monstroAtual.estaVivo()) {
                        System.out.println("\n--- Ação do Monstro ---");
                        monstroAtual.atacar(heroi);
                    } else {
                        System.out.println("O " + monstroAtual.getNome() + " foi derrotado!");
                        heroi.ganharExperiencia(monstroAtual); 
                    }
                }

                // Se o herói morreu no meio da fase, interrompe os combates
                if (!heroi.estaVivo()) {
                    break; 
                }
            }

            // Se o herói morreu, interrompe a progressão para as próximas fases
            if (!heroi.estaVivo()) {
                break;
            }

            System.out.println("\n--- FASE " + faseAtual.getNivel() + " CONCLUÍDA! ---");
            heroi.exibirStatus();
            System.out.println("---------------------------------");
        }

        // 5. CONCLUSÃO DO DESAFIO
        System.out.println("\n=====================================================");
        if (heroi.estaVivo()) {
            System.out.println("  VITÓRIA! " + heroi.getNome() + " conquistou a masmorra!");
            System.out.println("  Sua lenda será contada por eras!");
        } else {
            System.out.println("  GAME OVER! " + heroi.getNome() + " tombou bravamente na escuridão...");
            System.out.println("  A masmorra clama mais uma alma corajosa.");
        }
        System.out.println("=====================================================");
    }
}