import Personagens.Herois.*;
import Personagens.Monstro;
import java.util.List;

// --- NOVAS IMPORTAÇÕES PARA O SISTEMA DE MUNDO ---
import Fases.ConstrutorDeCenario;
import Fases.Fase; // A sua classe concreta
import Fases.GeradorDeFases; // A nova interface
import Fases.IFase; // A nova interface
import Jogo.ataques.AcaoCombate;

public class Main {

    public static void main(String[] args) {

        // 1. CRIAÇÃO DO HERÓI (Pode ser qualquer um dos seus heróis)
        Heroi heroi = new Barbaro("Conan", 150, 20);

        // --- MUDANÇA: GERAÇÃO DO MUNDO USANDO AS INTERFACES ---
        System.out.println("Criando o arquiteto do mundo...");
        // 1. Criamos um objeto que cumpre o contrato de GeradorDeFases
        GeradorDeFases gerador = new ConstrutorDeCenario(); 
        int numeroDeFases = 3;
        // 2. Usamos o gerador para criar a lista de fases. A lista é da INTERFACE.
        List<IFase> masmorra = gerador.gerar(numeroDeFases);

        // 3. APRESENTAÇÃO DO DESAFIO (praticamente igual)
        System.out.println("=====================================================");
        System.out.println("          O DESAFIO DAS ARENAS!!!");
        System.out.println("=====================================================");
        System.out.println(heroi.getNome() + ", um corajoso " + heroi.getClass().getSimpleName() + ", adentra a escuridão!");
        System.out.println("Ele deve sobreviver a " + numeroDeFases + " fase(s) para clamar a glória!");
        System.out.println("\n--- STATUS INICIAL DO HERÓI ---");
        heroi.exibirStatus();
        System.out.println("---------------------------------");

        // --- MUDANÇA: LOOP PRINCIPAL AGORA USA A INTERFACE IFase ---
        for (IFase faseAtual : masmorra) {
            
            // --- MUDANÇA: O método iniciar() agora aplica os efeitos do cenário no herói! ---
            faseAtual.iniciar(heroi);

            // Verificamos se o herói sobreviveu aos efeitos do cenário antes de começar o combate
            if (!heroi.estaVivo()) {
                break;
            }
            
            // Para acessar métodos específicos da sua classe 'Fase' (como getMonstros), fazemos um "cast"
            List<Monstro> monstrosDaFase = ((Fase) faseAtual).getMonstros();

            for (Monstro monstroAtual : monstrosDaFase) {
                // Se o monstro já estiver morto (por um evento futuro, por exemplo), pula para o próximo
                if (!monstroAtual.estaVivo()) continue;

                System.out.println("\n" + heroi.getNome() + " encara um " + monstroAtual.getNome() + "!");

                // O SEU BLOCO DE COMBATE (já estava perfeito e continua igual)
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
                } // FIM DO WHILE DE COMBATE

                // Lógica pós-combate (XP)
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

            // Verificamos usando o novo método se a fase realmente foi concluída
            if (faseAtual.isConcluida()) {
                System.out.println("\n--- FASE " + ((Fase) faseAtual).getNivel() + " CONCLUÍDA! ---");
                heroi.exibirStatus();
                System.out.println("---------------------------------");
            }
        }

        // 5. CONCLUSÃO DO DESAFIO (igual)
        System.out.println("\n=====================================================");
        if (heroi.estaVivo()) {
            System.out.println("  VITÓRIA! " + heroi.getNome() + " conquistou a masmorra!");
        } else {
            System.out.println("  GAME OVER! " + heroi.getNome() + " tombou bravamente na escuridão...");
        }
        System.out.println("=====================================================");
    }
}