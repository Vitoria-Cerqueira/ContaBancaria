package org.example.view;

import org.example.repository.TransactionRepository;

import java.util.Scanner;

public class TransactionView {
    private TransactionRepository transactionRepository;
    private Scanner scanner;


    public TransactionView() {
        transactionRepository = new TransactionRepository();
        scanner = new Scanner(System.in);
    }
    public void displayMenu() {
        while (true) {
            System.out.println("\nOperações de Transação");
            System.out.println("1. Registrar Transação");
            System.out.println("2. Exibir Histórico de Transações");
            System.out.println("0. Voltar");

            System.out.print("Digite sua escolha: ");
            int escolha = scanner.nextInt();
            scanner.nextLine();

            switch (escolha) {
                case 1:
                    registrarTransacao();
                    break;
                case 2:
                    exibirHistoricoTransacoes();
                    break;
                case 0:
                    return;
                default:
                    System.out.println("Escolha inválida. Por favor, tente novamente.");
            }
        }
    }

    private void registrarTransacao() {
        System.out.print("Data da Transação: ");
        String dataTransacao = scanner.nextLine();
        System.out.print("Valor da Transação: ");
        double valorTransacao = scanner.nextDouble();
        System.out.print("ID da Conta de Origem: ");
        int idContaOrigem = scanner.nextInt();
        System.out.print("ID da Conta de Destino: ");
        int idContaDestino = scanner.nextInt();

        boolean transacaoRegistrada = transactionRepository.registerTransaction(dataTransacao, valorTransacao, idContaOrigem, idContaDestino);
        if (transacaoRegistrada) {
            System.out.println("Transação registrada com sucesso!");
        } else {
            System.out.println("Falha ao registrar a transação.");
        }
    }

    private void exibirHistoricoTransacoes() {
        System.out.print("Digite o ID da Conta de Origem para Exibir o Histórico: ");
        int idContaExibirHistorico = scanner.nextInt();

        boolean historicoExibido = transactionRepository.showAllTransactionsofaSpecificAccount(idContaExibirHistorico);
        if (!historicoExibido) {
            System.out.println("Falha ao exibir o histórico de transações.");
        }
    }
}
