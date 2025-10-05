package com.rpg.cenario;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.rpg.personagens.Monstro;
import com.rpg.personagens.Monstros.*;
import com.rpg.game.*;

/**
 * Implementação concreta de {@link GeradorDeFases} que constrói o mundo do jogo.
 * <p>
 * Esta classe é a fábrica responsável por criar a sequência de fases de uma
 * partida. Ela seleciona ambientes, sorteia monstros de um bestiário pré-definido
 * e os fortalece com base na dificuldade escolhida pelo jogador.
 * </p>
 *
 * @author Fernando e Caio
 * @version 1.0
 * @since 2025-10-05
 */
public class ConstrutorDeCenario implements GeradorDeFases {

    public ConstrutorDeCenario() {}
    /**
     * {@inheritDoc}
     * <p>
     * Gera as fases iterativamente. Em cada iteração, um ambiente é selecionado,
     * um número aleatório de monstros (2 ou 3) é sorteado do bestiário, e cada
     * monstro é fortalecido usando o multiplicador da dificuldade do jogo antes
     * de ser adicionado a uma nova instância de {@link Fase}.
     * </p>
     */
    @Override
    public List<InterfaceFase> gerar(int quantidadeDeFases, Dificuldade dificuldade) {
        System.out.println("Construindo o mundo com " + quantidadeDeFases + " fases...(Dificuldade: " + dificuldade + ")");

        List<InterfaceFase> fasesGeradas = new ArrayList<>();
        List<TipoCenario> poolDeAmbientes = getAmbientes();
        List<Monstro> bestiario = criarBestiario();
        Random random = new Random();

        for (int i = 1; i <= quantidadeDeFases; i++) {
            int nivelAtual = i;
            TipoCenario ambienteAtual = poolDeAmbientes.get((nivelAtual - 1) % poolDeAmbientes.size());

            List<Monstro> monstrosParaFase = new ArrayList<>();
            int quantidadeMonstros = 2 + random.nextInt(2);
            for (int j = 0; j < quantidadeMonstros; j++) {
                int indiceAleatorio = random.nextInt(bestiario.size());

                Monstro monstro_base = bestiario.get(indiceAleatorio);

                double multiplicador = dificuldade.getMultiplicador();

                Monstro monstro_pronto = monstro_base.criarCopiaFortalecida(multiplicador);

                monstrosParaFase.add(monstro_pronto);
            }

            InterfaceFase novaFase = new Fase(nivelAtual, ambienteAtual, monstrosParaFase);
            fasesGeradas.add(novaFase);
        }

        System.out.println("Mundo construído com sucesso!\n");
        return fasesGeradas;
    }

    private List<TipoCenario> getAmbientes() {
        return List.of(TipoCenario.values());
    }

    private List<Monstro> criarBestiario() {
        List<Monstro> monstros = new ArrayList<>();
        monstros.add(new Servo(50, 10, 20));
        monstros.add(new Corredor(150, 25, 30, 10));
        monstros.add(new Esqueleto(30, 8, 15));
        return monstros;
    }
}
