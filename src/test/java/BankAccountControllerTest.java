import org.example.controller.BankAccountController;
import org.example.controller.CustomerController;
import org.example.repository.BankAccountRepository;
import org.example.repository.CustomerRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.sql.ResultSet;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class BankAccountControllerTest {
    private BankAccountRepository bankAccountRepository;
    private BankAccountController bankAccountController;

    @BeforeEach
    public void setUp() {
        bankAccountRepository = mock(BankAccountRepository.class);
        bankAccountController = new BankAccountController(bankAccountRepository);
    }

    @Test
    @DisplayName("Testa se o registrar conta retorna true")
    void registerAccountTest(){
        when(bankAccountRepository.registerAccount("888888",1200.00,2)).thenReturn(true);
        boolean result = bankAccountController.registerAccount("888888",1200.00,2);
        assertTrue(result);
    }
    @Test
    @DisplayName("Deve retornar verdadeiro ao tentar deletar um uma pelo numero da conta")
    public void testDeleteAccount(){
        when(bankAccountRepository.deleteAccount("123456")).thenReturn(true);
        boolean result = bankAccountController.deleteAccount("123456");
        assertTrue(result);
    }
    @Test
    @DisplayName("Deve retornar true ao mostrar o saldo atraves do numero da conta")
    public void t3(){
        when(bankAccountRepository.showBalance("101010")).thenReturn(true);
        boolean result = bankAccountController.showBalance("101010");
        assertTrue(result);
    }
    @Test
    @DisplayName("Deve retornar verdadeiro ao tirar saldo da conta")
    public void testUpdateBalence(){
        when(bankAccountRepository.updateBalance(1,50)).thenReturn(true);
        boolean result = bankAccountController.updateBalance(1,50);
        assertTrue(result);
    }
    @Test
    @DisplayName("Deve retornar verdadeiro ao adicionar saldo da conta")
    public void testaddUpdateBalence(){
        when(bankAccountRepository.addUpdateBalance(2,150)).thenReturn(true);
        boolean result = bankAccountController.addUpdateBalance(2,150);
        assertTrue(result);
    }
    @Test
    @DisplayName("Deve retornar true ao mostrar  conta atraves do id do cliente")
    public void testShowCustomerAccount(){
        when(bankAccountRepository.showCustomerAccount(1)).thenReturn(true);
        boolean result = bankAccountController.showCustomerAccount(1);
        assertTrue(result);
    }

}
