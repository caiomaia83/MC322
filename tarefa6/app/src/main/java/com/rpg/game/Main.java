package com.rpg.game;

import com.rpg.game.batalha.Batalha;
import com.rpg.game.persistencia.GerenciadorDePersistencia;
import com.rpg.game.util.InputManager;
import java.util.List;

/**
 * (Ponto de entrada principal do jogo.
 * Responsável pelo menu inicial (Novo Jogo, Carregar Jogo)
 * e por delegar a execução para a classe Batalha.
 */
public class Main {

    public static void main(String[] args) {
        System.out.println("=====================================================");
        System.out.println("          BEM-VINDO ÀS ARENAS!!!");
        System.out.println("=====================================================");

        Batalha batalha = null; // A sessão de jogo atual (inicia nula)
        boolean sairDoPrograma = false;

        while (!sairDoPrograma) {
            // verifica se existem jogos salvos
            boolean existemSaves = GerenciadorDePersistencia.existemJogosSalvos();
            
            // Chama o menu inicial
            int opcao = exibirMenuPrincipal(existemSaves);
            
            switch (opcao) {
                //  Inicia uma nova batalha
                case 1:
                    System.out.println("\nIniciando uma nova aventura...");
                    // O Herói é instanciado DENTRO da Batalha
                    batalha = new Batalha(true); 
                    // Entra no loop de jogo
                    jogarAventura(batalha); 
                    batalha = null; // Limpa a sessão ao sair da aventura
                    break;
                
                // Carrega uma batalha salva
                case 2:
                    if (existemSaves) {
                        String nomeSave = selecionarSave();
                        if (nomeSave != null) {
                            batalha = Batalha.carregarJogo(nomeSave);
                            if (batalha != null) {
                                // Entra no loop de jogo
                                jogarAventura(batalha); 
                            }
                        }
                        batalha = null; // Limpa a sessão ao sair da aventura
                    } else {
                        System.out.println("Opção inválida.");
                    }
                    break;

                case 0:
                    sairDoPrograma = true;
                    break;
                    
                default:
                    System.out.println("Opção inválida. Tente novamente.");
                    break;
            }
        }
    
        System.out.println("=====================================================");
        System.out.println("                  FIM DE JOGO");
        System.out.println("=====================================================");
    }

    /**
     * Exibe o menu principal e retorna a escolha do usuário.
     * @param temSaves Indica se a opção "Carregar Jogo" deve ser exibida.
     */
    private static int exibirMenuPrincipal(boolean temSaves) {
        System.out.println("\n--- MENU PRINCIPAL ---");
        System.out.println("[1] Nova Aventura");
        if (temSaves) {
            System.out.println("[2] Carregar Jogo");
        }
        System.out.println("[0] Sair do Jogo");
        
        return InputManager.lerInteiro("> ", 0, (temSaves ? 2 : 1));
    }

    /**
     * Exibe os jogos salvos e permite ao usuário escolher um.
     * @return O nome do save escolhido, ou null se cancelar.
     */
    private static String selecionarSave() {
        List<String> saves = GerenciadorDePersistencia.listarJogosSalvos();
        if (saves.isEmpty()) {
            System.out.println("Nenhum jogo salvo encontrado.");
            return null;
        }

        System.out.println("\n--- CARREGAR JOGO ---");
        for (int i = 0; i < saves.size(); i++) {
            System.out.printf("[%d] %s\n", (i + 1), saves.get(i));
        }
        System.out.println("[0] Voltar ao Menu");

        int escolha = InputManager.lerInteiro("> ", 0, saves.size());
        if (escolha == 0) {
            return null; // Cancelou
        }
        return saves.get(escolha - 1); // Retorna o nome do save
    }

    /**
     * Gerencia o loop "dentro do jogo" (Continuar, Salvar, Sair da Aventura).
     * @param batalha A sessão de jogo ativa.
     */
    private static void jogarAventura(Batalha batalha) {
        boolean sairDaAventura = false;
        
        while (!sairDaAventura && !batalha.isAventuraConcluida()) {
            
            System.out.println("\n--- AVENTURA EM PROGRESSO ---");
            System.out.println("Fase atual: " + (batalha.getFaseAtualIndex() + 1));
            System.out.println("[1] Continuar (Jogar Fase)");
            // (Tarefa 3.3) Opção de Salvar Jogo
            System.out.println("[2] Salvar Jogo");
            System.out.println("[3] Exibir Status do Herói");
            System.out.println("[0] Desistir (Voltar ao Menu Principal)");

            int opcao = InputManager.lerInteiro("> ", 0, 3);

            switch (opcao) {
                case 1:
                    batalha.executarProxFase();
                    break;
                case 2:
                    String nomeSave = InputManager.lerString("Digite um nome para seu save");
                    batalha.salvarJogo(nomeSave);
                    break;
                case 3:
                    batalha.exibirStatusHeroi();
                    break;
                case 0:
                    sairDaAventura = true;
                    break;
            }
        }
        
        if (batalha.isAventuraConcluida()) {
            System.out.println("Aventura concluída.");
        } else {
            System.out.println("Voltando ao menu principal...");
        }
    }
}