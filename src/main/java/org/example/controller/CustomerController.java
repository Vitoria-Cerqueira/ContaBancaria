package org.example.controller;

import org.example.model.CustomerModel;
import org.example.repository.CustomerRepository;

public class CustomerController {

    private CustomerRepository customerRepository;
    private CustomerModel customerModel = new CustomerModel();
    public CustomerController(){}
    public CustomerController(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }
    public boolean registerCustomer(String name, String cpf, String address){
       customerModel.setName(name);
       customerModel.setCpf(cpf);
       customerModel.setAddress(address);
        return customerRepository.registerCustomer(customerModel.getName(), customerModel.getCpf(), customerModel.getAddress());
    }
    public boolean deleteCustomer(String cpf) {
        customerModel.setCpf(cpf);
        return customerRepository.deleteCustomer(customerModel.getCpf());
    }
    public boolean changeAddress(String cpf, String address){
        customerModel.setCpf(cpf);
        customerModel.setAddress(address);
        return customerRepository.changeAddress(customerModel.getCpf(), customerModel.getAddress());
    }
    public boolean logIn(String cpf){
        customerModel.setCpf(cpf);
        return customerRepository.logIn(customerModel.getCpf());
    }
}
