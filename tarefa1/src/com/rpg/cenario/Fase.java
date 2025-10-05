package com.rpg.cenario;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.rpg.personagens.*;

/**
 * Representa uma fase ou nível do jogo.
 * <p>
 * Esta classe é responsável por gerenciar uma etapa do jogo, incluindo a
 * geração de monstros com dificuldade escalonada, a aplicação de efeitos
 * do cenário e a verificação das condições de vitória (todos os monstros derrotados).
 * </p>
 *
 * @author Fernando e Caio
 * @version 1.0
 * @since 2025-10-05
 */
public class Fase implements InterfaceFase { 
    private int nivel;
    private TipoCenario tipoCenario; 
    private List<Monstro> monstros;

        
    /**
     * Constrói uma nova Fase, gerando encontros de monstros aleatórios e fortalecidos.
     * <p>
     * O construtor seleciona aleatoriamente até 3 monstros da lista base fornecida.
     * Em seguida, calcula um fator de dificuldade com base no nível da fase e usa o
     * método {@link Monstro#criarCopiaFortalecida(double)} para criar versões
     * mais fortes dos monstros selecionados, que serão os inimigos reais da fase.
     * </p>
     *
     * @param nivel O nível desta fase, usado para escalar a dificuldade dos monstros.
     * @param tipoCenario O cenário da fase, que pode aplicar efeitos especiais.
     * @param monstrosBase Uma lista de "modelos" de monstros para sortear os inimigos da fase.
     */
    public Fase(int nivel, TipoCenario tipoCenario, List<Monstro> monstrosBase) {
        this.nivel = nivel;
        this.tipoCenario = tipoCenario;
        this.monstros = new ArrayList<>();

        List<Monstro> listaSorteavel = new ArrayList<>(monstrosBase);
        Collections.shuffle(listaSorteavel);
        int quantidadeDeMonstros = Math.min(3, listaSorteavel.size());
        List<Monstro> monstrosSelecionados = listaSorteavel.subList(0, quantidadeDeMonstros);
        double fatorDificuldade = 1.0 + (0.15 * nivel);
        for (Monstro monstroBase : monstrosSelecionados) {
            Monstro monstroFortalecido = monstroBase.criarCopiaFortalecida(fatorDificuldade);
            this.monstros.add(monstroFortalecido);
        }
    }
    /**
     * {@inheritDoc}
     * 
     * Prepara e exibe o início da fase para o jogador. Este método cura
     * completamente o herói, aplica os efeitos do cenário e mostra o status
     * inicial de todos os combatentes.
     * 
     */
    @Override
    public void iniciar(Heroi heroi) {
        System.out.println("\n--- FASE " + this.nivel + ": " + this.tipoCenario.name().replace("_", " ") + " ---");
        // Usando a descrição que colocamos no Enum
        System.out.println(this.tipoCenario.getDescricao());
        // Usando o efeito que colocamos no Enum
        this.tipoCenario.aplicarEfeitos(heroi);

        heroi.receberCura(heroi.getPontosDeVidaTotal());
        heroi.exibirStatus();

        System.out.println("\nMonstros a serem derrotados:");
        for (Monstro monstro : this.monstros) {
            monstro.exibirStatus();
        }
        System.out.println("------------------------------------");
    }

    @Override
    public boolean isConcluida() {
        for (Monstro monstro : this.monstros) {
            if (monstro.estaVivo()) {
                return false; // Encontrou um monstro vivo, fase não concluída
            }
        }
        return true; // Nenhum monstro vivo encontrado, fase concluída
    }

    @Override
    public TipoCenario getTipoDeCenario() {
        return this.tipoCenario;
    }

    public List<Monstro> getMonstros() {
        return this.monstros;
    }

    public int getNivel() {
        return this.nivel;
    }
}