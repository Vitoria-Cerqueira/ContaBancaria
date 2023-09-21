package org.example.model;

public class BankAccountModel {
    private int id_account_bank;
    private String numberAccount;
    private double balance;
    private int  idCustomer;

    public int getId_account_bank() {
        return id_account_bank;
    }

    public void setId_account_bank(int id_account_bank) {
        this.id_account_bank = id_account_bank;
    }

    public String getNumberAccount() {
        return numberAccount;
    }

    public void setNumberAccount(String numberAccount) {
        this.numberAccount = numberAccount;
    }


    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public int getIdCustomer() {
        return idCustomer;
    }

    public void setIdCustomer(int idCustomer) {
        this.idCustomer = idCustomer;
    }
}
