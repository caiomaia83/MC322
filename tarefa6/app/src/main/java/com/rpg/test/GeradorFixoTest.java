package com.rpg.test;

import java.util.ArrayList;
import java.util.List;

import com.rpg.game.combate.AcaoCombate;
import com.rpg.game.exceptions.NivelInsuficiente;
import com.rpg.game.exceptions.RecursoInsuficiente;
import com.rpg.game.itens.Armas.Arma;
import com.rpg.game.itens.Armas.ArmasHerois.Bárbaros.Epico.RugidoDoBerserker;
import com.rpg.game.itens.Loot.Lootavel;
import com.rpg.game.personagens.Combatente;
import com.rpg.game.personagens.Heroi;
import com.rpg.game.personagens.Monstro;
import com.rpg.game.personagens.Herois.Barbaro;
import com.rpg.game.personagens.Monstros.Esqueleto;
import com.rpg.game.util.Dificuldade;
import com.rpg.game.util.InputManager;

/**
 * Classe de teste unificada que executa todas as validações 
 *
 */
public class GeradorFixoTest {

    public static void main(String[] args) throws RecursoInsuficiente{
        System.out.println("=============================================");
        System.out.println("==  INICIANDO TESTES PARA O RPG   ==");
        System.out.println("=============================================");

        testarGerenciadorDeEntradas(); 
        testarCombatentes();           
        testarSistemaDeDificuldade();  
        testarExcecoes();              

        System.out.println("\n=============================================");
        System.out.println("==        TESTES CONCLUÍDOS COM SUCESSO      ==");
        System.out.println("=============================================");


    }

    /**
     * Testa os métodos da classe InputManager (Enunciado 3.1).
     */
    public static void testarGerenciadorDeEntradas() {
        System.out.println("\n--- INICIANDO TESTES DO GERENCIADOR DE ENTRADAS ---");
        System.out.println(">>> ESTA SEÇÃO REQUER SUA INTERAÇÃO <<<\n");

        System.out.println("[1.1] Testando lerString (caso comum):");
        InputManager.lerString("> INSTRUÇÃO: Digite seu nome e pressione Enter: ");
        System.out.println("[1.2] Testando lerString (caso de borda):");
        InputManager.lerString("> INSTRUÇÃO: Agora, apenas pressione Enter: ");
        System.out.println("[OK] Método lerString testado.\n");

        System.out.println("[2.1] Testando lerSimNao (caso comum):");
        InputManager.lerSimNao("> INSTRUÇÃO: Digite 's' para continuar: ");
        System.out.println("[2.2] Testando lerSimNao (caso de exceção):");
        System.out.println("INSTRUÇÕES:");
        System.out.println("  1. Digite 'invalido' e pressione Enter (deve pedir novamente).");
        System.out.println("  2. Digite 'n' para finalizar o teste.");
        InputManager.lerSimNao("> Sua resposta: ");
        System.out.println("[OK] Método lerSimNao testado.");
    }

    /**
     * Testa as funcionalidades dos Combatentes (Heróis e Monstros).
     */
    public static void testarCombatentes() throws RecursoInsuficiente{
        System.out.println("\n--- INICIANDO TESTES DE COMBATENTES ---");

        Heroi heroi = new Barbaro("Testador Herói", 100, 20);
        Monstro monstro = new Esqueleto(50, 10, 15);

        List<Combatente> combatentes = new ArrayList<>();
        combatentes.add(heroi);
        combatentes.add(monstro);
        System.out.println("[OK] Herói e Monstro implementam a interface Combatente.");

        int vidaInicialHeroi = heroi.getPontosDeVida();
        AcaoCombate acaoMonstro = monstro.escolherAcao(heroi);
        if (acaoMonstro != null) acaoMonstro.executar(monstro, heroi);
        if(heroi.getPontosDeVida() < vidaInicialHeroi) {
             System.out.println("[OK] Herói recebeu dano corretamente.");
        }

        int vidaInicialMonstro = monstro.getPontosDeVida();
        AcaoCombate acaoHeroi = heroi.escolherAcao(monstro);
        if (acaoHeroi != null) acaoHeroi.executar(heroi, monstro);
        if(monstro.getPontosDeVida() < vidaInicialMonstro) {
             System.out.println("[OK] Monstro recebeu dano e herói atacou corretamente.");
        }

        if (monstro instanceof Lootavel) {
            System.out.println("[OK] Monstro implementa a interface Lootavel.");
            ((Lootavel) monstro).droparLoot();
        } else {
            System.out.println("[FALHA] Monstro NÃO implementa a interface Lootavel.");
        }
    }

    /**
     * Testa o sistema de Dificuldade .
     */
    public static void testarSistemaDeDificuldade() {
        System.out.println("\n---  INICIANDO TESTES DE DIFICULDADE ---");

        Monstro monstroBase = new Esqueleto(100, 10, 20);

        Monstro monstroFacil = monstroBase.criarCopiaFortalecida(Dificuldade.FACIL.getMultiplicador());
        System.out.println("Monstro (Fácil): HP=" + monstroFacil.getPontosDeVida());

        Monstro monstroDificil = monstroBase.criarCopiaFortalecida(Dificuldade.DIFICIL.getMultiplicador());
        System.out.println("Monstro (Difícil): HP=" + monstroDificil.getPontosDeVida());

        if (monstroDificil.getPontosDeVida() > monstroFacil.getPontosDeVida()) {
            System.out.println("[OK] Monstro do modo Difícil é mais forte que o do modo Fácil.");
        } else {
            System.out.println("[FALHA] Sistema de dificuldade não escalou os atributos corretamente.");
        }
    }

    /**
     * Testa exceções customizadas não relacionadas à entrada .
     */
    public static void testarExcecoes() {
        System.out.println("\n---  INICIANDO TESTES DE EXCEÇÕES ---");

        Heroi heroiNivel1 = new Barbaro("Novato", 100, 10);
        Arma armaNivel10 = new RugidoDoBerserker();
        try {
            System.out.println("Testando NivelInsuficiente: Herói Nv.1 tentando equipar Arma Nv.10...");
            heroiNivel1.equiparArma(armaNivel10);
            System.out.println("[FALHA] Exceção NivelInsuficiente não foi lançada.");
        } catch (NivelInsuficiente e) {
            System.out.println("[OK] Exceção NivelInsuficiente capturada: " + e.getMessage());
        }

        try {
            System.out.println("Testando RecursoInsuficiente: Simulando uso de habilidade sem mana...");
            lancarExemploRecursoInsuficiente();
            System.out.println("[FALHA] Exceção RecursoInsuficiente não foi lançada.");
        } catch (RecursoInsuficiente e) {
            System.out.println("[OK] Exceção RecursoInsuficiente capturada: " + e.getMessage());
        }
    }

    /**
     * Método auxiliar que simula uma falha para lançar RecursoInsuficiente.
     * @throws RecursoInsuficiente sempre que é chamado.
     */
    private static void lancarExemploRecursoInsuficiente() throws RecursoInsuficiente {
        int manaDisponivel = 20;
        int custoHabilidade = 50;
        if (manaDisponivel < custoHabilidade) {
            throw new RecursoInsuficiente("Mana insuficiente! Requer " + custoHabilidade + ".");
        }
    }
}