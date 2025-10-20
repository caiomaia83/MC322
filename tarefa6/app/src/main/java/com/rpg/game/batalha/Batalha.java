package com.rpg.game.batalha;


import java.util.List;
import java.util.ArrayList;
import com.rpg.game.cenario.*;
import com.rpg.game.combate.*;
import com.rpg.game.itens.*;
import com.rpg.game.itens.Loot.*;
import com.rpg.game.personagens.*;
import com.rpg.game.personagens.Herois.*;
import com.rpg.game.personagens.Monstros.*; 
import com.rpg.game.util.*;
import com.rpg.game.exceptions.*;
import com.rpg.game.itens.Armas.Arma;

// Imports de Itens (para @XmlSeeAlso)
import com.rpg.game.itens.Armas.ArmasBase.Gerais.*;
import com.rpg.game.itens.Armas.ArmasMonstros.Corredor.*;
// ... (Adicione TODOS os seus itens e armas aqui) ...

// Imports para Persistência (JAXB)
import com.rpg.game.persistencia.GerenciadorDePersistencia;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlTransient; // Para ignorar campos

/**
 * Controla o estado de uma aventura de RPG, 
 * implementando o loop de fases e guardando o estado do jogo.
 */
@XmlRootElement 
@XmlAccessorType(XmlAccessType.PROPERTY) // Diz ao JAXB para usar Getters/Setters
@XmlSeeAlso({
    // Heróis:
    Barbaro.class, Arqueira.class, RecrutaReal.class,
    
    // Monstros:
    Esqueleto.class, Corredor.class, Servo.class,
    
    // Cenario:
    Fase.class,
    
    // Itens e Armas:
    DemolidorDeTorres.class, EspadaCurta.class, GalhoRobusto.class,
    /* ... adicione todas as outras classes de itens aqui ... */
})
public class Batalha {

    // --- Campos de Estado (Serão Salvos) ---
    private Heroi heroi;
    private List<Fase> fases; 
    private int faseAtualIndex;
    private Dificuldade dificuldade;
    private boolean aventuraConcluida;

    /**
     * Construtor padrão (vazio).
     * OBRIGATÓRIO para o JAXB funcionar (ao carregar o jogo).
     */
    public Batalha() {
        this.fases = new ArrayList<>(); // Sempre inicialize coleções
    }

    /**
     * Construtor para criar uma NOVA Aventura.
     * Este construtor agora é responsável por criar o Herói.
     * @param novoJogo Um booleano 'dummy'para diferenciar do construtor JAXB.
     */
    public Batalha(boolean novoJogo) {
        this(); // Chama o construtor vazio para inicializar listas

        // CRIAÇÃO DO HERÓI (Composição, conforme Tarefa 3.4)
        // (Aqui você pode adicionar um menu "selecionarHeroi()")
        this.heroi = new Barbaro("Conan, o Bárbaro", 150, 30);
        System.out.println(this.heroi.getNome() + " foi criado!");

        // GERAÇÃO DO MUNDO (Lógica da Main antiga)
        this.faseAtualIndex = 0;
        this.aventuraConcluida = false;
        
        GeradorDeFases gerador = new ConstrutorDeCenario(); 
        int numeroDeFases = 3; // Você pode transformar isso em um parâmetro
        this.dificuldade = selecionarDificuldade(); // Usa o método auxiliar
        

        List<InterfaceFase> tempFases = gerador.gerar(numeroDeFases, this.dificuldade);
        for (InterfaceFase f : tempFases) {
            this.fases.add((Fase) f); // Faz o cast para a classe concreta 'Fase'
        }

        //  APRESENTAÇÃO DA AVENTURA
        System.out.println("\n" + heroi.getNome() + ", um corajoso " + heroi.getClass().getSimpleName() + ", adentra a escuridão!");
        System.out.println("Ele deve sobreviver a " + this.fases.size() + " fase(s) para clamar a glória!");
    }

    // ==========================================
    // ==    Métodos Requisitados (API)        ==
    // ==========================================

