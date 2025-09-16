import Personagens.*;
import Personagens.Herois.*;
import Personagens.Monstros.*;
import java.util.List;
import Fases.ConstrutorDeCenario;
import Fases.Fase;
import Jogo.ataques.AcaoCombate; // ÚNICA NOVA IMPORTAÇÃO NECESSÁRIA

public class Main {

    public static void main(String[] args) {

        // 1. CRIAÇÃO DO HERÓI
        Heroi heroi = new RecrutaReal("Joao", 100, 15);

        // 2. GERAÇÃO DINÂMICA DO MUNDO
        int numeroDeFases = 2;
        List<Fase> masmorra = ConstrutorDeCenario.gerarFases(numeroDeFases);

        // 3. APRESENTAÇÃO DO DESAFIO
        System.out.println("=====================================================");
        System.out.println("  O DESAFIO DAs ARENAS !!!");
        System.out.println("=====================================================");
        System.out.println(heroi.getNome() + ", um corajoso " + heroi.getClass().getSimpleName() + ", adentra a escuridão!");
        System.out.println("Ele deve sobreviver a " + numeroDeFases + " fase(s) para clamar a glória!");
        System.out.println("\n--- STATUS INICIAL DO HERÓI ---");
        heroi.exibirStatus();
        System.out.println("---------------------------------");

        // 4. LOOP PRINCIPAL PELAS FASES DA MASMORRA
        for (Fase faseAtual : masmorra) {
            
            faseAtual.iniciar();
            
            for (Monstro monstroAtual : faseAtual.getMonstros()) {
                System.out.println("\n" + heroi.getNome() + " encara um " + monstroAtual.getNome());

                // ===== BLOCO DE COMBATE REFEITO =====
                while (heroi.estaVivo() && monstroAtual.estaVivo()) {
                    // --- TURNO DO HERÓI ---
                    System.out.println("\n--- Turno do " + heroi.getNome() + " ---");
                    AcaoCombate acaoHeroi = heroi.escolherAcao(monstroAtual);
                    if (acaoHeroi != null) {
                        acaoHeroi.executar(heroi, monstroAtual);
                    } else {
                        System.out.println(heroi.getNome() + " não fez nada.");
                    }

                    // Verifica se o monstro sobreviveu
                    if (monstroAtual.estaVivo()) {
                        // --- TURNO DO MONSTRO ---
                        System.out.println("\n--- Turno do " + monstroAtual.getNome() + " ---");
                        AcaoCombate acaoMonstro = monstroAtual.escolherAcao(heroi);
                        if (acaoMonstro != null) {
                            acaoMonstro.executar(monstroAtual, heroi);
                        } else {
                            System.out.println(monstroAtual.getNome() + " não fez nada.");
                        }
                    }
                } // ===== FIM DO WHILE DE COMBATE =====

                // Lógica pós-combate original (XP)
                if (!monstroAtual.estaVivo() && heroi.estaVivo()) {
                    System.out.println("\nO " + monstroAtual.getNome() + " foi derrotado!");
                    heroi.ganharExperiencia(monstroAtual); 
                }

                if (!heroi.estaVivo()) {
                    break; 
                }
            }

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
        } else {
            System.out.println("  GAME OVER! " + heroi.getNome() + " tombou bravamente na escuridão...");
        }
        System.out.println("=====================================================");
    }
}