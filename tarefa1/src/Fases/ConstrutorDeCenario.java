package Fases;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import Personagens.*;
import Personagens.Monstros.*;


public class ConstrutorDeCenario {

    // Um construtor privado impede que esta classe seja instanciada.
    private ConstrutorDeCenario() {}

    public static List<Fase> gerarFases(int nFases) {
        System.out.println("Construindo o mundo com " + nFases + " fases...");

        List<Fase> fasesGeradas = new ArrayList<>();
        List<String> poolDeAmbientes = getAmbientes();
        List<Monstro> bestiario = criarBestiario(); // Nosso catálogo de monstros
        Random random = new Random();

        // Loop para criar cada fase, de 1 até nFases
        for (int i = 1; i <= nFases; i++) {
            int nivelAtual = i;

            // Seleciona um ambiente de forma cíclica para dar uma sensação de progressão
            String ambienteAtual = poolDeAmbientes.get((nivelAtual - 1) % poolDeAmbientes.size());

            // Seleciona aleatoriamente alguns monstros do bestiário para esta fase
            List<Monstro> monstrosParaFase = new ArrayList<>();
            int quantidadeMonstros = 2 + random.nextInt(2); // Gera 2 ou 3 monstros por fase

            for (int j = 0; j < quantidadeMonstros; j++) {
                int indiceAleatorio = random.nextInt(bestiario.size());
                monstrosParaFase.add(bestiario.get(indiceAleatorio));
            }

            // Cria a nova fase com o nível, ambiente e monstros selecionados
            Fase novaFase = new Fase(nivelAtual, ambienteAtual, monstrosParaFase);
            fasesGeradas.add(novaFase);
        }

        System.out.println("Mundo construído com sucesso!\n");
        return fasesGeradas;
    }

    private static List<String> getAmbientes() {
        return List.of(
            "Tigela Bárbara",
            "Vale dos Feitiços",
            "Oficina do Construtor",
            "Teatro da Pekka",
            "Arena Real",
            "Pico Congelado",
            "Arena de Selva",
            "Estádio goblin",
            "Fosso de Ossos",
            "Montanha Hog",
            "Electro Valley",
            "Cidade Assustadora"

                        
                
            
        );
    }

    private static List<Monstro> criarBestiario() {
        List<Monstro> monstros = new ArrayList<>();
        monstros.add(new Servo(50, 10, 10));
        monstros.add(new Corredor(160, 30, 15, 10));
        monstros.add(new Esqueleto(30, 8, 12));;
        return monstros;
    }
}