    /**
     *  Método para carregar um jogo.
     * Utiliza o GerenciadorDePersistencia para carregar a Batalha.
     */
    public static Batalha carregarJogo(String nomeBatalha) {
        System.out.println("Carregando jogo '" + nomeBatalha + "'...");
        Batalha batalhaCarregada = GerenciadorDePersistencia.carregarBatalha(nomeBatalha);

        if (batalhaCarregada != null) {
            System.out.println("Jogo carregado. Bem-vindo de volta, " + batalhaCarregada.getHeroi().getNome() + "!");
            System.out.println("Continuando da Fase " + (batalhaCarregada.getFaseAtualIndex() + 1));
        }
        return batalhaCarregada;
    }

    /**
     * Executa a próxima fase incompleta da aventura.
     * Contém todo o loop de combate e a lógica pós-combate (XP, loot).
     */
    public void executarProxFase() {
        // --- 1Verificações de Estado ---
        if (aventuraConcluida) {
            System.out.println("A aventura já foi concluída! " + (heroi.estaVivo() ? "Você venceu!" : "Você foi derrotado."));
            return;
        }
        if (!heroi.estaVivo()) {
            System.out.println(heroi.getNome() + " está incapacitado. A aventura não pode continuar.");
            this.aventuraConcluida = true; // Marca como concluída (derrota)
            return;
        }
        if (faseAtualIndex >= fases.size()) {
            System.out.println("Erro interno: Não há mais fases para executar.");
            this.aventuraConcluida = true;
            return;
        }

        // --- inicia a Fase ---
        Fase faseAtual = fases.get(faseAtualIndex);
        System.out.println("\n=====================================================");
        System.out.println("            INICIANDO FASE " + faseAtual.getNivel());
        System.out.println("=====================================================");
        faseAtual.iniciar(heroi);
        
        // --- Loop de Monstros ---
        List<Monstro> monstrosDaFase = faseAtual.getMonstros();
        for (Monstro monstroAtual : monstrosDaFase) {
            if (!monstroAtual.estaVivo()) continue; 

            System.out.println("\n" + heroi.getNome() + " encara um " + monstroAtual.getNome() + "!");

            // --- Loop de Combate ---
            while (heroi.estaVivo() && monstroAtual.estaVivo()) {
                // ... (Turno do Herói) ...
                heroi.exibirStatus();
                monstroAtual.exibirStatus();
                System.out.println("\n--- Turno do " + heroi.getNome() + " ---");
                AcaoCombate acaoHeroi = heroi.escolherAcao(monstroAtual);
                if (acaoHeroi != null) {
                    try {
                        acaoHeroi.executar(heroi, monstroAtual);
                    } catch (RecursoInsuficiente e) {
                        System.out.println("!!! " + e.getMessage() + " !!!");
                    } catch (Exception e) {
                        System.out.println("Erro inesperado na ação do herói: " + e.getMessage());
                    }
                } 

                // ... (Turno do Monstro) ...
                if (monstroAtual.estaVivo()) {
                    heroi.exibirStatus();
                    monstroAtual.exibirStatus();
                    System.out.println("\n--- Turno do " + monstroAtual.getNome() + " ---");
                    AcaoCombate acaoMonstro = monstroAtual.escolherAcao(heroi);
                    if (acaoMonstro != null) {
                        try {
                            acaoMonstro.executar(monstroAtual, heroi);
                        } catch (Exception e) {
                            System.out.println("Erro inesperado na ação do monstro: " + e.getMessage());
                        }
                    } 
                }
            } // --- Fim do Combate ---

 // --- Lógica Pós-Combate (Corrigida) ---
            if (!monstroAtual.estaVivo() && heroi.estaVivo()) {
                System.out.println("\nO " + monstroAtual.getNome() + " foi derrotado!");
                heroi.ganharExperiencia(monstroAtual);

                // Tentativa de dropar uma arma
                if (monstroAtual instanceof Lootavel) {
                    // Define a sorte para o drop (pode vir do herói ou ser fixa)
                    float sorteParaDrop = 0.5f; // Exemplo: 50%
                    // Chame o MÉTODO largaArma() com o argumento da sorte
                    Arma armaDropada = ((Lootavel) monstroAtual).largaArma(sorteParaDrop);

                    if (armaDropada != null) {
                        System.out.println(monstroAtual.getNome() + " deixou cair uma arma: " + armaDropada.getNome() + "!");
                        System.out.println("--- Arma Dropada ---");
                        armaDropada.exibirStatusArma();
                        System.out.println("--- Sua Arma Atual ---");
                        if (heroi.getArmaEquipada() != null) {
                            heroi.getArmaEquipada().exibirStatusArma(); // Call directly
                        } else {
                            System.out.println("Nenhuma");
                        }

                        boolean equipar = InputManager.lerSimNao("Equipar a nova arma?");

                        if (equipar) {
                            try {
                                heroi.equiparArma(armaDropada);
                                System.out.println(heroi.getNome() + " equipou " + armaDropada.getNome() + ".");
                            } catch (NivelInsuficiente e) {
                                System.out.println("!!! " + e.getMessage() + " !!!");
                            }
                        } else {
                            
                            System.out.println("Você deixa a " + armaDropada.getNome() + ".");
                        }
                    }

                } 
            } 

            // Verifica se o herói morreu DURANTE ou APÓS o combate com ESTE monstro
            if (!heroi.estaVivo()) {
                break; // Sai do loop FOR dos monstros
            }
        }
        //  Lógica Pós-Fase (Lógica da Main antiga) ---
        if (!heroi.estaVivo()) {
            System.out.println("\n-----------------------------------------------------");
            System.out.println("  GAME OVER! " + heroi.getNome() + " tombou bravamente...");
            System.out.println("-----------------------------------------------------");
            this.aventuraConcluida = true;
            return; 
        }
        
        // ( menu pós combate
        if (faseAtual.isConcluida()) {
            System.out.println("\n--- FASE " + faseAtual.getNivel() + " CONCLUÍDA! ---");
            this.faseAtualIndex++; // Avança para a próxima fase
            exibirStatusHeroi(); 
        }

        // Verificação de Fim da Aventura ---
        if (faseAtualIndex >= fases.size()) {
            System.out.println("\n-----------------------------------------------------");
            System.out.println("  VITÓRIA! " + heroi.getNome() + " conquistou a masmorra!");
            System.out.println("-----------------------------------------------------");
            this.aventuraConcluida = true;
        }
    }

