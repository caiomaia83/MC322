package com.rpg.util;

public class Menu {

    public Menu() {
    }

    public int exibir() {
        System.out.println("\n===== MENU DO JOGO RPG =====");
        System.out.println("1. Iniciar Batalha");
        System.out.println("2. Ver Status do Personagem");
        System.out.println("0. Sair do Jogo");

        return InputManager.lerInteiro("Escolha uma opção: ", 1, 2);
    }
}
