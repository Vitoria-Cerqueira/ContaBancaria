package org.example.view;


import java.util.Scanner;

public class MainMenuView {
    private CustomerView customerView;
    private BankAccountView bankAccountView;
    private TransactionView transactionView;
    private Scanner scanner;

    public MainMenuView() {
        this.customerView = new CustomerView();
        this.bankAccountView = new BankAccountView();
        this.transactionView = new TransactionView();
        this.scanner = new Scanner(System.in);
    }

    public void displayMainMenu() {
        int choice;

        do {
            System.out.println("\nMenu Principal");
            System.out.println("1. Operações de Conta Bancária");
            System.out.println("2. Operações de Cliente");
            System.out.println("3. Operações de Transação");
            System.out.println("0. Sair");
            System.out.print("Escolha uma opção: ");

            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    bankAccountView.displayMenu();
                    break;
                case 2:
                    customerView.displayMenu();
                    break;
                case 3:
                    transactionView.displayMenu();
                    break;
                case 4:
                    System.out.println("Saindo do programa.");
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
                    break;
            }
        } while (choice != 4);
    }
}

