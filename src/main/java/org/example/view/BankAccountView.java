package org.example.view;

import org.example.controller.BankAccountController;
import org.example.repository.BankAccountRepository;

import java.util.Scanner;

public class BankAccountView {
    private BankAccountRepository bankAccountRepository;
    private Scanner scanner;

    public BankAccountView(){
        bankAccountRepository = new BankAccountRepository();
        scanner = new Scanner(System.in);
    }
    public void displayMenu() {
        while (true) {
            System.out.println("\nOperações de Conta Bancária");
            System.out.println("1. Registrar Conta Bancária");
            System.out.println("2. Excluir Conta Bancária");
            System.out.println("3. Exibir Saldo da Conta");
            System.out.println("4. Atualizar Saldo da Conta");
            System.out.println("5. Adicionar ao Saldo da Conta");
            System.out.println("6. Exibir Contas de um Cliente");
            System.out.println("0. Voltar");

            System.out.print("Digite sua escolha: ");
            int escolha = scanner.nextInt();
            scanner.nextLine(); // Consumir a nova linha

            switch (escolha) {
                case 1:
                    registrarConta();
                    break;
                case 2:
                    excluirConta();
                    break;
                case 3:
                    exibirSaldo();
                    break;
                case 4:
                    atualizarSaldo();
                    break;
                case 5:
                    adicionarSaldo();
                    break;
                case 6:
                    exibirContasCliente();
                    break;
                case 0:
                    return; // Voltar para o menu principal
                default:
                    System.out.println("Escolha inválida. Por favor, tente novamente.");
            }
        }
    }

    private void registrarConta() {
        System.out.print("Número da Conta: ");
        String numeroConta = scanner.nextLine();
        System.out.print("Saldo Inicial: ");
        double saldoInicial = scanner.nextDouble();
        System.out.print("ID do Cliente Associado: ");
        int idClienteAssociado = scanner.nextInt();
        scanner.nextLine();
        boolean contaRegistrada = bankAccountRepository.registerAccount(numeroConta, saldoInicial, idClienteAssociado);
        if (contaRegistrada) {
            System.out.println("Conta registrada com sucesso!");
        } else {
            System.out.println("Falha ao registrar a conta.");
        }
    }

    private void excluirConta() {
        System.out.print("Digite o Número da Conta para Excluir: ");
        String numeroContaExcluir = scanner.nextLine();

        boolean contaExcluida = bankAccountRepository.deleteAccount(numeroContaExcluir);
        if (contaExcluida) {
            System.out.println("Conta excluída com sucesso!");
        } else {
            System.out.println("Falha ao excluir a conta.");
        }
    }

    private void exibirSaldo() {
        System.out.print("Digite o Número da Conta para Exibir o Saldo: ");
        String numeroContaExibirSaldo = scanner.nextLine();

        boolean saldoExibido = bankAccountRepository.showBalance(numeroContaExibirSaldo);
        if (!saldoExibido) {
            System.out.println("Falha ao exibir o saldo da conta.");
        }
    }

    private void atualizarSaldo() {
        System.out.print("Digite o ID da Conta para Atualizar o Saldo: ");
        int idContaAtualizarSaldo = scanner.nextInt();
        System.out.print("Digite o valor a ser subtraído do saldo: ");
        double valorSubtrair = scanner.nextDouble();

        boolean saldoAtualizado = bankAccountRepository.updateBalance(idContaAtualizarSaldo, -valorSubtrair);
        if (saldoAtualizado) {
            System.out.println("Saldo atualizado com sucesso!");
        } else {
            System.out.println("Falha ao atualizar o saldo.");
        }
    }

    private void adicionarSaldo() {
        System.out.print("Digite o ID da Conta para Adicionar ao Saldo: ");
        int idContaAdicionarSaldo = scanner.nextInt();
        System.out.print("Digite o valor a ser adicionado ao saldo: ");
        double valorAdicionar = scanner.nextDouble();

        boolean saldoAtualizado = bankAccountRepository.addUpdateBalance(idContaAdicionarSaldo, valorAdicionar);
        if (saldoAtualizado) {
            System.out.println("Saldo atualizado com sucesso!");
        } else {
            System.out.println("Falha ao atualizar o saldo.");
        }
    }

    private void exibirContasCliente() {
        System.out.print("Digite o ID do Cliente para Exibir as Contas: ");
        int idClienteExibirContas = scanner.nextInt();

        boolean contasExibidas = bankAccountRepository.showCustomerAccount(idClienteExibirContas);
        if (!contasExibidas) {
            System.out.println("Falha ao exibir as contas do cliente.");
        }
    }
}
