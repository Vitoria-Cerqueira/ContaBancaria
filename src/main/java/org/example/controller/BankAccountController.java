package org.example.controller;

import org.example.model.BankAccountModel;
import org.example.repository.BankAccountRepository;

import java.sql.SQLException;

public class BankAccountController {
    private BankAccountRepository bankAccountRepository;
    private BankAccountModel bankAccountModel = new BankAccountModel();

    public BankAccountController(){}
    public BankAccountController(BankAccountRepository bankAccountRepository){
        this.bankAccountRepository = bankAccountRepository;
    }
  public boolean registerAccount(String number_account,double balence, int idCustomer){
        bankAccountModel.setNumberAccount(number_account);
        bankAccountModel.setBalance(balence);
        bankAccountModel.setIdCustomer(idCustomer);
        return bankAccountRepository.registerAccount(bankAccountModel.getNumberAccount(), bankAccountModel.getBalance(), bankAccountModel.getIdCustomer());
  }
    public boolean deleteAccount(String number_account){
        bankAccountModel.setNumberAccount(number_account);
        return bankAccountRepository.deleteAccount(bankAccountModel.getNumberAccount());
    }
    public boolean showBalance(String number_account){
        bankAccountModel.setNumberAccount(number_account);
        return bankAccountRepository.showBalance(bankAccountModel.getNumberAccount());
    }
    public boolean updateBalance(int id_account_bank, double value_total){
        bankAccountModel.setId_account_bank(id_account_bank);
        return bankAccountRepository.updateBalance(bankAccountModel.getId_account_bank(), value_total);
    }
    public boolean addUpdateBalance(int id_account_bank, double value_total){
        bankAccountModel.setId_account_bank(id_account_bank);
        return bankAccountRepository.addUpdateBalance(bankAccountModel.getId_account_bank(), value_total);
    }
    public boolean showCustomerAccount(int idCustomer){
        bankAccountModel.setIdCustomer(idCustomer);
        return bankAccountRepository.showCustomerAccount(bankAccountModel.getIdCustomer());
    }

}
