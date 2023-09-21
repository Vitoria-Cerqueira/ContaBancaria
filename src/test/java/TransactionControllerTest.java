import org.example.controller.CustomerController;
import org.example.controller.TransactionController;
import org.example.repository.CustomerRepository;
import org.example.repository.TransactionRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class TransactionControllerTest {
    private TransactionRepository transactionRepository;
    private TransactionController transactionController;
    @BeforeEach
    public void setUp(){
       transactionRepository = mock(TransactionRepository.class);
       transactionController = new TransactionController(transactionRepository);
    }
    @Test
    @DisplayName("Deve retonar  verdadeiro ao tentar cadastrar um cliente")
    public void testRegisterTransaction(){
        when(transactionRepository.registerTransaction("21/02/2003", 69.00,2,3)).thenReturn(true);
        boolean result = transactionController.registerTransaction("21/02/2003", 69.00,2,3);
        assertTrue(result);
    }
    @Test
    @DisplayName("Deve retonar  falso ao tentar cadastrar um cliente")
    public void testRegisterTransactionFalse(){
        when(transactionRepository.registerTransaction("21/02/2003", 69.00,2,3)).thenReturn(false);
        boolean result = transactionController.registerTransaction("21/02/2003", 69.00,2,3);
        assertFalse(result);
    }
    @Test
    @DisplayName("Deve retornar true ao passar um id de origem e mostrar as suas transações")
    public void testshowAllTransactionsofaSpecificAccountisTrue(){
        when(transactionRepository.showAllTransactionsofaSpecificAccount(2)).thenReturn(true);
        boolean result = transactionController.showAllTransactionsofaSpecificAccount(2);
        assertTrue(result);
    }
}
