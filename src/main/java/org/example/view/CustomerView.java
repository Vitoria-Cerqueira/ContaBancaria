package org.example.view;

import org.example.controller.CustomerController;
import org.example.repository.CustomerRepository;

import java.util.Scanner;

public class CustomerView {
    private CustomerRepository customerRepository;
    private Scanner scanner;


    public CustomerView() {
        customerRepository = new CustomerRepository();
        scanner = new Scanner(System.in);
    }
    public void displayMenu() {
        while (true) {
            System.out.println("\nOperações de Cliente");
            System.out.println("1. Registrar Cliente");
            System.out.println("2. Excluir Cliente");
            System.out.println("3. Alterar Endereço do Cliente");
            System.out.println("4. Fazer Login");
            System.out.println("0. Voltar");

            System.out.print("Digite sua escolha: ");
            int escolha = scanner.nextInt();
            scanner.nextLine(); // Consumir a nova linha

            switch (escolha) {
                case 1:
                    registrarCliente();
                    break;
                case 2:
                    excluirCliente();
                    break;
                case 3:
                    alterarEndereco();
                    break;
                case 4:
                    fazerLogin();
                    break;
                case 0:
                    return; // Voltar para o menu principal
                default:
                    System.out.println("Escolha inválida. Por favor, tente novamente.");
            }
        }
    }

    private void registrarCliente() {
        System.out.print("Nome do Cliente: ");
        String nomeCliente = scanner.nextLine();
        System.out.print("CPF do Cliente: ");
        String cpfCliente = scanner.nextLine();
        System.out.print("Endereço do Cliente: ");
        String enderecoCliente = scanner.nextLine();

        boolean clienteRegistrado = customerRepository.registerCustomer(nomeCliente, cpfCliente, enderecoCliente);
        if (clienteRegistrado) {
            System.out.println("Cliente registrado com sucesso!");
        } else {
            System.out.println("Falha ao registrar o cliente.");
        }
    }

    private void excluirCliente() {
        System.out.print("Digite o CPF do Cliente para Excluir: ");
        String cpfClienteExcluir = scanner.nextLine();

        boolean clienteExcluido = customerRepository.deleteCustomer(cpfClienteExcluir);
        if (clienteExcluido) {
            System.out.println("Cliente excluído com sucesso!");
        } else {
            System.out.println("Falha ao excluir o cliente.");
        }
    }

    private void alterarEndereco() {
        System.out.print("Digite o CPF do Cliente para Alterar o Endereço: ");
        String cpfAlterarEndereco = scanner.nextLine();
        System.out.print("Novo Endereço: ");
        String novoEndereco = scanner.nextLine();

        boolean enderecoAlterado = customerRepository.changeAddress(cpfAlterarEndereco, novoEndereco);
        if (enderecoAlterado) {
            System.out.println("Endereço do cliente alterado com sucesso!");
        } else {
            System.out.println("Falha ao alterar o endereço do cliente.");
        }
    }

    private void fazerLogin() {
        System.out.print("Digite o CPF do Cliente para Fazer Login: ");
        String cpfLogin = scanner.nextLine();

        boolean loginSucesso = customerRepository.logIn(cpfLogin);
        if (loginSucesso) {
            System.out.println("Login bem-sucedido!");
        } else {
            System.out.println("Login falhou. CPF não encontrado.");
        }
    }
}
