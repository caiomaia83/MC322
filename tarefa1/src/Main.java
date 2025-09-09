import Personagens.*;
import Personagens.Herois.*;
import Personagens.Monstros.*;

import java.util.Random;



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

        //  CRIAÇÃO DOS PERSONAGENS 
        RecrutaReal heroi = new RecrutaReal("joao", 100, 15);
        Monstro[] monstros = {
            new Servo( 30, 8,5),
            new Esqueleto( 50, 10, 5),
            new Corredor(70, 20, 20, 20)
        };

        //  APRESENTAÇÃO DO DESAFIO 
        System.out.println("=====================================================");
        System.out.println("  O DESAFIO DA MASMORRA DOS TRÊS TERRORES");
        System.out.println("=====================================================");
        System.out.println(heroi.getNome() + ", um corajoso aventureiro, adentra a escuridão para provar seu valor.");
        System.out.println("Ele deve sobreviver a três encontros para clamar a glória!");
        System.out.println("\n--- STATUS INICIAL DO HERÓI ---");
        heroi.exibirStatus();
        heroi.exibirStatusArma();
        System.out.println("---------------------------------");

        //  SIMULAÇÃO DOS TURNOS EM LOOP 
        for (int i = 0; i < monstros.length; i++) {
            Monstro monstroAtual = monstros[i];
            
            System.out.printf("\n================= TURNO %d =================\n", i + 1);
            System.out.println("Um " + monstroAtual.getNome() + " surge das sombras!");

            // O combate acontece enquanto ambos estiverem vivos
            while (heroi.estaVivo() && monstroAtual.estaVivo()) {
                System.out.println("\n--- Ação do Herói ---");
                // O heroi tem uma chance aleatoria de usar seu ataque especial
                Random random = new Random(); 
                if(random.nextInt(100) > 80) {
                    heroi.usarHabilidadeEspecial(monstroAtual);
                } else {
                    heroi.atacar(monstroAtual);
                }

                // O monstro só ataca de volta se ainda estiver vivo
                if (monstroAtual.estaVivo()) {
                    System.out.println("\n--- Ação do Monstro ---");
                    monstroAtual.atacar(heroi);
                } else {
                    System.out.println("O " + monstroAtual.getNome() + " foi derrotado!");
                    heroi.ganharExperiencia(monstroAtual);
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

        //  CONCLUSÃO DO DESAFIO 
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