    // ==========================================
    // ==      Outros Métodos (Auxiliares)     ==
    // ==========================================

    /**
     * Salva o estado atual desta Batalha em um arquivo.
     */
    public void salvarJogo(String nomeBatalha) {
        System.out.println("Salvando jogo em '" + nomeBatalha + ".xml'...");
        GerenciadorDePersistencia.salvarBatalha(this, nomeBatalha);
    }

    /** Exibe o status atual do herói. */
    public void exibirStatusHeroi() {
        System.out.println("\n--- STATUS ATUAL DO HERÓI ---");
        heroi.exibirStatus();
        System.out.println("---------------------------------");
    }

    public boolean isAventuraConcluida() {
        return this.aventuraConcluida;
    }
    
    public int getFaseAtualIndex() {
        return this.faseAtualIndex;
    }

    private Dificuldade selecionarDificuldade() {
        System.out.println("\nSELECIONE A DIFICULDADE DA AVENTURA:");
        System.out.println("[1] Fácil");
        System.out.println("[2] Normal");
        System.out.println("[3] Difícil");
        int escolha = InputManager.lerInteiro("> ", 1, 3);
        switch (escolha) {
            case 1: return Dificuldade.FACIL;
            case 3: return Dificuldade.DIFICIL;
            default: return Dificuldade.MEDIO;
        }
    }

    // ==========================================
    // ==   Getters e Setters (PARA JAXB)      ==
    // ==========================================

    @XmlElement
    public Heroi getHeroi() { return heroi; }
    public void setHeroi(Heroi heroi) { this.heroi = heroi; }

    @XmlElement(name="fase")
    public List<Fase> getFases() { return fases; }
    public void setFases(List<Fase> fases) { this.fases = fases; }
    
    @XmlElement
    public int getFaseAtual() { return faseAtualIndex; }
    public void setFaseAtual(int faseAtualIndex) { this.faseAtualIndex = faseAtualIndex; }

    @XmlElement
    public Dificuldade getDificuldade() { return dificuldade; }
    public void setDificuldade(Dificuldade dificuldade) { this.dificuldade = dificuldade; }

    @XmlElement
    public boolean getAventuraConcluida() { return aventuraConcluida; }
    public void setAventuraConcluida(boolean aventuraConcluida) { this.aventuraConcluida = aventuraConcluida; }
}