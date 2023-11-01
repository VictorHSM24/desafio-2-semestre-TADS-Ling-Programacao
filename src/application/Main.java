package application;

import entities.Agenda;
import entities.Contato;
import exceptions.AgendaCheiaException;
import exceptions.ContatoNaoExisteException;

import java.util.InputMismatchException;
import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws ContatoNaoExisteException, AgendaCheiaException {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        Agenda agenda = new Agenda();

        while (true) {
            System.out.println("Menu:");
            System.out.println("1 - Buscar um contato");
            System.out.println("2 - Adicionar um contato");
            System.out.println("3 - Sair");
            System.out.print("Escolha uma opção: ");

            int opcao = sc.nextInt();

            try {
                if (opcao == 1) {
                    if (agenda.estaVazia()) {
                        System.out.println("\nNão é possível buscar um contato, pois a agenda está vazia!");
                    } else {
                        sc.nextLine();
                        System.out.print("\nDigite o nome ou o telefone do contato a ser buscado na agenda: ");
                        String termoBusca = sc.nextLine();

                        try {
                            int index = agenda.buscarContato(termoBusca);
                            System.out.println("O contato foi encontrado na posição: " + index);
                        } catch (ContatoNaoExisteException e) {
                            System.out.println("Contato não encontrado na agenda.");
                        }
                    }
                } else if (opcao == 2) {
                    System.out.println("\nInsira os dados referentes ao contato:");
                    String nome;
                    String telefone;
                    do {
                        sc.nextLine();
                        System.out.print("Nome: ");
                        nome = sc.nextLine();
                        System.out.print("Telefone: ");
                        telefone = sc.nextLine();
                        if (nome.isEmpty() || telefone.isEmpty()) {
                            System.out.println("Nome e telefone são obrigatórios. Tecle Enter para tentar novamente.");
                        }
                    } while (nome.isEmpty() || telefone.isEmpty());
                    Contato contato = new Contato(nome, telefone);
                    agenda.addContato(contato);
                    System.out.println();
                } else if (opcao == 3) {
                    break;
                } else {
                    System.out.println("\nOpção inválida! Tente novamente.\n");
                }
            } catch (InputMismatchException e) {
                System.out.println("Opção inválida! Tente novamente.\n");
            }
        }
        sc.close();
    }
}
