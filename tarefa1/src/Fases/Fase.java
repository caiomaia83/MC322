package Fases;
import java.util.ArrayList;
import java.util.List;

import Personagens.Monstro;

public class Fase {
    private int nivel;
    private String ambiente;
    private List<Monstro> monstros;

    public Fase(int nivel, String ambiente, List<Monstro> monstrosBase) {
        this.nivel = nivel;
        this.ambiente = ambiente;
        this.monstros = new ArrayList<>(); // Cria uma nova lista para a fase

        // Fator de dificuldade: aumenta 15% por nível.
        // Nível 1 = 1.15, Nível 2 = 1.30, etc.
        // Usamos (nivel - 1) para que no nível 1 o aumento não seja zero.
        double fatorDificuldade = 1.0 + (0.15 * nivel);

        // Itera sobre a lista de monstros base para criar versões mais fortes
        for (Monstro monstroBase : monstrosBase) {
            // Cria uma nova instância do monstro com os atributos aumentados
            Monstro monstroFortalecido = monstroBase.criarCopiaFortalecida(fatorDificuldade);

            // Adiciona o monstro fortalecido à lista de monstros da fase
            this.monstros.add(monstroFortalecido);
        }
    }

    /**
     * Método para iniciar e exibir as informações da fase.
     */
    public void iniciar() {
        System.out.println("--- Bem-vindo à Fase " + this.nivel + " ---");
        System.out.println("Cenário: " + this.ambiente);
        System.out.println("Monstros a serem derrotados:");

        for (Monstro monstro : this.monstros) {
            monstro.exibirStatus();
        }
        System.out.println("------------------------------------");
    }
}