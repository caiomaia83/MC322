import Personagens.*;
import Herois.*;
import Monstros.*;



public class Main {

    public static void main(String[] args) {


        /* sessao de bloco comentada pois nao devemos receber entrada do usuario ainda
        
        Scanner scanner = new Scanner(System.in);
        System.out.println("Escolha qual herói voce quer utilizar ! Pressione 1 para bárbaro ou 2 para arqueira");
        int escolhaHeroi = scanner.nextInt();   
        
        if(escolhaHeroi == 1){
            Barbaro heroi = new Barbaro("barbaro", 100, 15, 1, 0);
        } else if (escolhaHeroi == 2){
            Arqueira heroi = new Arqueira("arqueira", 80, 10, 1, 0, 5);
        } 
        
        //scanner.close();
        */

        // --- 1. CRIAÇÃO DOS PERSONAGENS ---
        Barbaro heroi = new Barbaro("barbaro", 100, 15, 1, 0);
        Monstro[] monstros = {
            new Servos("Servos", 30, 8,5),
            new Esqueleto("Esqueleto Guerreiro", 50, 10, 5),
            new Corredor("Hog Rider", 70, 12, 20, 20)
        };

        // --- 2. APRESENTAÇÃO DO DESAFIO ---
        System.out.println("=====================================================");
        System.out.println("  O DESAFIO DA MASMORRA DOS TRÊS TERRORES");
        System.out.println("=====================================================");
        System.out.println(heroi.getNome() + ", um nobre cavaleiro, adentra a escuridão para provar seu valor.");
        System.out.println("Ele deve sobreviver a três encontros para clamar a glória!");
        System.out.println("\n--- STATUS INICIAL DO HERÓI ---");
        heroi.exibirStatus();
        System.out.println("---------------------------------");

        // --- 3. SIMULAÇÃO DOS TURNOS EM LOOP ---
        for (int i = 0; i < monstros.length; i++) {
            Monstro monstroAtual = monstros[i];
            
            System.out.printf("\n================= TURNO %d =================\n", i + 1);
            System.out.println("Um " + monstroAtual.getNome() + " surge das sombras!");

            // O combate acontece enquanto ambos estiverem vivos
            while (heroi.estaVivo() && monstroAtual.estaVivo()) {
                System.out.println("\n--- Ação do Herói ---");
                heroi.atacar(monstroAtual);

                // O monstro só ataca de volta se ainda estiver vivo
                if (monstroAtual.estaVivo()) {
                    System.out.println("\n--- Ação do Monstro ---");
                    monstroAtual.atacar(heroi);
                } else {
                    System.out.println("   O " + monstroAtual.getNome() + " foi derrotado!");
                }

                // Verificação de sobrevivência do herói
                if (!heroi.estaVivo()) {
                    break; // Se o herói morrer, sai do loop de combate
                }
            }

            // Se o herói morreu, o desafio acaba
            if (!heroi.estaVivo()) {
                break; // Interrompe o loop principal dos turnos
            }

            // Exibição de status no final do encontro
            System.out.println("\n--- STATUS PÓS-ENCONTRO ---");
            heroi.exibirStatus();
            System.out.println("---------------------------------");
        }

        // --- 4. CONCLUSÃO DO DESAFIO ---
        System.out.println("\n=====================================================");
        if (heroi.estaVivo()) {
            System.out.println("  VITÓRIA! " + heroi.getNome() + " sobreviveu aos horrores da masmorra!");
            System.out.println("  Sua lenda será contada por eras!");
        } else {
            System.out.println("  GAME OVER! " + heroi.getNome() + " tombou bravamente na escuridão...");
            System.out.println("  A masmorra clama mais uma alma corajosa.");
        }
        System.out.println("=====================================================");
    }
}