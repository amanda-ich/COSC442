import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class BankAccountTest {

    BankAccount myAccount;
    BankAccount yourAccount;

    @BeforeEach
    void setUp() {
        //arrange
        myAccount = new BankAccount("Me", 100.0);
        yourAccount = new BankAccount("You", 1000.0);
    }

    @AfterEach
    void tearDown() {
        myAccount = null;
        yourAccount = null;
    }

    @Test
    void testCloseAccount() {
        //act
        myAccount.withdraw(100.0);
        myAccount.closeAccount();
        //assert
        assertEquals(false, myAccount.isActive());
    }

    @Test
    void testDeposit() {
        //act
        myAccount.deposit(10.0);
        //assert
        double expectedBehavior = 110.0;
        double actualBehavior = myAccount.getBalance();
        assertEquals(expectedBehavior, actualBehavior, 0.001);
    }

    @Test
    void testGetBalance() {
        //assert
        double expectedBehavior = 100.0;
        double actualBehavior = myAccount.getBalance();
        assertEquals(expectedBehavior, actualBehavior, 0.001);
    }

    @Test
    void testGetOwner() {
        //assert
        String expectedBehavior = "Me";
        String actualBehavior = myAccount.getOwner();
        assertEquals(expectedBehavior, actualBehavior);
    }

    @Test
    void testIsActive() {
        //assert
        assertEquals(true, myAccount.isActive());
    }

    @Test
    void testTransferTo() {
        //act
        yourAccount.transferTo(myAccount, 20.0);
        //assert
        double expectedBehavior = 120.0;
        double actualBehavior = myAccount.getBalance();
        assertEquals(expectedBehavior, actualBehavior, 0.001);
    }

    @Test
    void testWithdraw() {
        //act
        myAccount.withdraw(10.0);
        //assert
        double expectedBehavior = 90.0;
        double actualBehavior = myAccount.getBalance();
        assertEquals(expectedBehavior, actualBehavior, 0.001);
    }

    @ParameterizedTest
    @ValueSource(doubles = {-1000.0, -100.0, 0.0})
    void testWithdrawIllegalException(double amount) {
        //act and assert
        assertThrows(IllegalArgumentException.class, () -> myAccount.withdraw(amount));
    }
}
