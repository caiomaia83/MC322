package Fases;

import java.util.ArrayList;
import java.util.Collections; // Import necessário para embaralhar a lista
import java.util.List;
// Mantenha o import da sua classe Monstro, seja ela Monstros.Monstro ou Personagens.Monstro
import Monstros.Monstro; 

import Personagens.Monstro;

public class Fase {
    private int nivel;
    private String ambiente;
    private List<Monstro> monstros;

    public Fase(int nivel, String ambiente, List<Monstro> monstrosBase) {
        this.nivel = nivel;
        this.ambiente = ambiente;
        this.monstros = new ArrayList<>(); // Cria a lista final de monstros da fase

        // ---- INÍCIO DA LÓGICA DE SELEÇÃO ALEATÓRIA ----

        // 1. Cria uma cópia da lista de monstros base para poder embaralhá-la
        //    sem alterar a lista original que veio do ConstrutorDeCenario.
        List<Monstro> listaSorteavel = new ArrayList<>(monstrosBase);

        // 2. Embaralha a lista de forma aleatória.
        Collections.shuffle(listaSorteavel);

        // 3. Define quantos monstros pegar. Será 3 ou o tamanho da lista, o que for menor.
        //    Isso evita erros se a lista de monstros base tiver menos de 3.
        int quantidadeDeMonstros = Math.min(3, listaSorteavel.size());

        // 4. Pega os primeiros 'quantidadeDeMonstros' da lista embaralhada.
        List<Monstro> monstrosSelecionados = listaSorteavel.subList(0, quantidadeDeMonstros);
        
        // ---- FIM DA LÓGICA DE SELEÇÃO ALEATÓRIA ----


        // Fator de dificuldade: aumenta 15% por nível.
        double fatorDificuldade = 1.0 + (0.15 * nivel);

        // Agora, itera sobre a lista de APENAS 3 monstros selecionados aleatoriamente.
        for (Monstro monstroBase : monstrosSelecionados) {
            // Calcula os novos atributos
            int novaVida = (int) (monstroBase.getPontosVida() * fatorDificuldade);
            int novaForca = (int) (monstroBase.getForca() * fatorDificuldade);

            // A lógica de criação do monstro fortalecido permanece a mesma que antes
            // (seja com `new Monstro(...)` ou com o método `criarVersaoFortalecida`)
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