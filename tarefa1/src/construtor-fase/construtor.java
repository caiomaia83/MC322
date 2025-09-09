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
        monstrosBase.add(new Monstro("Goblin Lanceiro", 50, 8));
        monstrosBase.add(new Monstro("Orc Grunt", 80, 12));

        // 2. Define uma lista de ambientes para variar o cenário
        String[] ambientes = {
            "Floresta Sombria",
            "Caverna de Cristal",
            "Pântano Apodrecido",
            "Ruínas de um Castelo",
            "Vulcão Adormecido"
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