package com.rpg.game.util;

import java.util.Scanner;
import java.util.InputMismatchException;


public class InputManager {

    private static final Scanner scanner = new Scanner(System.in);

    private InputManager() {
    }

    public static int lerInteiro(String mensagem, int min, int max) {
        while (true) { 
            try {
                System.out.print(mensagem);
                int numero = scanner.nextInt();
                scanner.nextLine();

                if (numero >= min && numero <= max) {
                    return numero; 
                } else {
                    System.out.println("Erro: Por favor, digite um número entre " + min + " e " + max + ".");
                }
            } catch (InputMismatchException e) {
                System.out.println("Erro: Entrada inválida. Por favor, digite um número inteiro.");
                scanner.nextLine(); 
            }
        }
    }
    public static String lerString(String mensagem) {
        System.out.print(mensagem);
        return scanner.nextLine();
    }

    public static void esperarEnter(String mensagem) {
        System.out.print(mensagem);
        scanner.nextLine();
    }

    public static boolean lerSimNao(String mensagem) {
        while (true) {
            System.out.print(mensagem + " (s/n) > ");
            String resposta = scanner.nextLine();
            if (resposta.equalsIgnoreCase("s")) {
                return true;
            } else if (resposta.equalsIgnoreCase("n")) {
                return false;
            } else {
                System.out.println("Erro: Resposta inválida. Por favor, digite 's' para sim ou 'n' para não.");
            }
        }
    }
    
    public static void fecharScanner() {
        scanner.close();
    }

    
}
