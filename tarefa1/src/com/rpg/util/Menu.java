package com.rpg.util;

import java.util.Scanner;

public class Menu {

    private Scanner scanner;

    public Menu() {
        this.scanner = new Scanner(System.in);
    }

    public int exibir() {
        System.out.println("\n===== MENU DO JOGO RPG =====");
        System.out.println("1. Iniciar Batalha");
        System.out.println("2. Ver Status do Personagem");
        System.out.println("3. Loja de Itens");
        System.out.println("4. Salvar Jogo");
        System.out.println("0. Sair do Jogo");
        System.out.print("Escolha uma opção: ");

        int opcao = -1;
        if (scanner.hasNextInt()) {
            opcao = scanner.nextInt();
        } else {
            System.out.println("Erro: Por favor, digite um número válido.");
            scanner.next(); 
        }
        return opcao;
    }

    public void fechar() {
        scanner.close();
    }
}