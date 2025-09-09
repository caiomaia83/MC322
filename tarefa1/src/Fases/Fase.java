package Fases;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import Personagens.Monstro;

public class Fase {
    private int nivel;
    private String ambiente;
    private List<Monstro> monstros;

    public Fase(int nivel, String ambiente, List<Monstro> monstrosBase) {
        this.nivel = nivel;
        this.ambiente = ambiente;
        this.monstros = new ArrayList<>(); // Cria a lista final de monstros da fase

        // A lógica de seleção aleatória de monstros está correta.
        List<Monstro> listaSorteavel = new ArrayList<>(monstrosBase);
        Collections.shuffle(listaSorteavel);
        int quantidadeDeMonstros = Math.min(3, listaSorteavel.size());
        List<Monstro> monstrosSelecionados = listaSorteavel.subList(0, quantidadeDeMonstros);
        
        // Fator de dificuldade: aumenta 15% por nível.
        double fatorDificuldade = 1.0 + (0.15 * nivel);

        // Itera sobre os monstros selecionados para criar suas versões fortalecidas.
        for (Monstro monstroBase : monstrosSelecionados) {
        
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

    /**
     * Retorna a lista de monstros desta fase para que possam ser combatidos.
     * @return A lista de monstros.
     */
    public List<Monstro> getMonstros() {
        return this.monstros;
    }

    /**
     * Retorna o nível atual da fase.
     * @return O número do nível.
     */
    public int getNivel() {
        return this.nivel;
    }
}
