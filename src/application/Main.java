package application;

import entities.Convidado;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        List<Convidado> convidado = new ArrayList<>();
        int resposta = 0;

        do {
            System.out.println(" Lista de convidados ");
            System.out.println("1. Ver lista");
            System.out.println("2. Adicionar pessoa");
            System.out.println("3. Remover pessoa");
            System.out.println("4. sair");

            try {
                resposta = sc.nextInt();
                sc.nextLine();

                switch (resposta) {
                    case 1:
                        for (int i = 0; i < convidado.size(); i++) {
                            System.out.println(i + 1 + " - " + convidado.get(i));
                        }
                        if (convidado.isEmpty()) {
                            System.out.println("Lista vazia");
                        }
                        break;
                    case 2:
                        System.out.println("Nome do convidado:");
                        String nome = sc.nextLine();

                        int idade = 0;

                        while (true) {
                            try {
                                System.out.println("Idade do convidado:");
                                idade = sc.nextInt();
                                sc.nextLine();

                                break;

                            } catch (InputMismatchException e) {
                                System.out.println("ERRO: Idade inválida. Por favor, digite apenas números inteiros.");
                                sc.nextLine();
                            }
                        }

                        convidado.add(new Convidado(nome, idade));
                        System.out.println("Convidado adicionado com sucesso");
                        break;
                    case 3:
                        if (!convidado.isEmpty()) {

                            for (int i = 0; i < convidado.size(); i++) {
                                System.out.println((i + 1) + " - " + convidado.get(i));
                            }

                            while (true) {
                                try {
                                    System.out.println("Digite o número que deseja remover:");
                                    int remover = sc.nextInt();
                                    sc.nextLine();

                                    if (remover > 0 && remover <= convidado.size()) {
                                        convidado.remove(remover - 1);
                                        System.out.println("Convidado removido");
                                    } else {
                                        System.out.println("ERRO: Esse número de convidado não existe.");
                                    }

                                    break;

                                } catch (InputMismatchException e) {
                                    System.out.println("ERRO: Por favor, digite apenas números inteiros.");
                                    sc.nextLine();
                                }
                            }

                        } else {
                            System.out.println("Lista vazia. Não há ninguém para remover.");
                        }
                        break;
                    case 4:
                        System.out.println("Fim");
                        break;
                    default:
                        System.out.println("Valor inválido digite números de 1 a 4");
                }
            }catch (InputMismatchException e) {
                System.out.println(" ERRO: Opção de menu inválida. Digite um número.");
                sc.nextLine();
            }

        } while (resposta != 4);



        sc.close();
    }
}