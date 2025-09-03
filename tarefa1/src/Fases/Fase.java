package Fases;

import java.util.ArrayList;
import java.util.List;
import Monstros.Monstro;

public class Fase {
    private int nivel;
    private String ambiente;
    private List<Monstro> monstros;

    /**
     * Construtor da Fase.
     * Inicializa os atributos e aplica o aumento de dificuldade nos monstros
     * com base no nível da fase.
     *
     * @param nivel O nível da fase.
     * @param ambiente A descrição do cenário da fase.
     * @param monstrosBase A lista de monstros com seus status originais.
     */
    public Fase(int nivel, String ambiente, List<Monstro> monstrosBase) {
        this.nivel = nivel;
        this.ambiente = ambiente;
        this.monstros = new ArrayList<>(); // Cria uma nova lista para a fase

        // Fator de dificuldade: aumenta 15% por nível.
        double fatorDificuldade = 1.0 + (0.15 * nivel);

        // Itera sobre a lista de monstros base para criar versões mais fortes
        for (Monstro monstroBase : monstrosBase) {
            // Calcula os novos atributos
            int novaVida = (int) (monstroBase.getPontosVida() * fatorDificuldade);
            int novaForca = (int) (monstroBase.getForca() * fatorDificuldade);

            // Cria uma nova instância do monstro com os atributos aumentados
            Monstro monstroFortalecido = new Monstro(monstroBase.getNome(), novaVida, novaForca);

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