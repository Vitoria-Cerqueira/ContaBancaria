import org.example.controller.CustomerController;
import org.example.repository.CustomerRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class CustomerControllerTest {
    private CustomerRepository customerRepository;
    private CustomerController customerController;
    @BeforeEach
    public void setUp(){
        customerRepository = mock(CustomerRepository.class);
        customerController = new CustomerController(customerRepository);
    }
    @Test
    @DisplayName("Deve retonar  verdadeiro ao tentar cadastrar um cliente")
    public void testRegisterCustomer(){
        when(customerRepository.registerCustomer("Vitoria", "12345678990","Av Rio Branco - n50, São Paulo -SP")).thenReturn(true);
        boolean result = customerController.registerCustomer("Vitoria", "12345678990","Av Rio Branco - n50, São Paulo -SP");
        assertTrue(result);
    }
    @Test
    @DisplayName("Deve retornar verdadeiro ao tentar deletar um cliente pelo cpf")
    public void testDeleteCustomer(){
        when(customerRepository.deleteCustomer("12345678990")).thenReturn(true);
        boolean result = customerController.deleteCustomer("12345678990");
        assertTrue(result);
    }
    @Test
    @DisplayName("Deve retonar verdadeiro ao tentar atualizar o endereço do cliente")
    public void testUpadateCustomer(){
        when(customerRepository.changeAddress("11122233344","Rua da felicidade")).thenReturn(true);
        boolean result = customerController.changeAddress("11122233344","Rua da felicidade");
        assertTrue(result);
    }
    @Test
    @DisplayName("Deve retonar  falso ao tentar cadastrar um cliente")
    public void testRegisterCustomerFalse(){
        when(customerRepository.registerCustomer("Vitoria", "12345678990","Av Rio Branco - n50, São Paulo -SP")).thenReturn(false);
        boolean result = customerController.registerCustomer("Vitoria", "12345678990","Av Rio Branco - n50, São Paulo -SP");
        assertFalse(result);
    }
    @Test
    @DisplayName("Deve retornar falso ao tentar deletar um cliente pelo cpf")
    public void testDeleteCustomerFalse(){
        when(customerRepository.deleteCustomer("12345678990")).thenReturn(false);
        boolean result = customerController.deleteCustomer("12345678990");
        assertFalse(result);
    }
    @Test
    @DisplayName("Deve retonar falso ao tentar atualizar o endereço do cliente")
    public void testUpadateCustomerFalse(){
        when(customerRepository.changeAddress("11122233344","Rua da felicidade")).thenReturn(false);
        boolean result = customerController.changeAddress("11122233344","Rua da felicidade");
        assertFalse(result);
    }
    @Test
    @DisplayName("Ao logar o teste retornar verdadeiro")
    public void testLogin(){
        when(customerRepository.logIn("66666666666")).thenReturn(true);

        boolean result = customerController.logIn("66666666666");

        assertTrue(result);
    }

}
