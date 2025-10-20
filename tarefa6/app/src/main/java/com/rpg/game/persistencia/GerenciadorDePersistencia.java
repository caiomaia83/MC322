package com.rpg.game.persistencia;

import com.rpg.game.batalha.Batalha; // Importa a classe Batalha

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.util.ArrayList; // Import para listar saves
import java.util.List; // Import para listar saves

/**
 * Classe estática responsável por salvar e carregar 
 * o estado da Batalha em arquivos XML usando JAXB.
 */
public class GerenciadorDePersistencia {

    /**
     * Define o diretório onde os arquivos de save serão armazenados.
     */
    private static final String SAVE_DIRECTORY = "saves";

    /**
     * (Tarefa 3.1) Salva o estado atual da Batalha em um arquivo XML.
     *
     * @param batalha A instância da Batalha a ser salva.
     * @param nomeBatalha O nome do arquivo (sem extensão) para este save.
     */
    public static void salvarBatalha(Batalha batalha, String nomeBatalha) {
        if (batalha == null) {
            System.err.println("Tentativa de salvar uma batalha nula.");
            return;
        }

        try {
            //Cria o contexto JAXB
            JAXBContext context = JAXBContext.newInstance(Batalha.class);
            Marshaller marshaller = context.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true); // Formata o XML

            //  Garante que o diretório "saves" exista
            File saveDir = new File(SAVE_DIRECTORY);
            if (!saveDir.exists()) {
                saveDir.mkdirs(); // Cria o diretório se ele não existir
            }

            // Cria  o arquivo de destino
            File saveFile = new File(saveDir, nomeBatalha + ".xml");

            // 4. Salva (marshal) do objeto no arquivo
            marshaller.marshal(batalha, saveFile);

            System.out.println("Batalha salva com sucesso em: " + saveFile.getAbsolutePath());

        } catch (JAXBException e) {
            System.err.println("Erro ao salvar a batalha (JAXB): " + e.getMessage());
            e.printStackTrace();
        }
    }

    /**
     * Carrega um estado de Batalha a partir de um arquivo XML.
     *
     * @param nomeBatalha O nome do arquivo (sem extensão) a ser carregado.
     * @return A instância da Batalha carregada, ou null se falhar.
     */
    public static Batalha carregarBatalha(String nomeBatalha) {
        try {
            File saveFile = new File(SAVE_DIRECTORY, nomeBatalha + ".xml");

            if (!saveFile.exists()) {
                System.err.println("Arquivo de save não encontrado: " + saveFile.getAbsolutePath());
                return null;
            }

            JAXBContext context = JAXBContext.newInstance(Batalha.class);
            Unmarshaller unmarshaller = context.createUnmarshaller();

            Batalha batalhaCarregada = (Batalha) unmarshaller.unmarshal(saveFile);

            System.out.println("Batalha carregada com sucesso de: " + saveFile.getAbsolutePath());
            return batalhaCarregada;

        } catch (JAXBException e) {
            System.err.println("Erro ao carregar a batalha (JAXB): " + e.getMessage());
            e.printStackTrace();
            return null;
        }
    }

    /**
     * Verifica se existe algum arquivo de save .xml no diretório 'saves'.
     * @return true se houver saves, false caso contrário.
     */
    public static boolean existemJogosSalvos() {
        File saveDir = new File(SAVE_DIRECTORY);
        
        if (!saveDir.exists() || !saveDir.isDirectory()) {
            return false;
        }

        // Lista todos os arquivos que terminam com .xml
        File[] saveFiles = saveDir.listFiles((dir, name) -> name.toLowerCase().endsWith(".xml"));
        
        return saveFiles != null && saveFiles.length > 0;
    }

    /**
     * Lista os nomes de todos os arquivos de save encontrados.
     * @return Uma lista de Strings com os nomes dos saves (sem a extensão .xml).
     */
    public static List<String> listarJogosSalvos() {
        List<String> nomesDosSaves = new ArrayList<>();
        File saveDir = new File(SAVE_DIRECTORY);

        if (!saveDir.exists() || !saveDir.isDirectory()) {
            return nomesDosSaves; // Retorna lista vazia
        }

        File[] saveFiles = saveDir.listFiles((dir, name) -> name.toLowerCase().endsWith(".xml"));

        if (saveFiles != null) {
            for (File saveFile : saveFiles) {
                String nome = saveFile.getName();
                nomesDosSaves.add(nome.substring(0, nome.lastIndexOf('.')));
            }
        }
        return nomesDosSaves;
    }
}