package Fases;

import java.util.ArrayList;
import java.util.List;
import Monstros.Monstro;

public class ConstrutorDeCenario {

    private ConstrutorDeCenario() {}


    public static List<Fase> gerarFases(int nFases) {
        List<Fase> fasesGeradas = new ArrayList<>();

        // 1. Define uma lista de monstros base que aparecerão em todas as fases
        //    (a dificuldade deles será ajustada pelo construtor da Fase).
        List<Monstro> monstrosBase = new ArrayList<>();
        // aqui vamos add todos os nossos monstros base
        monstrosBase.add(new Monstro("Corredor", 50, 8));
        monstrosBase.add(new Monstro("Esqueleto", 80, 12));
        monstrosBase.add(new Monstro("Servos", 100, 15));

        // 2. Define uma lista de ambientes para variar o cenário
        String[] ambientes = {
    "Estádio Goblin",
    "Fosso dos Ossos",
    "Torneio Bárbaro",
    "Parquinho da P.E.K.K.A",
    "Vale dos Feitiços",
    "Oficina do Construtor",
    "Arena Real",
    "Pico Congelado",
    "Arena da Selva",
    "Montanha do Porco",
    "Eletrovale",
    "Cidade Assombrada",
    "Covil dos Patifes",
    "Pico Sereno",
    "Mina do Mineiro",
    "Cozinha do Executor",
    "Cripta Real",
    "Santuário Silencioso",
    "Spa do Dragão",
    "Campo de Treinamento",
    "Clash Fest",
    "PANQUECAS!",
    "Valhalla",
    "Arena Lendária"

        };

        // 3. Loop para criar cada fase
        for (int i = 1; i <= nFases; i++) {
            // Seleciona um ambiente da lista. Usa o operador de módulo (%) para
            // repetir os ambientes se nFases for maior que a lista de ambientes.
            String ambienteDaFase = ambientes[(i - 1) % ambientes.length];

            // Cria a nova fase. O construtor da classe Fase já lida com o
            // aumento da força e vida dos monstros com base no nível 'i'.
            Fase novaFase = new Fase(i, ambienteDaFase, monstrosBase);

            // Adiciona a fase recém-criada à lista de retorno
            fasesGeradas.add(novaFase);
        }

        return fasesGeradas;
    }
}